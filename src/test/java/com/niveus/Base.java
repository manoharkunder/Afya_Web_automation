package com.niveus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.collections.Lists;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {

	public static File file;

	public static String fileName = null;
	public static Properties properties;
	public static FileInputStream inputStream;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static SimpleDateFormat simpleDateFormat;
	static int passedCount = 0;
	static int failureCount = 0;
	static int skippedCount = 0;
	public static FileOutputStream fos;

	public WebDriver driver;

	public static void main(String[] args) {

		List<String> suites = Lists.newArrayList();
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		// suites.add("StagingTestNG.xml");
		suites.add("testng.xml");

		testng.setTestSuites(suites);
		testng.addListener((ITestNGListener) tla);
		testng.run();
	}

	@BeforeMethod
	@BeforeSuite
	public void setUp() throws IOException {

		properties = new Properties();
		inputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/Qa.properties"));
		properties.load(inputStream);

		/******************** Extent Report *******************/
		htmlReporter = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Report/AutomationReport.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/Report/ExtentConfigFile.xml"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Operating System", properties.getProperty("OperatingSystem"));
		extent.setSystemInfo("System Name", properties.getProperty("SystemName"));
		extent.setSystemInfo("Environment", properties.getProperty("Environment"));
		extent.setSystemInfo("Platform", "Web Application");

		htmlReporter.config().setDocumentTitle(properties.getProperty("ReportDocumentTitle"));
		htmlReporter.config().setReportName(properties.getProperty("ReportName"));
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);

	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		int passed = 0;
		int failed = 0;
		int skipped = 0;
		if (result.getStatus() == ITestResult.FAILURE) {
			failed++;
			File path = new File(System.getProperty("user.dir") + "/Report/ScreenShot/" + result.getName() + ".png");
			try {
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location
				// result.getName() will return name of test case so that screenshot name will
				// be same as test case name
				FileUtils.copyFile(src, path);
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + "Test Failed Due to below issues", ExtentColor.RED));
			test.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(path.getName()).build());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			passed++;
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test is Passed", ExtentColor.GREEN));

		} else {
			skipped++;
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test is Skipped ", ExtentColor.YELLOW));
			test.skip(result.getThrowable());

		}
		passedCount = passedCount + passed;
		failureCount = failureCount + failed;
		skippedCount = skippedCount + skipped;
		driver.quit();
	}

	@AfterSuite
	public void flushReport() throws IOException, InterruptedException {

		// driver.quit();
		// flush all the information to the extent report
		extent.flush();
		// Send Email

		SendEmail email = new SendEmail();
		email.sendEmail(passedCount, failureCount, skippedCount);

		// close driver
//	driver.quit();
	}

	@BeforeClass

	public void configBc() {
		/*
		 * below code is used to launch the browser
		 */

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

	//  driver = new ChromeDriver(options);

		/*
		 * below code is used to run the Script in headless mode
		 */

		/*
		 * options.setPageLoadStrategy(PageLoadStrategy.NONE);
		 * 
		 * options.addArguments("enable-features=NetworkServiceInProcess");
		 * 
		 * options.addArguments("--headless", "--disable-web-security",
		 * "--ignore-certificate-errors", "--allow-running-insecure-content",
		 * "--allow-insecure-localhost", "--no-sandbox", "--lang=en_US",
		 * "--window-size=1920,1080", "--start-maximized", "--disable-gpu",
		 * "--test-type"); options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,
		 * true); options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 * options.setExperimentalOption("useAutomationExtension", false);
		 * options.setExperimentalOption("excludeSwitches", new String[] {
		 * "enable-automation" }); driver = new ChromeDriver(options);
		 * 
		 * 
		 */
		/*
		 * this is used to run the script in headless mode*
		 */

		
		  options.addArguments("--headless", "--disable-gpu",
		  "--blink-settings=imagesEnabled=false");
		  
		  options.setPageLoadStrategy(PageLoadStrategy.NONE);
		  
		  options.addArguments("enable-features=NetworkServiceInProcess");
		  
		  options.addArguments("headless");
		  
		  driver = new ChromeDriver(options);
		 

		System.out.println("browser is launched");

		driver.navigate().to("https:stagingwebapp.afya.chat/");

		driver.manage().window().maximize();

		Reporter.log(driver.getTitle() + " Page  is sucessfully displayed", true);
	}

}

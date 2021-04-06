package com.niveus;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	/**
	 * This method is used to select the Option by Value from Select Dropdown
	 * 
	 * @param webElement
	 * @param value
	 */
	public void selectByValue(WebElement webElement, String value) {
		Select sel = new Select(webElement);

		sel.selectByValue(value);

	}

	/**
	 * This method is used to switch the driver control to new tab
	 * 
	 * @param driver
	 * @return String
	 */
	public String switchToNewWindow(WebDriver driver) {
		Set<String> ids = driver.getWindowHandles();

		Iterator<String> it = ids.iterator();

		String pid = it.next();
		String cid = it.next();

		driver.switchTo().window(cid);

		return pid;
	}

	public static  void moveToElement(WebDriver driver, WebElement webelement) {
		Actions act = new Actions(driver);
		act.moveToElement(webelement).click().perform();
	}

	public static void hoverMouse(WebDriver driver, WebElement webelement) {
		Actions act = new Actions(driver);
		act.moveToElement(webelement).perform();
	}

	public static WebElement isElementPresnt(WebDriver driver, String xpath, int time) {

		WebElement ele = null;

		for (int i = 0; i < time; i++) {
			try {
				ele = driver.findElement(By.xpath(xpath));

				break;
			} catch (Exception e) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}

		}
		return ele;

	}

	/**
	 * 
	 */
	public static WebElement isElementPresntOnId(WebDriver driver, String Id, int time) {

		WebElement res = null;

		for (int i = 0; i < time; i++) {
			try {
				res = driver.findElement(By.id(Id));

				break;
			} catch (Exception e) {

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {

					System.out.println("Waiting for element to appear on DOM");
				}
			}

		}
		return res;

	}
}

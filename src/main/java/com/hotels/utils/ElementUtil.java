package com.hotels.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hotels.base.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		waitForElementPresent(locator);

		WebElement element = null;
		try {
			element = driver.findElement(locator);
			if (flash.equalsIgnoreCase("yes")) {
				JavaScriptUtil.flash(element, driver);
			}
		} catch (Exception e) {
			System.out.println("Some exception occured while creating webelement " + locator);
		}
		return element;
	}

	public void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception occured while click on  webelement " + locator);
		}
	}

	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception occured while sending to  webelement " + locator);
		}
	}

	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("Some exception occured while sending to  webelement " + locator);
		}
		return text;
	}

	public String waitForGetPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Some exception occured while checking webelement displayed " + locator);
			return false;
		}

	}

	public void mouseHover() {
		System.out.println("test");
	}

	public void actionMoveToElement(By locator) {

		Actions actions = new Actions(driver);
		actions.moveToElement(getElement(locator)).build().perform();
	}

	public void selectByValue(By locator, String value) {

		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}


	public void deneme() {

	}
	public void deneme2(){
		

	}
	
	public void deneme3(){
		
	}
}

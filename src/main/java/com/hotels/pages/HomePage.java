package com.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hotels.base.BasePage;
import com.hotels.utils.ElementUtil;
import com.hotels.utils.JavaScriptUtil;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends BasePage {

	ElementUtil util;
	JavaScriptUtil jutil;

	By destination = By.xpath("//input[@id='qf-0q-destination']");
	By check_in = By.id("widget-query-label-1");
	By next_month = By.xpath("//div[@class='widget-daterange-cont']//div[2]//div[1]//button[2]");
	By next_month_text = By.xpath("//div[@class='widget-daterange-cont']/div[2]/div[1]/div");
	By check_in_day = By.xpath("//div[@class='widget-daterange-cont']//div[2]//div[2]//table[1]//tbody[1]");
	By check_out = By.id("widget-query-label-3");
	By check_out_day = By.xpath("//div[@class='widget-daterange-cont']//div[1]//div[2]//table[1]//tbody[1]/tr[4]");
	By search = By.xpath("//button[@type='submit']");
	By child = By.id("qf-0q-room-0-children");
	By child1 = By.id("qf-0q-room-0-child-0-age");
	By child2 = By.id("qf-0q-room-0-child-1-age");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
		jutil = new JavaScriptUtil();
	}

	public void newMethod(){
		
	}
	public String getHomePageTitle(String title) {

		return util.waitForGetPageTitle(title);
	}
	
	public void newMethod1(){
		System.out.println("Hello");
	}
	public void selectDestinationDatesAndSubmit(){
		
		selectDestination();
		selectDates();
		selectChilds();
		util.doClick(search);
	}

	public void selectDestination() {

		util.doSendKeys(destination, "new");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(destination).sendKeys(Keys.DOWN);

		List<WebElement> text = driver.findElements(By.xpath("//div[@class='autosuggest-category-result']"));

		for (int i = 0; i < text.size(); i++) {
			String city = text.get(i).getText();
			if (city.equalsIgnoreCase("New York, New York, United States of America")) {
				text.get(i).click();
				break;
			} else {
				driver.findElement(destination).sendKeys(Keys.DOWN);
			}
		}

	}
	
	public void selectChilds(){
		
//		WebElement element = util.getElement(child);
//		Select select = new Select(element);
//		select.selectByValue("2");
		util.selectByValue(child, "2");
		util.selectByValue(child1, "3");
		util.selectByValue(child2, "7");
		
	}
	
	public void selectDates() {

		selectDestination();

		util.doClick(check_in);

		while (!driver.findElement(next_month_text).getText().contains("May")) {
			driver.findElement(next_month).click();
		}

		WebElement day = driver.findElement(check_in_day);
		List<WebElement> columns = day.findElements(By.tagName("td"));

		for (WebElement cell : columns) {
			if (cell.getText().equals("15")) {
				cell.findElement(By.linkText("15")).click();
				break;
			}
		}
		
		util.doClick(check_out);
		
		
		
		WebElement day2 = driver.findElement(check_out_day);
		List<WebElement> columns2 = day2.findElements(By.tagName("td"));
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (WebElement cell : columns) {
			if (cell.getText().equals("10")) {
				cell.findElement(By.linkText("10")).click();
				break;
			}
		}
	}
	
	
}

package com.hotels.pages;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hotels.base.BasePage;
import com.hotels.utils.ElementUtil;

public class SearchPage extends BasePage {

	WebDriver driver;
	ElementUtil util;

	By five_star = By.id("f-star-rating-5");
	By four_star = By.id("f-star-rating-4");
	By three_star = By.id("f-star-rating-3");
	By distances = By.xpath("//ul[@class='property-landmarks']//li[contains(text(),'City')]");
	By stars = By.xpath("//span[@class='star-rating-text star-rating-text-strong']");
	By hotel_name = By.xpath("//a[@class='property-name-link']");
	By whole_text = By.xpath("//div[@class='description resp-module']");

	public SearchPage(WebDriver driver) {

		this.driver = driver;
		util = new ElementUtil(driver);
	}

	public void selectFiveStarHotels(String choice) {

		if (choice.equals("5")) {
			util.doClick(five_star);
		} else if (choice.equals("4")){
			util.doClick(four_star);
		}else {
			util.doClick(three_star);
		}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}

	public List<WebElement> getDistances(String choice, String time) {

		int wait_time = Integer.parseInt(time);
		for (int second = 0;; second++) {
			if (second >= wait_time) {
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)", "");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		List<WebElement> distance = driver.findElements(distances);
		List<WebElement> star = driver.findElements(stars);
		List<WebElement> hotel_names = driver.findElements(hotel_name);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		if (choice.equals("mile")) {
			return distance;
		} else if (choice.equals("star")) {
			return star;
		} else
			return hotel_names;


	}

	public boolean checkHotelsInTenMiles(String choice, String time) {

		selectFiveStarHotels(choice);
		List<WebElement> distance = getDistances("mile", time);

		for (int i = 0; i < distance.size(); i++) {

			double miles = Integer.parseInt(distance.get(i).getText().replaceAll("[\\D]", ""));

			miles = miles / 10;
			//System.out.println(miles);
			if (miles > 10) {
				return false;
			}

		}
		return true;
	}

	public boolean checkHotelsNameForHilton(String choice, String time) {

		selectFiveStarHotels(choice);
		List<WebElement> hotel_names = getDistances("hotel", time);

		for (int i = 0; i < hotel_names.size(); i++) {

			String hotel_name = hotel_names.get(i).getText();
			if (hotel_name.contains("Hilton")) {
				return true;
			}
		}
		return false;

	}

	public boolean checkHotelsStars(String choice, String star, String time) {

		selectFiveStarHotels(choice);
		List<WebElement> hotel_stars = getDistances("star",time);

		for (int i = 0; i < hotel_stars.size(); i++) {

			String text = hotel_stars.get(i).getText();

			if (!text.equalsIgnoreCase(star)) {

				return false;
			}

		}
		return true;
	}

}

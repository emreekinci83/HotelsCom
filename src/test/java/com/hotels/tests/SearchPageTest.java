package com.hotels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hotels.base.BasePage;
import com.hotels.pages.HomePage;
import com.hotels.pages.SearchPage;
import com.hotels.listeners.TestAllureListener;

@Listeners({ TestAllureListener.class })
public class SearchPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	SearchPage searchPage;

	@BeforeMethod
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		homePage.selectDestinationDatesAndSubmit();
		searchPage = new SearchPage(driver);
	}

	@Test(priority = 1, description = "checking five star hotels that showing hotels in 10 miles range or not")
	public void fiveStarHotelsMilesTest() {

		Assert.assertTrue(searchPage.checkHotelsInTenMiles(prop.getProperty("five_star"),prop.getProperty("five_star_time")));
	}

	@Test(priority = 2, description = "checking five star hotels that showing only 5 star hotels or not")
	public void fiveStarHotelsStarsTest() {

		Assert.assertTrue(
				searchPage.checkHotelsStars(prop.getProperty("five_star"), prop.getProperty("five_star_text"),prop.getProperty("five_star_time")));
	}

	@Test(priority = 3, description = "checking five star hotels that any Hilton hotel is in the result set or not")
	public void fiveStarHotelsHiltonTest() {

		Assert.assertTrue(searchPage.checkHotelsNameForHilton(prop.getProperty("five_star"), prop.getProperty("five_star_time")));
	}

	@Test(priority = 4, description = "checking four star hotels that showing hotels in 10 miles range or not")
	public void fourStarHotelsMilesTest() {

		Assert.assertTrue(searchPage.checkHotelsInTenMiles(prop.getProperty("four_star"),prop.getProperty("four_star_time")));
	}

	@Test(priority = 5, description = "checking four star hotels that showing only 4 star hotels or not")
	public void fourStarHotelsStarsTest() {

		Assert.assertTrue(
				searchPage.checkHotelsStars(prop.getProperty("four_star"), prop.getProperty("four_star_text"), prop.getProperty("four_star_time")));
	}

	@Test(priority = 6, description = "checking four star hotels that any Hilton hotel is in the result set or not")
	public void fourStarHotelsHiltonTest() {

		Assert.assertTrue(searchPage.checkHotelsNameForHilton(prop.getProperty("four_star"), prop.getProperty("four_star_time")));
	}

	@Test(priority = 7, description = "checking three star hotels that showing hotels in 10 miles range or not")
	public void threeStarHotelsMilesTest() {

		Assert.assertTrue(searchPage.checkHotelsInTenMiles(prop.getProperty("three_star"), prop.getProperty("three_star_time")));
	}

	@Test(priority = 8, description = "checking three star hotels that showing only 3 star hotels or not")
	public void threeStarHotelsStarsTest() {

		Assert.assertTrue(
				searchPage.checkHotelsStars(prop.getProperty("three_star"), prop.getProperty("three_star_text"), prop.getProperty("three_star_time")));
	}

	@Test(priority = 9, description = "checking three star hotels that any Hilton hotel is in the result set or not")
	public void threeStarHotelsHiltonTest() {

		Assert.assertTrue(searchPage.checkHotelsNameForHilton(prop.getProperty("three_star"), prop.getProperty("three_star_time")));
	}

	@AfterMethod
	public void tearDown() {

		basePage.quitBrowser();
	}

}

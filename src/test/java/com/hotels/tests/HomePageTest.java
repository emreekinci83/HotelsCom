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
import com.hotels.utils.Constants;
import com.hotels.listeners.TestAllureListener;

@Listeners({ TestAllureListener.class })
public class HomePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		homePage = new HomePage(driver);
		
	}
	@Test(priority=1, description="verify home page title..")
	public void getTitleTest(){
		String title = homePage.getHomePageTitle(Constants.HOME_PAGE_TITLE);
		System.out.println(title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2, description="select new york as a destination, check in day may-15-2020 and check out day jun-10-2020 then click search")
	public void selectDestinationTest(){
		homePage.selectDestinationDatesAndSubmit();
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}

}

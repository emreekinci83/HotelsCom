package com.hotels.pages;

import org.openqa.selenium.By;

import com.hotels.utils.ElementUtil;
import com.hotels.utils.JavaScriptUtil;

public class LoginMethod {
	
	ElementUtil util;
	JavaScriptUtil jutil;

	By destination = By.xpath("//input[@id='qf-0q-destination']");
	By check_in = By.id("widget-query-label-1");
	By next_month = By.xpath("//div[@class='widget-daterange-cont']//div[2]//div[1]//button[2]");

}

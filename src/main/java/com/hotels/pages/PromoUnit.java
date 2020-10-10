package com.hotels.pages;

import org.openqa.selenium.By;

import com.hotels.base.BasePage;
import com.hotels.utils.ElementUtil;
import com.hotels.utils.JavaScriptUtil;

public class PromoUnit extends BasePage{

	public PromoUnit(){
		
	}
	
	ElementUtil util;
	JavaScriptUtil jutil;

	By destination = By.xpath("//input[@id='qf-0q-destination']");
	By check_in = By.id("widget-query-label-1");
	
	public void Method(){
		
	}
}



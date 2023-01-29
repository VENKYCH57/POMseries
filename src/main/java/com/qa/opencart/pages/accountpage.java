package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class accountpage {
	public WebDriver driver;

	public accountpage(WebDriver driver) {
		this.driver = driver;
	}

	private By email = By.xpath("//input[@text='cms']");

	public void getaccountStatus() {
		System.out.println("this is my account page checkout");
		driver.findElement(email).sendKeys("venkych57@gmail.com");
	}

}

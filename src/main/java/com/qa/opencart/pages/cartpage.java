package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class cartpage {

	private By email = By.xpath("src/main/java/com/qa/opencart/pages/cartpage.java");

	public cartpage() {
		System.out.println("this is my cart page");
	}
	
	public void getCheckoutPage() {
		System.out.println("this is my checkout cart page");
	}

	public void getcartpage() {
		System.out.println("this is my cartpage method");
	}

}

package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavascriptUtil;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil elementutil;
	private JavascriptUtil js;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
		js = new JavascriptUtil(driver);
	}

	private By titleimage = By.xpath("//img[@title='Your Store']");
	private By header = By.xpath("//div/h1");

	private By firstn = By.id("input-firstname");
	private By lastn = By.id("input-lastname");
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By btnYes = By.xpath("(//div[@class='form-check form-check-inline']//label)[1]");
	private By btnno = By.xpath("(//div[@class='form-check form-check-inline']//label)[2]");
	private By agree = By.name("agree");
	private By ctn = By.xpath("//button[@type='submit']");
	private By camera = By.linkText("Cameras");


	public boolean registarionTitleImageExistOrNot() {
		return elementutil.doElementIsDispalyed(titleimage);
	}

	public String regHeaderPrsentOrNot() {
		return elementutil.doGetText(header);
	}

	public cameraPage registartion(String fn, String ln, String em, String pwd, String subscribe) throws InterruptedException {
		fillRegister(fn, ln, em, pwd);
		subscribe(subscribe);
		agreAndCont();
		return new cameraPage(driver);
	}

	private void fillRegister(String fn, String ln, String em, String pwd) {
		elementutil.doActSendkeys(firstn, fn);
		elementutil.doActSendkeys(lastn, ln);
		elementutil.doActSendkeys(email, em);
		elementutil.doActSendkeys(password, pwd);
	}

	private void subscribe(String subscribe) {
		if (subscribe.equalsIgnoreCase("yes")) {
			elementutil.doActClick(btnYes);
		} else {
			elementutil.doActClick(btnno);
		}
	}

	private void agreAndCont() throws InterruptedException {
		elementutil.doClick(agree);
		elementutil.doActClick(ctn);
		Thread.sleep(500);
		elementutil.doActClick(camera);
	}

}

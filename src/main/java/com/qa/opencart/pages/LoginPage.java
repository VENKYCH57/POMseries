package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementutil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}

	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotpassword = By.linkText("Forgotten Password");
	private By registerlink = By.linkText("Register");
	private By camera = By.linkText("Cameras");

	@Step("getting login page title")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	@Step("checking login page url")
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	@Step("checking login page forgot password link")
	public boolean forgotPasswordLinkExistOrNot() {
		return elementutil.doElementIsDispalyed(forgotpassword);
	}

	@Step("cheking  login page registerlink ")
	public boolean registerLinkExistOrNot() {
		return elementutil.doElementIsDispalyed(registerlink);
	}

	@Step("login with username :{0} and password :{1}")
	public cameraPage doLogin(String un, String pwd) {
		elementutil.doActSendkeys(emailid, un);
		elementutil.doSendKeys(password, pwd);
		// elementutil.doClick(registerlink);
		elementutil.doActClick(camera);
		return new cameraPage(driver);
	}

}

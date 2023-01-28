package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.ConstantsUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100: Opencart App- Design Login page")
@Story("US 101:Login page features with some basic functions and modules")
public class LoginPageTest extends BaseTest {

	@Description("this is my loginpage title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.getLoginPageTitle();
		Assert.assertEquals(title, ConstantsUtil.LOGIN_PAGE_TITLE);

	}

	@Description("this is my loginpage url test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void loginPageUrlTest() {
		String url = loginpage.getLoginPageUrl();
		Assert.assertTrue(url.contains(ConstantsUtil.LOGIN_PAGE_URL));
	}

	@Description("this is my loginpage forgot password test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 4)
	public void forgotPaswordLinkTest() {
		Assert.assertTrue(loginpage.registerLinkExistOrNot());
	}

	@Description("this is my loginpage registerlink test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void registerLinkTest() {
		Assert.assertTrue(loginpage.registerLinkExistOrNot());
	}

	@Description("this is my loginpage login test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 5)
	public void doLoginTest() {
		loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

}

package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.ConstantsUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic("Epic 200:Opencart App-Camera Page Design")
@Story("US 201:camera page test desgin and functions with modules ")
public class CameraPageTest extends BaseTest {

	@BeforeClass
	public void CameraPageSetup() {
		campage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test
	public void getCameraHeaderTest() {

		String header = campage.getCameraHeader();
		Assert.assertEquals(header, ConstantsUtil.CAMERA_PAGE_HEADER);
	}

	@Test
	public void getcameraPageTitleTest() {

		String cameraTitle = campage.getcameraPageTitle();
		Assert.assertEquals(cameraTitle, ConstantsUtil.CAMERA_PAGE_TITLE);
	}

	@Test
	public void getselectcameraTest() {
		Map<String, String> actcamdata = campage.getcameraData();
		actcamdata.forEach((k, v) -> System.out.println(k + ":" + v));
		softassert.assertEquals(actcamdata.get("Brand"), "Canon");
		softassert.assertEquals(actcamdata.get("Availability"), "2-3 Days");
		softassert.assertEquals(actcamdata.get("Reward Points"), "200");
		softassert.assertAll();
	}

}

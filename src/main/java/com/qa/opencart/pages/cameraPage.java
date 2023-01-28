package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class cameraPage {

	private WebDriver driver;
	private ElementUtil elementutil;

	public cameraPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}

	By camerheader = By.xpath("//div//h2");
	By camlink = By.linkText("Canon EOS 5D");
	By prodin = By.xpath("(//div[@class='col-sm']//ul)[1]/li");

	public String getcameraPageTitle() {
		return driver.getTitle();
	}

	public String getCameraHeader() {
		return elementutil.doGetText(camerheader);
	}

	public Map<String, String> getcameraData() {
		elementutil.doActClick(camlink);
		Map<String, String> proddata = new HashMap<String, String>();
		getdataCamera(proddata);
		return proddata;
	}

	private void getdataCamera(Map<String, String> proddata) {
		List<WebElement> actproddata = elementutil.getElements(prodin);
		for (WebElement e : actproddata) {
			String prodlist = e.getText();
			String prodkey = prodlist.split(":")[0].trim();
			String prodValue = prodlist.split(":")[1].trim();
			proddata.put(prodkey, prodValue);
		}

	}
}

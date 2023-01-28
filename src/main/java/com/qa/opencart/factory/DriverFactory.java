package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static String highlight;
	public static OptionsManager optionsmanager;
	public Properties prop;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {
		optionsmanager = new OptionsManager(prop);
		highlight = prop.getProperty("highlight").trim();
		String Browser = prop.getProperty("Browser").trim();
		System.out.println("browsername is :" + Browser);
		if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver(optionsmanager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
		} else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver(optionsmanager.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(optionsmanager.getFirefoxOptions()));
		} else if (Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
		} else if (Browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("please pass the right browser :" + Browser);
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url").trim());

		return getDriver();
	}

	public synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public Properties initProp() {
		prop = new Properties();
		String env = System.getProperty("env");
		FileInputStream ip = null;
		if (env == null) {
			try {
				ip = new FileInputStream("./src/tests/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				System.out.println("running on the environment :" + env);

				switch (env) {
				case "qa":
					ip = new FileInputStream("./src/tests/resources/config/qa.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/tests/resources/config/dev.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/tests/resources/config/stage.config.properties");
					break;

				default:
					System.out.println("please pass the right environment :" + env);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}

package com.sportsDirect.bdd.step_def;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sportsDirect.bdd.pageObjects.SportsDirectPage;

public class PageObjectInit {
	public static WebDriver driver = null;

	protected static SportsDirectPage sports = null;

	public WebDriver getDriver() {
		if (driver == null) {
			String path = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path + "\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		sports = new SportsDirectPage(driver);
		return driver;

	}
}

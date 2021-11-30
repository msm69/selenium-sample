package com.example.selenium;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverExample {

	public static void main(String[] args) {
		FirefoxOptions firefoxOptions = new FirefoxOptions();

		try {
			WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), firefoxOptions);
			driver.get("http://www.google.com");
			driver.quit();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

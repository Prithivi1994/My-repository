package com.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;
import com.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass{
	@Before
	public void beforeScenario() throws IOException {
		getDriver("Chrome");
		getUrl(getPropertyValue("url"));
		manageWindow(); 
		LoginPage login=new LoginPage();
		login.login(getPropertyValue("username"), getPropertyValue("password"));
	}
	@After
	public void afterScenario(Scenario scenario) {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);
		scenario.attach(bs, "png", "Every Scenario");
		driver.quit();

	}

}

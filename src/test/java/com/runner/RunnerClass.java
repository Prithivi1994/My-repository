package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.jvmreport.JvmReportGenerate;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty","json:src/test/resources/Json/cucumber.json" }, dryRun = false, features = "src/test/resources", glue = "com.stepdefinition",monochrome=true)
public class RunnerClass {
	@AfterClass
	public static void AfterClass() throws IOException {
		String path = System.getProperty("user.dir");
		JvmReportGenerate.generateJVMreport(path+"\\src\\test\\resources\\Json\\cucumber.json");

	}

}

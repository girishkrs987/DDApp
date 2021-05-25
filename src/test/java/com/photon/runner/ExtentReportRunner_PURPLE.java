package com.photon.runner;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;




@CucumberOptions(features = { "Feature" }, glue = { "stepDefinition" }, dryRun = false , tags = { "@REP-634" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:output/extent-report/report.html", "html:target/cucumber-htmlreport"
		 })

public class ExtentReportRunner_PURPLE extends AbstractTestNGCucumberTests {

	@After
	public static void reportGeneration() {
		//Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+ "/src/test/java/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", System.getProperty("os.name"));
	}

}

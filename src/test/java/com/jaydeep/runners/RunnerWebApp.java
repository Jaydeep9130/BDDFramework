
package com.jaydeep.runners;
 
import org.testng.annotations.DataProvider;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(features = "src/test/resources/features", glue = { "com.jaydeep.steps" }, tags = "@DemoBlaze" , dryRun = false, monochrome = false, plugin = { "pretty",

				"pretty:target/cucumber-report/pretty.txt", "html:target/cucumber-report/cucumber-report.html",

				"json:target/cucumber-report/cucumber.json", "junit:target/cucumber-report/cucumber-junitreport.xml",

				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
 
public class RunnerWebApp extends AbstractTestNGCucumberTests {
 
	/***

	 * Please enable parallel = true for executing scenaeios in Parallel Also

	 * number of Parallel Threads can be controlled in suite-xml file with

	 * parameter data-provider-thread-count="1"

	 */
 
	@Override

	@DataProvider(parallel = false)

	public Object[][] scenarios() {

		return super.scenarios();

	}

}

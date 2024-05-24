

package com.jaydeep.steps;
 
import java.io.IOException;

import com.jaydeep.framework.DriverManager;
import com.jaydeep.framework.TestHarness;

import io.cucumber.java.After;

import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
 
public class CukeHooks extends MasterSteps {
 
	private TestHarness testHarness;
 
	@Before

	public void setUp(Scenario scenario) {
 
		testHarness = new TestHarness();

		DriverManager.getTestParameters().setScenario(scenario);

		testHarness.invokeDriver(scenario);

	}
 
	@After

	public void tearDown(Scenario scenario) throws IOException {
 
		testHarness.closeRespestiveDriver(scenario);

	}
 
}

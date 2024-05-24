
package com.jaydeep.steps;
 
import static java.lang.invoke.MethodHandles.lookup;

import static org.slf4j.LoggerFactory.getLogger;
 
import org.slf4j.Logger;

import org.testng.Assert;
 
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.restassured.RestAssured;

import io.restassured.response.Response;
 
public class DemoCreateEmployee_API_StepDef extends MasterSteps {

	final static Logger log = getLogger(lookup().lookupClass());

	Response response ;

	@Given("Administrator creates new employee with details such as Name {string}, Salary {string}, Age {string}")

	public void administrator_creates_new_employee_with_details_such_as_name_salary_age(String name, String salary,

			String age) {

		// Api full URI : https://dummy.restapiexample.com/api/v1/creates

		RestAssured.baseURI="https://dummy.restapiexample.com/api/";

		String reqBody = "{\"name\":\""+name+"\",\"salary\":\""+salary+"\",\"age\":\""+age+"\"}";

		response = RestAssured.given().header("Content-Type", "application/json").body(reqBody).post("v1/create");

		log.info("Request Body :\n"+reqBody);

		log.info("Response Body : \n"+response.prettyPrint());

	}
 
	@Then("Admin validates status code {string}")

	public void admin_validates_status_code(String statusCodeExpected) {

		String statusCode = Integer.toString(response.statusCode());

		log.info("Status code: "+statusCode);

		Assert.assertEquals(statusCode, statusCodeExpected,"Status Code is not matching...");

	}

	@Given("Administrator Searches employee with Id {string}")

	public void administrator_searches_employee_with_id(String empId) {

		RestAssured.baseURI="https://dummy.restapiexample.com/api/";

		String path = "v1/employee/"+empId;

		response = RestAssured.get(path);

		log.info("Response Body : "+response.asPrettyString());

	}

}

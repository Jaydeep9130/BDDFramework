
package com.jaydeep.steps;

import static java.lang.invoke.MethodHandles.lookup;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.virtualauthenticator.Credential;

import org.slf4j.Logger;

import org.testng.Assert;

import org.testng.asserts.SoftAssert;

import com.jaydeep.framework.DriverManager;
import com.jaydeep.njewelth.NJEwelthLogin;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

public class NjEWealth extends MasterSteps {

	WebDriver driver = DriverManager.getWebDriver();

	@Given("User is logged in nj e welth app {}")

	public void User_is_logged_in_nj_e_welth_app(String uname) {

		driver.get("https://ewa.njindiaonline.com/ewa/login");

		waitFor(5000);

		NJEwelthLogin njlogin = new NJEwelthLogin(driver);

		njlogin.loginIntoNjEwelth(uname);

	}

	@When("Custmers logged in successfully")

	public void Custmers_logged_in_successfully() {

		NJEwelthLogin njlogin = new NJEwelthLogin(driver);

		njlogin.UserProfile();

		attachScreenshotForWeb();

	}

	@Then("Click on Mutual fund button")

	public void Click_on_Mutual_fund_button() {

		NJEwelthLogin NjMutualfunds = new NJEwelthLogin(driver);

		NjMutualfunds.MutualFund();

		waitFor(8000);

		// String allRows =
		// driver.findElement(By.xpath("//*[@id=\"type-id\"]/div[2]")).getText();

		// System.out.println(allRows);

		List<WebElement> allrows = driver.findElements(By.xpath("//*[@id=\"type-id\"]/div[2]/div[2]/table/tbody"));

		int size = allrows.size();

		for (int i = 0; i < size; i++) {

			String rows = allrows.get(i).getText();

			System.out.println(rows);

		}

		attachScreenshotForWeb();

	}

}

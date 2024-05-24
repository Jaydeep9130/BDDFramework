
package com.jaydeep.steps;
 
import static java.lang.invoke.MethodHandles.lookup;

import static org.slf4j.LoggerFactory.getLogger;
 
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;

import org.testng.Assert;

import com.jaydeep.framework.DriverManager;
import com.jaydeep.pages.DemoBlazeBannerPage;
import com.jaydeep.pages.DemoBlazeHomePage;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
 
public class DemoBlazeStepDef extends MasterSteps{


	WebDriver driver = DriverManager.getWebDriver();

	final static Logger log = getLogger(lookup().lookupClass());

	@Given("User is logged into demoblaze website with username {string} and password {string}")

	public void user_is_logged_into_demoblaze_website_with_username_and_password(String usrName, String pass) {

		String appUrl = properties.getProperty("ApplicationUrl");

		driver.get(appUrl);

		DemoBlazeHomePage homePage = new DemoBlazeHomePage(driver);

		DemoBlazeBannerPage bannerPage = new DemoBlazeBannerPage(driver);

		waitFor(3000);

		bannerPage.clickOnLoginLink();

		log.info("Username entered : "+usrName);

		log.info("Password entered : "+pass);

		homePage.loginIntoDemoBlaze(usrName, pass);

		waitFor(5000);

	}
 
	@Then("User verifies Username {string} in dashboard")

	public void user_verifies_username_in_dashboard(String usrName) {

		DemoBlazeHomePage homePage = new DemoBlazeHomePage(driver);

		String nameOfTheUser = homePage.getNameOfTheUser();

		attachScreenshotForWeb();

		log.info("Logged User : "+nameOfTheUser);

		String ExpectedUsername = "Welcome "+usrName;

		Assert.assertEquals(nameOfTheUser, ExpectedUsername, "The Actual and Expected logged username is not matching....");

		waitFor(5000);

	}

	@Then("User adds {string} to cart and verifies")

	public void user_adds_monitor_to_cart_and_verifies(String productName) {

		DemoBlazeHomePage homePage = new DemoBlazeHomePage(driver);

		homePage.clickOnMonitors_Category();

		waitFor(4000);

		homePage.clickGivenProduct(productName);

		waitFor(3000);

		homePage.addProductToCart();

		waitFor(3000);

		driver.switchTo().alert().accept();

		waitFor(2000);

		DemoBlazeBannerPage bannerPage = new DemoBlazeBannerPage(driver);

		bannerPage.clickOnCartLink();

		waitFor(3000);

		String actualProductInCart = homePage.getProductAddedToCartLatest();

		log.info("Actual Product Available in cart : "+actualProductInCart);

		attachScreenshotForWeb();

		driver.quit();

	}


	@Given("User launches Flipkart application and loggs in with Username {string} and Password {string}")

	public void user_launches_flipkart_application_and_loggs_in_with_username_and_password(String string, String string2) {

	}
 
}

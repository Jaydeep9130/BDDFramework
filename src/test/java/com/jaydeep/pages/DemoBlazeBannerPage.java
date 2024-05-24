
package com.jaydeep.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.openqa.selenium.support.PageFactory;

import com.jaydeep.steps.MasterSteps;

public class DemoBlazeBannerPage extends MasterSteps {

	private WebDriver driver;

	public DemoBlazeBannerPage(WebDriver driver) {

		this.driver = driver;

		this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(240));

		PageFactory.initElements(this.driver, this);

	}

	@FindBy(how = How.ID, using = "login2")

	public WebElement logInLink;

	@FindBy(how = How.XPATH, using = "//a[text()='Cart']")

	public WebElement cartLink;

	public void clickOnLoginLink() {

		logInLink.click();

	}

	public void clickOnCartLink() {

		cartLink.click();

	}

}

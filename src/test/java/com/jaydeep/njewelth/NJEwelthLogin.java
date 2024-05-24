
package com.jaydeep.njewelth;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;

import java.util.Iterator;

import java.util.List;

import java.util.Set;
 
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.jaydeep.steps.MasterSteps;
 
public class NJEwelthLogin extends MasterSteps {


		private WebDriver driver;

		public NJEwelthLogin(WebDriver driver) {

			this.driver = driver;

			this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(240));

			PageFactory.initElements(this.driver, this);

		}

		@FindBy(how=How.XPATH, using="//input[@value='loginid']")

		public WebElement loginMethod; 

		@FindBy(how = How.XPATH, using = "//input[@id='loginid']")

		public WebElement Username;


		@FindBy(how = How.XPATH, using = "//input[@name='password']")

		public WebElement Password;

		@FindBy(how = How.XPATH, using = "//button[@id='loginsubmit']")

		public WebElement SignIn;

		@FindBy(how= How.XPATH, using="//*[@id=\"root\"]/div[3]/div[1]/div/div/section/div[1]/div[1]/div/h2[2]")

		public WebElement profile;

		@FindBy(how=How.XPATH, using="//*[@id=\"root\"]/div[3]/div[1]/div/div/section/div[3]/div/div[2]/div/div[2]/div/div/div/div[1]/ul/li/a/ul")

		public WebElement MutualFund;

		@FindBy(how=How.XPATH,using="//*[@id=\"type-id\"]/div[2]/div[2]/table")

		public WebElement MutualFundsDetails;

		@FindBy(how= How.XPATH, using="//div[contains(text(),'Detail Report')]")

		public WebElement DetailsReports;

		@FindBy(how=How.XPATH, using="//*[@id=\"root\"]/div[3]/header/div/div[1]/div[1]/a")

		public WebElement PortFolio;



		//Below Mention the login method

		public void loginIntoNjEwelth(String LoginUname) {

			loginMethod.click();

			Username.sendKeys(LoginUname);

			Password.sendKeys("Jaydeep@9096");

			SignIn.click();

			waitFor(8000);

		}


		public void UserProfile() {

			// TODO Auto-generated method stub

			String UserName=profile.getText();

			System.out.println(UserName);

		}

		public void MutualFund() {

			waitFor(5000);

			MutualFund.click();

			//System.out.println(Mutual);

		}
 
		public void DetailsReport() {

			DetailsReports.click();

			//String driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/main/div/div[2]/div/div[2]/div/div/div[2]/div"));

		}

		public void LivSystematicPlans() {


		}

	}
 
 

package com.jaydeep.pages;
 
import static java.lang.invoke.MethodHandles.lookup;

import static org.slf4j.LoggerFactory.getLogger;
 
import java.time.Duration;

import java.util.List;
 
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;

import com.jaydeep.steps.MasterSteps;
 
public class DemoBlazeHomePage extends MasterSteps {

	final static Logger log = getLogger(lookup().lookupClass());

	private WebDriver driver;


	public DemoBlazeHomePage(WebDriver driver) {

		this.driver = driver;

		this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(240));

		PageFactory.initElements(this.driver, this);

	}
 
	@FindBy(how = How.ID, using = "loginusername")

	public WebElement username;
 
	@FindBy(how = How.ID, using = "loginpassword")

	public WebElement password;
 
	@FindBy(how = How.XPATH, using = "//button[text()='Log in']")

	public WebElement LogInBtn;
 
	@FindBy(how = How.ID, using = "nameofuser")

	public WebElement nameOftheUser;
 
	@FindBy(how = How.XPATH, using = "//a[text()='Monitors']")

	public WebElement categories_Monitors;
 
	@FindBy(how = How.XPATH, using = "//h4[@class='card-title']/a")

	public List<WebElement> productList;
 
	@FindBy(how = How.XPATH, using = "//a[text()='Add to cart']")

	public WebElement addToCart;
 
	@FindBy(how = How.XPATH, using = "//tbody[@id='tbodyid']/tr/td[2]")

	public WebElement productNameInCart;
 
	public void loginIntoDemoBlaze(String usrName, String passWord) {

		username.sendKeys(usrName);

		password.sendKeys(passWord);

		LogInBtn.click();

	}
 
	public String getNameOfTheUser() {

		return nameOftheUser.getText();

	}
 
	public void clickOnMonitors_Category() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

//		js.executeScript("arguments[0].scrollIntoView();", categories_Monitors);

		js.executeScript("window.scrollBy(0,450)", "");

		try {

			Thread.sleep(5000);

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		categories_Monitors.click();

	}
 
	public void clickGivenProduct(String prdct) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,350)", "");

		try {

			Thread.sleep(5000);

		} catch (InterruptedException e1) {

			// TODO Auto-generated catch block

			e1.printStackTrace();

		}

		for (WebElement e : productList) {

			try {

				if (e.getText().equalsIgnoreCase(prdct)) {

					wait.until(ExpectedConditions.elementToBeClickable(e));

					e.click();
 
				} else {

					log.error("No Product Clicked");

				}

			} catch (Exception ex) {
 
			}

		}

	}
 
	public void addProductToCart() {

		addToCart.click();

	}
 
	public String getProductAddedToCartLatest() {

		return productNameInCart.getText();

	}

}

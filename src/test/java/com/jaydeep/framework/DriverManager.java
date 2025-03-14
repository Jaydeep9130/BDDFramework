
package com.jaydeep.framework;
 
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
import org.openqa.selenium.WebDriver;
 
import io.appium.java_client.AppiumDriver;
 
/**
* A generic WebDriver manager, which handles multiple instances of WebDriver.
* 
* 
*/
public class DriverManager {
 
	/*
	 * Used for Multithreading of WebDriver Object
	 */
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<SeleniumTestParameters> testParameters = new ThreadLocal<SeleniumTestParameters>();
	@SuppressWarnings("rawtypes")
	private static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<AppiumDriver>();
 
	static Logger log;
 
	static {
		 log = getLogger(lookup().lookupClass());
	}
 
	/**
	 * Function to return the object for WebDriver {@link WebDriver} object
	 * 
	 * @return Instance of the {@link WebDriver} object
	 */
	public static WebDriver getWebDriver() {
		if (webDriver.get() == null) {
			// this is need when running tests from IDE
			log.error(
					"WebDriver Object didnot initialize properly, please check the capabilities/parameters in TestNG.xml");
			// setWebDriver(DriverFactory.createWebDriverInstance(null));
		}
		return webDriver.get();
	}
 
	/**
	 * Function to set the WebDriver Object{@link WebDriver} object
	 * 
	 * @param driver
	 */
	public static void setWebDriver(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		DriverManager.webDriver.set(driver);
	}
 
	/**
	 * Function to set the SeleniumTestParameters
	 * Object{@link SeleniumTestParameters} object
	 * 
	 * @param testParameters
	 */
	public static void setTestParameters(SeleniumTestParameters testParameters) {
		DriverManager.testParameters.set(testParameters);
	}
 
	/**
	 * Function to return the object for SeleniumTestParameters
	 * {@link SeleniumTestParameters} object
	 * 
	 * @return Instance of the {@link SeleniumTestParameters} object
	 */
	public static SeleniumTestParameters getTestParameters() {
		return testParameters.get();
	}
 
	/**
	 * Function to return the object for AppiumDriver {@link AppiumDriver}
	 * object
	 * 
	 * @return Instance of the {@link AppiumDriver} object
	 */
	@SuppressWarnings("rawtypes")
	public static AppiumDriver getAppiumDriver() {
		if (appiumDriver.get() == null) {
			// this is need when running tests from IDE
			log.error(
					"AppiumDriver Object didnot initialize properly, please check the capabilities/parameters/Appium Setup");
			// setAppiumDriver(DriverFactory.createAppiumInstance(null));
		}
		return appiumDriver.get();
	}
 
	/**
	 * Function to set the AppiumDriver Object{@link AppiumDriver} object
	 * 
	 * @param driver
	 */
	@SuppressWarnings("rawtypes")
	public static void setAppiumDriver(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.appiumDriver.set(driver);
	}
}

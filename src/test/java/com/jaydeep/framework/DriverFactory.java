package com.jaydeep.framework;
 
import java.util.Properties;
 
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;

import static org.slf4j.LoggerFactory.getLogger;

import org.openqa.selenium.WebDriver;
 
import io.appium.java_client.AppiumDriver;
 
/**

* DriverFactory which will create respective driver Object

* 

* 

*/

public class DriverFactory {
 
	final static Logger log = getLogger(lookup().lookupClass());

	private static Properties properties = Settings.getInstance();
 
	/**

	 * Function to return the object for WebDriver {@link WebDriver} object

	 * 

	 * @param testParameters

	 * 

	 * @return Instance of the {@link WebDriver} object

	 */

	public static WebDriver createWebDriverInstance(SeleniumTestParameters testParameters) {

		WebDriver driver = null;

		try {

			switch (testParameters.getExecutionMode()) {
 
			case LOCAL:

				driver = WebDriverFactory.getWebDriver(testParameters.getBrowser());

				break;
 
			case GRID:

				driver = WebDriverFactory.getRemoteWebDriver(testParameters.getBrowser(),

						testParameters.getBrowserVersion(), testParameters.getPlatform(),

						properties.getProperty("RemoteUrl"));

				break;
 
			default:

				throw new Exception("Unhandled Execution Mode!");

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			log.error(ex.getMessage());

		}

		return driver;

	}
 
	/**

	 * Function to return the object for AppiumDriver {@link AppiumDriver} object

	 * 

	 * @param testParameters

	 * 

	 * @return Instance of the {@link AppiumDriver} object

	 */

	@SuppressWarnings("rawtypes")

	public static AppiumDriver createAppiumInstance(SeleniumTestParameters testParameters) {
 
		AppiumDriver driver = null;

		try {

			switch (testParameters.getExecutionMode()) {
 
			case MOBILE:
 
				driver = AppiumDriverFactory.getAppiumDriver(testParameters);

				break;
 
			default:

				throw new Exception("Unhandled Execution Mode!");

			}

		} catch (Exception ex) {

			ex.printStackTrace();

			log.error(ex.getMessage());

		}

		return driver;

	}

}
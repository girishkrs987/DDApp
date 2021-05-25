
package com.photon.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;

public class CommonLibrary {

	public static AppiumDriver<MobileElement> driver3 = null;
	public static AndroidDriver<MobileElement> driver2 = null;
	public static IOSDriver<MobileElement> driver1 = null;
	public static WebDriver driver = null;
	public static WebElement element = null;
	static WebDriverWait browserWithElementWait = null;
	static long t1 = 0;
	static long t2 = 0;
	static long timeTaken = 0;
	public static String systemUsername = null;
	public static Configuration config = null;
	static String destDir;
	static DateFormat dateFormat;
	public static String driverpath = System.getProperty("user.dir");
	public static String URL =null;
	public static String mainWindow =null;
	public static String Latesprojectpath = driverpath.replaceAll("\\\\", "\\\\\\\\");
	public static String chromepathLatest = Latesprojectpath + File.separator + "\\Killdriver" + File.separator
			+ "\\Killchrome1.bat";
	public static FileWriter reportFile = null;
	static long pageStartTime = -1;
	static BrowserMobProxy proxy = new BrowserMobProxyServer();

	public CommonLibrary() throws ConfigurationException, IOException {
		ConfigurationFactory factory = new ConfigurationFactory("config/config.xml");
		config = factory.getConfiguration();
	}

	/*
	 * 
	 * Method to Quit application
	 * 
	 */

	public static void closeApplication() throws InterruptedException {

		// driver.quit();
//		driver.close();

	}

	public static <ReportObject1> void logPerfMetrics(ReportObject1 ro1) throws IOException {
		// reportFile=new FileWriter("Report");

		reportFile.append(ro1.toString());
		reportFile.append("\n");
		reportFile.flush();
	}

	public static void takeScreenShot(Scenario scenario) throws IOException {
		String scrname = scenario.getId().replace(";", "").replace("-", "");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(scrFile,
				new File(driverpath + "/output/extent-report/FailureScreenShots/" + scrname + ".png"));
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
		Reporter.addScreenCaptureFromPath("./FailureScreenShots/" + scrname + ".png");
	}

	public static void dynamicDataValidation_regExpression(String pattern, String objectProperty) {

		element = getElementByProperty(objectProperty, driver);
		String actualText = element.getText();
		try {
			Pattern r = Pattern.compile(pattern);

			// Now create matcher object.
			Matcher m = r.matcher(actualText);
			if (m.find()) {
				System.out.println("The format of value is as expected " + m.group(0));

			} else {

				throw new Exception("NO MATCHING DATA FOUND");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void Assert(boolean Method, String Result) throws Exception {
		boolean e1 = Method;

		if (e1 == true) {
			System.out.println(Result);
		} else {

			CommonLibrary.closeApplication();
			throw new Exception(Result + ": False");

		}
	}

	public static void Soft_Assertion(boolean Method, String Result) {
		SoftAssert s_assert = new SoftAssert();
		s_assert.assertEquals(true, Method, Result);
	}

	public static void Hard_Assertion(boolean Method, String Result) {

		Assert.assertEquals(true, Method, Result);
	}

	/*
	 * 
	 * Method to Launch Application
	 * 
	 */
	public static void App_Launch() throws IOException {

		Object getConfigUrl = config.getProperty("applicationURL");
		systemUsername = System.getProperty("user.name");
		String envBrowser = System.getProperty("envBrowser");
		/*String[] parts = envBrowser.split("-");
		String env = parts[0]; // 004
		String browser = parts[1];*/
		
		//Local Execution
		String env = "ode1";
		String browser = "chrome"; 
		


		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.setExperimentalOption("useAutomationExtension", false);
			if (browser.contains("headless")) {
				options.addArguments("headless");
				options.addArguments("window-size=1200x800");
			}
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
		} else if (browser.contains("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/DriverJenkins/geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			if (browser.contains("headless")) {
				options.addArguments("-headless");
				options.addArguments("window-size=1200x800");
			}
			driver = new FirefoxDriver(options);
			driver.manage().deleteAllCookies();
		}

		else if (browser.contains("safari")) {

			SafariOptions options = new SafariOptions();
			if (browser.contains("headless")) {
				 //options.addArguments("-headless");
				 //options.addArguments("window-size=1200x800");
			}
			driver = new SafariDriver(options);
			driver.manage().deleteAllCookies();
		}

		// driver = new HtmlUnitDriver();
		URL = "https://uat:watchoutforsharks@uat.purple.com/";
		//URL = "https://staging:watchoutforsharks@staging.purple.com/";//"https://purple" + env + getConfigUrl.toString();
		System.out.println(URL);
		driver.get(URL);


	}
	
	public static void App_Launch1(String browser) throws IOException {

		Object getConfigUrl = config.getProperty("applicationURL");
		systemUsername = System.getProperty("user.name");
		
		//Jenkins Execution
		/*String envBrowser = System.getProperty("envBrowser");
		String[] parts = envBrowser.split("-");
		String env = parts[0]; // 004
		String browser = parts[1];*/
		

		//Local Execution
		//String env = "ode1";
		//String browser = "chrome"; 

		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.setExperimentalOption("useAutomationExtension", false);
			if (browser.contains("headless")) {
				options.addArguments("headless");
				options.addArguments("window-size=1200x800");
			}
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
		} else if (browser.contains("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();

			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/DriverJenkins/geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			if (browser.contains("headless")) {
				options.addArguments("-headless");
				options.addArguments("window-size=1200x800");
			}
			driver = new FirefoxDriver(options);
			driver.manage().deleteAllCookies();
		}

		else if (browser.contains("safari")) {

			SafariOptions options = new SafariOptions();
			if (browser.contains("headless")) {
				 //options.addArguments("-headless");
				 //options.addArguments("window-size=1200x800");
			}
			driver = new SafariDriver(options);
			driver.manage().deleteAllCookies();
		}

		// driver = new HtmlUnitDriver();
		//URL = "https://uat:watchoutforsharks@uat.purple.com/";
		URL = "https://purple" + env + getConfigUrl.toString();
		System.out.println(URL);
		driver.get(URL);


	}

	public static boolean isElementPresentVerifyClick(String objectProperty1, String objectproperty, String pageName)
			throws Throwable {
		boolean isVerifiedAndClicked = false;
		browserWithElementWait = new WebDriverWait(driver, 50);

		try {
			element = getElementByProperty(objectProperty1, driver);
			browserWithElementWait.until(ExpectedConditions.elementToBeClickable(element));
			if (element != null) {
			
				proxy.newHar("pageName");
				long startTime = System.currentTimeMillis();
				element.click();
				long endTime = System.currentTimeMillis();
				long timeTaken = (endTime - startTime);
				System.out.println("Total time taken on " + pageName + " :" + timeTaken + "ms");
				Har har = proxy.endHar();
				System.out.println("***********************************");
				String harFileName = System.getProperty("user.dir") + File.separator + "har" + File.separator + pageName
						+ ".har";
				File file = new File(harFileName);
				System.out.println(har.toString());
				har.writeTo(file);
				System.out.println("***********************************");
				// PageLoadEvaluation(pageName, startTime, timeTaken);
				Thread.sleep(1000);
				isVerifiedAndClicked = true;
			} else {
				throw new Exception("Object Couldn't be retrieved and clicked");
			}
		} catch (Exception e) {
			element = null;
			e.printStackTrace();
		}
		return isVerifiedAndClicked;
	}

	public static void closeReportFile() throws IOException {
		reportFile.flush();
		reportFile.close();
	}

	public static boolean isElementPresentVerifyClickAuthentication(String objectProperty, String pageName)
			throws Throwable {

		boolean isVerifiedAndClicked = false;
		browserWithElementWait = new WebDriverWait(driver, 50);

		try {
			element = getElementByProperty(objectProperty, driver);
			browserWithElementWait.until(ExpectedConditions.elementToBeClickable(element));
			if (element != null) {
				// JavascriptExecutor executor = (JavascriptExecutor)driver;
				// executor.executeScript("arguments[0].click(true);", element);
				proxy.newHar("pageName");
				long startTime = System.currentTimeMillis();
				element.click();
				long endTime = System.currentTimeMillis();
				long timeTaken = (endTime - startTime);
				System.out.println("Total time taken on " + pageName + " :" + timeTaken + "ms");
				Har har = proxy.endHar();
				System.out.println("***********************************");
				String harFileName = System.getProperty("user.dir") + File.separator + "har" + File.separator + pageName
						+ ".har";
				File file = new File(harFileName);
				System.out.println(har.toString());
				har.writeTo(file);
				System.out.println("***********************************");
				// PageLoadEvaluationAuthentication(pageName, startTime,
				// timeTaken);
				Thread.sleep(1000);
				isVerifiedAndClicked = true;
			} else {
				throw new Exception("Object Couldn't be retrieved and clicked");
			}
		} catch (Exception e) {
			element = null;
			e.printStackTrace();
		}
		return isVerifiedAndClicked;
	}

	public static void killChromeSession() throws Throwable {
		String os = System.getProperty("os.name");
		if (os != null && os.contains("Mac")) {
			String target = "Killdriver/Killchrome2.sh";
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(target);
			proc.waitFor();
			StringBuffer output = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\t");
				System.out.println("#" + output);
			}
		} else if (os != null && os.contains("Window")) {

			Runtime.getRuntime().exec("cmd /c start " + chromepathLatest);
		} else {
			System.out.println("OS is not supported to kill Chrome session");
		}
	}

	/*
	 * Method for Text validation
	 */

	public static boolean text_Validation(String objectProperty, String expectedText) {
		boolean Textvalidation = false;
		try {
			element = getElementByProperty(objectProperty, driver);
			String actualText = element.getText().replace('\n', ' ');
			if (actualText.equalsIgnoreCase(expectedText)) {
				Textvalidation = true;
				// System.out.println("Text expected and actual text are Same:" + actualText);
			} else {
				System.out.println(" Text expected and actual text are not Same:");
				System.out.println(" Text - Actual : " + actualText);
				System.out.println(" Text -Expected : " + expectedText);

			}
		} catch (Exception e) {

		} finally {
		}
		return Textvalidation;
	}

	// Added temporarily
	public static boolean text_ValidationUsingContains(String objectProperty, String expectedText) {
		boolean Textvalidation = false;
		try {
			element = getElementByProperty(objectProperty, driver);
			String actualText = element.getText().replace('\n', ' ');
			if (actualText.contains(expectedText)) {
				Textvalidation = true;
				// System.out.println(" Text expected and actual text are Same:" + actualText);
			} else {
				System.out.println(" Text expected and actual text are not Same:");
				System.out.println(" Text - Actual : " + actualText);
				System.out.println(" Text -Expected : " + expectedText);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return Textvalidation;
	}

	/*
	 * Method for Image Accessibility
	 */

	public static void accessibilityValidation(String objectProperty, String Text, String imgName) {
		try {
			element = getElementByProperty(objectProperty, driver);
			String alt = element.getAttribute("alt");
			if (alt.equalsIgnoreCase(Text)) {
				System.out.println(imgName + " Image accessibility expected and actual name are Same");
			} else {
				System.out.println(imgName + " Image accessibility expected and actual name are not Same");
				System.out.println("Accessibility-Actual : " + alt);
				System.out.println("Accessibility-Expected : " + Text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	/*
	 * Method for Link Text Validation
	 */

	public static void linkText_Validation(String objectProperty, String Text) {
		try {
			element = getElementByProperty(objectProperty, driver);
			String linkText = element.getText();

			if (linkText.equalsIgnoreCase(Text)) {
				System.out.println("Link Text expected and actual text are Same");
			} else {
				System.out.println("Link Text expected and actual text are not Same");
				System.out.println("Link Text - Actual : " + linkText);
				System.out.println("Link Text -Expected : " + Text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	/*
	 * Method for performance validation
	 */

	public static void performanceValidation(long t1, long t2, String perf_Expected)
			throws Exception, IOException, InterruptedException {
		try {
			timeTaken = (t2 - t1) / 1000;
			long expected = Long.parseLong(perf_Expected);
			if (timeTaken <= expected) {
			} else {
				System.out.println(" Page Load Time is High while Navigating to ::" + driver.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	/*
	 * Method for identifying Web-element by ID/CLASS/NAME/XPATH
	 */

	public static WebElement getElementByProperty(String objectProperty, WebDriver webDriver) {
		element = null;

		String propertyType = null;
		WebDriverWait browserWithElementWait = null;
		try {

			browserWithElementWait = new WebDriverWait(webDriver, 30);
			propertyType = StringUtils.substringAfter(objectProperty, "~");
			objectProperty = StringUtils.substringBefore(objectProperty, "~");
			if (propertyType.equalsIgnoreCase("CSS")) {
				element = browserWithElementWait
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("ID")) {
				element = browserWithElementWait
						.until(ExpectedConditions.visibilityOfElementLocated((By.id(objectProperty))));
				// highlightElement(webElement, browser);
			} else if (propertyType.equalsIgnoreCase("NAME")) {
				element = browserWithElementWait
						.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(objectProperty))));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("LINKTEXT")) {
				element = browserWithElementWait
						.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(objectProperty))));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("CLASS")) {
				element = browserWithElementWait
						.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(objectProperty))));
				highlightElement(element, webDriver);
			} else {
				element = browserWithElementWait
						.until(ExpectedConditions.visibilityOfElementLocated((ByXPath.xpath(objectProperty))));

			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {

		}

		return element;
	}

	/*
	 * Common Methods for Element Verification
	 */

	public static boolean isElementPresentVerification(String objectProperty) throws Exception {
		boolean isElementPresent = false;

		try {
			element = getElementByProperty(objectProperty, driver);
			if (element != null) {
				isElementPresent = true;
			} else {
				// throw new Exception("Object Couldn't be retrieved and
				// verified");
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return isElementPresent;
	}

	public static boolean isElementNotPresentVerification(String objectProperty) throws Exception {
		boolean isElementPresent = false;

		try {
			element = getElementByProperty(objectProperty, driver);
			if (element == null) {
				isElementPresent = true;
				// t2=System.currentTimeMillis();
			} else {
				 throw new Exception("Element Present");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return isElementPresent;
	}

	public static boolean isElementSelected(String objectProperty) throws Exception {
		boolean isElementSelected = false;
		try {
			element = getElementByProperty(objectProperty, driver);
			if (element.isSelected()) {
				isElementSelected = true;
			} else {
				throw new Exception("Given Element not selected");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return isElementSelected;

	}

	public static boolean isElementDisplayed(String objectProperty) throws Exception {
		boolean isElementDisplayed = false;
		try {
			element = getElementByProperty(objectProperty, driver);
			browserWithElementWait.until(ExpectedConditions.visibilityOf(element));
			if (element.isEnabled()) {
				isElementDisplayed = true;
				t2 = System.currentTimeMillis();
			} else {
				throw new Exception("Given Element is avilable");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return isElementDisplayed;

	}

	// To check the Element is Enable and disabled

	public static boolean isElementEnabled(String objectProperty, String elementState) throws Exception {
		boolean isElementEnable = false;
		try {
			element = getElementByProperty(objectProperty, driver);
			String att = element.getAttribute("enabled");
			if (elementState.equals("enabled")) {
				if (att.equals("true")) {
					isElementEnable = true;
					System.out.println("Element is :" + elementState);
				} else {
					throw new Exception("Given Element is avilable");
				}
			}

			if (elementState.equals("disabled")) {
				if (att.equals("false")) {
					isElementEnable = true;
					System.out.println("Element is :" + elementState);
					// t2=System.currentTimeMillis();
				} else {
					throw new Exception("Given Element is avilable");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return isElementEnable;

	}

	/*
	 * Created this method to verify if an element is not clickable and this in turn
	 * verify that the element is also not editable
	 * 
	 */
	public static boolean isElementNotClickable(String objectProperty, String elementState) throws Exception {
		boolean isElementclickable = false;
		try {
			element = getElementByProperty(objectProperty, driver);
			String att = element.getAttribute("clickable");
			if (elementState.equals("clickable")) {
				if (att.equals("false")) {
					isElementclickable = true;
					System.out.println("Element is Not: " + elementState);
				} else {
					throw new Exception("Given Element clickable");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return isElementclickable;

	}
	

	public static boolean moveToElement(String objectProperty) throws Exception {
		boolean isElementPresent = false;

		try {
			element = getElementByProperty(objectProperty, driver);
			if (element != null) {
				 Actions action = new Actions(driver);
				  action.moveToElement(element).pause(1000).build().perform();
				isElementPresent = true;
			} else {
				// throw new Exception("Object Couldn't be retrieved and
				// verified");
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return isElementPresent;
	}
	
	public static boolean moveToElementAndClick(String objectProperty) throws Exception {
		boolean isElementPresent = false;

		try {
			element = getElementByProperty(objectProperty, driver);
			if (element != null) {
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();
				  action.click().build().perform();
				isElementPresent = true;
			} else {
				// throw new Exception("Object Couldn't be retrieved and
				// verified");
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return isElementPresent;
	}

	/*
	 * Method for Entering text in to a field
	 */

	public static boolean clearAndEnterText(String objectProperty, String Text) throws IOException {
		boolean isTextEnteredResult = false;

		try {
			if ("-".equals(Text)) {
				// ignore this field
				isTextEnteredResult = true;
			} else {
				WebElement textBox = getElementByProperty(objectProperty, driver);

				textBox.clear();
				Thread.sleep(1000);

				textBox.sendKeys(Text);

				isTextEnteredResult = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return isTextEnteredResult;
	}

	/*
	 * Method for Highlight the Elements
	 */
	public static void highlightElement(WebElement element, WebDriver webDriver) {
		for (int i = 0; i < 1; i++) {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: black; border: 3px solid black;");
		}
	}

	/*
	 * Method for Click Element if available
	 */

	public static boolean isElementPresentVerifyClick(String objectProperty) throws InterruptedException {
		boolean isVerifiedAndClicked = false;

		browserWithElementWait = new WebDriverWait(driver, 60);
		try {
			element = getElementByProperty(objectProperty, driver);
			browserWithElementWait.until(ExpectedConditions.elementToBeClickable(element));

			if (element != null) {

				element.click();
				isVerifiedAndClicked = true;

			} else {
				throw new Exception("Object Couldn't be retrieved and clicked");
			}
		} catch (Exception e) {
			element = null;
		}
		return isVerifiedAndClicked;
	}

	public static boolean isElementPresentVerifyClickJavaScript(String objectProperty) throws InterruptedException {
		boolean isVerifiedAndClicked = false;

		browserWithElementWait = new WebDriverWait(driver, 60);
		try {
			element = getElementByProperty(objectProperty, driver);
			browserWithElementWait.until(ExpectedConditions.elementToBeClickable(element));

			if (element != null) {

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				isVerifiedAndClicked = true;

			} else {
				throw new Exception("Object Couldn't be retrieved and clicked");
			}
		} catch (Exception e) {
			element = null;
		}
		return isVerifiedAndClicked;
	}

	// switch to frame
	public static boolean switchtoFrame(String frameid) throws Exception {
		boolean switchtoframe = false;

		browserWithElementWait = new WebDriverWait(driver, 60);
		browserWithElementWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameid));
		try {

			if (frameid != null) {

				driver.switchTo().frame(frameid);
				switchtoframe = true;
				System.out.println(switchtoframe);

			} else {
				throw new Exception("Frame Couldn't be retrieved");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return switchtoframe;
	}

	// switch to default content
	public static boolean switchtodefault() throws Exception {
		boolean switchtoframe = false;

		try {
			
			driver.switchTo().defaultContent();
			switchtoframe = true;
		
		} catch (Exception e) {
			throw new Exception("Frame Couldn't be retrieved");
		}
		return switchtoframe;
	}


	/*
	 * Methods for
	 */

	public static Map<String, List<String>> getHorizontalData(DataTable dataTable) {
		Map<String, List<String>> dataMap = null;
		try {
			dataMap = new HashMap<String, List<String>>();
			List<String> headingRow = dataTable.raw().get(0);
			int dataTableRowsCount = dataTable.getGherkinRows().size() - 1;
			ArrayList<String> totalRowCount = new ArrayList<String>();
			totalRowCount.add(Integer.toString(dataTableRowsCount));
			dataMap.put("totalRowCount", totalRowCount);
			for (int i = 0; i < headingRow.size(); i++) {
				List<String> dataList = new ArrayList<String>();
				dataMap.put(headingRow.get(i), dataList);
				for (int j = 1; j <= dataTableRowsCount; j++) {
					List<String> dataRow = dataTable.raw().get(j);
					dataList.add(dataRow.get(i));

				}
			}
		} catch (Exception e) {

		}
		return dataMap;
	}

	/*
	 * Methods for
	 */

	public static Map<String, List<String>> getVerticalData(DataTable dataTable) {
		Map<String, List<String>> dataMap = null;
		try {
			int dataTableRowsCount = dataTable.getGherkinRows().size();
			dataMap = new HashMap<String, List<String>>();
			for (int k = 0; k < dataTableRowsCount; k++) {
				List<String> dataRow = dataTable.raw().get(k);
				String key = dataRow.get(0);
				dataRow.remove(0);
				dataMap.put(key, dataRow);
			}
		} catch (Exception e) {

		}
		return dataMap;
	}

	/*
	 * Methods for
	 */

	public static String getXLSTestData(String FileName, String SheetName, String RowId, String column)
			throws IOException {
		// config.getString("ItemCode");
		String col1 = null;
		DataFormatter df = new DataFormatter();
		FileInputStream file = new FileInputStream(
				new File(System.getProperty("user.dir") + "/InputData" + File.separator + FileName + ".xls"));
		HSSFWorkbook book = new HSSFWorkbook(file);
		HSSFSheet sheet = book.getSheet(SheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int rowIterator = 1; rowIterator <= rowCount; rowIterator++) {
			String row = sheet.getRow(rowIterator).getCell(0).getStringCellValue();
			if (row.equalsIgnoreCase(RowId)) {
				for (int colIterator = 1; colIterator < sheet.getRow(rowIterator).getLastCellNum(); colIterator++) {
					String col = sheet.getRow(0).getCell(colIterator).getStringCellValue();
					if (col.equalsIgnoreCase(column)) {
						Cell cellvalue = sheet.getRow(rowIterator).getCell(colIterator);
						col1 = df.formatCellValue(cellvalue);
						break;
					}
				}
			}
		}
		return col1;
	}



	public static boolean isElementNotSelected(String objectProperty) throws Exception {
		boolean isElementNotSelected = false;
		try {
			element = getElementByProperty(objectProperty, driver);
			// browserWithElementWait.until(ExpectedConditions.visibilityOf(element));
			if (!element.isSelected()) {
				isElementNotSelected = true;
				// t2=System.currentTimeMillis();
			} else {
				throw new Exception("Given Element is selected");
			}
			// Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return isElementNotSelected;

	}
	
	public static void switchToNewWindow() throws Throwable {
		// killChromeSession();
		try {
			Set<String> windowNames = driver.getWindowHandles();
			for (String windowName : windowNames) {

				if (windowName != null) {
					driver.switchTo().window(windowName);
				} else {
					throw new Exception("New window could not be retrived");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void switchToMainWindow() throws Throwable {
		// killChromeSession();
		try {
			driver.switchTo().window(mainWindow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getMainWindow() throws Throwable {
		String mainWindow = null;
		try {
			mainWindow = driver.getWindowHandle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mainWindow;
	}

}
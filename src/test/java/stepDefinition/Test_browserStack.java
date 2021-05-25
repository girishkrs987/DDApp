package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_browserStack {

	
	public static final String AUTOMATE_USERNAME = "girishkr1";
	  public static final String AUTOMATE_ACCESS_KEY = "GFNjp9AfYzBoFZkvucvS";
	  public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		/*
		 * ChromeOptions chromeOptions = new ChromeOptions();
		 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
		 * ChromeDriver(chromeOptions); // Launch Website
		 * driver.navigate().to("http://www.javatpoint.com/");
		 * 
		 * //Maximize the browser driver.manage().window().maximize();
		 */ 
          
		
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "latest");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
		    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
		    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		    driver.get("http://www.docnu.com/");
		    
		    
		    WebElement doctorType = driver.findElement(By.xpath("//a[@data-target=\"#Doctor_Login\"]"));
		    WebElement username = driver.findElement(By.xpath("//input[@id=\"UserName\"]"));
		    WebElement pwd = driver.findElement(By.xpath("//input[@id=\"DocLoginpassword\"]"));
		    WebElement Doctor_SignIn_Button = driver.findElement(By.xpath("//input[@id=\"DocLoginpassword\"]"));
		  //input[@id="UserName"]
		    
		    
		    doctorType.click();
		    username.sendKeys("gggggg");
		    pwd.sendKeys("hhgfdd");
		    Doctor_SignIn_Button.click();
		   // element.submit();
		    // Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
		    WebDriverWait wait = new WebDriverWait(driver, 5);
		    try {
		    	wait.until(ExpectedConditions.titleContains("Doctor Login"));
		    	markTestStatus("passed","Yaay title contains 'Doctor Login'!",driver);
		    }
		    catch(Exception e) {
		    	markTestStatus("failed","Naay title does not contain 'Doctor Login'!",driver);
		    }
		    System.out.println(driver.getTitle());
		    driver.quit();
		  }
		  // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
		  public static void markTestStatus(String status, String reason, WebDriver driver) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+status+"\", \"reason\": \""+reason+"\"}}");
		  }
	}



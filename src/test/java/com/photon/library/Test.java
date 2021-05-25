package com.photon.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	
	//public class TestReference {
	    public static   WebDriver driver ;
	    
	   // public static WebElement element ;
	    
	    public Test(WebDriver driver)
	    {
	       this.driver=driver;
	        //PageFactory.initElements(driver.this);
	        PageFactory.initElements(driver, this);
	    }
	    

	    @FindBy(xpath="//mat-icon[text()=\"add \"]")
	    //@FindBy(how=How.XPATH, using="//*[@id=\"outer1\\"]/div[1]/text()\")
		private  WebElement RWDaddCTAWeb;
	    
//	    public String ClickAdd() {
//	    	//String data=RWDaddCTAWeb.getText();
//	    	//return data;
//	    	//RWDaddCTAWeb.click();
//	    }

	   

	    public static WebDriver Browser_Launch(String browser,WebDriver driver) throws InterruptedException {
	        if (browser.contains("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            ChromeOptions options = new ChromeOptions();
	            driver = new ChromeDriver(options);
	            driver.manage().deleteAllCookies();
	        } else if (browser.contains("firefox")) {

	            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/DriverJenkins/geckodriver");
	            FirefoxOptions options = new FirefoxOptions();
	            driver = new FirefoxDriver(options);
	            driver.manage().deleteAllCookies();
	        } else if (browser.contains("safari")) {

	            SafariOptions options = new SafariOptions();
	            if (browser.contains("headless")) {
	                // options.addArguments("-headless");
	                // options.addArguments("window-size=1200x800");
	            }
	            driver = new SafariDriver(options);
	            driver.manage().deleteAllCookies();
	            return driver;
	        }

	        // driver = new HtmlUnitDriver();
	        String URL = "https://dd-rc-webappfb.web.app/113074/bookclub/user1/challenges";
	        // URL =
	        // "https://staging:watchoutforsharks@staging.purple.com/";//"https://purple" +
	        // env + getConfigUrl.toString();
	        // System.out.println(URL);
	        driver.get(URL);
	        Thread.sleep(5000);
			return driver;
	      
	        //RWDaddCTAWeb.click();
	    }
	    
	
	    
public static void main(String[] args) throws InterruptedException {
		
	
    Test d= new Test(driver); 
	
		
		
d.Browser_Launch("chrome", driver);
d.RWDaddCTAWeb.click();






	}

}

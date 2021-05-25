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

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Test1 {
	
    public static WebDriver driver ;
	
//    @FindBy(xpath="//mat-icon[text()=\"add \"]")
//   	private  WebElement RWDaddCTAWeb; 
    
    public Test1(WebDriver driver) {
    	
    	this.driver=driver;
    	  PageFactory.initElements(driver, this);
    	    	
    }

    
    public static void ClickCreatechhale(WebDriver driver) {
    	//RWDaddCTAWeb.sendKeys(Keys.SPACE);
    	String xpath="//mat-icon[text()=\"add \"]";
    	WebElement RWDaddCTAWeb=driver.findElement(By.xpath(xpath));
   	RWDaddCTAWeb.click();
    	
        }
    
    
    public static WebDriver Browser_Launch(String browser,WebDriver driver) throws InterruptedException {
        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else if (browser.contains("firefox")) {

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/DriverJenkins/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        } else if (browser.contains("safari")) {

            SafariOptions options = new SafariOptions();
            if (browser.contains("headless")) {
                // options.addArguments("-headless");
                // options.addArguments("window-size=1200x800");
            }
            driver = new SafariDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            return driver;
        }

        // driver = new HtmlUnitDriver();
        String URL = "https://dd-rc-webappfb.web.app/113074/bookclub/user1/challenges";
        // URL =
        // "https://staging:watchoutforsharks@staging.purple.com/";//"https://purple" +
        // env + getConfigUrl.toString();
        // System.out.println(URL);
        driver.get(URL);
      //  Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        
        ClickCreatechhale(driver);
        //driver.findElement(By.xpath("//mat-icon[text()=\"add \"]")).click();
		return driver;
      
        //RWDaddCTAWeb.click();
    }

  
    
    
    
    
public static void main(String[] args) throws Exception {
////    	
Test1 da=new Test1(driver);
////    	
////    	
da.Browser_Launch("chrome", driver);
	Thread.sleep(10000);
   //da.ClickCreatechhale(driver);   
//	driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//   driver.findElement(By.xpath("//mat-icon[text()=\"add \"]")).click();
   
}
}

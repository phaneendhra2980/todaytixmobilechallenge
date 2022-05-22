import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BookJourneyTestAndroidEmulator {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait                wait;

 // Elements By

 	By skip = By.id("com.todaytix.TodayTix:id/skip_button");
 	By selectcity = By.id("com.todaytix.TodayTix:id/select_city_button");
 	By londonLocation = By.xpath("//android.widget.TextView[@text='London']");
 	By bannerpager = By.id("com.todaytix.TodayTix:id/banner_pager");
 	By headline = By.id("com.todaytix.TodayTix:id/headline");
 	By bannerimage = By.xpath("//android.widget.TextView[@text='Dear Evan Hansen']");
 	By title = By.id("com.todaytix.TodayTix:id/title");
 	By footer = By.id("com.todaytix.TodayTix:id/footer_button");
 	By continuecheckout = By.id("com.todaytix.TodayTix:id/checkout_button"); 	
 	By calenderdatecheckout = By.xpath("//android.widget.TextView[@text='23']");
 	By chartContainer = By.id("chartContainerContainer");
 	By search = By.id("com.todaytix.TodayTix:id/tab_search");
 	By searchbar = By.id("com.todaytix.TodayTix:id/editable_search_field");
 	By Wrapper =By.id("com.todaytix.TodayTix:id/click_wrapper");
 	By availbitySection =By.className("android.widget.LinearLayout");

    
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel XL API 30");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.todaytix.TodayTix");        
        caps.setCapability("appium:appActivity", "com.todaytix.TodayTix.activity.MainTabsActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

   
    
    @Test
    public void bookJourneyEmulatorTest() throws InterruptedException {
    	// CLICK SKIP
    			MobileElement skipElement = (MobileElement) driver.findElement(skip);
    			skipElement.click();

    			// CLICK SELECT CITY
    			MobileElement selectcityElement = (MobileElement) driver.findElement(selectcity);
    			selectcityElement.click();

    			// SELECT LONDON LOCATION
    			MobileElement londonLocationElement = (MobileElement) driver.findElement(londonLocation);
    			londonLocationElement.click();


    			//Click Search Icon to find the Show
    			MobileElement searchElement = (MobileElement) driver.findElement(search);
    	        searchElement.click();		

    	        //Enter Dear Evan Hansen in search Bar
    	        MobileElement searchbarElement = (MobileElement) driver.findElement(searchbar);
    	        searchbarElement.sendKeys("Dear Evan Hansen");	
    	        
    	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	        
    	        //Click Dear Evan Hansen
    	        MobileElement wrapperElement = (MobileElement) driver.findElement(Wrapper);
    	        wrapperElement.click();	
    	        
    	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    			// Click Pick your seats
    			MobileElement footerElement = (MobileElement) driver.findElement(footer);
    			footerElement.click();

    	         //select date
    			MobileElement SelectCalenderDateElement = (MobileElement) driver.findElement(calenderdatecheckout);
    			SelectCalenderDateElement.click();
    			
    			// Click Availbilty
    			MobileElement availbitySectionElement = (MobileElement) driver.findElement(title);
    			availbitySectionElement.click();
    		
    			WebElement iframe = driver.findElementByTagName("iframe");
    	        driver.switchTo().frame(iframe);
    	        WebElement canvas = driver.findElement(By.id("myCanvas"));
    	        System.out.println(canvas.getText());

    			// Select Seat
    			MobileElement chartContainerElement = (MobileElement) driver.findElement(chartContainer);
    			chartContainerElement.click();
    			chartContainerElement.click();
    			chartContainerElement.click();

    			// Click Continue
    			MobileElement continuecheckoutElement = (MobileElement) driver.findElement(continuecheckout);
    			continuecheckoutElement.click();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

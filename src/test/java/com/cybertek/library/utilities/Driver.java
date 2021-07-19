package com.cybertek.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //creating private constructor, so this class' object is not reachable from outside. Can not create object of this class
    private Driver() {
    }

    //making our 'driver' instance private, so that's is not reachable from outside of the class
    //we make it static, because we want it to run before everything else. And also we will use it in the static method
    private static WebDriver driver;

    //creating reusable utility method, that will return same 'driver' instance every time we call it
    public static WebDriver getDriver() {
        if (driver == null) {
            //we read our browser type from configuration.properties file using .getProperty method we creating in ConfigurationReader class.
            String browserType = ConfigurationReader.getProperty("browser");
            //depending on the browser type,our switch statement will determine to open specific type of browser/driver

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
          /*
        Same driver instance will be returned every time we call Driver.getDriver(); method
         */
        return driver;

    }

    /*

     */

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();//session completely done
            driver = null;// if we dont put null, driver not gonna exist at all. Its like reset
        }
    }

}

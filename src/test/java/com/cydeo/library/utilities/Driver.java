package com.cydeo.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //Creating a private constructor, we are closing access to the object of this class from outside the class
    private Driver() {
    }

    // We make WebDriver private, because we want to close access from outside of class
    // We make it static, because we will use it inside static method
    private static WebDriver driver;

    // Create a re-usable utility method which will return the same driver instance when we call it
    public static WebDriver getDriver() {

        // It will check if driver is null and if its we will set up browser inside if statement
        // If you already set up driver and using it again for following lines of code, it will return teh same driver.

        if (driver == null) {

            // We read browser Type from configuration.properties with the help of ConfigurationReader class' getProperty() method
            String browserType = ConfigurationReader.getProperty("browser");

            //Singleton Design Patter:
            // In driver util class. If driver is null, for the first time we are setting up browser (maximizing window and implicit wait). Next time it's closed, it won't do it all over again, it will return back to one single driver object.
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

        return driver;
    }
    // this method will make sure our driver value is always null after using quit() method
    public static void closeDriver(){
        if (driver != null){
            driver.quit();// this line will terminate the existing driver session. With using this driver will not be null.
            driver = null;
        }
    }
}

package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void SetupDriver() throws MalformedURLException {

        // Browser Variable : Chrome or Firefox
        // HUB_HOST : localhost or IP Address or hostname

        // Default values
        String host = "localhost";
        //DesiredCapabilities dc = DesiredCapabilities.chrome();
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }
        else {
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        /*System.setProperty("webdriver.chrome.driver", "/Users/abrahamlo/Programming/drivers/chromedriver96/chromedriver");
        this.driver = new ChromeDriver();
        */

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }
}

package com.cucumber.nowoox.steps;

import com.cucumber.nowoox.utility.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver driver;
    public Logger logger = LogManager.getLogger(Hooks.class);

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory(DriverFactory.Browser.chrome.toString().toLowerCase());
        try {
            WebDriverManager.chromedriver().setup();
            driver = driverFactory.createDriver();
            logger.info("Драйвер запущен");
        } catch (Exception e) {

        }
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен");
        }
    }
}

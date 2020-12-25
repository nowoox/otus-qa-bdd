package com.cucumber.nowoox.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public enum Browser {
        chrome,
        firefox
    }

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private final String browser;

    public DriverFactory(String browser) {
        this.browser = browser;
    }

    public WebDriver createDriver() {
        switch (browser) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless", "--silent");
                options.addArguments("--start-maximized");
                //System.setProperty("webdriver.chrome.silentOutput", "true");
                //System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                driver.set(new ChromeDriver(options));
                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;
        }
        return driver.get();
    }

}

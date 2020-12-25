package com.cucumber.nowoox.steps;

import com.cucumber.nowoox.pages.LoginPage;
import com.cucumber.nowoox.pages.PersonalDataPage;
import com.cucumber.nowoox.utility.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Hooks{

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }



    public PersonalDataPage personalDataPage;
   public LoginPage loginPage;

//    public static PersonalDataPage getPersPage(){
//        return personalDataPage(driver);
//    }

    @Before
    public void setUp() {

        //driver = new ChromeDriver();


        DriverFactory driverFactory = new DriverFactory(DriverFactory.Browser.chrome.toString().toLowerCase());
        //try {
            WebDriverManager.chromedriver().setup();
            driver = driverFactory.createDriver();
            //logger.info("Драйвер запущен");
            //loginPage = PageFactory.initElements(driver, LoginPage.class);
            //aboutPage = PageFactory.initElements(driver, AboutPage.class);
            //mainPage = PageFactory.initElements(driver, MainPage.class);
           personalDataPage = PageFactory.initElements(driver, PersonalDataPage.class);
            loginPage = PageFactory.initElements(driver, LoginPage.class);
        //} catch (Exception e) {
        //}
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
            //logger.info("Драйвер остановлен");
        }
    }
}

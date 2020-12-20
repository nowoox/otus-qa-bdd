package com.cucumber.nowoox.steps;

import com.cucumber.nowoox.base.DriverFactory;
import com.cucumber.nowoox.pages.PersonalDataPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StepValues {

    //WebDriver driver = new ChromeDriver();
    protected WebDriver driver;
    //public Logger logger = LogManager.getLogger(BaseTest.class);
    //public ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    //public LoginPage loginPage;
    //public AboutPage aboutPage;
    //public MainPage mainPage;
    public PersonalDataPage personalDataPage;


}

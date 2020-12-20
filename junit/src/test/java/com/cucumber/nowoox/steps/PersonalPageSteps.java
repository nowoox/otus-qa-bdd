package com.cucumber.nowoox.steps;

import com.cucumber.nowoox.base.DriverFactory;
import com.cucumber.nowoox.pages.LoginPage;
import com.cucumber.nowoox.pages.PersonalDataPage;
import gherkin.lexer.Pa;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PersonalPageSteps {

    protected WebDriver driver;
    protected PersonalDataPage personalDataPage;
    protected LoginPage loginPage;

    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory(DriverFactory.Browser.chrome.toString().toLowerCase());
        try {
            WebDriverManager.chromedriver().setup();
            driver = driverFactory.createDriver();
            //logger.info("Драйвер запущен");
            //loginPage = PageFactory.initElements(driver, LoginPage.class);
            //aboutPage = PageFactory.initElements(driver, AboutPage.class);
            //mainPage = PageFactory.initElements(driver, MainPage.class);
            personalDataPage = PageFactory.initElements(driver, PersonalDataPage.class);
            loginPage = PageFactory.initElements(driver, LoginPage.class);
        } catch (Exception e) {
        }
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
            //logger.info("Драйвер остановлен");
        }
    }


    @Given("^I open personal data page$")
    public void iOpenPersonalPage() {
        personalDataPage.goToCourses();
    }

//    @Then("^I get my courses$")
//    public void iGetMyCourses() {
//        personalDataPage.goToCourses();
//    }


    @Then("Courses are empty")
    public void coursesAreEmpty(){
        personalDataPage.checkIfCoursesEmpty();
    }

    @Given("I login on site")
    public void iLoginOnSite() {
        loginPage.login();
    }
}

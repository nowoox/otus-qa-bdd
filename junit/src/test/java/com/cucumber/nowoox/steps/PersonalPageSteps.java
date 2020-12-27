package com.cucumber.nowoox.steps;

import com.cucumber.nowoox.pages.BasePage;
import com.cucumber.nowoox.pages.LoginPage;
import com.cucumber.nowoox.pages.PersonalDataPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PersonalPageSteps {

    public PersonalDataPage personalDataPage;
    public LoginPage loginPage;
    public Logger logger = LogManager.getLogger(BasePage.class);

    public PersonalPageSteps() {
        WebDriver driver = Hooks.getDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        personalDataPage = PageFactory.initElements(driver, PersonalDataPage.class);
    }


    @Given("^I open personal data page$")
    public void iOpenPersonalPage() {
        personalDataPage.goToPersonalDataPage();
    }

    @Then("Courses are empty")
    public void coursesAreEmpty() {
        personalDataPage.checkIfCoursesEmpty();
        System.out.println("HELP");
    }

    @Given("I login on site")
    public void iLoginOnSite() {
        loginPage.login();
    }

    @When("I open page take friend")
    public void iOpenPageTakeFriend() {
        personalDataPage.goToTakeFriend();
    }

    @And("I send invitation")
    public void iSendInvitation() {
        personalDataPage.sendInvitation();
    }

    @Then("I get message invitation is sent")
    public void iGetMessageInvitationIsSent() {
        personalDataPage.checkIfInvitationSent();
    }

    @Then("I go to my courses page")
    public void iGoToMyCoursesPage() {
        personalDataPage.goToCourses();
    }

    @And("I open settings page")
    public void iOpenSettingsPage() {
        personalDataPage.goToSettings();
    }

    @And("I change notifications settings")
    public void iChangeNotificationsSettings() {
        personalDataPage.changeNotificationSettings();
    }

    @Then("I get popup changes are saved")
    public void iGetPopupChangesAreSaved() {
        personalDataPage.checkIfPopupDisplayed();
    }

    @And("I go to notifications")
    public void iGoToNotifications() {
        personalDataPage.goToNotifications();
    }

    @When("I check {string} and value is {string}")
    public void iCheckAndValueIs(String account, String value) {
        personalDataPage.checkIfAccountValid(account, value);
    }

    @When("I open my posts page")
    public void iOpenMyPostsPage() {
        personalDataPage.goToPosts();
    }

    @Then("I get message no posts")
    public void iGetMessageNoPosts() {
        personalDataPage.checkIfNoPosts();
    }

    @And("I go to notifications archive")
    public void iGoToNotificationsArchive() {
        personalDataPage.goToNotificationArchive();
    }

    @Then("I get message no archive notifications")
    public void iGetMessageNoArchiveNotifications() {
        personalDataPage.checkIfNoArchiveNotifications();
    }
}

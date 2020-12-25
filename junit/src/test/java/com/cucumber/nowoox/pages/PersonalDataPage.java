package com.cucumber.nowoox.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PersonalDataPage extends BasePage {

    public PersonalDataPage(WebDriver driver) {
        super(driver);
    }

    protected String MAIN_PAGE_PROFILE_LINK = ".header2-menu__dropdown-text";
    protected String EMAIL_FIELD = "input.input:nth-child(1)";
    protected String SEND_INVITATION_BUTTON = ".input-group__addon";

    public String randomMail() {
        return (RandomStringUtils.randomAlphabetic(10) + "@we.rt");
    }

    public void goToPersonalDataPage() {
        waitPresence(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.cssSelector(".header2-menu__item-text__username")))
                .build()
                .perform();

        waitVisibility(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        driver.findElement(By.cssSelector(MAIN_PAGE_PROFILE_LINK)).click();

    }

    public void goToCourses() {
        waitPresence(By.cssSelector("div.nav:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)"));
        click(By.cssSelector("div.nav:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)"));
    }

    public void checkIfCoursesEmpty() {

        waitVisibility(By.cssSelector(".text"));

        WebElement noCourseLabel = driver.findElement(By.cssSelector(".text"));

        Assert.assertTrue(noCourseLabel.isDisplayed());
    }

    public void goToTakeFriend() {
        click(By.cssSelector("a[href='/lk/invite/']"));
    }

    public void sendInvitation() {
        waitPresence(By.cssSelector(EMAIL_FIELD));
        type(By.cssSelector(EMAIL_FIELD), randomMail());
        click(By.cssSelector(SEND_INVITATION_BUTTON));
        waitVisibility(By.cssSelector("p.input-line"));
        Assert.assertTrue(driver.findElement(By.cssSelector("p.input-line")).isDisplayed());
    }

}

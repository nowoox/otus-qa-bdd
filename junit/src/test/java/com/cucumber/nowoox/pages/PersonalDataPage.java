package com.cucumber.nowoox.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PersonalDataPage extends BasePage{


    public PersonalDataPage(WebDriver driver){
        super(driver);
    }

    protected String MAIN_PAGE_PROFILE_LINK = ".header2-menu__dropdown-text";


    public void goToCourses(){

        waitPresence(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.cssSelector(".header2-menu__item-text__username")))
                .build()
                .perform();

        waitVisibility(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        driver.findElement(By.cssSelector(MAIN_PAGE_PROFILE_LINK)).click();
        driver.findElement(By.cssSelector("div.nav:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).click();

    }

    public void checkIfCoursesEmpty(){

        waitVisibility(By.cssSelector(".text"));

        WebElement noCourseLabel = driver.findElement(By.cssSelector(".text"));

         Assert.assertEquals(true, noCourseLabel.isDisplayed());
    }

}

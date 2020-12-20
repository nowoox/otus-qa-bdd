package com.cucumber.nowoox.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait webDriverWait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void open(String url){
        driver.get(url);
    }

    public void click(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void type(By elementBy, String text){
        driver.findElement(elementBy).sendKeys(Keys.CONTROL + "a");
        driver.findElement(elementBy).sendKeys(text);
    }

    public void isElementDisplayed(By elementBy){
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
        //logger.info("Элемент найден: " + elementBy);
    }

    public void waitVisibility(By elementBy){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitIsClickable(By elementBy){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void waitPresence(By elementBy){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }
}

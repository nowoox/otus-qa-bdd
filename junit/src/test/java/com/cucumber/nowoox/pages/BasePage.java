package com.cucumber.nowoox.pages;

import com.cucumber.nowoox.steps.Hooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public Logger logger = LogManager.getLogger(BasePage.class);


    public BasePage(WebDriver driver){
        this.driver = Hooks.getDriver();
        webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void open(String url){
        driver.get(url);
    }

    public void clickViaTry(By elementBy){
        waitIsClickable(elementBy);

        try {
            click(elementBy);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            click(elementBy);;
        }
    }

    public void moveAndClick(By elementBy){

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(elementBy))
                .click()
                .build()
                .perform();
    }

    public void click(By elementBy){
        driver.findElement(elementBy).click();
        logger.info("Выполнен клик по элементу: " + elementBy);
    }

    public void type(By elementBy, String text){
        driver.findElement(elementBy).sendKeys(Keys.CONTROL + "a");
        driver.findElement(elementBy).sendKeys(text);
        logger.info("В поле " + elementBy + " введен текст " + text);
    }

    public void isElementDisplayed(By elementBy){
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
        logger.info("Элемент найден: " + elementBy);
    }

    public void waitVisibility(By elementBy){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        logger.info("Элемент найден: " + elementBy);
    }

    public void waitIsClickable(By elementBy){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(elementBy));
        logger.info("Элемент найден: " + elementBy);
    }

    public void waitPresence(By elementBy){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
        logger.info("Элемент найден: " + elementBy);
    }
}

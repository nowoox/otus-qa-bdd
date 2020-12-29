package com.cucumber.nowoox.pages;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.ByteArrayInputStream;

public class PersonalDataPage extends BasePage {

    protected String MAIN_PAGE_PROFILE_LINK = ".header2-menu__dropdown-text";
    protected String EMAIL_FIELD = "input.input:nth-child(1)";
    protected String SEND_INVITATION_BUTTON = ".input-group__addon";
    protected String NO_POSTS_MESSAGE = ".blog-empty__text";

    public PersonalDataPage(WebDriver driver) {
        super(driver);
    }

    public String randomMail() {
        String mail = RandomStringUtils.randomAlphabetic(10) + "@we.rt";
        logger.info("Random mail is generated: " + mail);
        return (mail);
    }

    @Step
    public void goToPersonalDataPage() {
        waitPresence(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.cssSelector(".header2-menu__item-text__username")))
                .build()
                .perform();

        waitVisibility(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        click(By.cssSelector(MAIN_PAGE_PROFILE_LINK));
    }

    @Step
    public void logout() {

        waitPresence(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.cssSelector(".header2-menu__item-text__username")))
                .build()
                .perform();

        waitVisibility(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        click(By.xpath("//a[contains(@href, '/logout')]"));

    }

    @Step
    public void goToCourses() {
        waitPresence(By.cssSelector("div.nav:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)"));
        click(By.cssSelector("div.nav:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)"));
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step
    public void checkIfCoursesEmpty() {

        waitVisibility(By.cssSelector(".text"));
        WebElement noCourseLabel = driver.findElement(By.cssSelector(".text"));
        Assert.assertTrue("Сообщение об отсутствии курсов не отображается", noCourseLabel.isDisplayed());
        logger.info("Сообщение об отсутствии курсов отображается");
    }

    @Step
    public void checkIfPopupDisplayed() {
        waitVisibility(By.xpath("//div[@class='notification-lib notification-lib_success undefined']"));
        Assert.assertTrue("Попап не отображается",
                driver.findElement(By.xpath("//div[@class='notification-lib notification-lib_success undefined']")).isDisplayed());
        logger.info("Попап отображается");
    }

    @Step
    public void goToTakeFriend() {
        click(By.cssSelector("a[href='/lk/invite/']"));
    }

    @Step
    public void goToSettings() {
        click(By.cssSelector("a[href='/lk/settings/auth/']"));
    }

    @Step
    public void goToNotifications() {
        click(By.xpath("(//a[@href='/lk/settings/notifications/'])[last()]"));
    }

    @Step
    public void goToNotificationArchive() {
        waitPresence(By.cssSelector(".header2_subheader-img"));

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.cssSelector(".header2_subheader-img")))
                .build()
                .perform();

        waitVisibility(By.cssSelector(".header2_subheader-menu_item > div:nth-child(2) > a:nth-child(4) > div:nth-child(1)"));

        click(By.cssSelector(".header2_subheader-menu_item > div:nth-child(2) > a:nth-child(4) > div:nth-child(1)"));

        click(By.cssSelector("div.js-tab:nth-child(2)"));

    }

    @Step
    public void goToPosts() {
        waitPresence(By.xpath("//*[text()='Блог' and @class='header2_subheader-link']"));
        click(By.xpath("//*[text()='Блог' and @class='header2_subheader-link']"));
        waitVisibility(By.xpath("//*[text()='Моё']"));
        click(By.cssSelector("a[href='/nest/my/']"));
    }

    @Step
    public void goToTestingPage() {
        waitVisibility(By.cssSelector(".transitional-main__event-text"));

        clickViaTry(By.xpath("//*[@id='categories_id']//*[@title='Тестирование']"));
    }

    @Step
    public void sendInvitation() {
        waitPresence(By.cssSelector(EMAIL_FIELD));
        type(By.cssSelector(EMAIL_FIELD), randomMail());
        click(By.cssSelector(SEND_INVITATION_BUTTON));
        waitVisibility(By.cssSelector("p.input-line"));
        Assert.assertTrue("Сообщение об отправке приглашения не отображается",
                driver.findElement(By.cssSelector("p.input-line")).isDisplayed());
        logger.info("Сообщение об отправке приглашения отображается");
    }

    @Step
    public void changeNotificationSettings() {
        click(By.xpath("//span[contains(text(), 'Основные')]"));
    }

    @Step
    public void checkIfAccountValid(String account, String value) {
        driver.findElement(By.xpath("//div[contains(text(), '" + account + "')]"));
        Assert.assertEquals("Настройка аккаунта + " + account + " неверная",
                driver.findElement(By.xpath("//div[contains(text(), '" + account + "')]/following::div[1]")).getText(), value);
        logger.info("Настройка аккаунта " + account + " верная");
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step
    public void checkIfNoPosts() {
        waitVisibility(By.cssSelector(NO_POSTS_MESSAGE));
        Assert.assertTrue("Сообщение об отсутствии постов не отображается",
                driver.findElement(By.cssSelector(NO_POSTS_MESSAGE)).isDisplayed());
        logger.info("Сообщение об отсутствии постов отображается");
    }

    @Step
    public void checkIfNoArchiveNotifications() {
        Assert.assertTrue("Сообщение об отсутствии архивных уведомлений не отображается",
                driver.findElement(By.cssSelector(".notifications-list__item_empty > div:nth-child(1)")).isDisplayed());
        logger.info("Сообщение об отсутствии архивных уведомлений отображается");
    }

    @Step
    public void checkIfInvitationSent() {
        Assert.assertTrue("Сообщение об отправке приглашения не отображается",
                driver.findElement(By.cssSelector("p.input-line")).isDisplayed());
        logger.info("Сообщение об отправке приглашения отображается");
    }

    @Step
    public void checkIfPwdPopupDisplayed() {
        Assert.assertTrue("Попап об обязательности заполнения поля не отображается",
                driver.findElement(By.cssSelector("")).isDisplayed());
        logger.info("Попап об обязательности заполнения поля отображается");
    }

    @Step
    public void checkIfBadPwdMessageIsDisplayed() {
        Assert.assertTrue("Сообщение о невалидном пароле не отображается",
                driver.findElement(By.cssSelector(".input-line__error")).isDisplayed());
        logger.info("Сообщение о невалидном пароле отображается");
    }

    @Step
    public void checkIfWrongSmsMessageIsDisplayed() {
        waitVisibility(By.cssSelector(".input-error__text"));
        Assert.assertTrue("Сообщение о неверном смс не отображается",
                driver.findElement(By.cssSelector(".input-error__text")).isDisplayed());
        logger.info("Сообщение о неверном смс отображается");
    }

    @Step
    public void checkIfNeedRegistrationMessageIsDisplayed() {
        Assert.assertTrue("Сообщение о необходимости регистрации не отображается",
                driver.findElement(By.cssSelector(".assessment-form-fields_header")).isDisplayed());
        logger.info("Сообщение о необходимости регистрации отображается");
    }

    @Step
    public void checkIfLoginButtonIsDisplayed() {
        Assert.assertTrue("Кнопка входа не отображается",
                driver.findElement(By.cssSelector(".header2__auth")).isDisplayed());
        logger.info("Кнопка входа отображается");
    }

    @Step
    public void typeNewPwds() {
        type(By.cssSelector("#id_password"), "1");
        type(By.cssSelector("#id_password_check"), "1");
    }

    @Step
    public void inputPhoneValidationSms() {
        click(By.cssSelector(".js-change-phone"));
        waitVisibility(By.cssSelector("p.text:nth-child(2)"));
        click(By.cssSelector(".js-send"));
        waitVisibility(By.cssSelector("input.js-code"));
        type(By.cssSelector("input.js-code"), "1111");
        click(By.cssSelector(".js-send"));
    }

    @Step
    public void submitQaLeadCourse() {
        waitPresence(By.cssSelector("a.js-stats:nth-child(4) > div:nth-child(1) > div:nth-child(1) > picture:nth-child(1) > img:nth-child(2)"));

        click(By.cssSelector("body > div.sticky-banner.js-sticky-banner > div > div.sticky-banner__right > div"));

        moveAndClick(By.cssSelector("a.js-stats:nth-child(4) > div:nth-child(1) > div:nth-child(1) > picture:nth-child(1) > img:nth-child(2)"));

        waitPresence(By.cssSelector(".course-header2__new > form:nth-child(1) > div:nth-child(1) > button:nth-child(1) > span:nth-child(1)"));
        click(By.cssSelector(".course-header2__new > form:nth-child(1) > div:nth-child(1) > button:nth-child(1) > span:nth-child(1)"));

    }

}

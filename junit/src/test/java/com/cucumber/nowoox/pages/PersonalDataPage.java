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
    protected String NO_POSTS_MESSAGE = ".blog-empty__text";

    public String randomMail() {
        String mail = RandomStringUtils.randomAlphabetic(10) + "@we.rt";
        logger.info("Random mail is generated: " + mail);
        return (mail);
    }

    public void goToPersonalDataPage() {
        waitPresence(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.cssSelector(".header2-menu__item-text__username")))
                .build()
                .perform();

        waitVisibility(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        click(By.cssSelector(MAIN_PAGE_PROFILE_LINK));
    }

    public void logout(){

        waitPresence(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.cssSelector(".header2-menu__item-text__username")))
                .build()
                .perform();

        waitVisibility(By.cssSelector(MAIN_PAGE_PROFILE_LINK));

        click(By.xpath("//a[contains(@href, '/logout')]"));

    }

    public void goToCourses() {
        waitPresence(By.cssSelector("div.nav:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)"));
        click(By.cssSelector("div.nav:nth-child(6) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)"));
    }

    public void checkIfCoursesEmpty() {

        waitVisibility(By.cssSelector(".text"));

        WebElement noCourseLabel = driver.findElement(By.cssSelector(".text"));

        Assert.assertTrue("Сообщение об отсутствии курсов не отображается", noCourseLabel.isDisplayed());
    }

    public void checkIfPopupDisplayed(){
        waitVisibility(By.xpath("//div[@class='notification-lib notification-lib_success undefined']"));
        Assert.assertTrue("Попап не отображается",
                driver.findElement(By.xpath("//div[@class='notification-lib notification-lib_success undefined']")).isDisplayed());
    }

    public void goToTakeFriend() {
        click(By.cssSelector("a[href='/lk/invite/']"));
    }

    public void goToSettings(){
        click(By.cssSelector("a[href='/lk/settings/auth/']"));
    }

    public void goToNotifications(){
        click(By.xpath("(//a[@href='/lk/settings/notifications/'])[last()]"));
    }

    public void goToNotificationArchive(){
        waitPresence(By.cssSelector(".header2_subheader-img"));

        Actions builder = new Actions(driver);

        builder.moveToElement(driver.findElement(By.cssSelector(".header2_subheader-img")))
                .build()
                .perform();

        waitVisibility(By.cssSelector(".header2_subheader-menu_item > div:nth-child(2) > a:nth-child(4) > div:nth-child(1)"));

        click(By.cssSelector(".header2_subheader-menu_item > div:nth-child(2) > a:nth-child(4) > div:nth-child(1)"));

        click(By.cssSelector("div.js-tab:nth-child(2)"));

    }

    public void goToPosts(){
        waitPresence(By.xpath("//*[text()='Блог' and @class='header2_subheader-link']"));
        click(By.xpath("//*[text()='Блог' and @class='header2_subheader-link']"));
        waitVisibility(By.xpath("//*[text()='Моё']"));
        click(By.cssSelector("a[href='/nest/my/']"));
    }

    public void goToTestingPage(){
        waitVisibility(By.cssSelector(".transitional-main__event-text"));

        clickViaTry(By.xpath("//*[@id='categories_id']//*[@title='Тестирование']"));
    }

    public void sendInvitation() {
        waitPresence(By.cssSelector(EMAIL_FIELD));
        type(By.cssSelector(EMAIL_FIELD), randomMail());
        click(By.cssSelector(SEND_INVITATION_BUTTON));
        waitVisibility(By.cssSelector("p.input-line"));
        Assert.assertTrue("Сообщение об отправке приглашения не отображается", driver.findElement(By.cssSelector("p.input-line")).isDisplayed());
    }

    public void changeNotificationSettings(){
        click(By.xpath("//span[contains(text(), 'Основные')]"));
    }

    public void checkIfAccountValid(String account, String value){
        driver.findElement(By.xpath("//div[contains(text(), '" + account + "')]"));
        Assert.assertEquals("Настройка аккаунта + " + account + " верная",
                driver.findElement(By.xpath("//div[contains(text(), '" + account + "')]/following::div[1]")).getText(), value);
    }

    public void checkIfNoPosts(){
        waitVisibility(By.cssSelector(NO_POSTS_MESSAGE));
        Assert.assertTrue("Сообщение об отсутствии постов не отображается",
                driver.findElement(By.cssSelector(NO_POSTS_MESSAGE)).isDisplayed());
    }

    public void checkIfNoArchiveNotifications(){
        Assert.assertTrue("Сообщение об отсутствии архивных уведомлений не отображается",
                driver.findElement(By.cssSelector(".notifications-list__item_empty > div:nth-child(1)")).isDisplayed());
    }

    public void checkIfInvitationSent(){
        Assert.assertTrue("Сообщение об отправке приглашения не отображается",
                driver.findElement(By.cssSelector("p.input-line")).isDisplayed());
    }

    public void checkIfPwdPopupDisplayed(){
        Assert.assertTrue("Попап об обязательности заполнения поля не отображается",
                driver.findElement(By.cssSelector("")).isDisplayed());
    }

    public void checkIfBadPwdMessageIsDisplayed(){
        Assert.assertTrue("Сообщение о невалидном пароле не оторажается",
                driver.findElement(By.cssSelector(".input-line__error")).isDisplayed());
    }

    public void checkIfWrongSmsMessageIsDisplayed(){
        waitVisibility(By.cssSelector(".input-error__text"));
        Assert.assertTrue("Сообщение о неверном смс не отображается",
                driver.findElement(By.cssSelector(".input-error__text")).isDisplayed());
    }

    public void checkIfNeedRegistrationMessageIsDisplayed(){
        Assert.assertTrue("Сообщение о необходимости регистрации не отображается",
                driver.findElement(By.cssSelector(".assessment-form-fields_header")).isDisplayed());
    }

    public void checkIfLoginButtonIsDisplayed(){
        Assert.assertTrue("Кнопка входа отображается",
                driver.findElement(By.cssSelector(".header2__auth")).isDisplayed());
    }

    public void typeNewPwds(){
        type(By.cssSelector("#id_password"), "1");
        type(By.cssSelector("#id_password_check"), "1");
    }

    public void inputPhoneValidationSms(){
        click(By.cssSelector(".js-change-phone"));
        waitVisibility(By.cssSelector("p.text:nth-child(2)"));
        click(By.cssSelector(".js-send"));
        waitVisibility(By.cssSelector("input.js-code"));
        type(By.cssSelector("input.js-code"), "1111");
        click(By.cssSelector(".js-send"));
    }

    public void submitQaLeadCourse(){
        waitPresence(By.cssSelector("a.js-stats:nth-child(4) > div:nth-child(1) > div:nth-child(1) > picture:nth-child(1) > img:nth-child(2)"));

        //waitPresence(By.cssSelector("a.nav__item:nth-child(6)"));
        click(By.cssSelector("body > div.sticky-banner.js-sticky-banner > div > div.sticky-banner__right > div"));

        moveAndClick(By.cssSelector("a.js-stats:nth-child(4) > div:nth-child(1) > div:nth-child(1) > picture:nth-child(1) > img:nth-child(2)"));

        //click(By.cssSelector("a.js-stats:nth-child(4) > div:nth-child(1) > div:nth-child(1) > picture:nth-child(1) > img:nth-child(2)"));
        waitPresence(By.cssSelector(".course-header2__new > form:nth-child(1) > div:nth-child(1) > button:nth-child(1) > span:nth-child(1)"));
        click(By.cssSelector(".course-header2__new > form:nth-child(1) > div:nth-child(1) > button:nth-child(1) > span:nth-child(1)"));

    }

}

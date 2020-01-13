package ru.Robar3.mail.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;


public class LoginPage {

    private By loginField = By.id("mailbox:login");
    private By submit = By.id("mailbox:submit");
    private By password = By.id("mailbox:password");
    private By loginedEmail = By.id("PH_user-email");

    public void loginWriteEmail(String login) {
        SelenideElement delText = $(loginField);
        while ($(loginField).val().length() != 0)
            delText.sendKeys(Keys.BACK_SPACE);
        $(loginField).sendKeys(login);
        $(submit).click();
    }

    public void loginWritePass(String pass) {
        $(password).sendKeys(pass);
        $(submit).click();
    }

    public void assertLogined(String login) {
        String a = $(loginedEmail).shouldBe(Condition.visible).getText();
        Assert.assertEquals(a, login);
    }
}

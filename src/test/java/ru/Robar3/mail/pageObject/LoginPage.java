package ru.Robar3.mail.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;


public class LoginPage{
    public void login(String login,String pass){
        SelenideElement loginField =  $(By.id("mailbox:login"));
        while (loginField.val().length() != 0)
            loginField.sendKeys(Keys.BACK_SPACE);
        $(By.id("mailbox:login")).sendKeys(login);
        $(By.id("mailbox:submit")).click();
        $(By.id("mailbox:password")).sendKeys(pass);
        $(By.id("mailbox:submit")).click();
        String a = $(By.id("PH_user-email")).shouldBe(Condition.visible).getText();
        Assert.assertEquals(a,login);
    }
}

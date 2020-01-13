package ru.Robar3.mail.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MailPage {

    private static String dateIdSendEmail;

    private By writeMail = byClassName("compose-button__wrapper");
    private By setEmail =byClassName("container--zU301");
    private By div = By.tagName("div");
    private By sendPanelFind = byClassName("compose-app__buttons");
    private By messegeIsSend = byClassName("layer__header");
    private By closeSend = byClassName("layer__controls");
    private By sendsEmail = byLinkText("Отправленные");
    private By exit = byTitle("выход");

    String timeSent = "[class='letter__date']";
    String autorSent = "[class='letter__contact-item']";
    String title = "title";
    String firstLetter = "[title^='Сегодня']";
    String send = "[title='Отправить']";
    String textEmail = "[class^='editable-container-']";
    public void clickWriteMail(){
        $(writeMail).shouldBe(Condition.visible).click();
    }
    public void writeLetter(String email,String text){
        $(send).shouldBe(Condition.visible);
        $(setEmail).shouldBe(Condition.visible).sendKeys(email);
        SelenideElement textPanel = $(textEmail);
        SelenideElement webElement = textPanel.$(div);
        webElement.$(div).sendKeys(text);
    }
    public void sendAndClose(){
        SelenideElement sendPanel = $(sendPanelFind).shouldBe(Condition.visible);
        sendPanel.$(send).click();
        String sendMessage = $(messegeIsSend).shouldBe(Condition.visible).getText();
        Assert.assertEquals(sendMessage,"Письмо отправлено");
        $(closeSend).shouldBe(Condition.visible).click();

    }
    public void checkDate(){
        $(sendsEmail).shouldBe(Condition.visible).click();
        dateIdSendEmail = $(firstLetter)
                .shouldBe(Condition.visible).getAttribute(title);
    }
    public void exitMail(){
        $(exit).shouldBe(Condition.visible).click();

    }
    public  void assertGetMail(String email){
        $(firstLetter).shouldBe(Condition.visible).click();
        String autorEmail = $(autorSent)
                .shouldBe(Condition.visible).getAttribute(title);
        String timeEmail = $(timeSent).getText();
        Assert.assertEquals(dateIdSendEmail, timeEmail);
        Assert.assertEquals(email, autorEmail);
    }
}

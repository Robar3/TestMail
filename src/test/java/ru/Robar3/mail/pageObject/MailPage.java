package ru.Robar3.mail.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class MailPage {


    public  static String dateIdSendEmail;
    public void clickWriteMail(){

        $(By.className("compose-button__wrapper")).shouldBe(Condition.visible).click();
    }
    public void writeLetter(String email,String text){
        $(By.className("container--zU301")).sendKeys(email);
        SelenideElement textPanel = $(("[class^='editable-container-']"));
        SelenideElement webElement = textPanel.$(By.tagName("div"));
        webElement.$(By.tagName("div")).sendKeys(text);
    }
    public void sendAndClose(){
        SelenideElement sendPanel = $(By.className("compose-app__buttons"));
        sendPanel.$(By.cssSelector("[title='Отправить']")).click();
        String send = $(By.className("layer__header")).shouldBe(Condition.visible).getText();
        Assert.assertEquals(send,"Письмо отправлено");
        $(By.className("layer__controls")).click();

    }
    public void checkDate(){
        $(By.linkText("Отправленные")).click();
        dateIdSendEmail = $(("[title^='Сегодня']")).shouldBe(Condition.visible).getAttribute("title");
    }
    public void exitMail(){
        $(byTitle("выход")).click();

    }
    public  void assertGetMail(String email,String dateIdSendEmail){
        $(By.cssSelector("[title^='Сегодня']")).click();
        String autorEmail = $(("[class='letter__contact-item']")).getAttribute("title");
        String timeEmail = $(("[class='letter__date']")).getText();
        Assert.assertEquals(dateIdSendEmail, timeEmail);
        Assert.assertEquals(email, autorEmail);
    }
}

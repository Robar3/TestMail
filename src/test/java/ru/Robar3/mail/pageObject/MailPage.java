package ru.Robar3.mail.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class MailPage {

    static String dateIdSendEmail;
    public void clickWriteMail(){

        $(By.className("compose-button__wrapper")).shouldBe(Condition.visible).click();
    }
    public void writeLetter(String email,String text){
        $(By.cssSelector("[title='Отправить']")).shouldBe(Condition.visible);
        $(By.className("container--zU301")).shouldBe(Condition.visible).sendKeys(email);
        SelenideElement textPanel = $(("[class^='editable-container-']"));
        SelenideElement webElement = textPanel.$(By.tagName("div"));
        webElement.$(By.tagName("div")).sendKeys(text);
    }
    public void sendAndClose(){
        SelenideElement sendPanel = $(By.className("compose-app__buttons")).shouldBe(Condition.visible);
        sendPanel.$(("[title='Отправить']")).click();
        String send = $(By.className("layer__header")).shouldBe(Condition.visible).getText();
        Assert.assertEquals(send,"Письмо отправлено");
        $(By.className("layer__controls")).shouldBe(Condition.visible).click();

    }
    public void checkDate(){
        $(By.linkText("Отправленные")).shouldBe(Condition.visible).click();
        dateIdSendEmail = $("[title^='Сегодня']")
                .shouldBe(Condition.visible).getAttribute("title");
    }
    public void exitMail(){
        $(byTitle("выход")).shouldBe(Condition.visible).click();

    }
    public  void assertGetMail(String email){
        $(By.cssSelector("[title^='Сегодня']")).shouldBe(Condition.visible).click();
        String autorEmail = $(("[class='letter__contact-item']")).shouldBe(Condition.visible).getAttribute("title");
        String timeEmail = $(("[class='letter__date']")).getText();
        Assert.assertEquals(dateIdSendEmail, timeEmail);
        Assert.assertEquals(email, autorEmail);
    }
}

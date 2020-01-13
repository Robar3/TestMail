package ru.Robar3.mail.tests;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ru.Robar3.mail.pageObject.LoginPage;
import ru.Robar3.mail.pageObject.MailPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class ConfigMail {

    public String password = System.getenv("onepass");
    public String password2 = System.getenv("twopass");

    public String email = "vanya.test.ivan@mail.ru";

    public String text = "Hello,it is test";
    public String email2 = "ivan.test68@mail.ru";


    MailPage mailPage = new MailPage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void test1LoginWriteEmail() {
        loginPage.loginWriteEmail(email);
    }
    @Test
    public void test2LoginWritePassword() {
        loginPage.loginWritePass(password);
        loginPage.assertLogined(email);
    }

    @Test
    public void test3ClickOnWrite() {
        mailPage.clickWriteMail();
    }
    @Test
    public void test4EnterEmailAndText() {
        mailPage.writeLetter(email2, text);
    }
    @Test
    public void test5ClickSend() {
        mailPage.sendAndClose();
        mailPage.checkDate();
    }
    @Test
    public void test6ChangeEmail() {
        mailPage.exitMail();
    }
    @Test
    public void test7AssertAutorAndTimeEmail() {

        loginPage.loginWriteEmail(email2);
        loginPage.loginWritePass(password2);
        loginPage.assertLogined(email2);
        mailPage.assertGetMail(email);

    }
}

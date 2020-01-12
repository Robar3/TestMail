package ru.Robar3.mail.tests;


import ru.Robar3.mail.pageObject.LoginPage;
import ru.Robar3.mail.pageObject.MailPage;

//login vanya.test.ivan@mail.ru
//пароль test1test

public class ConfigMail {

    public String email = "vanya.test.ivan@mail.ru";
    public String password = "test1test";
    public String text = "Hello,it is test";
    public String email2 = "ivan.test68@mail.ru";
    public String password2 = "test2test";
    MailPage mailPage = new MailPage();
    LoginPage loginPage =new LoginPage();



    public void test2Login() {
        loginPage.login(email, password);
    }


    public void test3ClickOnWrite() {
        mailPage.clickWriteMail();
    }

    public void test4EnterEmailAndText() {
        mailPage.writeLetter(email2, text);
    }

    public void test5ClickSend() {
        mailPage.sendAndClose();
        mailPage.checkDate();
    }
    public void test6ChangeEmail(){
        mailPage.exitMail();
    }

    public void test7AssertAutorAndTimeEmail() {

        loginPage.login(email2,password2);
        mailPage.assertGetMail(email, MailPage.dateIdSendEmail);

    }
}

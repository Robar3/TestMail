package ru.Robar3.mail.tests;


import ru.Robar3.mail.pageObject.LoginPage;
import ru.Robar3.mail.pageObject.MailPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigMail {

    public static String password;
    public static String password2;

    public String email = "vanya.test.ivan@mail.ru";

    public String text = "Hello,it is test";
    public String email2 = "ivan.test68@mail.ru";

    MailPage mailPage = new MailPage();
    LoginPage loginPage =new LoginPage();



    public void test2Login() {
        FileInputStream fis;
        Properties property = new Properties();

        try{
            fis = new FileInputStream("src/main/resources/Config.properties");
            property.load(fis);
            password = property.getProperty("pass1");
            password2 =property.getProperty("pass2");
        }catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
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

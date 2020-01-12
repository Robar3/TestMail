package ru.Robar3.mail.tests;



import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static com.codeborne.selenide.Selenide.open;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestChrome{

    @BeforeClass
    public static void setUpOpera() {

        Configuration.browser = "chrome";
        open("https://mail.ru/");

}
    ConfigMail configMail = new ConfigMail();

    @Test
    public void test2() {
        configMail.test2Login();
    }

    @Test
    public void test3() {
        configMail.test3ClickOnWrite();
    }
    @Test
    public void test4() {
        configMail.test4EnterEmailAndText();
    }
    @Test
    public void test5() {
        configMail.test5ClickSend();
    }

    @Test
    public void test6() {
        configMail.test6ChangeEmail();
    }

    @Test
    public void test7() {
        configMail.test7AssertAutorAndTimeEmail();
    }

}

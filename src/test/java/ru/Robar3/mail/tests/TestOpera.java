package ru.Robar3.mail.tests;


import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import static com.codeborne.selenide.Selenide.open;


public class TestOpera extends ConfigMail{

    @BeforeClass
    public static void setUpOpera() {
        Configuration.browser = "opera";
        open("https://mail.ru/");

    }

}

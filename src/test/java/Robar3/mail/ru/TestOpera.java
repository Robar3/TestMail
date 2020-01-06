package Robar3.mail.ru;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestOpera extends ConfigMail {
    public static WebDriver driver;
    @BeforeClass
    public static void setUpOpera() {
        System.setProperty("webdriver.opera.driver", "src/main/resources/drivers/operadriver.exe");
        driver = new OperaDriver();
        driver.get("https://mail.ru/");

    }
    @Test
    public void test1(){
            test1OnMail(driver);}
    @Test
    public void test2(){
            test2Login(driver);}
    @Test
    public void test3(){
            test3Send(driver);}
    @Test
            public void test4(){
            test4Get(driver);
    }
    @AfterClass
    public static void close() {
        driver.quit();
    }
}

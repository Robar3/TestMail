package Robar3.mail.ru;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//login vanya.test.ivan@mail.ru
//пароль test1test

public class ConfigMail {
    public static String email = "vanya.test.ivan@mail.ru";
    public static String password = "test1test";
    public static String text = "Hello,it is test";




    public void test1OnMail(WebDriver driver) {
        String title = driver.getTitle();
        Assert.assertEquals("Mail.ru: почта, поиск в интернете, новости, игры", title);
    }



    public void test2Login(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailbox:login")));
        driver.findElement(By.id("mailbox:login")).sendKeys(email);
        driver.findElement(By.id("mailbox:submit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailbox:password")));
        driver.findElement(By.id("mailbox:password")).sendKeys(password);
        driver.findElement(By.id("mailbox:submit")).click();
    }


    public void test3Send(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("app-canvas")));
        driver.findElement(By.className("compose-button__wrapper")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compose-app__compose")));
        driver.findElement(By.className("container--zU301")).sendKeys(email);

        WebElement textPanel = driver.findElement(By.cssSelector("[class^='editable-container-']"));
        WebElement webElement = textPanel.findElement(By.tagName("div"));
        webElement.findElement(By.tagName("div")).sendKeys(text);

        WebElement sendPanel = driver.findElement(By.className("compose-app__buttons"));
        sendPanel.findElement(By.xpath("//*[contains(text(), 'Отправить')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("layer__controls")));
        driver.findElement(By.className("layer__controls")).click();
    }


    public void test4Get(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement navigation=driver.findElement(By.className("nav-folders"));
        navigation.findElement(By.cssSelector("[title='Отправленные']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title^='Сегодня']")));

        String dataIdSendEmail = driver.findElement(By.cssSelector("[title^='Сегодня']")).getAttribute("title");
        navigation.findElement(By.cssSelector("[title='Входящие']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title^='Сегодня']")));

        driver.findElement(By.cssSelector("[title^='Сегодня']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("letter__footer-buttons")));
        String autorEmail = driver.findElement(By.cssSelector("[class='letter__contact-item']")).getAttribute("title");
        String timeEmail = driver.findElement(By.cssSelector("[class='letter__date']")).getText();
        Assert.assertEquals(dataIdSendEmail,timeEmail);
        Assert.assertEquals(email,autorEmail);
    }
}

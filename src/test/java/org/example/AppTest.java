package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static WebDriver webDriver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    void initMainPage(){
       Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("http://users.bugred.ru/"),"Страница недоступна");
    }

    @Test
    void testRegistration(){

        WebElement webElementLoginButton = webDriver.findElement(By.xpath("//div[@id='main-menu']/ul/li[2]/a"));
        webElementLoginButton.click();
        //webElementLoginButton.submit();

        WebElement webElementName = webDriver.findElement(By.name("name"));
        webElementName.click();
        webElementName.sendKeys("testik777");

        WebElement webElementEmail = webDriver.findElement(By.name("email"));
        webElementEmail.click();
        webElementEmail.sendKeys("testik777@yandex.ru");

        WebElement webElementPassword = webDriver.findElement(By.xpath("(//input[@name='password'])[2]"));
        webElementPassword.click();
        webElementPassword.sendKeys("123321");

        WebElement webElementRegister = webDriver.findElement(By.name("act_register_now"));
        webElementRegister.click();
      //  webElementRegister.submit();

    }

    @Test
    void testSearch(){
        WebElement webElementName = webDriver.findElement(By.name("q"));
        webElementName.click();
        webElementName.sendKeys("testik777@yandex.ru");

        WebElement webElementSearchButton = webDriver.findElement(By.xpath("//button[@type='submit']"));
        webElementSearchButton.click();
       // webElementSearchButton.submit();

    }

    @Test
    void testAuthorization(){

        WebElement webElementLoginButton = webDriver.findElement(By.xpath("//div[@id='main-menu']/ul/li[2]/a"));
        webElementLoginButton.click();
        webElementLoginButton.submit();

        WebElement webElementEmail = webDriver.findElement(By.name("login"));
        webElementEmail.click();
        webElementEmail.sendKeys("testik777@yandex.ru");

        WebElement webElementPassword = webDriver.findElement(By.xpath("input[@name='password']"));
        webElementPassword.click();
        webElementPassword.sendKeys("123321");

        WebElement webElementRegister = webDriver.findElement(By.xpath("//input[@value='Авторизоваться']"));
        webElementRegister.click();
       // webElementRegister.submit();

    }

    @Test
    void testExit(){
        WebElement webElementLoginButton = webDriver.findElement(By.xpath("//div[@id='main-menu']/ul/li[2]/a"));
        webElementLoginButton.click();
        //webElementLoginButton.submit();

        WebElement webElementEmail = webDriver.findElement(By.name("login"));
        webElementEmail.click();
        webElementEmail.sendKeys("testik777@yandex.ru");

        WebElement webElementPassword = webDriver.findElement(By.xpath("input[@name='password']"));
        webElementPassword.click();
        webElementPassword.sendKeys("123321");

        WebElement webElementRegister = webDriver.findElement(By.xpath("//input[@value='Авторизоваться']"));
        webElementRegister.click();
       // webElementRegister.submit();

        WebElement webElementDropdown = webDriver.findElement(By.xpath("//li[@id='fat-menu']/a"));
        webElementDropdown.click();
       // webElementDropdown.submit();

        WebElement webElementExit = webDriver.findElement(By.xpath("//a[contains(text(),'Выход')]"));
        webElementExit.click();
       // webElementExit.submit();

    }

  @AfterEach
   void exit (){
       webDriver.quit();
    }


}
















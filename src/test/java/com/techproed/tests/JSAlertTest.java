package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void calis(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void jsAlertTest(){
        //<button onclick="jsAlert()">Click for JS Alert</button>
        //xpath, cssSelector, tagname
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();

        //Alert e gecis yapma --> driver.switchTo().alert();
        //Alert in icerdigi mesaji almak icin getText kullaniriz.
        String alertMesaji = driver.switchTo().alert().getText();
        System.out.println(alertMesaji);

        //Alertin icindeki ok butonuna tiklamak icin accept kullanilir
        driver.switchTo().alert().accept();
    }
    @Test
    public void jsConfirmTest(){
        //<button onclick="jsConfirm()">Click for JS Confirm</button>
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button.click();

        /*
        alert.accept();
        alert.getText();
        alert.sendKeys("Gerek yok");*/

        String alertMesaji = driver.switchTo().alert().getText();
        System.out.println(alertMesaji);

        //Alertin icindeki ok butonuna tiklamak icin accept kullanilir
        //driver.switchTo().alert().accept();

        //Alertin icindeki cancel butonuna tiklamak icin dismiss kullanilir
        driver.switchTo().alert().dismiss();
    }
    @Test
    public void jsPromtTest(){
        //<button onclick="jsPrompt()">Click for JS Prompt</button>
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();

        String alertMesaji = driver.switchTo().alert().getText();
        System.out.println(alertMesaji);

        driver.switchTo().alert().sendKeys("Merhaba TestNG");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Alertin icindeki ok butonuna tiklamak icin accept kullanilir
        driver.switchTo().alert().accept();

        //Alertin icindeki cancel butonuna tiklamak icin dismiss kullanilir
        //driver.switchTo().alert().dismiss();

        WebElement ekran = driver.findElement(By.id("result"));
        System.out.println(ekran.getText());

    }


    @AfterClass
    public void tearDown(){
       // driver.quit();
    }
}

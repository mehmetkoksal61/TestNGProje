package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDowlansTest extends TestBase {
    @Test
    public void dosyaVarMi(){
        System.out.println(System.getProperty("user.dir")); //C:\Users\w2345\IdeaProjects\TestNGProje
        System.out.println(System.getProperty("user.home")); //C:\Users\w2345

        String kullaniciDosyaYolu = System.getProperty("user.dir");

        String dosyaYolu = System.getProperty("user.dir");
        //C:\Users\w2345\IdeaProjects\TestNGProje\pom.xml
        String pomXmlDosyaYolu = kullaniciDosyaYolu+"/pom.xml";
        boolean varMi= Files.exists(Paths.get(pomXmlDosyaYolu));
        Assert.assertTrue(varMi);
    }

    @Test
    public void dosyaUpload(){ //Bilgisayardan web sayfasina dosya yukleme
        driver.get("http://the-internet.herokuapp.com/upload");
        // E:\java ders\logo.png
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        chooseFile.sendKeys("E:\\java ders\\logo.png");

        driver.findElement(By.id("file-submit")).click();

        //WebElement ekranYaizi = driver.findElement(By.tagName("h3)"));
        WebElement ekranYaizi = driver.findElement(By.xpath("//*[.='File Uploaded!']"));
        Assert.assertTrue(ekranYaizi.isDisplayed());

    }
    @Test
    public void dosyaDownload(){ //Web sayfasindan bilgisayara dosya yukleme
        driver.get("http://the-internet.herokuapp.com/download");
       driver.findElement(By.partialLinkText("Amsterdam.jpg")).click();
        //C:\Users\w2345\Downloads\Amsterdam.jpg
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean varMi= Files.exists(Paths.get("C:\\Users\\w2345\\Downloads\\Amsterdam.jpg"));
        Assert.assertTrue(varMi);
    }

}

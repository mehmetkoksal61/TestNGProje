package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Ornek_AmazonKayitSayfasi extends TestBase {
    // Day_14 : 6 Eylul 2020 Pazar

    @Test
    public void test01(){
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(element).perform();

        WebElement startHere = driver.findElement(By.partialLinkText("Start here"));
        startHere.click();

        String title = driver.getTitle();

        Assert.assertEquals("Amazon Registration",title);
    }
    @Test (dependsOnMethods = "test01")
    public void test02(){
        WebElement yourName = driver.findElement(By.id("ap_customer_name"));
        yourName.sendKeys("MehmetKoksal");

        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("mehmetkoksal61@gmail.com");

        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("Tonya.61");

        WebElement passwordTekrar = driver.findElement(By.id("ap_password_check"));
        passwordTekrar.sendKeys("Tonya.61");

        WebElement createNewAccount = driver.findElement(By.id("continue"));
        createNewAccount.click();

    }

}

package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitTest extends TestBase {
    @Test
    public void implicitlyWait() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButonu = driver.findElement(By.xpath("//*[.='Remove']"));
        removeButonu.click();
        WebElement element = driver.findElement(By.xpath("//*[.='Add']"));
        Assert.assertTrue(element.isDisplayed());
    }
    @Test
    public void explicityWait (){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        //Explicit wait kullanamk icin WebDriverWait class indan obje uretmeliyiz
        WebDriverWait wait = new WebDriverWait(driver ,30);

        //WebElement removeButton = driver.findElement(By.xpath("//*[.='Remove]"));
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        //WebElement message = driver.findElement(By.id("message"));
        System.out.println(message.getText());


    }
}

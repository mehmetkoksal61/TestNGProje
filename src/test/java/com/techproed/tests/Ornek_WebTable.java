package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Ornek_WebTable extends TestBase {
    public void giris(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);

    }
    @Test
    public void odev() {
        giris();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> satir= driver.findElements(By.xpath("//tbody/tr[3]"));
        for( WebElement  w:satir){
            System.out.println(w.getText());
        }
        List<WebElement> satirSayisi= driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("Tabloda "+ satirSayisi.size()+" tane satir vardir");
    }
}

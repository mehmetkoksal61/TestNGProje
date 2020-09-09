package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends TestBase {

    public void girist(){
        driver.get("http://www.fhctrip-qa.com/admin/HotelRoomAdmin");

        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ Keys.ENTER);

    }
    @Test
    public void table(){
        girist();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());

        List<WebElement> basliklar = driver.findElements(By.xpath("//thead/tr/th"));

        for( WebElement  baslik:basliklar){
            System.out.println(baslik.getText());
        }
    }
    @Test
    public void tumsatirlar(){
        girist();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> satirlar= driver.findElements(By.xpath("//tbody/tr"));
        for( WebElement  satir:satirlar){
            System.out.println(satir.getText());
        }
    }
    @Test
    public void tumhucreler(){
        girist();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> hucreler= driver.findElements(By.xpath("//tbody/tr/td"));
        for( WebElement  hucre:hucreler){
            System.out.println(hucre.getText());
        }
    }
    @Test
    public void belirliBirSutun(){
        girist();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> sutun= driver.findElements(By.xpath("//tbody/tr/td[4]"));
        for( WebElement  w:sutun){
            System.out.println(w.getText());
        }
    }
    @Test
    public void calistir(){
        girist();
        hucreYazdir(3,5);
        hucreYazdir(5,2);
        hucreYazdir(2,1);
        hucreYazdir(9,4);
    }
    public void hucreYazdir(int satir,  int sutun){
        String xpathDegerim = "//tbody/tr["+satir+"]/td["+sutun+"]";
        //                     //tbody/tr[3]/td[5]
        WebElement hucre = driver.findElement(By.xpath(xpathDegerim));
        System.out.println(hucre.getText());
    }
}


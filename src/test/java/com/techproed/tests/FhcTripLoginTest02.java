package com.techproed.tests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.pages.FhcTripLoginPage02;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FhcTripLoginTest02 extends TestBase {
    //http://fhctrip-qa.com/admin/HotelAdmin/Create
    //1 - FhcTripHotelCreatePage ---- PAGES paketinde
    //	code, name, adress, phone, mail, idgroup, save bu webelementleri @FindBy
    //	kullanarak locate edelim.
    //2 - FhcTripHotelCreateTest ---- TESTS paketinde
    //	FhcTripHotelCreatePage class'ından nesne üretelim ve içerisindeki webelementleri kullanarak hotel oluşturalım.
    public void giris(){
    driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
    driver.findElement(By.id("UserName")).sendKeys("manager2");
    driver.findElement(By.id("Password")).sendKeys("Man1ager2!"+ 	Keys.ENTER);
    }
    @Test
    public void aramaTesti(){
        giris();
        FhcTripLoginPage02 hotel = new FhcTripLoginPage02(driver);
        hotel.code.sendKeys("1111");
        hotel.name.sendKeys("Akasya");
        hotel.adres.sendKeys("Alanya");
        hotel.telefon.sendKeys("021200000000");
        hotel.mail.sendKeys("akasya.alanya@hotmail.com");
        Select select = new Select(hotel.dropDown);
        select.selectByIndex(2);
        hotel.save.click();

    }

}

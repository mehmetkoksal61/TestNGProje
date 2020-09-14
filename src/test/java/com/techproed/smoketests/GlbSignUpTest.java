package com.techproed.smoketests;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GlbSignUpTest {
    // artik extend yapilmasina gerek yok

    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("yeni_urls"));
        GlbSignUpPage sayfa =new GlbSignUpPage();
        sayfa.email.sendKeys(ConfigurationReader.getProperty("email"));
        sayfa.isim.sendKeys(ConfigurationReader.getProperty("isim"));
        sayfa.telNo.sendKeys(ConfigurationReader.getProperty("telefon"));
        sayfa.sifre.sendKeys(ConfigurationReader.getProperty("sifre"));
        sayfa.sifreTekrar.sendKeys(ConfigurationReader.getProperty("sifre")+ Keys.ENTER);
        //sayfa.signUp.click();
        boolean basarili =sayfa.yazi.getText().contains("Succes");
        Assert.assertTrue(basarili);

    }
    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }
}

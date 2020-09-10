package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {
    @Test
    public void aramaTesti(){
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
        loginPage.userName.sendKeys("manager2");
        loginPage.password.sendKeys("Man1ager2!"+ Keys.ENTER);
        //loginPage.login.click();

    }
}

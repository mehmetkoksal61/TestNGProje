package com.techproed.smoketests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {
    @Test
    public void aramaTesti(){
        driver.get(ConfigurationReader.getProperty("url"));
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("passsword")+ Keys.ENTER);

    }
}

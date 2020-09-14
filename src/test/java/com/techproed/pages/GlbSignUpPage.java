package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

    public GlbSignUpPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "name")
    public WebElement isim;

    @FindBy(id = "mobile")
    public WebElement telNo;

    @FindBy(id = "password")
    public WebElement sifre;

    @FindBy(id = "re_password")
    public WebElement sifreTekrar;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signUp;

    @FindBy(xpath = "//*[.='Success!']")
    public WebElement yazi;
}

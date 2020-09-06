package Tekrar;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);

        WebElement paragraf = driver.findElement(By.xpath("//P"));
        paragraf.clear();
        paragraf.sendKeys("ABI NASILSIN");

        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

    }
}

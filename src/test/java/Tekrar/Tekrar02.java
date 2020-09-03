package Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Tekrar02 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test01(){
        driver.get("http://gogle.com");
        String title = driver.getTitle();
        SoftAssert asse =new SoftAssert();
        asse.assertTrue(title.contains("Google"));
        asse.assertAll();
    }
    @Test
    public void test02(){
        driver.get("http://gogle.com");
        String title = driver.getTitle();
        SoftAssert asse =new SoftAssert();
        asse.assertTrue(title.equals("Gogle"));
        asse.assertAll();
    }

}

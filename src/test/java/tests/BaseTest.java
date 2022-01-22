package tests;

//token
// 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

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjects.Urls;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.BASE_URL);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pageObjects.Urls;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.BASE_URL);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

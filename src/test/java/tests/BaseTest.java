package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pageObjects.Urls;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        //options.addArguments("--disable-dev-shm-usage");
    }

    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();

        //для работы с дженкинсом раскомментить \/
        //options.addArguments("--headless");

        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(Urls.BASE_URL);
        //options.addArguments("--disable-dev-shm-usage");

    }

    @AfterMethod
    public void tearDown(){
        Allure.addAttachment("screenshot",new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        driver.quit();
    }



}

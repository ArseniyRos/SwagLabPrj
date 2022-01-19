package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;

public class Test1 {
    public static void main(String[] args) {

        //Create Webdriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(Urls.BASE_URL);

        //LoginPage
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sleep(2000);
        loginPage.fillForm("standard_user", "secret_sauce");

        //ProductsPage
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect("https://www.saucedemo.com/inventory.html", "PRODUCTS"));
        productsPage.sleep(2000);
        productsPage.tearDown();

    }
}

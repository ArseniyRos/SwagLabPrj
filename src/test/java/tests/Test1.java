package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;

public class Test1 extends BaseTest{
    @Test
    public void test1() {

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
    @Test
    public void test2() {

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




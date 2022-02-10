package tests.loginTests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;
import tests.BaseTest;

public class SuccessfulLoginTests extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify able to login with correct username/password")
    @Epic("E01")
    @Feature("Feature3: login")
    @Story("Story:PRO-45262")
    @Test(testName = "Login with standard user")
    public void test_01(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
    }

    @Story("Login with correct username/password for problem user")
    @Test(testName = "Login with problem user")
    public void test_02(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.PROBLEM_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
    }

    @Story("Login with correct username/password for glitched user")
    @Test(testName = "Login with glitched user")
    public void test_03(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.GLITCH_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
    }



}

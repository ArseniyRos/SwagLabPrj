package tests.sanityTests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import tests.BaseTest;

public class itemsCounterTest extends BaseTest{
    @Severity(SeverityLevel.MINOR)
    @Description("Verify items counter on cart icon")
    @Epic("Functional tests")
    @Feature("Feature: Icon")
    @Story("Adding items to cart and check number in counter")
    @Test(testName = "Verify items counter on cart icon")
    public void test_01() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));

        Assert.assertEquals(productsPage.getNumberFromCartIcon(),0);
        //productsPage.addToCartProduct("Sauce Labs Fleece Jacket");
        //productsPage.addToCartProduct("Sauce Labs Onesie");
        String products [] = {"Sauce Labs Fleece Jacket", "Sauce Labs Onesie"};
        for (int i = 0; i < products.length; i++) {
            //String product = products[i];
            productsPage.addToCartProduct(products[i]);
        }
        Assert.assertEquals(productsPage.getNumberFromCartIcon(),products.length);

    }
}

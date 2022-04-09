package tests.sanityTests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import tests.BaseTest;

public class NegativeBuyingNothingTest extends BaseTest {

    @Severity(SeverityLevel.MINOR)
    @Description("Trying to go checkout with empty cart")
    @Epic("E02")
    @Feature("Feature1: Buying products")
    @Story("Login and trying go checkout with empty cart")
    @Test(testName = "Trying to go checkout with empty cart")
    public void test_01(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.applyFilter_1AZ_2ZA_A3LoHi_4HiLo(3);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
        productsPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.checkRedirectViaDisplayingElementAndHisTitle(cartPage.getPageTitle(), "YOUR CART"));
        double sumPrice = cartPage.priceOfProducts();
        Assert.assertTrue(cartPage.cartIsEmpty(),"Cart is empty");
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertFalse(checkoutPage.checkRedirectViaDisplayingElementAndHisTitle(checkoutPage.getPageTitle(), "CHECKOUT: YOUR INFORMATION"));
    }
}

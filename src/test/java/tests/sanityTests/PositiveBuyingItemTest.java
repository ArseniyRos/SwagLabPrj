package tests.sanityTests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import tests.BaseTest;

public class PositiveBuyingItemTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Description("End to end test with login, choosing and buying products, using sorting and checking prices")
    @Epic("E01")
    @Feature("Feature2: Login")
    @Story("Story:PRO-45262")
    @Test(testName = "Positive buying 1 item test")
    public void test_01(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.applyFilter_1AZ_2ZA_A3LoHi_4HiLo(3);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
        productsPage.addToCartProduct("Sauce Labs Fleece Jacket");
        productsPage.addToCartProduct("Sauce Labs Onesie");
        productsPage.openProduct("Sauce Labs Bolt T-Shirt");

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.checkRedirectViaDisplayingElementAndHisTitle(productPage.getProductTitle(),"Sauce Labs Bolt T-Shirt"));
        productPage.clickAddToCart();
        productPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.checkRedirectViaDisplayingElementAndHisTitle(cartPage.getPageTitle(), "YOUR CART"));
        //Assert.assertTrue(cartPage.checkRedirectViaDisplayingElementAndHisTitle(cartPage.getListOfProductTitles().get(2),"Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(cartPage.checkRedirectViaDisplayingElementAndHisTitle(cartPage.getListOfProductTitles().get(cartPage.findElementInListOfThemOnAPage(cartPage.getListOfProductTitles(), "Sauce Labs Bolt T-Shirt")),"Sauce Labs Bolt T-Shirt"));
        double sumPrice = cartPage.priceOfProducts();
        // cartPage.test();
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.checkRedirectViaDisplayingElementAndHisTitle(checkoutPage.getPageTitle(), "CHECKOUT: YOUR INFORMATION"));
        checkoutPage.fillForm("Arseniy", "Rosenberg", "5692030");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertTrue(checkoutOverviewPage.checkRedirectViaDisplayingElementAndHisTitle(checkoutOverviewPage.getPageTitle(), "CHECKOUT: OVERVIEW"));
       // Assert.assertTrue(checkoutOverviewPage.checkRedirectViaDisplayingElementAndHisTitle(checkoutOverviewPage.getListOfProductTitles().get(2), "Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(checkoutOverviewPage.checkRedirectViaDisplayingElementAndHisTitle(checkoutOverviewPage.getListOfProductTitles().get(checkoutOverviewPage.findElementInListOfThemOnAPage(checkoutOverviewPage.getListOfProductTitles(), "Sauce Labs Bolt T-Shirt")),"Sauce Labs Bolt T-Shirt"));

        Assert.assertTrue(checkoutOverviewPage.pricesComparison(sumPrice));
        checkoutOverviewPage.clickFinish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutCompletePage.checkRedirectViaDisplayingElementAndHisTitle(checkoutCompletePage.getPageTitle(), "CHECKOUT: COMPLETE!"));
        Assert.assertTrue(checkoutCompletePage.checkRedirectViaDisplayingElementAndHisTitle(checkoutCompletePage.getThanksForYourOrderTitle(), "THANK YOU FOR YOUR ORDER"));
        checkoutCompletePage.clickBackHome();

    }
}

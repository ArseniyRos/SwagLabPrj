package tests.sanityTests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;
import tests.BaseTest;

public class NegativeLogoutBackAndToBeLoggedInTest extends BaseTest {
    @Severity(SeverityLevel.MINOR)
    @Description("Trying to get login via login->logout->back")
    @Epic("E01")
    @Feature("Feature2: negative login test")
    @Story("Story:PRO-45262")
    @Test(testName = "Login after logout using back button")
    public void test_01() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
        Assert.assertTrue(productsPage.checkLogoutLink());
        driver.navigate().back();
        //Assert.assertFalse(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"), "Redirect didnt happen");
        Assert.assertFalse(productsPage.urlIsCorrect(Urls.INVENTORY_URL), "Redirect happened");
    }
}
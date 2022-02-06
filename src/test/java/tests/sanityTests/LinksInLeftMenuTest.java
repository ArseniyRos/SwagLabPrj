package tests.sanityTests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;
import tests.BaseTest;

public class LinksInLeftMenuTest extends BaseTest {
    @Severity(SeverityLevel.MINOR)
    @Description("Verify links in left menu")
    @Epic("E01")
    @Feature("Feature2: external links check")
    @Story("Story:PRO-45262")
    @Test(testName = "Verify links in left menu")
    public void test_01() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
        Assert.assertTrue(productsPage.checkAboutLink());
        driver.navigate().back();
        productsPage.openProduct("Sauce Labs Onesie");
        Assert.assertTrue(productsPage.checkAllItemsLink());
        Assert.assertTrue(productsPage.checkLogoutLink());

    }
}
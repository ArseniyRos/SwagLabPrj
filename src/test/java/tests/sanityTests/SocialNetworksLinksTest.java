package tests.sanityTests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import tests.BaseTest;

import java.util.ArrayList;

public class SocialNetworksLinksTest extends BaseTest {
    @Severity(SeverityLevel.MINOR)
    @Description("Verify external social network links")
    @Epic("E03")
    @Feature("Feature4: external links check")
    @Story("Login and open all external social network links")
    @Test(testName = "External social networks links test")
    public void test_01() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);


        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
        Assert.assertTrue(productsPage.checkTwitterLink());
        Assert.assertTrue(productsPage.checkFacebookLink());
        Assert.assertTrue(productsPage.checkLinkedinLink());
    }
}
package tests.loginTests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;
import tests.BaseTest;


public class LoginTestsWithProvideData extends BaseTest{

    @DataProvider
    public Object[][] get_data(){
        return new Object[][]{
                {Credentials.STANDARD_USER,Credentials.CORRECT_PASSWORD},
                {Credentials.GLITCH_USER,Credentials.CORRECT_PASSWORD},
                {Credentials.PROBLEM_USER, Credentials.CORRECT_PASSWORD},
        };
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify able to login with correct username/password")
    @Epic("E01")
    @Feature("Feature3: login")
    @Story("Story:PRO-45262")
    @Test(dataProvider = "get_data", testName = "Login with standard user", groups = {"Smoke", "Login"})
    public void test_01(String x, String y){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
    }
}

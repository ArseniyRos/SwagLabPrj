package tests.loginTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;
import tests.BaseTest;

public class NegativeLoginTests extends BaseTest {

    @Test(testName = "Login with locked user")
    public void test_01(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.LOCKED_USER, Credentials.CORRECT_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");
    }

}

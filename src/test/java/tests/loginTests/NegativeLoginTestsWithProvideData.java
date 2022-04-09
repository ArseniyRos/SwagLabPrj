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

public class NegativeLoginTestsWithProvideData extends BaseTest{

    @DataProvider
    public Object[][] get_data(){
        return new Object[][]{
               // {Credentials.LOCKED_USER,Credentials.CORRECT_PASSWORD},
                {Credentials.EMPTY_USER,Credentials.CORRECT_PASSWORD, Credentials.ERROR_LOGIN1},
                {Credentials.STANDARD_USER, Credentials.EMPTY_PASSWORD, Credentials.ERROR_LOGIN2},
                {Credentials.EMPTY_USER, Credentials.EMPTY_PASSWORD, Credentials.ERROR_LOGIN1},
                {Credentials.LOCKED_USER, Credentials.CORRECT_PASSWORD, Credentials.ERROR_LOGIN3},
        };
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify able to login with correct username/password")
    @Epic("E01")
    @Feature("Feature3: login")
    @Story("Story:PRO-45262")
    @Test(dataProvider = "get_data", testName = "Login with standard user", groups = {"Smoke", "Login", "Negative"})
    public void test_01(String x, String y, String z){

        for (int i = 0; i < get_data().length; i++) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.fillForm(x, y);
            Assert.assertEquals(loginPage.getErrorMessage(),z);
            for (int j = 0; j < get_data().length; j++) {


            }

        }

        //Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");

    }



}

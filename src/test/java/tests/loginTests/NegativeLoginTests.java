package tests.loginTests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import tests.BaseTest;

public class NegativeLoginTests extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify unable to login and error message with empty blocked username/password")
    @Epic("E01")
    @Feature("Feature3: login")
    @Story("Login with empty blocked username/password")
    @Test(testName = "Login with locked user")
    public void test_01(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.LOCKED_USER, Credentials.CORRECT_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");
    }

    @Story("Login with empty username")
    @Test(testName = "Login with empty login")
    public void test_02(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.EMPTY_USER, Credentials.CORRECT_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }

    @Story("Login with empty password")
    @Test(testName = "Login with empty password")
    public void test_03(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.EMPTY_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required");
    }

    @Story("Login with empty username/password")
    @Test(testName = "Login with empty password and login")
    public void test_04(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.EMPTY_USER, Credentials.EMPTY_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }

}

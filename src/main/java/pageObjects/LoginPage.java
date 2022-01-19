package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {       super(driver);    }

    //Elements
    By userNameTextField = By.cssSelector("[id='user-name']");
    By passwordTextField = By.cssSelector("[id='password']");
    By loginButton = By.cssSelector("[id='login-button']");

    //Methods

    public void fillLogin(String text){
        fillText(driver.findElement(userNameTextField), text);
    }

    public void fillPassword(String text){
        fillText(driver.findElement(passwordTextField), text);
    }

    public void clickLogin(){
        clickElement(driver.findElement(loginButton));
    }

    public void fillForm(String login, String password) {
        fillText(driver.findElement(userNameTextField), login);
        fillPassword(password);
        clickLogin();
    }




}

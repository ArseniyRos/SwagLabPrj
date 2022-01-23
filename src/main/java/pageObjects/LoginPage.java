package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {super(driver);}

    //Elements
    @FindBy (css = "[id='user-name']")
    WebElement userNameTextField;
    @FindBy (css = "[id='password']")
    WebElement passwordTextField;
    @FindBy (css = "[id='login-button']")
    WebElement loginButton;
    @FindBy (css = "[data-test='error']")
    WebElement errorMessage;



    //Methods
    public void fillLogin(String text){
        fillText(userNameTextField, text);
    }

    public void fillPassword(String text){
        fillText(passwordTextField, text);
    }

    public void clickLogin(){
        clickElement(loginButton);
    }

    public void fillForm(String login, String password) {
        fillText(userNameTextField, login);
        fillPassword(password);
        clickLogin();
    }

    public String getErrorMessage(){
        return getElementText(errorMessage);
    }




}

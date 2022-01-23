package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends CommonElements{

    public CheckoutPage(WebDriver driver) {super(driver);}

    //Elements
    @FindBy(css = "[class='header_secondary_container'] [class='title']")
    WebElement pageTitle;

    @FindBy(css = "[id='continue']")
    WebElement continueButton;

    @FindBy(css = "[id='cancel']")
    WebElement cancelButton;

    @FindBy(css = "[id='first-name']")
    WebElement firstNameTextBox;

    @FindBy(css = "[id='last-name']")
    WebElement lastNameTextBox;

    @FindBy(css = "[id='postal-code']")
    WebElement postalCodeTextBox;

    //Methods
    public void clickContinue(){
        clickElement(continueButton);
    }

    public void clickCancel(){
        clickElement(cancelButton);
    }

    public void fillForm(String firstName, String lastName, String postalCode) {
        fillText(firstNameTextBox, firstName);
        fillText(lastNameTextBox, lastName);
        fillText(postalCodeTextBox, postalCode);
        clickContinue();
    }



}

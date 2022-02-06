package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends CommonElements{
    public CheckoutCompletePage(WebDriver driver) {super(driver);}

    //Elements
    @FindBy(css = "[class='header_secondary_container'] [class='title']")
    WebElement pageTitle;

    @FindBy(css = "[id='back-to-products']")
    WebElement backHomeButton;

    @FindBy(css = "[class='complete-header']")
    WebElement thanksForYourOrderTitle;

    //Getters


    @Override
    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getBackHomeButton() {
        return backHomeButton;
    }

    public WebElement getThanksForYourOrderTitle() {
        return thanksForYourOrderTitle;
    }

    //Methods
    public void clickBackHome(){
        clickElement(backHomeButton);
    }

}

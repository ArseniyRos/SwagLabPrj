package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElements extends BasePage{
    public CommonElements(WebDriver driver) {super(driver);}

    //Elements
    @FindBy(css = "[class='header_secondary_container'] [class='title']")
    WebElement pageTitle;

    @FindBy(css = "[class='social_twitter']")
    WebElement twitterButton;

    @FindBy(css = "[class='social_facebook']")
    WebElement facebookButton;

    @FindBy(css = "[class='social_linkedin']")
    WebElement linkedinButton;

    @FindBy(css = "[class='shopping_cart_link']")
    WebElement shoppingCartButton;

    @FindBy(css = "[class='shopping_cart_badge']")
    WebElement cartItemsCounter;

    @FindBy(css = "[id='react-burger-menu-btn']")
    WebElement sandwichButton;

    @FindBy(css = "[id='inventory_sidebar_link']")
    WebElement allItemsSidebarOption;

    @FindBy(css = "[id='about_sidebar_link']")
    WebElement aboutSidebarOption;

    @FindBy(css = "[id='logout_sidebar_link']")
    WebElement logoutSidebarOption;

    @FindBy(css = "[id='reset_sidebar_link']")
    WebElement resetSidebarOption;


    //Methods
    public void openCart() {
        clickElement(shoppingCartButton);
    }

    public void clickLinkedin() {
        clickElement(linkedinButton);
    }

    public void clickFacebook() {
        clickElement(facebookButton);
    }

    public void clickTwitter() {
        clickElement(twitterButton);
    }

    public boolean redirectIsCorrect(String url, String correctTitle){
        if (textIsCorrect(pageTitle, correctTitle ) && urlIsCorrect(url)) {
            return true;
        }
        else return false;
    }





}

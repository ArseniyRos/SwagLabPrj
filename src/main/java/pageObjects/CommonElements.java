package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;

public class CommonElements extends BasePage {
    public CommonElements(WebDriver driver) {
        super(driver);
    }

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



    //getters


    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getTwitterButton() {
        return twitterButton;
    }

    public WebElement getFacebookButton() {
        return facebookButton;
    }

    public WebElement getLinkedinButton() {
        return linkedinButton;
    }

    public WebElement getShoppingCartButton() {
        return shoppingCartButton;
    }

    public WebElement getCartItemsCounter() {
        return cartItemsCounter;
    }

    public WebElement getSandwichButton() {
        return sandwichButton;
    }

    public WebElement getAllItemsSidebarOption() {
        return allItemsSidebarOption;
    }

    public WebElement getAboutSidebarOption() {
        return aboutSidebarOption;
    }

    public WebElement getLogoutSidebarOption() {
        return logoutSidebarOption;
    }

    public WebElement getResetSidebarOption() {
        return resetSidebarOption;
    }

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

    public void clickAbout(){
        clickElement(sandwichButton);
        clickElement(aboutSidebarOption);
    }

    public void clickLogout(){
        clickElement(sandwichButton);
        clickElement(logoutSidebarOption);
    }

    public void clickAllItems(){
        clickElement(sandwichButton);
        clickElement(allItemsSidebarOption);
    }

    public boolean redirectIsCorrect(String url, String correctTitle) {
        //wont work (fall) if redirect actually didnt happend, will fixed later
        return  (textIsCorrect(pageTitle, correctTitle) && urlIsCorrect(url));
    }

    public boolean checkTwitterLink(){
        clickTwitter();
        System.out.println(driver.getCurrentUrl());
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        System.out.println(driver.getCurrentUrl());
        if (urlIsCorrect(Urls.TWITTER_URL)) {
            driver.close();
            driver.switchTo().window(tabs.get(0)); //switches to new tab
            return true;
        }
        else return false;
    }

    public boolean checkFacebookLink(){
        clickFacebook();
        System.out.println(driver.getCurrentUrl());
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        System.out.println(driver.getCurrentUrl());
        if (urlIsCorrect(Urls.FACEBOOK_URL)) {
            driver.close();
            driver.switchTo().window(tabs.get(0)); //switches to new tab
            return true;
        }
        else return false;
    }

    public boolean checkLinkedinLink(){
        clickLinkedin();
        System.out.println(driver.getCurrentUrl());
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        System.out.println(driver.getCurrentUrl());
        if (urlIsCorrect(Urls.LINKEDIN_URL) || driver.getCurrentUrl().contains("https://www.linkedin.com/authwal")) {
            driver.close();
            driver.switchTo().window(tabs.get(0)); //switches to new tab
            return true;
        }
        else return false;
    }

    public boolean checkAboutLink(){
        clickAbout();
        System.out.println(driver.getCurrentUrl());
        return (urlIsCorrect(Urls.ABOUT_URL));
    }

    public boolean checkLogoutLink(){
        clickLogout();
        return ((urlIsCorrect(Urls.BASE_URL)) && elementIsDisplayed(driver.findElement(By.id("login-button"))) && textBoxIsEmpty(driver.findElement(By.id("user-name"))) && textBoxIsEmpty(driver.findElement(By.id("password"))));
    }

    public boolean checkAllItemsLink(){
        clickAllItems();
        return ((urlIsCorrect(Urls.INVENTORY_URL)) && (checkRedirectViaDisplayingElementAndHisTitle(pageTitle, "PRODUCTS")));
    }


    /*public boolean checkLinkInNewTab(String nameOfNetwork) {
        switch (nameOfNetwork) {
            case "twitter":
                clickTwitter();
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1)); //switches to new tab
                if (driver.getCurrentUrl().equals(Urls.TWITTER_URL)) {
                    return true;
                }
                System.out.println(driver.getCurrentUrl() + "twitter option");
                driver.switchTo().window(tabs.get(0)); //switches to new tab
                break;
            case "facebook":
                clickFacebook();
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1)); //switches to new tab
                if (driver.getCurrentUrl().equals(Urls.FACEBOOK_URL)) {
                    return true;
                }
                System.out.println(driver.getCurrentUrl() + "facebook option");
                driver.switchTo().window(tabs.get(0)); //switches to new tab
                break;
            case "linkedin":
                clickLinkedin();
                ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1)); //switches to new tab
                if (driver.getCurrentUrl().equals(Urls.LINKEDIN_URL)) {
                    return true;
                }
                System.out.println(driver.getCurrentUrl() + "linkedin option");
                driver.switchTo().window(tabs.get(0)); //switches to new tab
                break;
        }
        driver.switchTo().window(tabs.get(0)); //switches to new tab
        System.out.println(driver.getCurrentUrl());
        return false;
    }*/
}

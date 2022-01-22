package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Elements

    @FindBy(css = "[class='header_secondary_container'] [class='title']")
    WebElement pageTitle;

    @FindBy(css = "[class='inventory_item_name']")
    private List<WebElement> listOfProductTitle;

    @FindBy(css = "[class='inventory_item_price']")
    private List<WebElement> listOfProductPrice;

    @FindBy(css = "[class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> listOfAddToCardButton;

    @FindBy(css = "[class='btn btn_secondary btn_small btn_inventory']")
    private List<WebElement> listOfRemoveButton;

    @FindBy(css = "[class='inventory_item_desc']")
    private List<WebElement> listOfProductDescription;

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

    @FindBy(css = "[class='product_sort_container']")
    WebElement productSortDrp;

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

    public void openProduct(String titleOfProductForChoose) {

        for (WebElement productTitle : listOfProductTitle) {
            if (productTitle.getText().equalsIgnoreCase(titleOfProductForChoose)) {
                productTitle.click();
            }
            break;
        }
    }
    //will work if there is no added to cart products right now, dunno how to fix for now
    public void addToCartProduct(String titleOfProductForAddingToCart) {
        int i=0;
        for (WebElement productTitle : listOfProductTitle) {
            if (productTitle.getText().equalsIgnoreCase(titleOfProductForAddingToCart)) {
                listOfAddToCardButton.get(i).click();
            }
            i++;
        }
    }
    //stilled, but fixed cssSelector (only add, without remove)
    public void addToCart(String titleOfProductForAddingToCart) {

        for (WebElement productAreaElement : listOfProductTitle) {
            String title = productAreaElement.findElement(By.cssSelector("[class='inventory_item_name']")).getText();
            if(title.equalsIgnoreCase(titleOfProductForAddingToCart)) {
                WebElement addButton = productAreaElement.findElement(By.cssSelector("a[id^='add-to-cart-']"));
                clickElement(addButton);
                break;
            }
        }
    }

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
































    //Methods
    /*public  boolean productsPageIsDisplayedByTitle(){
        return textIsCorrect(driver.findElement(title), "Products" );
    }

    public boolean productsPageIsDisplayedByUrl(String text){
        return urlIsCorrect(text);
    }*/
    //сначала разбил проверку на 2 метода, но потом подумал, что можно и объединить

    public boolean redirectIsCorrect(String url, String correctTitle){
        if (textIsCorrect(pageTitle, correctTitle ) && urlIsCorrect(url)) {
            return true;
        }
        else return false;
    }



}

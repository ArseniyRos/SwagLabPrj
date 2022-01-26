package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends CommonElements{

    public ProductPage(WebDriver driver) {super(driver);}

    //Elements

    @FindBy(css = "[class='inventory_details_name large_size']")
    WebElement productTitle;

    @FindBy(css = "[class='inventory_details_desc large_size']")
    WebElement productDescription;

    @FindBy(css = "[class='inventory_details_price']")
    WebElement productPrice;

    @FindBy(css = "[class='btn btn_primary btn_small btn_inventory']")
    WebElement addToCartButton;

    @FindBy(css = "[id='back-to-products']")
    WebElement backButton;

    @FindBy(css = "[class='shopping_cart_badge']")
    WebElement cartItemsCounter;

    @FindBy(css = "[class='shopping_cart_link']")
    WebElement shoppingCartButton;

    //Getters
    public WebElement getProductTitle() {
        return productTitle;
    }

    public WebElement getProductDescription() {
        return productDescription;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getCartItemsCounter() {
        return cartItemsCounter;
    }

    public WebElement getShoppingCartButton() {
        return shoppingCartButton;
    }

//Methods

    public void clickBackToProducts() {
        clickElement(backButton);
    }

    public void clickAddToCart() {
        clickElement(addToCartButton);
    }






}

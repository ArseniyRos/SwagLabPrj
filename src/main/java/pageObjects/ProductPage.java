package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

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

    //Methods

    public void clickBackToProducts() {
        clickElement(backButton);
    }

    public void clickAddToCart() {
        clickElement(addToCartButton);
    }



}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {super(driver);}

    //Elements
    @FindBy(css = "[class='header_secondary_container'] [class='title']")
    WebElement pageTitle;

    @FindBy(css = "[class='btn btn_secondary back btn_medium']")
    WebElement continueToShoppingButton;

    @FindBy(css = "[class='btn btn_action btn_medium checkout_button']")
    WebElement checkoutButton;

    @FindBy(css = "[class='btn btn_secondary btn_small cart_button']")
    private List<WebElement> listOfRemoveButtons;

    @FindBy(css = "[class='inventory_item_name']")
    private List<WebElement> listOfProductTitles;

    @FindBy(css = "[class='cart_quantity']")
    private List<WebElement> listOfQuantityOfProducts;

    //Methods

    public void continueShopping(){
        clickElement(continueToShoppingButton);
    }

    public void clickCheckout(){
        clickElement(checkoutButton);
    }

    public void removeItem(String titleOfRemovingProduct){
        for (WebElement product : listOfProductTitles) {
                String title = product.findElement(By.cssSelector("[class='inventory_item_name']")).getText();
                   if(title.equalsIgnoreCase(titleOfRemovingProduct)) {
                       WebElement removeButton = product.findElement(By.cssSelector("[class='btn btn_secondary btn_small cart_button']"));
                       clickElement(removeButton);
                       break;
                   }
            }
        }
    public void openItem(String titleOfRemovingProduct){
        for (WebElement product : listOfProductTitles) {
            String title = product.findElement(By.cssSelector("[class='inventory_item_name']")).getText();
            if(title.equalsIgnoreCase(titleOfRemovingProduct)) {
                WebElement itemTitle = product.findElement(By.cssSelector("[class='inventory_item_name']"));
                clickElement(itemTitle);
                break;
            }
        }
    }



}









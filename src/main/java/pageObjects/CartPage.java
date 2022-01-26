package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends CommonElements{

    public CartPage(WebDriver driver) {super(driver);}

    //Elements

    @FindBy(css = "[class='btn btn_secondary back btn_medium']")
    WebElement continueToShoppingButton;

    @FindBy(css = "[class='btn btn_action btn_medium checkout_button']")
    WebElement checkoutButton;

    @FindBy(css = "[class='btn btn_secondary btn_small cart_button']")
    private List<WebElement> listOfRemoveButtons;

    @FindBy(css = "[class='inventory_item_name']")
    private List<WebElement> listOfProductTitles;

    @FindBy(css = "[class='inventory_item_price']")
    private List<WebElement> listOfProductPrices;

    @FindBy(css = "[class='cart_quantity']")
    private List<WebElement> listOfQuantityOfProducts;

    //Getters

    public WebElement getContinueToShoppingButton() {
        return continueToShoppingButton;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public List<WebElement> getListOfRemoveButtons() {
        return listOfRemoveButtons;
    }

    public List<WebElement> getListOfProductTitles() {
        return listOfProductTitles;
    }

    public List<WebElement> getListOfQuantityOfProducts() {
        return listOfQuantityOfProducts;
    }


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

    public double priceOfProducts(){
        String priceText;
        String priceTextWithout$;
        Double priceInDouble;
        Double finalSum = 0.0;
        int numberOfElements = listOfProductPrices.size();
        for (int i = 0; i < numberOfElements; i++){
            priceInDouble = Double.parseDouble(getElementText(listOfProductPrices.get(i)).replace("$",""));
            finalSum = finalSum+priceInDouble;
        }
        System.out.println("final sum "+ finalSum);
        return finalSum;
    }

    //Assert.assertTrue(checkoutOverviewPage.checkRedirectViaDisplayingElementAndHisTitle(checkoutOverviewPage.getListOfProductTitles().get(2), "Sauce Labs Bolt T-Shirt"));
    /*public boolean checkProductIsDisplayedInList(String productTitle) {
        for (product: listOfProductTitles) {
            elementIsDisplayed(product)
        }
        ) {

        }
    } */





}









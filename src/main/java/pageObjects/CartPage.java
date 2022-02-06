package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends CommonElements {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Elements

    @FindBy(css = "[class='btn btn_secondary back btn_medium']")
    WebElement continueToShoppingButton;

    @FindBy(css = "[class='btn btn_action btn_medium checkout_button']")
    WebElement checkoutButton;

    @FindBy(css = "[class='btn btn_secondary btn_small cart_button']")
    private List<WebElement> listOfRemoveButtons;

    @FindBy(css = "[class='cart_item']")
    private List<WebElement> cartItems;

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


//Array.from($0.getElementsByClassName('cart_item')).reduce((acc, item) => {
//    const price = item.getElementsByClassName('inventory_item_price')[0].textContent.split('$')[1];
//    const quantity = item.getElementsByClassName('cart_quantity')[0].textContent;
//
//        return acc + Number(price) * Number(quantity);
//    }, 0);
    //Methods

    public void test() {
        Number sum = cartItems.stream().map((item) -> {
            System.out.println(item.findElement(By.cssSelector("[class='inventory_item_price']")).getText().split("\\$") + "'!!!!!!!!!!!'"); //разобраться в сплите стригов
            String price = item.findElement(By.cssSelector("[class='inventory_item_price']")).getText().split("$")[1];
            String quantity = item.findElement(By.cssSelector("[class='cart_quantity']")).getText();

            return   Double.parseDouble(price) * Double.parseDouble(quantity);
        }).reduce(0.0, (acc, item) -> acc + item);

        System.out.println(sum+ "ttttuuuuuuuttttt");
    }

    public void continueShopping() {
        clickElement(continueToShoppingButton);
    }

    public void clickCheckout() {
        clickElement(checkoutButton);
    }

    public void removeItem(String titleOfRemovingProduct) {
        for (WebElement product : listOfProductTitles) {
            String title = product.findElement(By.cssSelector("[class='inventory_item_name']")).getText();
            if (title.equalsIgnoreCase(titleOfRemovingProduct)) {
                WebElement removeButton = product.findElement(By.cssSelector("[class='btn btn_secondary btn_small cart_button']"));
                clickElement(removeButton);
                break;
            }
        }
    }

    public void openItem(String titleOfRemovingProduct) {
        for (WebElement product : listOfProductTitles) {
            String title = product.findElement(By.cssSelector("[class='inventory_item_name']")).getText();
            if (title.equalsIgnoreCase(titleOfRemovingProduct)) {
                WebElement itemTitle = product.findElement(By.cssSelector("[class='inventory_item_name']"));
                clickElement(itemTitle);
                break;
            }
        }
    }

    public double priceOfProducts() {
        String priceText;
        String priceTextWithout$;
        Double finalSum = 0.0;
        int numberOfElements = listOfProductPrices.size();
        for (int i = 0; i < numberOfElements; i++) {
            finalSum += (Double.parseDouble(getElementText(listOfProductPrices.get(i)).replace("$", "")))*(1);
        }
        //System.out.println("final sum " + finalSum);
        return finalSum;
    }

    public boolean cartIsEmpty() {
        return driver.findElements(By.className("inventory_item_name")).isEmpty();
    }
}

//Assert.assertTrue(checkoutOverviewPage.checkRedirectViaDisplayingElementAndHisTitle(checkoutOverviewPage.getListOfProductTitles().get(2), "Sauce Labs Bolt T-Shirt"));
    /*public boolean checkProductIsDisplayedInList(String productTitle) {
        for (product: listOfProductTitles) {
            elementIsDisplayed(product)
        }
        ) {

        }
    } */















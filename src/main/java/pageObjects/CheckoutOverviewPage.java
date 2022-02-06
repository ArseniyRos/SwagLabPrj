package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage extends CommonElements{
    public CheckoutOverviewPage(WebDriver driver) {super(driver);}

    //Elements
    @FindBy(css = "[class='header_secondary_container'] [class='title']")
    WebElement pageTitle;

    @FindBy(css = "[id='cancel']")
    WebElement cancelButton;

    @FindBy(css = "[id='finish']")
    WebElement finishButton;

    @FindBy(css = "[class='summary_subtotal_label']")
    WebElement itemsPrice;

    @FindBy(css = "[class='summary_tax_label']")
    WebElement tax;

    @FindBy(css = "[class='summary_total_label']")
    WebElement totalPrice;

    @FindBy(css = "[class='inventory_item_name']")
    private List<WebElement> listOfProductTitles;

    @FindBy(css = "[class='inventory_item_price']")
    private List<WebElement> listOfProductPrices;

    //Getters


    @Override
    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getFinishButton() {
        return finishButton;
    }

    public WebElement getItemsPrice() {
        return itemsPrice;
    }

    public WebElement getTax() {
        return tax;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public List<WebElement> getListOfProductTitles() {
        return listOfProductTitles;
    }

    public List<WebElement> getListOfProductPrices() {
        return listOfProductPrices;
    }

    //Methods
    public void clickFinish(){
        clickElement(finishButton);
    }

    public void clickCancel(){
        clickElement(cancelButton);
    }


    public boolean pricesComparison(double firstSum){
        //checking:
        // 1 sum of items from CartPage with number on CheckoutPage
        // 2 sum price+tax+finalPrice
        // 3 tax !> 10%
        double currentItemsSum = Double.parseDouble(getElementText(itemsPrice).replace("Item total: $",""));
        double taxPrice = Double.parseDouble(getElementText(tax).replace("Tax: $",""));
        double sumPlusTax = Double.parseDouble(getElementText(totalPrice).replace("Total: $",""));

        if (firstSum==currentItemsSum && firstSum*1.1>=sumPlusTax && firstSum+taxPrice==sumPlusTax){
            return true;
        }
        else return false;

    }


    /*public void checkSum(){
        for (WebElement itemPrice:listOfProductPrices) {
            itemPrice.getAttribute("text"[2]).

        }
    }*/



}

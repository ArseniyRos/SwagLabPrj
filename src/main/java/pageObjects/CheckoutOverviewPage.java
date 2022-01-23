package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage extends BasePage{
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

    //Methods
    public void clickFinish(){
        clickElement(finishButton);
    }

    public void clickCancel(){
        clickElement(cancelButton);
    }

    /*public void checkSum(){
        for (WebElement itemPrice:listOfProductPrices) {
            itemPrice.getAttribute("text"[2]).

        }
    }*/



}

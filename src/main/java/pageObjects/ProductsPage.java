package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends CommonElements{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Elements

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

    @FindBy(css = "[class='product_sort_container']")
    WebElement productSortDrp;

    @FindBy(css = "[value='az']")
    WebElement sortAZ;

    @FindBy(css = "[value='za']")
    WebElement sortZA;

    @FindBy(css = "[value='lohi']")
    WebElement sortLoHi;

    @FindBy(css = "[value='hilo']")
    WebElement sortHiLo;


    //getters

    public List<WebElement> getListOfProductTitle() {
        return listOfProductTitle;
    }

    public List<WebElement> getListOfProductPrice() {
        return listOfProductPrice;
    }

    public List<WebElement> getListOfAddToCardButton() {
        return listOfAddToCardButton;
    }

    public List<WebElement> getListOfRemoveButton() {
        return listOfRemoveButton;
    }

    public List<WebElement> getListOfProductDescription() {
        return listOfProductDescription;
    }


    //Methods

    public void openProduct(String titleOfProductForChoose) {

        for (WebElement productTitle : listOfProductTitle) {
            if (productTitle.getText().equalsIgnoreCase(titleOfProductForChoose)) {
                productTitle.click();
                break;
            }
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
        //for (WebElement item : listOfItems) {
        //      String itemTitle = item.findElement(By.className("inventory_item_name")).getText();
        //if(itemTitle.equals(productTitle)){
        // clickElement(item.findElement(By.cssSelector("button)));
        //}
        //
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

    public void applyFilter_1AZ_2ZA_A3LoHi_4HiLo(int filterType) {
        switch (filterType){
            case 1:
                clickElement(productSortDrp);
                clickElement(sortAZ);
                break;
            case 2:
                clickElement(productSortDrp);
                clickElement(sortZA);
                break;
            case 3:
                clickElement(productSortDrp);
                clickElement(sortLoHi);
                break;
            case 4:
                clickElement(productSortDrp);
                clickElement(sortHiLo);
                break;

        }


    }




    //Methods
    /*public  boolean productsPageIsDisplayedByTitle(){
        return textIsCorrect(driver.findElement(title), "Products" );
    }

    public boolean productsPageIsDisplayedByUrl(String text){
        return urlIsCorrect(text);
    }*/
    //сначала разбил проверку на 2 метода, но потом подумал, что можно и объединить




}

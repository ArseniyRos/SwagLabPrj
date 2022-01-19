package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    By title = By.cssSelector("[class='header_secondary_container'] [class='title']");

    //Methods
    /*public  boolean productsPageIsDisplayedByTitle(){
        return textIsCorrect(driver.findElement(title), "Products" );
    }

    public boolean productsPageIsDisplayedByUrl(String text){
        return urlIsCorrect(text);
    }*/
    //сначала разбил проверку на 2 метода, но потом подумал, что можно и объединить

    public boolean redirectIsCorrect(String url, String correctTitle){
        System.out.println(driver.findElement(title).getText());
        System.out.println(driver.getCurrentUrl());
        if (textIsCorrect(driver.findElement(title), correctTitle ) && urlIsCorrect(url)) {
            return true;
        }
        else return false;
    }



}

package pageObjects;

import com.sun.org.apache.xpath.internal.axes.PredicatedNodeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    //Elements
    protected WebDriver driver;

    protected WebDriverWait wait;


    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }


    //Methods
    public void fillText(WebElement element, String text) {
                waitUntilElementIsVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        //Highlight
        waitUntilElementIsVisibleAndClickable(element);
        element.click();
    }

    public void waitUntilElementIsVisibleAndClickable(WebElement element) {
        wait.until((ExpectedConditions.visibilityOf(element)));
        wait.until((ExpectedConditions.elementToBeClickable(element)));
    }

    public void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public String getElementText(WebElement element) {
        waitUntilElementIsVisible(element);
        return element.getText();

    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean elementIsDisplayed(WebElement element) {
        waitUntilElementIsVisible(element);
        return element.isDisplayed();
    }

    public boolean textIsCorrect(WebElement element, String verificationText) {
        waitUntilElementIsVisible(element);
        return element.getText().contains(verificationText);
    }

    public boolean urlIsCorrect(String correctUrl) {
        if (correctUrl.equals(driver.getCurrentUrl())) {
            return true;
        } else return false;

    }

    public boolean checkRedirectViaDisplayingElementAndHisTitle(WebElement element, String titleForCheck){
        if (elementIsDisplayed(element) && textIsCorrect(element, titleForCheck) ){
            return true;
        } else return false;
    }
//возвращает индекс элемента в листе по его имени
    public int findElementInListOfThemOnAPage(List<WebElement> listOfElements , String titleForCheck){
        int numberOfElements = listOfElements.size();
        int j;
        for (int i = 0; i<numberOfElements; i++){
            if (elementIsDisplayed(listOfElements.get(i)) && textIsCorrect(listOfElements.get(i), titleForCheck)){
                System.out.println("index in list = "+ i);
                return i;
            }
        }
        return -5;
    }
/* public double priceOfProducts(){
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
    }*/

    public void tearDown() {
        driver.quit();
    }


}

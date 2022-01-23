package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    public void tearDown() {
        driver.quit();
    }


}

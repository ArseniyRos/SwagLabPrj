package tests.sanityTests;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Credentials;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.Urls;
import tests.BaseTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortingProducts extends BaseTest {
    @Severity(SeverityLevel.MINOR)
    @Description("Verify products sorting with different options(asc/desc price), asc/desc title")
    @Epic("Functional tests")
    @Feature("Feature: Sorting")
    @Story("Sorting products with different options")
    @Test(testName = "Verify products sorting")
    public void test_01() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillForm(Credentials.STANDARD_USER, Credentials.CORRECT_PASSWORD);

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.redirectIsCorrect(Urls.INVENTORY_URL, "PRODUCTS"));
        //SORTING PRICE LOW-HI
        // creating list of unsorted prices
        List<WebElement> pricesBeforeSorting = productsPage.getListOfProductPrice();
        List<Double> listOfPricesBeforeSorting = new ArrayList<>();
        //removing $ symbol from text and parsing string to list of double
        for (WebElement i : pricesBeforeSorting) {
            listOfPricesBeforeSorting.add(Double.parseDouble(i.getText().replace("$","")));
        }
        //make sorting
        productsPage.applyFilter_1AZ_2ZA_A3LoHi_4HiLo(3);
        //save list of sorted prices
        List<WebElement> pricesAfterSorting = productsPage.getListOfProductPrice();
        List<Double> listOfPricesAfterSorting = new ArrayList<>();
        //removing $ symbol from text and parsing string to list of double
        for (WebElement i : pricesAfterSorting) {
            listOfPricesAfterSorting.add(Double.parseDouble(i.getText().replace("$","")));
        }

        System.out.println(listOfPricesBeforeSorting);

        //compare two list, but before - sort unsorted list
        Collections.sort(listOfPricesBeforeSorting);

        System.out.println(listOfPricesBeforeSorting);
        System.out.println(listOfPricesAfterSorting);

        Assert.assertEquals(listOfPricesBeforeSorting, listOfPricesAfterSorting);

        //SORTING PRICE HI-LOW
        //clear lists after sorting
        pricesAfterSorting.clear();
        listOfPricesAfterSorting.clear();
        //apply Hi-Lo sorting and save price list again
        productsPage.applyFilter_1AZ_2ZA_A3LoHi_4HiLo(4);
        pricesAfterSorting = productsPage.getListOfProductPrice();
        //removing $ symbol from text and parsing string to list of double
        for (WebElement i : pricesAfterSorting) {
            listOfPricesAfterSorting.add(Double.parseDouble(i.getText().replace("$","")));
        }
        Collections.reverse(listOfPricesBeforeSorting);
        Assert.assertEquals(listOfPricesBeforeSorting, listOfPricesAfterSorting);

        //SORTING TITLE ASC ALPHABET
        //creating list of unsorted titles
        List<WebElement> titlesBeforeSorting = productsPage.getListOfProductTitle();
        List<String> listOfTitlesBeforeSorting = new ArrayList<>();
        for (WebElement i : titlesBeforeSorting) {
            listOfTitlesBeforeSorting.add(i.getText());
        }
        //make sorting
        productsPage.applyFilter_1AZ_2ZA_A3LoHi_4HiLo(1);
        //save list of sorted titles
        List<WebElement> titlesAfterSorting = productsPage.getListOfProductTitle();
        List<String> listOfTitlesAfterSorting = new ArrayList<>();
        for (WebElement i : titlesAfterSorting) {
            listOfTitlesAfterSorting.add(i.getText());
        }

        System.out.println(listOfTitlesBeforeSorting);

        //compare two list, but before - sort unsorted list
        Collections.sort(listOfTitlesBeforeSorting);

        System.out.println(listOfTitlesBeforeSorting);
        System.out.println(listOfTitlesAfterSorting);

        Assert.assertEquals(listOfTitlesBeforeSorting, listOfTitlesAfterSorting);

        //SORTING TITLE DESC ALPHABET
        //clear lists after sorting
        titlesAfterSorting.clear();
        listOfTitlesAfterSorting.clear();
        //apply desc alphabet sorting and save Title list again
        productsPage.applyFilter_1AZ_2ZA_A3LoHi_4HiLo(2);
        titlesAfterSorting = productsPage.getListOfProductTitle();

        for (WebElement i : titlesAfterSorting) {
            listOfTitlesAfterSorting.add(i.getText());
        }
        Collections.reverse(listOfTitlesBeforeSorting);
        Assert.assertEquals(listOfTitlesBeforeSorting, listOfTitlesAfterSorting);










    }
}

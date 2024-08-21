package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchedProductsPage
{

    //Variables
    private WebDriver driver;

    //Locators
    private By searchedProductText = By.xpath("//h2[text()='Searched Products']");


    //Constructor
    public SearchedProductsPage(WebDriver driver)
    {
        this.driver = driver;
    }


    ////////////////////Actions\\\\\\\\\\\\\\\\\\\\
    public boolean isSearchedProductDisplayed()
    {
        return driver.findElement(searchedProductText).isDisplayed();
    }
}

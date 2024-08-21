package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductQuantityPage
{

    //Variables
    private WebDriver driver;

    //Locators
    private By quantityField = By.id("quantity");
    private By addToCartButton = By.xpath("//button[@class='btn btn-default cart']");
    private By viewCartButton = By.xpath("//a[normalize-space()='View Cart']");

    //Constructor
    public ProductQuantityPage(WebDriver driver)
    {
        this.driver = driver;
    }


    ////////////////////Actions\\\\\\\\\\\\\\\\\\\\
    public void increaseProductQuantity(String quantity)
    {
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(quantity);
    }

    public void clickAddToCart()
    {
        driver.findElement(addToCartButton).click();
    }

    public CartPage clickViewCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement viewCart = driver.findElement(viewCartButton);
        wait.until(ExpectedConditions.elementToBeClickable(viewCart));
        viewCart.click();
        return new CartPage(driver);
    }
}

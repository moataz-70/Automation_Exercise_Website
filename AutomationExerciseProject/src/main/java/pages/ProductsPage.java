package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductsPage
{
    //Variables
    private WebDriver driver;

    //Locators
    private By searchProductField = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By productBox = By.className("product-image-wrapper");
    private By viewProductButton = By.linkText("/product_details/1");
    private By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    private By viewCartButton = By.xpath("//a[normalize-space()='View Cart']");
    private By closeAdsButton = By.id("dismiss-button");
    private By visibilityOfItem = By.xpath("//tr[@class='cart_menu']");
    private By getAddToCartButton(String itemName)
    {
        return By.xpath("//div[@class='overlay-content']//p[text()='" + itemName + "']//following-sibling::a[text()='Add to cart']");
    }

    //Constructor
    public ProductsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    ////////////////////Actions\\\\\\\\\\\\\\\\\\\\

    public ProductDetailPage clickViewProduct_FirstProduct()
    {
        driver.findElement(viewProductButton).click();
        return new ProductDetailPage(driver);
    }


    public SearchedProductsPage searchForProduct(String text)
    {
        driver.findElement(searchProductField).sendKeys(text);
        driver.findElement(searchButton).click();
        return new SearchedProductsPage(driver);
    }

    public void hoverOverProduct(int index)
    {
        WebElement product = driver.findElements(productBox).get(index-1);
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(product));
    }

    public void clickAddToCart(String itemName)
    {
        driver.findElement(getAddToCartButton(itemName)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
    }

    public void clickContinueShopping()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement continueShopping = driver.findElement(continueShoppingButton);
        wait.until(ExpectedConditions.visibilityOf(continueShopping));
        continueShopping.click();
    }

    public  CartPage clickViewCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement viewCart = driver.findElement(viewCartButton);
        wait.until(ExpectedConditions.elementToBeClickable(viewCart));
        viewCart.click();
        return new CartPage(driver);

    }

    public void closeAds()
    {
        driver.findElement(closeAdsButton).click();
    }


}

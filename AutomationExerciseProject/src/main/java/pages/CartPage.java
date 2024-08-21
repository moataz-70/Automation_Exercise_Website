package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage
{
    //Variables
    private WebDriver driver;

    //Locators
    private By item1 = By.xpath("//a[@href='/product_details/1']");
    private By item2 = By.xpath("//a[@href='/product_details/2']");
    private By itemPrice = By.xpath("//td[@class='cart_price']");
    private By itemQuantity = By.xpath("//td[@class='cart_quantity']");
    private By totalPrice = By.xpath("//p[@class='cart_total_price']");
    private By subscriptionText  = By.xpath("//h2[text()='Subscription']");
    private By subscriptionEmailField = By.xpath("//input[@id='susbscribe_email']");
    private By subscribeButton = By.id("subscribe");
    private By footer = By.id("footer");
    private By proceedToCheckoutButton = By.xpath("//a[text()='Proceed To Checkout']");
    //private By registerLoginButton = By.xpath("//p[text()='Register / Login account to proceed on checkout.'");
    private By registerLoginButton = By.xpath("//u[text()='Register / Login']");
    private By getItemInTheCart(String itemName)
    {
        return By.xpath("//div[@id='cart_info']//child::tbody//a[text()='" + itemName + "']");
    }
    private By removeProductButton(String productName)
    {
      return By.xpath("//h4[.='" + productName + "']//parent::td//parent::tr//a[@class='cart_quantity_delete']");
    }


    //Constructor
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }


    //////////////////// Actions \\\\\\\\\\\\\\\\\\\\
    public String getItem1Text()
    {
        return driver.findElement(item1).getText();
    }

    public String getItem2Text()
    {
        return driver.findElement(item2).getText();
    }

    public String isProductDisplayedInTheCart(String itemName)
    {
        WebElement itemInTheCart = driver.findElement(getItemInTheCart(itemName));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(itemInTheCart));
         return itemInTheCart.getText();
    }


    public String getItemPrice(int index)
    {
        WebElement price = driver.findElements(itemPrice).get(index-1);
        return price.getText();
    }

    public String getItemQuantity(int index)
    {
        WebElement quantity = driver.findElements(itemQuantity).get(index-1);
        return quantity.getText();
    }

    public String getTotalPrice(int index)
    {
        WebElement totalPrice = driver.findElements(this.totalPrice).get(index-1);
        return totalPrice.getText();
    }

    public void removeProduct(String productName)
    {
        driver.findElement(removeProductButton(productName)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(removeProductButton(productName)));
    }

    public Boolean isElementExist( String productName)
    {
        try
        {
            driver.findElement(removeProductButton(productName));
            return true;
        }

        catch (NoSuchElementException e)
        {
            return false;
        }

    }


    public boolean isSubscriptionTextDisplayed()
    {
        return driver.findElement(subscriptionText).isDisplayed();
    }

    public void enterSubscriptionEmail(String email)
    {
        driver.findElement(subscriptionEmailField).sendKeys(email);
        driver.findElement(subscribeButton).click();
    }

    public void scrollToFooter()
    {
        WebElement footer = driver.findElement(this.footer);
        String script = "arguments[0].scrollIntoView";
        ((JavascriptExecutor)driver).executeScript(script,footer);
    }

    public void whileRegister_ProceedToCheckout()
    {
        driver.findElement(proceedToCheckoutButton).click();
    }

    public CheckoutPage whileLoggedIn_ProceedToCheckout()
    {
        driver.findElement(proceedToCheckoutButton).click();
        return new CheckoutPage(driver);
    }


    public SignUp_LoginPage whileCheckout_clickRegisterLoginButton()
    {
        driver.findElement(registerLoginButton).click();
        return new SignUp_LoginPage(driver);
    }

}

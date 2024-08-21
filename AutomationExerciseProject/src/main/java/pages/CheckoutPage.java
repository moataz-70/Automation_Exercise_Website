package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage
{
    //Variables
    private WebDriver driver;

    //Locators
    private By commentField = By.className("form-control");
    private By placeOrderButton = By.linkText("payment");

    //Constructor
    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    ////////////////////Actions\\\\\\\\\\\\\\\\\\\\
    public void enterCommentAboutYourOrder(String comment)
    {
        driver.findElement(commentField).sendKeys(comment);
    }

    public PaymentPage clickPlaceOrderButton()
    {
        driver.findElement(placeOrderButton).click();
        return new PaymentPage(driver);
    }
}

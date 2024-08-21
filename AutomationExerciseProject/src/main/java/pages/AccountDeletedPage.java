package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage
{
    //Variables
    private WebDriver driver;

    //Locators
    private By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");
    private By continueButton = By.linkText("/");

    //Constructor
    public AccountDeletedPage(WebDriver driver)
    {
        this.driver = driver;
    }

    ////////////////////Actions\\\\\\\\\\\\\\\\\\\\
    public boolean isAccountDeletedTextVisible()
    {
        return driver.findElement(accountDeletedText).isDisplayed();
    }

    public HomePage clickContinueButton()
    {
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }


}

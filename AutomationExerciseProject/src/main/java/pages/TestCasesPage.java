package pages;

import org.openqa.selenium.WebDriver;

public class TestCasesPage
{
    //Variables
    private WebDriver driver;

    //Constructor
    public TestCasesPage(WebDriver driver)
    {
        this.driver = driver;
    }


    //////////////////////Actions\\\\\\\\\\\\\\\\\\\\
    public String getPageTitle()
    {
        return driver.getTitle();
    }
}

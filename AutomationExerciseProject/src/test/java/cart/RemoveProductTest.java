package cart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class RemoveProductTest extends BaseTest
{
    @Test
    public void verifyRemoveProductFromCart()
    {
        var productsPage = homePage.clickProducts();
        productsPage.hoverOverProduct(1);
        productsPage.clickAddToCart("Blue Top");
        productsPage.clickContinueShopping();
        productsPage.hoverOverProduct(8);
        productsPage.clickAddToCart("Fancy Green Top");

        var cartPage = productsPage.clickViewCart();
        cartPage.removeProduct("Fancy Green Top");
        boolean isItemExist = cartPage.isElementExist("Fancy Green Top");
        assertFalse(isItemExist, "Product still exist!");

    }










}

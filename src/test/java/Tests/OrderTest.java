package Tests;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    ItemPage itemPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    @BeforeClass
    public void preconditions()
    {
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        itemPage=new ItemPage(driver);
        cartPage =new CartPage(driver);
        checkoutPage=new CheckoutPage(driver);
    }
    //pass only at the first time after that it fail
    @Test
    public void ValidateMakeAnOrderWithASuccessfullPaymentatTheFirstTime() throws InterruptedException {
        loginPage.navigateToLoginPage();
        loginPage.Login("ahmed1517@gmail.com","Ahmed114477@@");
        homePage.NavigateToHomePage();
        homePage.selectMacBook();
        itemPage.enterQuantity("2");
        itemPage.addToCart();
        Thread.sleep(1000);
        itemPage.validateAddItemCart();
        itemPage.openCart();
        cartPage.validateCartPage();
        cartPage.checkOut();
        Thread.sleep(500);
        checkoutPage.writeMandatoryBellingDetail("Ahmed","Alaa","El mansoura","Al Qahirah","Egypt");
        checkoutPage.writeOptionalBellingDetail("valeo;","el senbellawein","6542");
        checkoutPage.submitBellingDetails();
        checkoutPage.continueCheckout();
        checkoutPage.validateCheckOutSuccessfully();
    }
    @Test
    public void ValidateMakeAnOrderWithASuccessfullPaymentWithPreviousDetails() throws InterruptedException{
        loginPage.navigateToLoginPage();
        loginPage.Login("ahmed1517@gmail.com","Ahmed114477@@");
        homePage.NavigateToHomePage();
        homePage.selectMacBook();
        itemPage.enterQuantity("2");
        itemPage.addToCart();
        Thread.sleep(1000);
        itemPage.validateAddItemCart();
        itemPage.openCart();
        cartPage.validateCartPage();
        cartPage.checkOut();
        Thread.sleep(500);
        checkoutPage.useTheSameDetails();
        checkoutPage.continueCheckout();
        checkoutPage.validateCheckOutSuccessfully();
    }

}

package Tests;

import Pages.AccoutPage;
import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ServicesTest extends TestBase{
    LoginPage loginPage;
    AccoutPage accoutPage;
    HomePage homePage;
    ContactUsPage contactUsPage;
    @BeforeClass
    public void preconditions()
    {
        loginPage=new LoginPage(driver);
        accoutPage=new AccoutPage(driver);
        homePage=new HomePage(driver);
        contactUsPage=new ContactUsPage(driver);
    }
    @Test
    public void validateContactCustomerService()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477");
        accoutPage.ValidateAccountPage();
        homePage.ClickOnContactUs();
        contactUsPage.WriteTheProblem("When I'm trying to add some items to cart,the item page open");
        contactUsPage.submitTheProblem();
        contactUsPage.validateSendingTheProblem();
    }

}

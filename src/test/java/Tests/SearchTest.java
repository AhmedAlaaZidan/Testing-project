package Tests;

import Pages.AccoutPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{
    LoginPage loginPage;
    AccoutPage accoutPage;
    @BeforeClass
    public void Preconditions()
    {
        loginPage=new LoginPage(driver);
        accoutPage=new AccoutPage(driver);
    }
    @Test
    public void searchForProductsSuccessfully()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        loginPage.Search("iphone");
    }

}

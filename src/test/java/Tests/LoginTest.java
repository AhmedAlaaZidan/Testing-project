package Tests;

import Pages.AccoutPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    LoginPage loginPage;
    AccoutPage accoutPage;
    @BeforeClass
    public void Preconditions()
    {
        loginPage=new LoginPage(driver);
        accoutPage=new AccoutPage(driver);
    }
    //pass
    @Test
    public void ValidateLoginWithValidCredentials()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaazidan@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
    }
    @Test
    //pass
    public void ValidateLoginWithInValidEmail()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaazidangmail.com","Ahmed114477@@");
        loginPage.validateNotLogin();
    }
    //pass
    @Test
    public void ValidateLoginWithInValidPassword()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaazidan@gmail.com","Ahmed114477@");
        loginPage.validateNotLogin();
    }


}

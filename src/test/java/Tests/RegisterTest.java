package Tests;

import Pages.AccoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    AccoutPage accoutPage;
    @BeforeClass
    public void preconditions()
    {
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        registerPage=new RegisterPage(driver);
        accoutPage=new AccoutPage(driver);
    }
    @Test
    public void ValidateRegisterWithValidCredentials()
    {
        homePage.NavigateToHomePage();
        homePage.ClickOnMyAccount();
        loginPage.ValidateNavigationToLoginPage();
        loginPage.ClickOnRegister();
        registerPage.CheckNavigationToRegisterPage();
        registerPage.Register("Ahmed","Alaa","alaazidan@gmail.com","01007927409","Ahmed114477@@","Ahmed114477@@");
        registerPage.ClickOnNoSuubscribe();
        registerPage.AgreeToThePolicy();
        registerPage.ClickOnContinueRegister();
        registerPage.ValidateRegisterSuccessfully();
        registerPage.ClickOnContinueToAccount();
        accoutPage.ValidateAccountPage();
    }
    @Test
    public void ValidateRegisterWithInvalidEmail()
    {
        homePage.NavigateToHomePage();
        homePage.ClickOnMyAccount();
        loginPage.ValidateNavigationToLoginPage();
        loginPage.ClickOnRegister();
        registerPage.CheckNavigationToRegisterPage();
        registerPage.Register("Ahmed","Alaa","alaa2405gmail.com","01007927409","Ahmed114477@@","Ahmed114477@@");
        registerPage.ClickOnNoSuubscribe();
        registerPage.AgreeToThePolicy();
        registerPage.ClickOnContinueRegister();
        registerPage.validateErrorInRegister();
    }
    @Test
    public void ValidateRegisterWithOutAgreeToThePolicy()
    {
        homePage.NavigateToHomePage();
        homePage.ClickOnMyAccount();
        loginPage.ValidateNavigationToLoginPage();
        loginPage.ClickOnRegister();
        registerPage.CheckNavigationToRegisterPage();
        registerPage.Register("Ahmed","Alaa","alaa2845@gmail.com","01007927409","Ahmed114477@@","Ahmed114477@@");
        registerPage.ClickOnNoSuubscribe();
        registerPage.ClickOnContinueRegister();
        registerPage.validateErrorInRegister();
    }
    @Test
    public void ValidateRegisterWithOutMatchingBetweenPasswords()
    {
        homePage.NavigateToHomePage();
        homePage.ClickOnMyAccount();
        loginPage.ValidateNavigationToLoginPage();
        loginPage.ClickOnRegister();
        registerPage.CheckNavigationToRegisterPage();
        registerPage.Register("Ahmed","Alaa","alaa245@gmail.com","01007927409","Ahmed114477@","Ahmed114477@@");
        registerPage.ClickOnNoSuubscribe();
        registerPage.AgreeToThePolicy();
        registerPage.ClickOnContinueRegister();
        registerPage.validateErrorInRegister();
    }
    @Test
    public void ValidateRegisterWithTelephoneNumberContainsTwoDigits()
    {
        homePage.NavigateToHomePage();
        homePage.ClickOnMyAccount();
        loginPage.ValidateNavigationToLoginPage();
        loginPage.ClickOnRegister();
        registerPage.CheckNavigationToRegisterPage();
        registerPage.Register("Ahmed","Alaa","alaa2405@gmail.com","21","Ahmed114477@@","Ahmed114477@@");
        registerPage.ClickOnNoSuubscribe();
        registerPage.AgreeToThePolicy();
        registerPage.ClickOnContinueRegister();
        registerPage.validateErrorInRegister();
    }

}

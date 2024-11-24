package Tests;

import Pages.AccoutPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditAcountTest extends TestBase{
    LoginPage loginPage;
    AccoutPage accoutPage;
    @BeforeClass
    public void preconditions()
    {
        loginPage=new LoginPage(driver);
        accoutPage=new AccoutPage(driver);
    }
    @Test
    public void validateEditInformationSuccessfully(){
        loginPage.navigateToLoginPage();
        loginPage.Login("alss459@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        accoutPage.editAccount("ahmed","alaa","alaa24549@gmail.com","01007927409");
        accoutPage.validateEditAccount();
    }
    @Test
    public void validateEditPasswordSuccessfully(){
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477@@");
        accoutPage.ValidateAccountPage();
        accoutPage.editPassword("114477","114477");
        accoutPage.validateEditPassword();
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477");
        accoutPage.ValidateAccountPage();
    }
    @Test
    public void validateNewsletterSubscriptionSuccessfully()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477");
        accoutPage.ValidateAccountPage();
        accoutPage.newsletterSubscription();
        accoutPage.validateNewsletterSubscription();
    }
}

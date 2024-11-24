package Tests;

import Pages.AccoutPage;
import Pages.AfiiliatePage;
import Pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AffiliateTest extends TestBase{
    AccoutPage accoutPage;
    LoginPage loginPage;
    AfiiliatePage afiiliatePage;
    @BeforeClass
    public void preconditions()
    {
        accoutPage=new AccoutPage(driver);
        loginPage=new LoginPage(driver);
        afiiliatePage=new AfiiliatePage(driver);
    }
    //pass
    @Test
    public void validateUserToCreateAffiliateAccountUsingChequeWithValidCredentialsSuccessfully()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("zidan@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        afiiliatePage.newAffiliate();
        afiiliatePage.AffiliateInformationUsingChecque("aaaa");
        afiiliatePage.validateCreateAffiliateAccount();
    }
    @Test
    public void validateUserToCreateAffiliateAccountUsingBankTransferWithValidCredentialsSuccessfully()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("al@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        afiiliatePage.newAffiliate();
        afiiliatePage.AffiliateInformationUsingBankTransfer("aaaa","45675");
        afiiliatePage.validateCreateAffiliateAccount();
    }
    //fail
    @Test
    public void validateUserToCreateAffiliateAccountUsingBankTransferWithInValidBankNumber()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaaaa@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        afiiliatePage.newAffiliate();
        afiiliatePage.AffiliateInformationUsingBankTransfer("aaaa","15622");
        afiiliatePage.validateNotCreateAffiliateAccount();
    }

    //pass
    @Test
    public void validateUserToCreateAffiliateAccountUsingPaypalWithValidCredentialsSuccessfully()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alla@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        afiiliatePage.newAffiliate();
        afiiliatePage.AffiliateInformationUsingPayPal("aalaa@24549gmail.com");
        afiiliatePage.validateCreateAffiliateAccount();
    }
    //pass
    @Test
    public void validateUserToCreateAffiliateAccountUsingPaypalWithInvalidEmail()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alla@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        afiiliatePage.newAffiliate();
        afiiliatePage.AffiliateInformationUsingPayPal("aalaa24549gmail.com");
        afiiliatePage.validateAppearWrongEmailMessage();
    }
    //pass
    @Test
    public void validateUserToCreateAffiliateAccountWithoutAgreeAboutOfUs()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("zidan@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        afiiliatePage.newAffiliate();
        afiiliatePage.AffiliateInformationUsingChecqueWithoutAgreeAboutOfUs("aaaa");
        afiiliatePage.validateAppearMessageAboutOfUsIsMandatory();
    }
    //pass
    @Test
    public void validateEditAffiliateInformation()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("zidan@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        afiiliatePage.editAffiliateInformation();
        afiiliatePage.validateOpenYourAffiliateInformation();
    }

}

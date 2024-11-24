package Tests;

import Pages.ForgottenPasswordPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends TestBase{
    ForgottenPasswordPage forgottenPasswordPage;
    @BeforeClass
    public void Preconditions()
    {
        forgottenPasswordPage=new ForgottenPasswordPage(driver);
    }
    @Test
    public void ValidateForgetPassFunctionality()
    {
        forgottenPasswordPage.NavigateToForgottenPasswordPage();
        forgottenPasswordPage.enterEmail("alaa24549@gmail.com");
        forgottenPasswordPage.CLickOnContinue();
        forgottenPasswordPage.ValidateConfirmationLinkSendSuccessfully();
    }
}

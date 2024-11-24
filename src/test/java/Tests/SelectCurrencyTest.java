package Tests;

import Pages.AccoutPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectCurrencyTest extends TestBase{
    LoginPage loginPage;
    AccoutPage accoutPage;
    @BeforeClass
    public void Preconditions()
    {
        loginPage=new LoginPage(driver);
        accoutPage=new AccoutPage(driver);
    }
    @Test
    public void ValidateSwitchBetweenCurrenciesSuccessfully() throws InterruptedException {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","Ahmed114477@@");
        accoutPage.ValidateAccountPage();
        accoutPage.selectEuro();
        accoutPage.validateEuro();
        accoutPage.selectDollar();
        accoutPage.selectDollar();
        accoutPage.selectPoundSterling();
        accoutPage.validatePoundSterling();
    }
}

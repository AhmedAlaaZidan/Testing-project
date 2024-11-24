package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ForgottenPasswordPage {
    WebDriver driver;
    public ForgottenPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void NavigateToForgottenPasswordPage()
    {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/forgotten");
    }
    public void enterEmail(String email)
    {
        driver.findElement(By.id("input-email")).sendKeys(email);
    }
    public void CLickOnContinue()
    {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    public void ValidateConfirmationLinkSendSuccessfully()
    {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText().contains("An email with a confirmation link has been sent your email address."));
    }

}

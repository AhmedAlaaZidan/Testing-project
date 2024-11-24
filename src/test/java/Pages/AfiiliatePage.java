package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AfiiliatePage {
    WebDriver driver;

    public AfiiliatePage(WebDriver driver) {
        this.driver = driver;
    }
    public void newAffiliate()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Register for an affiliate account')]")).click();
    }
    public void AffiliateInformationUsingChecque(String ChequePayeeName)
    {
        driver.findElement(By.xpath("//input[@id='input-cheque']")).sendKeys(ChequePayeeName);
        driver.findElement(By.xpath("//input[@value='cheque']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    public void AffiliateInformationUsingChecqueWithoutAgreeAboutOfUs(String ChequePayeeName)
    {
        driver.findElement(By.xpath("//input[@id='input-cheque']")).sendKeys(ChequePayeeName);
        driver.findElement(By.xpath("//input[@value='cheque']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }
    public void AffiliateInformationUsingPayPal(String PayPalEmail)
    {
        driver.findElement(By.xpath("//input[@value='paypal']")).click();
        driver.findElement(By.xpath("//input[@id='input-paypal']")).sendKeys(PayPalEmail);
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }
    public void AffiliateInformationUsingBankTransfer(String accountName,String accountNumber)
    {
        driver.findElement(By.xpath("//input[@value='bank']")).click();
        driver.findElement(By.xpath("//input[@id='input-bank-account-name']")).sendKeys(accountName);
        driver.findElement(By.xpath("//input[@id='input-bank-account-number']")).sendKeys(accountNumber);
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    public void validateNotCreateAffiliateAccount()
    {
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: Your account has been successfully updated."));
    }
    public void validateCreateAffiliateAccount()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: Your account has been successfully updated."));
    }
    public void validateAppearWrongEmailMessage()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='text-danger']")).getText().contains("PayPal Email Address does not appear to be valid!"));
    }
    public void validateAppearMessageAboutOfUsIsMandatory()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: You must agree to the About Us!"));
    }
    public void editAffiliateInformation()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Edit your affiliate information')]")).click();
    }
    public void validateOpenYourAffiliateInformation()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).getText().contains("Your Affiliate Information"));
    }
}

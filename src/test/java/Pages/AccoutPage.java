package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccoutPage {
    WebDriver driver;

    public AccoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ValidateAccountPage()
    {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/h2[1]")).getText().contains("My Account"));
    }

    public void selectPoundSterling()
    {
        driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
        driver.findElement(By.xpath("//button[@name='GBP']")).click();
    }
    public void validatePoundSterling()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='btn-group'] //button //strong")).getText().contains("£"));
    }

    public void selectEuro()
    {
        driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
        driver.findElement(By.xpath("//button[@name='EUR']")).click();
    }
    public void validateEuro()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='btn-group'] //button //strong")).getText().contains("€"));
    }

    public void selectDollar()
    {
        driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
        driver.findElement(By.xpath("//button[@name='USD']")).click();
    }
    public void validateDollar()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='btn-group'] //button //strong")).getText().contains("$"));
    }
    public void editAccount(String f_name,String l_name,String email,String telephone)
    {
        driver.findElement(By.xpath("//a[contains(text(),'Edit your account information')]")).click();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).clear();
        driver.findElement(By.xpath("//input[@id='input-lastname']")).clear();
        driver.findElement(By.xpath("//input[@id='input-email']")).clear();
        driver.findElement(By.xpath("//input[@id='input-telephone']")).clear();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(f_name);
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(l_name);
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephone);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    public void validateEditAccount()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: Your account has been successfully updated."));
    }
    public void editPassword(String newPass,String confirmPass)
    {
        driver.findElement(By.xpath("//a[contains(text(),'Change your password')]")).click();
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(newPass);
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(confirmPass);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    public void validateEditPassword() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: Your password has been successfully updated."));
        driver.findElement(By.xpath("//a[@class='list-group-item' and contains(text(),'Logout')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
    }
    public void newsletterSubscription()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Newsletter') and @class='list-group-item']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: Your newsletter subscription has been successfully updated!"));
    }
    public void validateNewsletterSubscription()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: Your newsletter subscription has been successfully updated!"));
    }
}

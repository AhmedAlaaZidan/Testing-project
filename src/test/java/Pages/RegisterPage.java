package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void CheckNavigationToRegisterPage()
    {
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=account/register");
    }

    public void ClickOnNoSuubscribe()
    {
        driver.findElement(By.xpath("//input[@value='0']")).click();
    }
    public void ClickOnSubscribe()
    {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/div/label[1]/input")).click();
    }
    public void AgreeToThePolicy()
    {
        driver.findElement(By.name("agree")).click();
    }
    public void ClickOnContinueRegister()
    {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }
    public void ValidateRegisterSuccessfully()
    {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/h1")).getText().contains("Your Account Has Been Created!"));
    }
    public void validateErrorInRegister()
    {
        Assert.assertFalse(driver.findElement(By.xpath("/html/body/div[2]/div/div/h1")).getText().contains("Your Account Has Been Created!"));
    }
    public void ClickOnContinueToAccount()
    {
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    }

    public void Register(String f_name,String l_name,String email,String telephone,String pass,String c_pass)
    {
        driver.findElement(By.id("input-firstname")).sendKeys(f_name);
        driver.findElement(By.id("input-lastname")).sendKeys(l_name);
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
        driver.findElement(By.id("input-password")).sendKeys(pass);
        driver.findElement(By.id("input-confirm")).sendKeys(c_pass);
    }





}

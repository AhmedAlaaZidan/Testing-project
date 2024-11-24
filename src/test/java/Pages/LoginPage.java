package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToLoginPage()
    {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
    }
    public void ValidateNavigationToLoginPage()
    {
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=account/login");
    }

    public void ClickOnRegister()
    {
        driver.findElement(By.xpath("/html/body/div[2]/div/aside/div/a[2]")).click();
    }

    public void Login(String email,String pass)
    {
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
    }
    public void Search(String product)
    {
        driver.findElement(By.name("search")).sendKeys(product);
        driver.findElement(By.name("search")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/h1")).getText().contains("Search -"));
    }
    public  void validateNotLogin()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password"));
    }
}

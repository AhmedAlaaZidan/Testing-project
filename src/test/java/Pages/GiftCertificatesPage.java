package Pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GiftCertificatesPage {
    WebDriver driver;

    public GiftCertificatesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void purchaseAGiftCertificate(String Recipient_Name,String Recipient_email,String user_name,String user_email,String message,String amount)
    {
        driver.findElement(By.xpath("//input[@id='input-to-name']")).sendKeys(Recipient_Name);
        driver.findElement(By.xpath("//input[@id='input-to-email']")).sendKeys(Recipient_email);
        driver.findElement(By.xpath("//input[@id='input-from-name']")).clear();
        driver.findElement(By.xpath("//input[@id='input-from-email']")).clear();
        driver.findElement(By.xpath("//input[@id='input-from-name']")).sendKeys(user_name);
        driver.findElement(By.xpath("//input[@id='input-from-email']")).sendKeys(user_email);
        driver.findElement(By.xpath("//input[@value='7']")).click();
        driver.findElement(By.xpath("//textarea[@id='input-message']")).sendKeys(message);
        driver.findElement(By.xpath("//input[@id='input-amount']")).sendKeys(amount);
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }
    public void valedatepurchaseAGiftCertificate()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//p")).getText().contains("Thank you for purchasing a gift certificate!"));
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
    }
    public void valedateNotpurchaseAGiftCertificate()
    {
        Assert.assertFalse(driver.findElement(By.xpath("//div[@id='content']//p")).getText().contains("Thank you for purchasing a gift certificate!"));
    }

}

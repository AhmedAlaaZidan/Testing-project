package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void WriteTheProblem(String problem)
    {
        driver.findElement(By.xpath("//textarea[@id='input-enquiry']")).sendKeys(problem);
    }
    public void submitTheProblem()
    {
        driver.findElement(By.xpath("//div[@class='pull-right']//input")).click();
    }
    public void validateSendingTheProblem()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']")).getText().contains("Your enquiry has been successfully sent to the store owner!"));
    }
}

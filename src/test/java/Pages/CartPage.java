package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void validateCartPage()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).getText().contains("Shopping Cart"));
    }
    public  void checkOut()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
    }
}

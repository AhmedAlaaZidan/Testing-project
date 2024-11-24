package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductComparisonPage {
    WebDriver driver;

    public ProductComparisonPage(WebDriver driver) {
        this.driver = driver;
    }
    public void validateComparisonBetweenIphoneAndMacBook()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//img[@title='iPhone']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//img[@title='MacBook']")).isDisplayed());
    }

}

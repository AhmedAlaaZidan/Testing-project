package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrandsPage {
    WebDriver driver;

    public BrandsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void validateOpenBrandsPage()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']")).getText().contains("Find Your Favorite Brand"));
    }
    public void openAppleBrand()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Apple')]")).click();
    }
}

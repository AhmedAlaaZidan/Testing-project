package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ItemPage {
    WebDriver driver;

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterQuantity(String quantity)
    {
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys(quantity);
    }
    public void addToCart()
    {
        driver.findElement(By.id("button-cart")).click();
    }
    public void validateAddItemCart()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: You have added"));
    }
    public void openCart()
    {
        driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
        driver.findElement(By.xpath("//strong//i[@class='fa fa-shopping-cart']")).click();
    }
    public void validateOpenApplePage()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h2")).getText().contains("Apple"));
    }
    public void openReviews()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Reviews (0)')]")).click();
    }
    public void makeAReview(String name,String Review,int rate)
    {
        driver.findElement(By.xpath("//input[@id='input-name']")).sendKeys(name);
        driver.findElement(By.xpath("//textarea[@id='input-review']")).sendKeys(Review);
        switch (rate)
        {
            case 1 : driver.findElement(By.xpath("//input[@value='1']")).click();
                break;
            case 2 : driver.findElement(By.xpath("//input[@value='2']")).click();
                break;
            case 3  : driver.findElement(By.xpath("//input[@value='3']")).click();
                break;
            case 4 : driver.findElement(By.xpath("//input[@value='4']")).click();
                break;
            case 5 : driver.findElement(By.xpath("//input[@value='5']")).click();
                break;
        }
        driver.findElement(By.xpath("//button[@id='button-review']")).click();
    }
    public void validateSubmitOfTheReview() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Thank you for your review. It has been submitted to the webmaster for approval."));
    }
    public void validateFailSubmittingTheReview() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Thank you for your review. It has been submitted to the webmaster for approval."));
    }
}

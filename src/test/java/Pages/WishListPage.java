package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WishListPage {
    WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }
     public void openWishList()
     {
         driver.findElement(By.id("wishlist-total")).click();
     }
     public void removeItemFromWishList()
     {
         driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/table/tbody/tr[1]/td[6]/a")).click();
     }
     public void validateRemoveItemFromWishList()
     {
         Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: You have modified your wish list!"));
         Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//p")).getText().contains("Your wish list is empty."));
     }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.security.Key;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void NavigateToHomePage()
    {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    public void ClickOnMyAccount()
    {
        driver.findElement(By.xpath("/html/body/footer/div/div/div[4]/ul/li[1]/a")).click();
    }

    public void CheckLoginPage()
    {
        Assert.assertEquals(driver.getCurrentUrl(),"https://awesomeqa.com/ui/index.php?route=account/login");
    }
    //hover
    public void hoverDesktopsAndChooseMac()
    {
        Actions act =new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Desktops')]"))).build().perform();
        driver.findElement(By.xpath("//a[contains(text(),'Mac')]")).click();
    }
    public void validateOpenMacPage()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h2")).getText().contains("Mac"));
    }
    public void hoverComponentsAndChooseMonitors()
    {
        Actions act =new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Components')]"))).build().perform();
        driver.findElement(By.xpath("//a[contains(text(),'Monitors')]")).click();
    }
    public void validateOpenMonitorsPage()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h2")).getText().contains("Monitors"));
    }

    public void hoverMP3PlayersAndChooseTest20()
    {
        Actions act =new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'MP3 Players')]"))).build().perform();
        driver.findElement(By.xpath("//a[contains(text(),'test 20')]")).click();
    }
    public void validateOpenTest20Page()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h2")).getText().contains("test 20"));
    }

    //select Categories
    public void SelectSoftwareCategory()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Software')]")).click();
    }
    public void ValidateOpenSoftwareCategoryPAge()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h2")).getText().contains("Software"));
    }

    public void SelectPhonesAndPDAsCategory()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Phones & PDAs')]")).click();
    }
    public void ValidateOpenPhonesAndPDAsCategoryPAge()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h2")).getText().contains("Phones & PDAs"));
    }

    public void SelectCamerasCategory()
    {
        driver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul/li[7]/a")).click();
    }
    public void ValidateOpenCamerasCategoryPAge()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h2")).getText().contains("Cameras"));
    }
    //add items to cart
    public void AddMacBookToCart()
    {
        driver.findElement(By.xpath("//button[@onclick=\"cart.add('43');\"]")).click();
    }

    public void AddAppleCinema30ToCart()
    {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[3]/div/div[3]/button[1]")).click();
    }
    public void validateAddItemCart()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: You have added"));
    }
    //add items to wish list
    public void addMacBookTOWishList()
    {
        driver.findElement(By.xpath("//button[@data-toggle='tooltip' and @onclick=\"wishlist.add('43');\"]")).click();
    }
    public void validateNotAddingItemToWishList()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("You must"));
        driver.findElement(By.xpath("//button[@class='close']")).click();
    }
    public void AddAppleCinema30ToWishList()
    {
        driver.findElement(By.xpath("//button[@data-toggle='tooltip' and @onclick=\"wishlist.add('42');\"]")).click();
    }
    public void validateAddingItemToWishList()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: You have added"));
        driver.findElement(By.xpath("//button[@class='close']")).click();
    }
    //add items to compare list
    public  void  addMacBookToCompareList()
    {
        driver.findElement(By.xpath("//button[@data-toggle='tooltip' and @onclick=\"compare.add('43');\"]")).click();
    }
    public  void  addIphoneToCompareList()
    {
        driver.findElement(By.xpath("//button[@data-toggle='tooltip' and @onclick=\"compare.add('40');\"]")).click();
    }
    public void validateAddItemToCompareList()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: You have"));
        driver.findElement(By.xpath("//button[@class='close']")).click();
    }
    public void validateNotAddItemToCompareList()
    {
        Assert.assertFalse(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().contains("Success: You have"));
    }
    public void selectMacBook()
    {
        driver.findElement(By.xpath("//img[@title='MacBook' and @class=\"img-responsive\"]")).click();
    }
    public void ClickOnContactUs()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]")).click();
    }
    public void clickOnBrands()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Brands')]")).click();
    }
    public void openCompareList() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'product comparison')]")).click();
    }
    public void openGiftCertificatesPage()
    {
        driver.findElement(By.xpath("//a[contains(text(),'Gift Certificates')]")).click();
    }
}


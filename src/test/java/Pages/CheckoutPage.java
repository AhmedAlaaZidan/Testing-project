package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void writeMandatoryBellingDetail(String f_name,String l_name,String address1,String city,String country) throws InterruptedException {
        driver.findElement(By.id("input-payment-firstname")).sendKeys(f_name);
        driver.findElement(By.id("input-payment-lastname")).sendKeys(l_name);

        driver.findElement(By.id("input-payment-address-1")).sendKeys(address1);

        driver.findElement(By.id("input-payment-city")).sendKeys(city);
        Select sel=new Select(driver.findElement(By.xpath("//select[@name='country_id']")));
        sel.selectByVisibleText(country);
        Thread.sleep(500);
        Select select=new Select(driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
        select.selectByVisibleText(city);
    }
    public void useTheSameDetails()
    {
        //driver.findElement(By.xpath("//input[@value=\"new\"]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div/form/div[5]/div/input")).click();
    }
    public void writeOptionalBellingDetail(String company,String address2,String postcode)
    {
        driver.findElement(By.id("input-payment-company")).sendKeys(company);
        driver.findElement(By.id("input-payment-address-2")).sendKeys(address2);
        driver.findElement(By.id("input-payment-postcode")).sendKeys(postcode);
    }
    public void submitBellingDetails() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

    }
    public void continueCheckout() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div/form/div[5]/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[4]/div[2]/div/div[2]/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[5]/div[2]/div/div[2]/div/input[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[6]/div[2]/div/div[2]/div/input")).click();

    }
    public void validateCheckOutSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h1")).getText().contains("Your order has been placed!"));
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/a")).click();
    }
}

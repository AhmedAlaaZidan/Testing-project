package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    WebDriver driver;
    @BeforeClass
    public void OpenBrowser()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void CloseBrowser()
    {
       // driver.quit();
    }
}

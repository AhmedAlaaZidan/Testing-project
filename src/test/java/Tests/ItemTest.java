package Tests;

import Pages.*;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ItemTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    AccoutPage accoutPage;
    WishListPage wishListPage;
    BrandsPage brandsPage;
    ItemPage itemPage;
    ProductComparisonPage productComparisonPage;
    GiftCertificatesPage giftCertificatesPage;
    @BeforeClass
    public void preconditions()
    {
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        accoutPage=new AccoutPage(driver);
        wishListPage=new WishListPage(driver);
        brandsPage=new BrandsPage(driver);
        itemPage=new ItemPage(driver);
        productComparisonPage=new ProductComparisonPage(driver);
        giftCertificatesPage=new GiftCertificatesPage(driver);
    }

    @Test
    public void ValidateHoverMainAndSubCategoriesRandomly()
    {
        homePage.NavigateToHomePage();
        homePage.hoverDesktopsAndChooseMac();
        homePage.validateOpenMacPage();
        homePage.hoverComponentsAndChooseMonitors();
        homePage.validateOpenMonitorsPage();
        homePage.hoverMP3PlayersAndChooseTest20();
        homePage.validateOpenTest20Page();
    }

    @Test
    public void ValidateSelectMainAndSubCategoriesRandomly()
    {
        homePage.NavigateToHomePage();
        homePage.SelectCamerasCategory();
        homePage.ValidateOpenCamerasCategoryPAge();
        homePage.SelectSoftwareCategory();
        homePage.ValidateOpenSoftwareCategoryPAge();
        homePage.SelectPhonesAndPDAsCategory();
        homePage.ValidateOpenPhonesAndPDAsCategoryPAge();
    }
    //fail
    @Test
    public void ValidateAddItemsToCart() throws InterruptedException {
        homePage.NavigateToHomePage();
        homePage.AddMacBookToCart();
        Thread.sleep(500);
        homePage.validateAddItemCart();
        homePage.AddAppleCinema30ToCart();
        Thread.sleep(500);
        homePage.validateAddItemCart();

    }
    @Test
    public void ValidateAddItemsToWishlListWithOutLogin() throws InterruptedException {
        homePage.NavigateToHomePage();
        homePage.addMacBookTOWishList();
        Thread.sleep(500);
        homePage.validateNotAddingItemToWishList();
        homePage.AddAppleCinema30ToWishList();
        Thread.sleep(500);
        homePage.validateNotAddingItemToWishList();
    }
    @Test
    public void ValidateAddItemsToWishlListAfterLogin() throws InterruptedException {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","Ahmed114477@@");
        homePage.NavigateToHomePage();
        homePage.addMacBookTOWishList();
        Thread.sleep(500);
        homePage.validateAddingItemToWishList();
    }
    //Fail
    @Test
    public void ValidateAddItemsToCompareListWithOutLogin() throws InterruptedException {
        homePage.NavigateToHomePage();
        homePage.addMacBookToCompareList();
        Thread.sleep(500);
        homePage.validateNotAddingItemToWishList();
        homePage.addIphoneToCompareList();
        Thread.sleep(500);
        homePage.validateNotAddItemToCompareList();
    }
    @Test
    public void ValidateAddItemsToCompareListWithLogin() throws InterruptedException {
        homePage.NavigateToHomePage();
        homePage.addMacBookToCompareList();
        Thread.sleep(500);
        homePage.validateAddItemToCompareList();
        homePage.addIphoneToCompareList();
        Thread.sleep(500);
        homePage.validateAddItemToCompareList();
    }
    @Test
    public void validateRemoveItemFromWishList()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477");
        accoutPage.ValidateAccountPage();
        homePage.NavigateToHomePage();
        homePage.addMacBookTOWishList();
        wishListPage.openWishList();
        wishListPage.removeItemFromWishList();
        wishListPage.validateRemoveItemFromWishList();
    }
    @Test
    public void validateOpenBrands()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477");
        accoutPage.ValidateAccountPage();
        homePage.NavigateToHomePage();
        homePage.clickOnBrands();
        brandsPage.validateOpenBrandsPage();
        brandsPage.openAppleBrand();
        itemPage.validateOpenApplePage();
    }
    @Test
    public void validateProductComparison() throws InterruptedException {
        homePage.NavigateToHomePage();
        homePage.addIphoneToCompareList();
        homePage.addMacBookToCompareList();
        homePage.openCompareList();
        productComparisonPage.validateComparisonBetweenIphoneAndMacBook();
    }
    //fail
    @Test
    public void validatePurchaseAGiftCertificateWithWrongUserEmail()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477");
        accoutPage.ValidateAccountPage();
        homePage.openGiftCertificatesPage();
        giftCertificatesPage.purchaseAGiftCertificate("alaa","546@gmail.com","Ahmed alaa","alaa24549@gmail.com","Happy birthday","1");
        giftCertificatesPage.valedateNotpurchaseAGiftCertificate();
    }
    @Test
    public void validatePurchaseAGiftCertificateWithWrongUserName()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477");
        accoutPage.ValidateAccountPage();
        homePage.openGiftCertificatesPage();
        giftCertificatesPage.purchaseAGiftCertificate("alaa","alaa24549@gmail.com","Ali alaa","alaa24549@gmail.com","Happy birthday","1");
        giftCertificatesPage.valedateNotpurchaseAGiftCertificate();
    }
    @Test
    public void validatePurchaseAGiftCertificateWithValidCredentials()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477");
        accoutPage.ValidateAccountPage();
        homePage.openGiftCertificatesPage();
        giftCertificatesPage.purchaseAGiftCertificate("alaa","alaa2546@gmail.com","ahmed alaa","alaa24549@gmail.com","Happy birthday","1");
        giftCertificatesPage.valedatepurchaseAGiftCertificate();
    }
    @Test
    public void validatePurchaseAGiftCertificateUsingCharacterInAmount()
    {
        loginPage.navigateToLoginPage();
        loginPage.Login("alaa24549@gmail.com","114477");
        accoutPage.ValidateAccountPage();
        homePage.openGiftCertificatesPage();
        giftCertificatesPage.purchaseAGiftCertificate("alaa","546@gmail.com","Ahmed alaa","alaa24549@gmail.com","Happy birthday","x");
        giftCertificatesPage.valedateNotpurchaseAGiftCertificate();
    }
    @Test
    public void validatewriteAReviewAboutItemsWithLogin() throws InterruptedException {
        homePage.NavigateToHomePage();
        homePage.selectMacBook();
        itemPage.openReviews();
        itemPage.makeAReview("Ahmed Alaa","it's easy to use, portable and i recommend it ",5);
        itemPage.validateSubmitOfTheReview();
    }
    //fail
    @Test
    public void validatewriteAReviewAboutItemsWithOutLogin() throws InterruptedException {
        homePage.NavigateToHomePage();
        homePage.selectMacBook();
        itemPage.openReviews();
        itemPage.makeAReview("Ahmed Alaa","it's easy to use, portable and i recommend it ",5);
        itemPage.validateFailSubmittingTheReview();
    }



}

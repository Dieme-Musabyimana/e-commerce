package context;

import org.openqa.selenium.WebDriver;
import pages.minPages.*;

public class TestContext {
    public WebDriver driver;

    // 2. The Pages (Initialized lazily)
    private AccountPage accountPage;
    private StorePage storePage;
    private CartPage cartPage;
    private ProductPage productPage;
    private HomePage homePage;
    private CheckOutPage checkOutPage;

    public AccountPage getAccountPage() {
        if (accountPage == null) {
            accountPage = new AccountPage(driver);
        }
        return accountPage;
    }

    public StorePage getStorePage() {
        if (storePage == null) {
            storePage = new StorePage(driver);
        }
        return storePage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public ProductPage getProductPage(){
        if(productPage == null){
            productPage = new ProductPage(driver);
        }
        return productPage;
    }
    public HomePage getHomePage(){
        if(homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }
    public CheckOutPage getCheckOutPage(){
        if(checkOutPage == null){
            homePage = new HomePage(driver);
        }
        return checkOutPage;
    }

}

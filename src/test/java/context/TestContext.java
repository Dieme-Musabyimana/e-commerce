package context;

import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.CartPage;

public class TestContext {
    public WebDriver driver;

    // 2. The Pages (Initialized lazily)
    private AccountPage accountPage;
    private CartPage cartPage;

    public AccountPage getAccountPage() {
        if (accountPage == null) {
            accountPage = new AccountPage(driver);
        }
        return accountPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }
}

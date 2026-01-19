package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void load(String url) {
        driver.get(url);
    }

    public void addProductFromProductPageToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart"))).click();
    }

    public void viewCartFromProductPage() {
        String selector = "div[role='alert'] a[class='button wc-forward']";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector))).click();
    }
}




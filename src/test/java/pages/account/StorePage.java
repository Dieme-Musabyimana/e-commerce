package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.IExpectedExceptionsHolder;
import pages.base.BasePage;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver){
        super(driver);
    }
    public void load(String url) {
        driver.get(url);
    }
    public void addProductToCart(String productName){
        String selector = "a[aria-label='Add “" + productName + "” to your cart']";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector))).click();
    }

    public  void viewCartFromStorePage() {
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='View cart']")));
        viewCart.click();

    }



    public void gotToProductPage(String productName){

        String urlSlug = productName.toLowerCase().replace(" ", "-");
        String selector = String.format("a[href*='product/%s']", urlSlug);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector))).click();
    }


    public String selectCategory(String categoryName) {

        wait.until(ExpectedConditions.elementToBeClickable(By.id("product_cat"))).click();
        String selector = "//option[contains(text(), '" + categoryName + "')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector))).click();
        return driver.getTitle();

    }
    public ProductPage goToProductPage(String productPageName){
        String selector = "//h2[normalize-space()='" + productPageName + "']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selector))).click();
        return new ProductPage(driver);
    }
}

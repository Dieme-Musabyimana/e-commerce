package pages.minPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class StorePage extends BasePage {
    @FindBy(id = "min_price") private WebElement minPriceInput;
    @FindBy(id = "max_price") private WebElement maxPriceInput;
    @FindBy(css = ".price_slider_amount button.button") private WebElement filterButton;
    @FindBy(css = ".woocommerce-Price-amount bdi") private List<WebElement> productPrices;
    @FindBy(id = "woocommerce_price_filter-3") private WebElement filterWidget;

    public StorePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void load(String url) {
        driver.get(url);
    }
    public void addProductToCart(String productName){
        String selector = "a[aria-label*='" + productName + "']";
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

//    public void filterByPrice(double minPrice, double maxPrice) {
//        List<WebElement> oldProducts = driver.findElements(By.cssSelector(".product"));
//
//        WebElement leftHandle = driver.findElement(By.cssSelector(".ui-slider-handle:nth-of-type(1)"));
//        WebElement rightHandle = driver.findElement(By.cssSelector(".ui-slider-handle:nth-of-type(2)"));
//        WebElement sliderBar = driver.findElement(By.cssSelector(".price_slider"));
//
//        int totalWidth = sliderBar.getSize().getWidth();
//
//        Actions action = new Actions(driver);
//        action.dragAndDropBy(leftHandle, -totalWidth, 0).build().perform(); // Reset to 0
//
//
//        int leftOffset = (int) ((minPrice / 150) * totalWidth);
//        action.dragAndDropBy(leftHandle, leftOffset, 0).build().perform();
//
//        action.dragAndDropBy(rightHandle, totalWidth, 0).build().perform(); // Reset to far right
//        int rightOffset = (int) (((maxPrice - 150) / 150) * totalWidth);
//        action.dragAndDropBy(rightHandle, rightOffset, 0).build().perform();
//
//        wait.until(ExpectedConditions.elementToBeClickable(filterButton)).click();
//
//        if (!oldProducts.isEmpty()) {
//            wait.until(ExpectedConditions.stalenessOf(oldProducts.get(0)));
//        }
//    }
}

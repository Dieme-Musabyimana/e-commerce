package pages.minPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getAddedProductName(String productName){
        String selector = "//a[normalize-space()='" + productName + "']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector))).getText();
    }
    public int getAddedProductQuantity(int productQuantity){

        WebElement quantityFld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td.product-quantity input.qty")));
        return Integer.parseInt( quantityFld.getAttribute("value"));
    }
public void removeProductFromCart(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" a[aria-label='Remove this item']"))).click();

}
public String getProductRemovalSuccessAlert(String productName){
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[normalize-space()='" + productName + "']")));

    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message"))).getText();
}
public int getProductQuantityAfterRemove(){

    String quantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.count"))).getText();
    return Integer.parseInt(quantity.trim());
}

public void proceedToCheckout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".checkout-button.button.alt.wc-forward"))).click();
}

}
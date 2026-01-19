package pages.account;

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


}
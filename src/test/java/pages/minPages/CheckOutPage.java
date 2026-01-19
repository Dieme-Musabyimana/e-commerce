package pages.minPages;

import context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import pages.base.BasePage;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    public void enterOrderDetails(){

    }

    public void placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();

    }

}

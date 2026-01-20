package pages.minPages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.Map;

public class CheckOutPage extends BasePage {

    // 1. Define WebElements using @FindBy
    @FindBy(id = "billing_first_name") private WebElement fNameField;
    @FindBy(id = "billing_last_name") private WebElement lNameField;
    @FindBy(id = "billing_country") private WebElement countryDropdown;
    @FindBy(id = "billing_address_1") private WebElement streetAddressField;
    @FindBy(id = "billing_city") private WebElement townField;
    @FindBy(id = "billing_state") private WebElement stateDropdown;
    @FindBy(id = "billing_postcode") private WebElement zipCodeField;
    @FindBy(id = "billing_phone") private WebElement phoneNumField;
    @FindBy(id = "billing_email") private WebElement emailField;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;

    public CheckOutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterOrderDetails(DataTable dataTable){
        Map<String, String> details = dataTable.asMap(String.class, String.class);

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", fNameField);

        fNameField.sendKeys(details.get("firstName"));
        lNameField.sendKeys(details.get("lastName"));

        new Select(countryDropdown).selectByValue(details.get("country"));
        streetAddressField.sendKeys(details.get("streetAddress"));
        townField.sendKeys(details.get("town"));

        new Select(stateDropdown).selectByValue(details.get("state"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({block:'center'});", zipCodeField);
        zipCodeField.sendKeys(details.get("postCode"));
        phoneNumField.sendKeys(details.get("phone"));
        emailField.sendKeys(details.get("email"));
    }

    public void placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public void selectPaymentMethod(String pMethodName) {
        By locator = By.xpath("//ul[contains(@class,'payment_methods')]//label[contains(text(),'" + pMethodName + "')]");
        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", label);
        label.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockOverlay")));
    }
public String verifyAlertOrderAlert(){

        By statusMessage = By.cssSelector(".woocommerce-order p");
      return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-order p"))).getText();

    }
}
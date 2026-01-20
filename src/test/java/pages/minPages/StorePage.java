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

    }


package pages.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

import static java.awt.SystemColor.menu;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }
    public void load(String url) {
        driver.get(url);
}

public void navigateToMenu(String menu){
        String selector = menu;
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(selector))).click();
}
    public String getPageTitle(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        return driver.getTitle();
    }
}




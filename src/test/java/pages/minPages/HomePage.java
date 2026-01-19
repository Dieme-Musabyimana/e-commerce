package pages.minPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

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




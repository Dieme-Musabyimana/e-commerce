package pages.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver driverInitializer() {
        // If you want offline, use your local ChromeDriver path:
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");

        // Create Chrome instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}

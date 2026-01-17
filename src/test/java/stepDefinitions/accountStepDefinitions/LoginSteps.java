package stepDefinitions.accountStepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class logingSteps {

    private By usernameLoginField = By.id("username");
    private By passwordLoginField = By.id("password");
    private By loginButton = By.name("login");
    private By dashboard = By.linkText("Dashboard");
    private By errorMessage = By.cssSelector(".woocommerce-error");
    private By account = By.linkText("Account");


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Hooks.driver.get("https://askomdch.com/");
        Hooks.driver.findElement(account).click();
    }

    @When("I enter credentials {string} {string}")
    public void i_enter_credentials(String username, String password) {
        Hooks.driver.findElement(usernameLoginField).sendKeys(username);
        Hooks.driver.findElement(passwordLoginField).sendKeys(password);
    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        Hooks.driver.findElement(loginButton).click();
    }

    @Then("I should see the dashboard page")
    public void i_should_see_the_dashboard_page() {
        String dashboardText = Hooks.driver.findElement(dashboard).getText();
        Assert.assertEquals("Dashboard", dashboardText);
    }

    @Then("I should see {string} message")
    public void i_should_see_message(String error) {
        String alertMessage = Hooks.driver.findElement(errorMessage).getText();
        // Trim spaces from feature file input to avoid mismatch
        Assert.assertTrue(alertMessage.contains(error.trim()));
    }
}

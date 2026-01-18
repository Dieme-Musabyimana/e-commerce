package stepDefinitions.accountStepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BaseSteps {
    private final TestContext context;

    public BaseSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am on the account page")
    public void i_am_on_the_account_page() {
        context.getAccountPage().load("https://askomdch.com/account/");
    }

    @Then("I should see an {string} message")
    public void i_should_see_an_error_message(String expectedError) {
        String actualError = context.getAccountPage().getErrorMessage();
        Assert.assertTrue(actualError.contains(expectedError));
    }

    @Then("I should be taken to the dashboard page")
    public void i_should_be_taken_to_the_dashboard_page() {
        String dashboardText = context.getAccountPage().getDashboardText();
        Assert.assertTrue(dashboardText.toLowerCase().contains("dashboard"));
    }
}

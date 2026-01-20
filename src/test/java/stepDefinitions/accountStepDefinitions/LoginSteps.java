package stepDefinitions.accountStepDefinitions;

import context.TestContext;
import io.cucumber.java.en.When;
import pages.minPages.AccountPage;

public class LoginSteps {
    AccountPage accountPage;
    private final TestContext context;
    public LoginSteps(TestContext context){
        this.context = context;

    }

// TODO: implement login validation

    @When("I enter credentials {string} {string}")
    public void i_enter_credentials(String username, String password) {
        context.getAccountPage().enterLoginCredentials(username, password);
    }

    @When("I click on login button")
    public void i_click_on_login_button() {
context.getAccountPage().clickLoginButton();
    }

}

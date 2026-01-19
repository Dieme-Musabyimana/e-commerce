package stepDefinitions.accountStepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.minPages.AccountPage;


public class registerSteps {
    private final TestContext context;
    AccountPage accountPage;
    public registerSteps(TestContext context) {
        this.context = context;
    }
        @Given("I am on the register page")
        public void i_am_on_the_register_page() {
            context.getAccountPage().load("https://askomdch.com/account/");
        }
    @When("I enter unique credentials {string} {string} {string}")
    public void i_enter_unique_credentials(String username, String email, String password) {
        context.getAccountPage().enterUniqueRegistrationDetails(username, email, password);
    }

        @When("I enter credentials {string} {string} {string}")
        public void i_enter_credentials(String username, String email, String password) {
        context.getAccountPage().enterRegistrationDetails(username, email, password);
        }

        @When("I click on register button")
        public void i_click_on_register_button() {
            context.getAccountPage().clickRegisterButton();

        }

    }



package stepDefinitions.cartSteps;

import context.TestContext;
import io.cucumber.java.en.Given;

public class AddToCartAsLoggedInUser {
    private final TestContext context;
    public AddToCartAsLoggedInUser(TestContext context){
    this.context = context;
    }
    @Given("I am a logged-in user with credentials {string} and {string}")
    public void enterCrdentials (String username , String passcode) {
        context.getAccountPage().load("https://askomdch.com/account/");
  context.getAccountPage().enterLoginCredentials(username , passcode);
  context.getAccountPage().clickLoginButton();

    }

}
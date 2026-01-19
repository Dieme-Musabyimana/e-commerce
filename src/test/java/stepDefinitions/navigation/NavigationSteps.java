package stepDefinitions.navigation;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;

public class NavigationSteps {
    private final TestContext context;
    public NavigationSteps(TestContext context){
        this.context = context;
    }
    @Given("I'm On any page of the AskOmDch website")
    public void i_m_on_any_page_of_the_ask_om_dch_website() {
   context.getHomePage().load("https://askomdch.com/");
    }
    @When("I click on {string}")
    public void i_click_on(String menu) {
       context.getHomePage().navigateToMenu(menu);
    }
    @Then("I should be directed to the page with {string}")
    public void i_should_be_directed_to_the_page_with(String expectedTitle) {
       String actualTitle = context.getHomePage().getPageTitle(expectedTitle);
       assertEquals(actualTitle,expectedTitle);

    }



}

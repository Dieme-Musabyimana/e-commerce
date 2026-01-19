package stepDefinitions.productBrowsingAndSearching;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FilterProductsByCategories {
    private final TestContext context;
    public FilterProductsByCategories(TestContext context){
        this.context = context;
    }
    @When("I select a product category {string}")
    public void i_select_a_product_category(String category) {
    context.getStorePage().selectCategory(category);
    }
    @Then("I should be taken to the page {string} of the selected category")
    public void i_should_be_taken_to_the_page_of_the_selected_category(String page) {
    String expectedUrl =  context.getStorePage().selectCategory(page);
        Assert.assertTrue(expectedUrl.contains(page));
    }

}

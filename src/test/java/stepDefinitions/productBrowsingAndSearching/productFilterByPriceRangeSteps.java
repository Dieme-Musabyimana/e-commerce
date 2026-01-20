package stepDefinitions.productBrowsingAndSearching;

import context.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class productFilterByPriceRangeSteps {
    private final TestContext context;
    public productFilterByPriceRangeSteps(TestContext context){
        this.context = context;
    }


    @When("I filter products between {double} and {double}")
    public void i_filter_products_between_and(double minPrice, double maxPrice) {
        context.getStorePage().filterByPrice(minPrice, maxPrice);
    }

    @Then("all displayed products should be priced between {double} and {double}")
    public double all_displayed_products_should_be_priced_between_and(double minPrice, double maxPrice) {
        List<Double> actualPrices = context.getStorePage().filterByPrice(minPrice,maxPrice);

        // 1. Define the logic clearly
        boolean isEveryPriceInRange = actualPrices.stream()
                .allMatch(price -> price >= minPrice && price <= maxPrice);

        // 2. Create a professional failure message
        String failureMessage = String.format(
                "Price Validation Failed! Expected Range: [%.2f - %.2f]. Found Prices: %s",
                minPrice, maxPrice, actualPrices
        );

        // 3. Assert (Condition first, then message for JUnit)
        Assert.assertTrue(isEveryPriceInRange, failureMessage);
    }

}

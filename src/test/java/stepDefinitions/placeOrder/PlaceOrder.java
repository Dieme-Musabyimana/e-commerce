package stepDefinitions.placeOrder;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrder {
    private final TestContext context;
    public PlaceOrder(TestContext context){
        this.context = context;
    }
    @Given("I have a product {string} in the cart")
    public void i_have_a_product_in_the_cart(String productName) {
        context.getStorePage().addProductToCart(productName);
    }

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
        context.getStorePage().viewCartFromStorePage();
        context.getCartPage().proceedToCheckout();

    }

    @When("I enter billing details")
    public void i_enter_billing_details(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @When("I select payment method {string}")
    public void i_select_payment_method(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I place the order")
    public void i_place_the_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

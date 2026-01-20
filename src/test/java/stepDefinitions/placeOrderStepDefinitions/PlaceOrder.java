package stepDefinitions.placeOrderStepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PlaceOrder {
    private final TestContext context;
    public PlaceOrder(TestContext context){
        this.context = context;
    }
    @Given("I have product {string} in my cart")
    public void i_have_product_in_my_cart(String productName) {
        context.getStorePage().load("https://askomdch.com/store/");
        context.getStorePage().addProductToCart(productName);
    }

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
       context.getStorePage().viewCartFromStorePage();
       context.getCartPage().proceedToCheckout();
    }

    @When("I provide valid shipping details")
    public void i_provide_valid_shipping_details(io.cucumber.datatable.DataTable dataTable) {
       context.getCheckOutPage().enterOrderDetails(dataTable);
    }

    @When("I select")
    public void i_select(io.cucumber.datatable.DataTable dataTable) {
        String methodName = dataTable.asList().get(0);
        context.getCheckOutPage().selectPaymentMethod(methodName);


    }

    @When("I place the order")
    public void i_place_the_order() {
       context.getCheckOutPage().placeOrder();
    }

    @Then("I should see an order confirmation message")
    public void i_should_see_an_order_confirmation_message() {
    String actualMessage = context.getCheckOutPage().verifyAlertOrderAlert();
    String expectedMessage = "Thank you. Your order has been received.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }


}

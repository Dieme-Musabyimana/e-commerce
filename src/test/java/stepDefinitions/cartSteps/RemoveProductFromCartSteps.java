package stepDefinitions.cartSteps;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RemoveProductFromCartSteps {
    private final TestContext context;
    public RemoveProductFromCartSteps(TestContext context){
        this.context = context;
    }
    @Given("I have product {string} in the cart")
    public void i_have_product_in_the_cart(String product) {
      context.getStorePage().addProductToCart(product);
      context.getStorePage().viewCartFromStorePage();
    }

    @When("I remove product from the cart")
    public void i_remove_product_from_the_cart() {
        context.getCartPage().removeProductFromCart();
    }


    @Then("the product should be successfully removed")
    public void the_product_should_be_successfully_removed() {
        int cartQuantity = context.getCartPage().getProductQuantityAfterRemove();
        Assert.assertEquals(cartQuantity, 0);
    }

    @Then("I should see success alert message containing removed {string}")
    public void i_should_see_success_alert_message(String productName) {
        String actualAlertMessage = context.getCartPage().getProductRemovalSuccessAlert(productName);
        Assert.assertTrue(actualAlertMessage.contains("“" + productName + "” removed"));
    }

}

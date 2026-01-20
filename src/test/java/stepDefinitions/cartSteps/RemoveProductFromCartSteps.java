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
    public void i_have_product_in_the_cart(String productName) {
        context.getStorePage().addProductToCart(productName);
    }

    @When("I remove the product from the cart")
    public void i_remove_the_product_from_the_cart() {
        context.getStorePage().viewCartFromStorePage();
        context.getCartPage().removeProductFromCart();
    }

    @Then("the product should be successfully removed")
    public void the_product_should_be_successfully_removed() {
        int qnty = context.getCartPage().getProductQuantityAfterRemove();
        Assert.assertEquals(qnty,0);
    }


    @Then("I should see a success alert message containing {string}")
    public void i_should_see_a_success_alert_message_containing(String productName) {
        String successAlert = context.getCartPage().getProductRemovalSuccessAlert(productName);
        Assert.assertTrue(successAlert.contains("“" + productName + "”" +" removed"));

    }

}

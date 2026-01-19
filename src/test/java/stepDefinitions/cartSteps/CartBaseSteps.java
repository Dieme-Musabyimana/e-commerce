package stepDefinitions.cartSteps;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CartBaseSteps {
    private final TestContext context;
    public CartBaseSteps(TestContext context){
        this.context = context;
    }

    @Given("I am on the store page")
    public void i_am_on_the_store_page() {
        context.getStorePage().load("https://askomdch.com/store/");
    }

    @When("I add the product {string} from store page to  the cart")
    public void i_add_the_product_from_store_page_to_the_cart(String product_name) {
        context.getStorePage().addProductToCart(product_name);
    }

    @Then("I should see {int} {string} from store page in the cart")
    public void i_should_see_from_store_page_in_the_cart(Integer qnty, String product_name) {
        context.getStorePage().viewCartFromStorePage();
        int productQnty = context.getCartPage().getAddedProductQuantity(qnty);
        String productName = context.getCartPage().getAddedProductName(product_name);

        Assert.assertEquals(productQnty, qnty);
        Assert.assertEquals(productName, product_name);

    }

    @Given("I am on the Product page for {string}")
    public void i_am_on_the_product_page_for(String productPageName) {
        context.getStorePage().load("https://askomdch.com/store/");
        context.getStorePage().goToProductPage(productPageName);
    }

    @When("I add the product {string} from the product page to the cart")
    public void i_add_the_product_from_the_product_page_to_the_cart(String product_name) {
        context.getProductPage().addProductFromProductPageToCart();
    }

    @Then("I should see {int} {string} from product page in the cart")
    public void i_should_see_from_product_page_in_the_cart(Integer qnty, String product) {
        context.getProductPage().viewCartFromProductPage();
        String actualProductName = context.getCartPage().getAddedProductName(product);
        int actualProductQnty = context.getCartPage().getAddedProductQuantity(qnty);


        Assert.assertEquals(actualProductQnty, qnty);
        Assert.assertEquals(actualProductName, product);
    }


}

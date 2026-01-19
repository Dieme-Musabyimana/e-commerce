//package stepDefinitions.cartSteps;
//
//import context.TestContext;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.testng.Assert;
//import pages.account.CartPage;
//import pages.account.StorePage;
//
//public class AddToCartAsGuest {
//    StorePage storePage;
//    CartPage cartPage;
//    private final TestContext context;
//    public AddToCartAsGuest(TestContext context){
//        this.context = context;
//
//    }
//    @Given("I am on the store page")
//    public void i_am_on_the_store_page() {
//        context.getStorePage().load("https://askomdch.com/store/");
//
//    }
//    @When("I add the product {string} from store page to  the cart")
//    public void i_add_the_product_from_store_page_to_the_cart(String productName) {
//        context.getStorePage().addProductToCart(productName);
//        context.getStorePage().viewCart();
//
//    }
//
//    @When("I add the product {string} from the product page to the cart")
//    public void i_add_the_product_from_the_product_page_to_the_cart(String productName) {
//        context.getStorePage().load("https://askomdch.com/store/");
//        context.getStorePage().gotToProductPage(productName);
//        context.getStorePage().gotToProductPage(productName);
//    }
//
//
//}

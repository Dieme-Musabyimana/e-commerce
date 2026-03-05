package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/cartFeatures/addToCart_Guest.feature"},
        glue = {"stepDefinitions.cartSteps", "hooks"},
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                // >>>>>>>>>>>>>>>>>>>>>> EXTENT REPORT <<<<<<<<<<<<<<<<<<<<
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                // >>>>>>>>>>>>>>>>>>>>>> EXTENT REPORT <<<<<<<<<<<<<<<<<<<<

                // >>>>>>>>>>>>>>>>>>>>>> ALLURE REPORT <<<<<<<<<<<<<<<<<<<<
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                // >>>>>>>>>>>>>>>>>>>>>> ALLURE REPORT <<<<<<<<<<<<<<<<<<<<
        },
        monochrome = true
)
public class runnerClass extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
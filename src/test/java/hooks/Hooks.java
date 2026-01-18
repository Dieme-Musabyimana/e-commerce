package hooks;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private TestContext context;

    // Receive the context via constructor
    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp() {
        // Assign the driver directly to the context's driver
        context.driver = new ChromeDriver();
        context.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (context.driver != null) {
            context.driver.quit();
        }
    }
}
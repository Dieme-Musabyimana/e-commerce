//package hooks;
//
//import context.TestContext;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import io.qameta.allure.Allure;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import pages.factory.DriverFactory;
//import utils.VideoRecorder; // Ensure this import matches your project structure
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.nio.file.Files;
//
//public class Hooks {
//    private TestContext context;
//
//    public Hooks(TestContext context) {
//        this.context = context;
//    }
//
//    @Before
//    public void setUp(Scenario scenario) throws Exception {
//        // 1. Prepare video recording name
//        String testName = scenario.getName().replace(" ", "_");
//
//        // 2. Start Recording BEFORE driver initialization
//        VideoRecorder.startRecording(testName);
//
//        // 3. Initialize the Driver (Uncommented and fixed order)
//        context.driver = DriverFactory.initializeDriver("chrome");
//
//        // 4. Manage window (Must happen AFTER driver is initialized)
//        context.driver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown(Scenario scenario) throws Exception {
//        // 1. Stop the recorder and get the file
//        File videoFile = VideoRecorder.stopRecording();
//
//        if (context.driver != null) {
//            if (scenario.isFailed()) {
//                // 2. Attach Screenshot to Report
//                final byte[] screenshot = ((TakesScreenshot) context.driver)
//                        .getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
//
//                // 3. Attach Video to Allure Report
//                byte[] videoBytes = Files.readAllBytes(videoFile.toPath());
//                Allure.addAttachment("Failed Scenario Video", "video/avi",
//                        new ByteArrayInputStream(videoBytes), ".avi");
//            } else {
//                // 4. Delete video if test passed to save disk space
//                if (videoFile.exists()) {
//                    videoFile.delete();
//                }
//            }
//            context.driver.quit();
//        }
//    }
//}
//



//
package hooks;

import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario; // Need this for reporting
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Keep this for local browser visibility
        options.addArguments("--remote-allow-origins=*");

        context.driver = new ChromeDriver(options);
        context.driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (context.driver != null) {
            // This is what puts the "Evidence" in your Extent Report
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) context.driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Step Screenshot");
            }
            context.driver.quit();
        }
    }
}
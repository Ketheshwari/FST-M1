package ProjectActivity;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void googleKeep() throws InterruptedException {
        // Perform the calculation
        driver.findElement(AppiumBy.id("new_note_button")).click();
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("FST_Note");
       Thread.sleep(3000);
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Appium FST Training project");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(3000);

        // Find the result
        String result = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='FST_Note']")).getText();

        // Assertion
        Assert.assertEquals(result, "FST_Note");
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();

    }

}

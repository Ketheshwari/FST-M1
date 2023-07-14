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

public class Activity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void googleTask() throws InterruptedException {
        // Perform the calculation
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("add_task_done")).click();


        //task2
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        //task3
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        Thread.sleep(3000);
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        String result1 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Tasks']")).getText();
        // Assertion
        Assert.assertEquals(result1, "Complete Activity with Google Tasks");

        String result2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Keep']")).getText();
        // Assertion
        Assert.assertEquals(result2, "Complete Activity with Google Keep");

        String result3 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Complete the second Activity Google Keep']")).getText();
        // Assertion
        Assert.assertEquals(result3, "Complete the second Activity Google Keep");

    }
        // Tear down method
        @AfterClass
        public void tearDown() {
            // Close the app
            driver.quit();

    }

}

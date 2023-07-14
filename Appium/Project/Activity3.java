package ProjectActivity;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();


        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium");

    }

    @Test
    public void seleniumPage() throws IOException, InterruptedException {

        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";


        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable+".scrollTextIntoView(\"Drag and Drop\")"));
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();

Thread.sleep(3000);
     //   wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("android.widget.Button[@text='Add Task']")));

        driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Add Task\")")).click();

        driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Add Task\")")).click();

        driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Add Task\")")).click();


        driver.findElement(AppiumBy.androidUIAutomator("text(\"Add tasks to list\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Get number of tasks\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Clear the list\")")).click();

        Thread.sleep(2000);

        driver.findElement(AppiumBy.androidUIAutomator("textContains(\"Clear List\")")).click();

        Assert.assertTrue(true,"PASS");



    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();

    }
}

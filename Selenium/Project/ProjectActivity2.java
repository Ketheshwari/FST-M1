package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ProjectActivity2 {

    public static void main(String[] args) throws InterruptedException {

    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();
    driver.get("https://alchemy.hguy.co/jobs");

    String pageHeading = driver.findElement(By.className("entry-title")).getText();
    System.out.println(pageHeading);

        Assert.assertEquals(pageHeading,"Welcome to Alchemy Jobs");
        driver.quit();

    }

}

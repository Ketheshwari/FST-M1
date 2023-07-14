package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ProjectActivity4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        WebElement headingPath = driver.findElement(By.xpath("//*[contains(text(),'Quia quis non')][2]"));

        String secondHeading = headingPath.getText();
        System.out.println(secondHeading);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", headingPath);

        Thread.sleep(4000);

        Assert.assertEquals(secondHeading, "Quia quis non");
        driver.close();




    }
}

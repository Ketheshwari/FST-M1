package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ProjectActivity9 {

    public static void main(String[] args) throws InterruptedException {


    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();

        driver.findElement(By.xpath("//div[contains(text(),'Job Listings')]//parent::div[@class='wp-menu-name']")).click();
        driver.findElement(By.xpath("//*[@class='page-title-action' and contains(text(),'Add New')]")).click();

        driver.findElement(By.xpath("(//div[@class='components-modal__header']//following::button)[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[starts-with(@id, 'editor-') ]")).sendKeys("Automation Tester");
        driver.findElement(By.xpath("//input[@id='_application']")).sendKeys("nisha18@cklabs.com");

        WebElement publish = driver.findElement(By.xpath("//button[contains(text(),'Publish…')]"));
       publish .click();
        System.out.println("click first");
        driver.findElement(By.xpath("//div[@class='editor-post-publish-panel__header-publish-button']//button")).click();

        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[contains(text(),'Preview')]")).click();

        driver.quit();


    }
}

package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class ProjectActivity1 {

    public static void main(String[] args) throws InterruptedException {

    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();
    driver.get("https://alchemy.hguy.co/jobs");

    String title = driver.getTitle();

    System.out.println("Title of the page: " + driver.getTitle());
    Thread.sleep(2000);
        Assert.assertEquals(title,"Alchemy Jobs – Job Board Application");

        driver.close();




    }
}

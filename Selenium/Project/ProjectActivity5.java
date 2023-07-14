package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

public class ProjectActivity5 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        List<WebElement> navigationBar= driver.findElements(By.xpath("//div[@class='main-navigation']//a"));

        for(WebElement link:navigationBar){
            System.out.println(link.getText() + " - " + link.getAttribute("href"));

            if(link.getText().equals("Jobs"))
            {
                link.click();
                break;
            }
        }

        String jobPageTitle= driver.getTitle();
        System.out.println(jobPageTitle);
        Assert.assertEquals(jobPageTitle, "Jobs – Alchemy Jobs");
        driver.close();

    }
    }

package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class ProjectActivity6 {

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

        driver.findElement(By.id("search_keywords")).sendKeys("Java");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        Thread.sleep(2000);

        List<WebElement> jobList= driver.findElements(By.xpath("//div[@class='job_listings']//following-sibling::ul[@class='job_listings']"));

        for(WebElement jobSelect:jobList){
            System.out.println(jobSelect.getText() );
            Thread.sleep(2000);

           while(true)
           {
               jobSelect.click();
               break;
           }
        }

        driver.findElement(By.xpath("//input[@value = 'Apply for job']")).click();
       String emailVal= driver.findElement(By.xpath("//a[@class='job_application_email']")).getText();
        System.out.println("emailDetails: "+emailVal);

        driver.close();
    }
}

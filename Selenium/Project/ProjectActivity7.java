package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class ProjectActivity7 {

    public static void main(String[] args) throws InterruptedException {

WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

    List<WebElement> navigationBar= driver.findElements(By.xpath("//div[@class='main-navigation']//a"));

        for(WebElement link:navigationBar){
        System.out.println(link.getText() + " - " + link.getAttribute("href"));

        if(link.getText().equals("Post a Job"))
        {
            link.click();
            break;
        }
    }

        driver.findElement(By.id("create_account_email")).sendKeys("nisha27@gmail.com");
        driver.findElement(By.id("job_title")).sendKeys("Tester");
        driver.findElement(By.id("application")).sendKeys("workemail@gmail.com");
       // driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("Testing");
        driver.findElement(By.id("job_description_ifr")).sendKeys("ATesting1");

        driver.findElement(By.id("company_name")).sendKeys("TrainingPgm7");
        driver.findElement(By.name("submit_job")).click();

        driver.findElement(By.id("job_preview_submit_button")).click();

        List<WebElement> navigationBar1= driver.findElements(By.xpath("//div[@class='main-navigation']//a"));

        for(WebElement link:navigationBar1){
            System.out.println(link.getText() + " - " + link.getAttribute("href"));

            if(link.getText().equals("Jobs"))
            {
                link.click();
                break;
            }
        }
        driver.findElement(By.id("search_keywords")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();


     // WebElement jobAdded =driver.findElement(By.xpath("//*[contains(text(),'TrainingPgm4')]/parent::div/parent::div"));

        List<WebElement> jobList= driver.findElements(By.xpath("//div[@class='job_listings']//following-sibling::ul[@class='job_listings']"));

        for(WebElement jobSelect:jobList){
            System.out.println(jobSelect.getText() );
            Thread.sleep(2000);

            while(true)
            {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", jobSelect);
                Thread.sleep(5000);
                break;
            }
        }


driver.close();





    }
}

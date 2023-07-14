package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");

        String imageUrl = driver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']"))
                         .getAttribute("src");

        System.out.println(imageUrl);
        driver.close();



    }
}

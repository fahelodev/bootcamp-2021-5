package selenium.arey;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class atc02_AutomationPracticeChiffonDress {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://automationpractice.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        Thread.sleep(1500);
        driver.quit();
    }
}

package selenium.acabrera;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class act04Encontrar {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("blo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results > ul > li")));
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\'search\']/div[2]/ul/li")).click();
        driver.close();
    }
}

package selenium.landres;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class atc03 {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;



        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);




        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.id("search_query_top")).sendKeys("blo");
        //driver.findElement(By.xpath("//*[@id='searchbox']/button")).sendKeys(Keys.ENTER);
        //driver.findElement(By.id("//*[@id='search']/div[2]/ul/li")).getTagName("Blouses")
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Login to Selenium Account')]"))).click();



        //driver.findElement(By.cssSelector("ac_even ac_over")).click();

       // driver.findElement(By.cssSelector("ac_even ac_over")).click();
        driver.close();



    }


}


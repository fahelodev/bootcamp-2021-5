package selenium.fluzon.gortego;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc01 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();

    }


}

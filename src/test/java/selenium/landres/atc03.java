package selenium.landres;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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






        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.id("search_query_top")).sendKeys("blo");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='index']/div[2]/ul/li")));
        WebElement busqueda = driver.findElement(By.xpath("//*[@id='search_query_top']"));
       // WebElement busqueda = driver.findElement(By.id("'search_query_top'"));
        busqueda.sendKeys(Keys.ARROW_DOWN);
        busqueda.sendKeys(Keys.ENTER);


        String blousa = driver.findElement(By.xpath("//*[@id='product_reference']")).getText();
        Assert.assertEquals("Model demo_2",blousa);


    }


}


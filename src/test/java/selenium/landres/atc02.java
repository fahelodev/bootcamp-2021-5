package selenium.landres;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import static org.junit.Assert.assertEquals;


public class atc02 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;



        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();



        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.id("search_query_top")).sendKeys("liquido matapulga");
        driver.findElement(By.xpath("//*[@id='searchbox']/button")).sendKeys(Keys.ENTER);
        System.out.println(driver.findElement(By.cssSelector("#center_column > p")).getText());
        String palabra="No results were found for your search liquido matapulga";
        assertEquals("No results were found for your search liquido matapulga",palabra);


    }


}

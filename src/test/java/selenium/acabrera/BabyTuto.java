package selenium.acabrera;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BabyTuto {

    private WebDriver driver;

    @BeforeClass
    public static void Setup(){


        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String pagina = "https://www.babytuto.com/";
        driver.get(pagina);
    }

    @Test
    public void atc06filtrarProductos() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver,15);

        if (driver.findElement(By.cssSelector("#newsletter > div")).isDisplayed()){
            driver.findElement(By.cssSelector("#newsletter > button")).click();
        }

        List<WebElement> options_list = driver.findElements(By.tagName("li"));

        for (WebElement l: options_list) {

            if (l.getText().contains("COCHES"))
            {
                l.click();
                break;
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Accesorios para coches')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Accesorios para coches')]")).click();

        //driver.findElement(By.xpath("//ul/li/a/span[contains(text(),'BBpro')]")).click();
        driver.findElement(By.xpath("//a/span[contains(text(),'BBpro')]")).click();




    }

    /*@After
    public void cerrar() {


        if (driver != null) {
            driver.close();
        }
    }*/
}

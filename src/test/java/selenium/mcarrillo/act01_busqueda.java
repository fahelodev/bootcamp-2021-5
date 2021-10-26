package selenium.mcarrillo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class act01_busqueda {


    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Inicialización del WebDriver con Firefox
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();

        Thread.sleep(4000);
        driver.close();

    }
}

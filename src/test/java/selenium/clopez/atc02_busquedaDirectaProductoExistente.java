package selenium.clopez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class atc02_busquedaDirectaProductoExistente {

    private WebDriver driver;

    @BeforeClass
    public static void Setup(){
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void init() throws InterruptedException {
        System.out.println("init para instanciar");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com//");
        // Esperamos
        Thread.sleep(2000);
        while (driver.getTitle() == "508 Error - Resource Limit Reached"){
            driver.navigate().refresh();
            // Esperamos
            Thread.sleep(1000);
        }
    }

    @Test
    public void atc02_busquedaDirectaProductoExistente() throws InterruptedException {
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click();
        // Espera
        Thread.sleep(2000);
        // Tomamos el nombre del primer elemento
        Assert.assertEquals( "Printed Chiffon Dress", driver.findElement(By.cssSelector("a.product-name")).getText());
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");
    }
}
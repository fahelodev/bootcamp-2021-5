package selenium.clopez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class atc01_BusquedaPalabrasClaves {

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
    public void atc01_BusquedaPalabrasClaves() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("dress");
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")).click();
        // Esperamos
        Thread.sleep(2000);
        // se crea una lista de elementos web
        // List<WebElement> dress = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
        List<WebElement> dress = driver.findElements(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li"));
        // Tamaño obtenido = 7 en ambas listas anteriores
        // System.out.println("Tamaño = "+dress.size());
        Assert.assertTrue(dress.size() > 2);
    }

    @After
    public void close(){
        // Espera
        if(driver != null){
            driver.close();
        }

    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");

    }
}

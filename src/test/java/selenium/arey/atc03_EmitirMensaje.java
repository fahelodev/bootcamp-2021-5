package selenium.arey;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class atc03_EmitirMensaje {

    private WebDriver driver;

    //Inicialización del WebDriver con Chrome
    @BeforeClass
    public static void setup()
    {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init()
    {
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");
    }

    @Test
    public void atc03EmitirMensaje(){
        while(driver.getTitle()==" 508 Resource Limit Is Reached")
        {
            driver.navigate().refresh();
        }
        String strBusqueda = "liquido matapulgas";
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys(strBusqueda);
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
    }

    @After
    public void close() throws InterruptedException {
        if (driver != null){
            Thread.sleep(2500);
            driver.close();
        }
    }

    @AfterClass
    public static void closeAll()
    {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizados en el test");
    }

}
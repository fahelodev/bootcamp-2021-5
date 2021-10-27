package selenium.arey;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class atc04_EncontrarProductoLista {
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
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //TODO PRIMERA FORMA DE HACERLO - MANERA IMPLICITA (TIEMPO MAXIMO QUE LE DA AL
//                                                                                                                          TEST PARA CARGAR EL ATRIBUTO)
        driver.get("http://automationpractice.com");
        while(driver.getTitle()=="508 Resource Limit Is Reached")
        {
            driver.navigate().refresh();
        }
    }

    @Test
    public void atc04BusquedaProductoLista() {
        String strBusqueda = "blo";
        driverElement("//*[@id=\"search_query_top\"]").sendKeys(strBusqueda);
        WebDriverWait w = new WebDriverWait(driver,15); //TODO SEGUNDA FORMA DE HACERLO - MANERA EXPLICITA (TIEMPO MAXIMO QUE LE DA AL TEST PARA TERMINAR O
        //                                                                                                            TERMINA ANTES SI SE CUMPLE LA CONDICION SOLICITADA)

//        WebElement result = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"index\"]/div[2]"))); //TODO SEGUNDA/TERCERA FORMA DE HACERLO
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver) //TODO TERCERA FORMA DE HACERLO - MANERA FLUIDA (MARCA TIEMPO MAXIMO QUE LE DA AL WEBDRIVER PARA ESPERAR
                                                                    //     A QUE UNA CONDICION, O SEA UN WEBELEMENT, SE VUELVA VISIBLE. TAMBIEN CON CUANTA FRECUENCIA CHEQUEA
                                                                    //   SI LA CONDICION APARECE ANTES DE TIRAR ALGUN ERROR/EXCEPCION))
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"index\"]/div[2]")));

        WebElement search = driverElement("//*[@id=\"index\"]/div[2]");
        Assert.assertTrue(search.isDisplayed() && search.isEnabled());
        Assert.assertEquals("Blouses > Blouse", search.getText());
        search.click();
        Assert.assertEquals("Model demo_2", driverElement("//*[@id=\"product_reference\"]").getText());



    }

    @After
    public void close() throws InterruptedException {
        if (driver != null){
            Thread.sleep(2000);
            driver.close();
        }
    }

    @AfterClass
    public static void closeAll()
    {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizados en el test");
    }

    public WebElement driverElement(String path)
    {
        WebElement driverelement = driver.findElement(By.xpath(path));
        return driverelement;
    }
}

package viajesfalabella.equipo6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
public class AutomationAutomovilesFalabella {

    private WebDriver driver;

    @BeforeClass
    public static void Setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.viajesfalabella.cl");
    }

    @Test
    public void Autos_falabella001(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.cssSelector("a[title='Autos']")).click();
        driver.findElement(By.cssSelector(".sbox-destination")).sendKeys("Aeropuerto Internacional John F Kennedy");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item-text"))).click();
        // Selecciona fecha de retiro
        driver.findElement(By.cssSelector("[placeholder='Retiro']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--month-active']//span[@class='_dpmg2--date _dpmg2--available']/span[.='8']"))).click();
        // Selecciona decha de devolucion
        driver.findElement(By.cssSelector("[placeholder='Devolución']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--has-start-range _dpmg2--month-active']/div[@class='_dpmg2--dates']/span[.='10']"))).click();
        driver.findElement(By.cssSelector("._dpmg2--desktopFooter-button-apply-text")).click();
        driver.findElement(By.xpath("//em[.='Buscar']")).click();
        //Se ven los detalles del auto
        driver.findElement(By.xpath("//div[@class='clusters-by-categories']/div[1]//div[@class='cluster-container']/div[2]//div[@class='display-none-sm display-none-xs']//em[@class='btn-text']")).click();
    }
    @Test
    public void Autos_falabella002() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.cssSelector("a[title='Autos']")).click();
        driver.findElement(By.cssSelector(".sbox-destination")).sendKeys("Aeropuerto Internacional John F Kennedy");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item-text"))).click();
        // Selecciona fecha de retiro
        driver.findElement(By.cssSelector("[placeholder='Retiro']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--month-active']//span[@class='_dpmg2--date _dpmg2--available']/span[.='8']"))).click();
        // Selecciona decha de devolucion
        driver.findElement(By.cssSelector("[placeholder='Devolución']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--has-start-range _dpmg2--month-active']/div[@class='_dpmg2--dates']/span[.='10']"))).click();
        driver.findElement(By.cssSelector("._dpmg2--desktopFooter-button-apply-text")).click();
        // Selecciona la hora
        driver.findElement(By.cssSelector(".sbox-timein")).click();
        driver.findElement(By.xpath("//select[@class='select-tag sbox-timein']/option[.='15:00']")).click();
        driver.findElement(By.cssSelector(".sbox-timeout")).click();
        driver.findElement(By.xpath("//select[@class='select-tag sbox-timeout sbox-bind-disable-timeout']/option[.='20:00']")).click();
        driver.findElement(By.xpath("//em[.='Buscar']")).click();
        //Se utilizan los filtros
        driver.findElement(By.cssSelector(".dropdown-item[data-index='0'] [data-index='2'] .checkbox-check")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//em[.='Budget']"))).click();
        //Se utilizan los tread.sleep porque la pagina carga y no espera la seleccion
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[.='4 Personas']"))).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//em[.='Oficina en el aeropuerto']"))).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("sorting-selector #eva-select")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("'[value='CUSTOMER_REVIEW']'"))).click();
    }

    @Test
    public void Autos_falabella003(){
        //Seleccionamos la seccion autos
        driver.findElement(By.cssSelector(".CARS")).click();
        //Seleccionamos lugar de entrega
        WebElement altoDestino = driver.findElement(By.cssSelector(".sbox-destination"));
        altoDestino.click();
        altoDestino.sendKeys("Nueva york");
        driver.findElement(By.xpath("//li[.='Nueva York, Nueva York, Estados Unidos']")).click();

        //Elegimos fecha de retiro
        driver.findElement(By.cssSelector("[placeholder='Retiro']")).click();
        driver.findElement(By.cssSelector("[data-month='2021-11'] span:nth-of-type(10) > ._dpmg2--date-number")).click();

        //Elegimos fecha de entrega y aplicamos
        driver.findElement(By.cssSelector("._dpmg2--has-start-range span:nth-of-type(19)")).click();
        driver.findElement(By.cssSelector("._dpmg2--desktopFooter-button-apply-text")).click();

        //Elegimos hora de retiro
        driver.findElement(By.xpath("//select[@class='select-tag sbox-timein']")).click();
        driver.findElement(By.xpath("//select[@class='select-tag sbox-timein']/option[.='02:00']")).click();
        //Elegimos hora de entrega y buscamos
        driver.findElement(By.cssSelector(".sbox-timeout")).click();
        driver.findElement(By.cssSelector(".sbox-timeout > [value='300']")).click();
        driver.findElement(By.xpath("//em[.='Buscar']")).click();

        //Verificamos el detalle del primer resultado
        driver.findElement(By.xpath("//div[@class='clusters-by-categories']/div[1]//div[@class='cluster-container']/div[2]//div[@class='display-none-sm display-none-xs']//a[.='Ver detalle']")).click();
    }


    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
    @AfterClass
    public static void closeAll() {
    }
}
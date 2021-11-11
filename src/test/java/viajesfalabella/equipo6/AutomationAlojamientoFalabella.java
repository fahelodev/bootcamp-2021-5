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
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;


public class AutomationAlojamientoFalabella {

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
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.viajesfalabella.cl");
    }

    @Test
    public void alojamiento_falabella001(){
        driver.findElement(By.xpath("//label[.='Alojamientos']")).click();
        WebElement destino = driver.findElement(By.cssSelector("[placeholder='Ingresa una ciudad, alojamiento o atracción']"));
        destino.click();
        destino.sendKeys("Cordoba");
        driver.findElement(By.xpath("//li[.='Córdoba, Córdoba, Argentina']")).click();
        driver.findElement(By.cssSelector(".checkbox-label")).click();
        driver.findElement(By.cssSelector(".sbox-search")).click();
    }

    @Test
    public void alojamiento_falabella002(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        driver.findElement(By.xpath("//label[.='Alojamientos']")).click();
        WebElement destino = driver.findElement(By.cssSelector("[placeholder='Ingresa una ciudad, alojamiento o atracción']"));
        destino.click();
        destino.sendKeys("Cordoba");
        //Comparar si es correcto
        String ciudad = driver.findElement(By.xpath("//span[.='Córdoba, Córdoba, Argentina']")).getText();
        Assert.assertEquals("Córdoba, Córdoba, Argentina", ciudad);
        driver.findElement(By.xpath("//li[.='Córdoba, Córdoba, Argentina']")).click();

        //introducir fechas
        driver.findElement(By.cssSelector("[placeholder='Entrada']")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--dates']/child::span[18]"))).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='25NocheNoches']"))).click();
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]")).click();
        driver.findElement(By.cssSelector(".sbox-search")).click();

        //Boton buscar
        driver.findElement(By.cssSelector("[placeholder='Ingresá una ciudad, alojamiento o atracción']")).click();
        driver.findElement(By.cssSelector("[placeholder='Ingresá una ciudad, alojamiento o atracción']")).clear();

        WebElement modificado = driver.findElement(By.cssSelector("[placeholder='Ingresá una ciudad, alojamiento o atracción']"));
        modificado.click();
        modificado.sendKeys("Buenos aires");
        //Comparar si es correcto
        String ciudadmodificada = driver.findElement(By.xpath("//span[.='Buenos Aires, Ciudad de Buenos Aires, Argentina']")).getText();
        Assert.assertEquals("Buenos Aires, Ciudad de Buenos Aires, Argentina", ciudadmodificada);
        driver.findElement(By.xpath("//li[.='Buenos Aires, Ciudad de Buenos Aires, Argentina']")).click();

        //Selecciona no he decidido la fecha
        driver.findElement(By.cssSelector(".sbox5-label-ovr")).click();
        //Busca
        driver.findElement(By.cssSelector(".sbox5-box-button-ovr")).click();
    }

    @Test
    public void alojamiento_falabella003(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        driver.findElement(By.xpath("//label[.='Alojamientos']")).click();
        driver.findElement(By.xpath("//div[.='qp Hotels Lima']")).click();
        String hotel = driver.findElement(By.xpath("//div[.='qp Hotels Lima']")).getText();
        Assert.assertEquals("qp Hotels Lima", hotel);

        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        driverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();

        //Si aparece una nueva ventana, debe trabajar en la nueva ventana
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.close();
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //Elige las fechas
        driver.findElement(By.cssSelector("[placeholder='Entrada']")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--dates']/child::span[18]"))).click();
        driver.findElement(By.cssSelector("[placeholder='Salida']")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='25NocheNoches']"))).click();
        driver.findElement(By.cssSelector("._dpmg2--desktopFooter-button-apply")).click();
        driver.findElement(By.cssSelector(".sbox-search")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Hotel Miramar')]")).click();


        WebDriverWait driverWaitLong = new WebDriverWait(driver, 10);
        driverWaitLong.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindows = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindows.contentEquals(windowHandle)) {
                driver.close();
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Reservar ahora')]"))).click();
        driver.findElement(By.id("select-test")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[.='LIM, Aeropuerto Internacional Jorge Chavez']"))).click();

        driver.findElement(By.id("arrivalTime")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='arrivalTime']/option[.='01:30']"))).click();

        driver.findElement(By.id("departureTime")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='departureTime']/option[.='06:00']"))).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='highlight-card-container -eva-3-shadow-1-hover -eva-3-bc-white TRANSFER REGULAR']//button[@class='eva-3-btn -eva-3-fwidth -md -primary']"))).click();
        driver.findElement(By.xpath("//a[.='Ver detalle']")).click();
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


package viajesfalabella.equipo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServicioTrasladosTest {

    private WebDriver driver;
    private WebDriverWait espera;

    @BeforeClass
    public static void Setup() {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.viajesfalabella.cl");
        espera= new WebDriverWait(driver, 7);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @Test
    public void caso09(){

        driver.findElement(By.xpath("//label[contains(text(),'Traslados')]")).click();

        //driver.findElement(By.xpath("//input[@name='sbox-transfers-type' and not(@checked='checked')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),' Hacia el aeropuerto')]")).click();
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus.sbox-destination")).sendKeys("Naindo");
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Naindo')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Naindo')]")).click();

        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus.sbox-origin")).sendKeys("La rioja");
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Aeropuerto Capitan Vicente Almando, La ')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Aeropuerto Capitan Vicente Almando, La ')]")).click();

        driver.findElement(By.cssSelector("input.input-tag.sbox-checkout")).click();
        driver.findElement(By.xpath("//span[@class='_dpmg2--date-number' and contains(text(),'8')]")).click();

        Select hora = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-time-departure")));
        hora.selectByVisibleText("07:00");

        driver.findElement(By.cssSelector("i.input-icon.sbox-3-icon-search")).click();

        WebElement mensaje1 = driver.findElement(By.cssSelector("h5.eva-3-h5"));
        WebElement mensaje2 = driver.findElement(By.cssSelector("a.ng-binding"));
        String resultadoEsperado1 = "¡Ups! No hay traslados disponibles para esta fecha.";
        String resultadoEsperado2 = "Sentimos no poder ayudarte. Esperamos que encuentres lo que estás buscando.";

        assertEquals(resultadoEsperado1,mensaje1.getText());
        assertEquals(resultadoEsperado2,mensaje2.getText());

    }

    @Test
    public void caso10() {

        driver.findElement(By.xpath("//label[contains(text(),'Traslado')]")).click();
        espera.until(ExpectedConditions.elementToBeClickable((By.cssSelector("input[placeholder='Ingresa un aeropuerto'"))));
        driver.findElement(By.cssSelector("input[placeholder='Ingresa un aeropuerto'")).sendKeys("Córdoba");
        espera.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div.ac-container ul li"))));
        driver.findElement(By.cssSelector("div.ac-container ul li")).click();
        driver.findElement(By.cssSelector("input[placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys("Sava");
        espera.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div.ac-container ul li"))));
        driver.findElement(By.cssSelector("div.ac-container ul li")).click();

        // driver.findElement(By.xpath("//input[@placeholder='Arribo']")).click();
        driver.findElement(By.cssSelector("input.input-tag.sbox-checkin")).click();

        List<WebElement> seleccionarHora = driver.findElements(By.xpath("//span[@class='_dpmg2--date-number' and contains(text(),'8')]"));
        for (WebElement elemento:seleccionarHora) {
            if(elemento.getText().equals("8")) {
                elemento.click();
                break;
            }
        }
        Select horaArribo = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-time-arrival")));
        horaArribo.selectByVisibleText("07:00");
        driver.findElement(By.cssSelector("div.sbox-distri-container")).click();
        int i=0;
        while(i<3) {
            driver.findElement(By.cssSelector("._pnlpk-itemRow__item._pnlpk-stepper-adults.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus")).click();
            i++;
        }
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        List<WebElement> listaAutos = driver.findElements(By.cssSelector("div.search-cluster.ng-scope.ng-hide"));
        int resultado= listaAutos.size();
        System.out.println(resultado);
        assertTrue(resultado>=1);
    }


    @After
    public void close() {
        if (driver != null) {
            //driver.close();
        }

    }

    @AfterClass
    public static void closeAll() {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");

    }

}

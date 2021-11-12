package viajesfalabella.equipo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.util.List;

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

    }


    @Test
    public void caso09(){

        //click en traslados
        driver.findElement(By.xpath("//label[contains(text(),'Traslados')]")).click();

        //click en la opcion "hacia el aeorpuerto"
        driver.findElement(By.xpath("//span[contains(text(),' Hacia el aeropuerto')]")).click();

        //ingresamos la palabra "naindo"
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus.sbox-destination")).sendKeys("Naindo");
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Naindo')]")));
        //seleccionamos la opcion naindo de la lista
        driver.findElement(By.xpath("//span[contains(text(),'Naindo')]")).click();

        //ingreamos "la rioja" en el campo "hasta"
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus.sbox-origin")).sendKeys("La rioja");
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Aeropuerto Capitan Vicente Almando, La ')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Aeropuerto Capitan Vicente Almando, La ')]")).click();

        //seleccionamos en el campo "fecha hora" la fecha "22 de noviembre" y hora "07:00"
        driver.findElement(By.cssSelector("input.input-tag.sbox-checkout")).click();
        driver.findElement(By.xpath("//span[@class='_dpmg2--date-number' and contains(text(),'22')]")).click();
        Select hora = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-time-departure")));
        hora.selectByVisibleText("07:00");

        //click en buscar
        driver.findElement(By.cssSelector("i.input-icon.sbox-3-icon-search")).click();

           espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h5.eva-3-h5")));
        //se obtienen los mensajes de advertencia
        WebElement mensaje1 = driver.findElement(By.cssSelector("h5.eva-3-h5"));
        WebElement mensaje2 = driver.findElement(By.cssSelector("a.ng-binding"));
       String resultadoEsperado1 = "¡Ups! No hay traslados disponibles para esta fecha.";
       String resultadoEsperado2 = "Sentimos no poder ayudarte. Esperamos que encuentres lo que estás buscando.";


        //validacion de los resultados
        assertEquals(resultadoEsperado1,mensaje1.getText());
        assertEquals(resultadoEsperado2,mensaje2.getText());

    }

    @Test
    public void caso10() {

        //click en traslados
        driver.findElement(By.xpath("//label[contains(text(),'Traslado')]")).click();
        espera.until(ExpectedConditions.elementToBeClickable((By.cssSelector("input[placeholder='Ingresa un aeropuerto'"))));

        //ingresamos "cordoba"
        driver.findElement(By.cssSelector("input[placeholder='Ingresa un aeropuerto'")).sendKeys("Córdoba");
        espera.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div.ac-container ul li"))));
        driver.findElement(By.cssSelector("div.ac-container ul li")).click();

        //ingresamos "sava"
        driver.findElement(By.cssSelector("input[placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys("Sava");
        espera.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div.ac-container ul li"))));
        driver.findElement(By.cssSelector("div.ac-container ul li")).click();

        //click en el campo fecha y se ingresa "22 de noviembre"
        driver.findElement(By.cssSelector("input.input-tag.sbox-checkin")).click();

        List<WebElement> seleccionarHora = driver.findElements(By.xpath("//span[@class='_dpmg2--date-number' and contains(text(),'22')]"));
        for (WebElement elemento:seleccionarHora) {
            if(elemento.getText().equals("22")) {
                elemento.click();
                break;
            }
        }
        //seleccionamos la hora "07:00"
        Select horaArribo = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-time-arrival")));
        horaArribo.selectByVisibleText("07:00");

        //hacemos click en pasajeros
        driver.findElement(By.cssSelector("div.sbox-distri-container")).click();
        int i=0;
        //hacemos tres click en el boton (+) de pasajeros
        while(i<3) {
            driver.findElement(By.cssSelector("._pnlpk-itemRow__item._pnlpk-stepper-adults.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus")).click();
            i++;
        }
        //click en buscar
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();
        espera.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div.search-cluster.ng-scope.ng-hide"))));
        //comprobamos que exista al menos un resultado para "traslados"
        List<WebElement> listaAutos = driver.findElements(By.cssSelector("div.search-cluster.ng-scope.ng-hide"));
        int resultado= listaAutos.size();
        System.out.println(resultado);
        assertTrue(resultado>=1);
    }


    @Test
    public void caso11()  {

        //Click en traslados
        driver.findElement(By.xpath("//label[contains(text(),'Traslados')]")).click();

        //ingreamos "cordoba" en y seleccionamos la opcion "aeropuerto Taravella"
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus.sbox-origin")).sendKeys("Cordoba");
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Taravella')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Taravella')]")).click();

        //ingresamos "sava" y seleccionamos la palabra para seleccionar el hotel de Santa Fe
        driver.findElement(By.cssSelector("input[placeholder='Ingresa un hotel o dirección adónde quieras ir']")).sendKeys("Sava");
        espera.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div.ac-container ul li"))));
        driver.findElement(By.cssSelector("div.ac-container ul li")).click();


        //seleccionamos el campo fecha e ingresamos "22 de noviembre"
        driver.findElement(By.cssSelector("input.input-tag.sbox-checkin")).click();
        List<WebElement> seleccionarHora = driver.findElements(By.xpath("//span[@class='_dpmg2--date-number' and contains(text(),'22')]"));
        for (WebElement elemento : seleccionarHora) {
            if (elemento.getText().equals("22")) {
                elemento.click();
                break;
            }
        }
        //seleccionamos la hora "07:00"
        Select hora = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-time-arrival")));
        hora.selectByVisibleText("07:00");

        //click en pasajeros
        driver.findElement(By.cssSelector("div.sbox-3-input.-md.sbox-distri-input")).click();
        WebElement pasajeros = driver.findElement(By.cssSelector("a.steppers-icon-right.sbox-3-icon-plus"));

        int numeroPasajero = 12;
        //click doce veces en el boton (+) de la opcion pasajeros
        for (int i = 0; i < 12; i++) {
            pasajeros.click();
        }

        //click en el boton buscar
        driver.findElement(By.cssSelector("i.input-icon.sbox-3-icon-search")).click();


        espera.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div.search-cluster.ng-scope.ng-hide"))));
        //validacion de la cantidad de resultados de autos
        List<WebElement> listadoAutos = driver.findElements(By.cssSelector("div.search-cluster.ng-scope.ng-hide"));
        System.out.println(listadoAutos.size());
        int totalAutos = listadoAutos.size();
        int totalAutosEsperado = 2;
        assertEquals(totalAutosEsperado,totalAutos);

        //validacion de la cantidad de personas por vehiculo
        WebElement chek = driver.findElement(By.cssSelector(".search-view-items-container > div:nth-of-type(3) span:nth-of-type(1) > span:nth-of-type(1) > span:nth-of-type(1) > span:nth-of-type(2)"));
        System.out.println(chek.getText());
        assertEquals("14 personas por vehículo", chek.getText());

    }

    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }

    }

    @AfterClass
    public static void closeAll() {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");

    }
}

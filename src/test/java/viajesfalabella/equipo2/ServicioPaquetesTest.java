package viajesfalabella.equipo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServicioPaquetesTest {

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
        espera= new WebDriverWait(driver, 10);


    }

    @Test
    public void caso03() {

        //click en habitaciones
        driver.findElement(By.cssSelector("div.sbox-distri-container")).click();
        int i=0;
        //click tres veces en (+) en campo "adultos"
        while(i<3) {
          //  driver.findElement(By.cssSelector("div._pnlpk-panel__blocks._pnlpk-dynamicContent  a.steppers-icon-right.sbox-3-icon-plus")).click();
            driver.findElement(By.xpath("//div[contains(@class,'_pnlpk-dynamicContent')]/following:: label[contains(text(),'A')] /following::a[contains(@class,'plus')] ")).click();
            i++;
        }
        //click tres veces en (+) en campo "menores"
        for (int j = 0; j < 3; j++)
           // driver.findElement(By.cssSelector("div._pnlpk-panel__blocks._pnlpk-dynamicContent ._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus")).click();
            driver.findElement(By.xpath("//div[contains(@class,'_pnlpk-dynamicContent')]/following:: label[contains(text(),'M')] /following::a[contains(@class,'plus')] ")).click();


        //se obtiene el mensaje y se almacena en una variable String
        List<WebElement> options_list = driver.findElements(By.cssSelector("div._pnlpk-tooltip"));
        String resultado = "";
        for (WebElement l: options_list)
        {

            resultado += l.getText();

        }

        assertEquals("Solo puedes hacer búsquedas de hasta 8 personas",resultado);
    }

    @Test
    public void caso04() {

        //ingresamos la palabra cordoba en el campo "origen"
        driver.findElement(By.xpath("//input[contains(@class,'sbox-places-first')]")).sendKeys("cordoba");
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Córdoba, Córdoba, Argentina')]")));

        List<WebElement> listaAlojamientos = driver.findElements(By.cssSelector("div.ac-container ul>li"));
        //recorre la lista y compara cual es igual a Córdoba, Córdoba, Argentina y en caso que se encuentre hace click
        for (WebElement elemento : listaAlojamientos) {
            if (elemento.getText().equals("Córdoba, Córdoba, Argentina")) {
                elemento.click();
                break;
            }
        }
        //ingresamos la palabra cordoba en el campo destino
        driver.findElement(By.xpath("//input[contains(@class,'sbox-places-second')]")).sendKeys("cordoba");
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Córdoba, Córdoba, Argentina')]")));

        List<WebElement> listaDestino = driver.findElements(By.cssSelector("div.ac-container ul>li"));
        //recorre la lista y compara cual es igual a Córdoba, Córdoba, Argentina y en caso que se encuentre hace click
        for (WebElement elemento : listaDestino) {
            if (elemento.getText().equals("Córdoba, Córdoba, Argentina")) {
                elemento.click();
                break;
            }
        }
        //click en la opcion "todavia no he decidido la fecha"
        driver.findElement(By.xpath("//span[contains(text(),'Todavía no he decidido la fecha')]")).click();

        //seleccionamos el mes enero del año 2022
        Select meses = new Select(driver.findElement(By.xpath("//select[contains(@class,'month')]")));
        meses.selectByVisibleText("Enero 2022");

        //click en el boton buscar
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();
        String resultado= driver.findElement(By.xpath("//span[contains(text(),'El destino debe ser diferente del origen.')]")).getText();
        assertEquals("El destino debe ser diferente del origen.",resultado);
    }

    @Test
    public void caso05()  throws InterruptedException{
        //ingresamos la palabra "cordoba" en el campo origen
        driver.findElement(By.xpath("//input[contains(@class,'sbox-places-first')]")).sendKeys("cordoba");
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Córdoba, Córdoba, Argentina')]")));
        List<WebElement> listaAlojamientos = driver.findElements(By.cssSelector("div.ac-container ul>li"));
        //recorre la lista y compara cual es igual a Córdoba, Córdoba, Argentina y en caso que se encuentre hace click
        for (WebElement elemento : listaAlojamientos) {
            if (elemento.getText().equals("Córdoba, Córdoba, Argentina")) {
                elemento.click();
                break;
            }
        }
        //ingresa la palabra "buenos aires" en el campo destino
        driver.findElement(By.xpath("//input[contains(@class,'sbox-places-second')]")).sendKeys("buenos aires");
        espera.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div.ac-container ul li"))));



        //ingresamos en el campo "fecha ida" y seleccionamos la fecha 1 de diciembre
        driver.findElement(By.cssSelector("div.ac-container ul>li")).click();
        driver.findElement(By.cssSelector("input.input-tag.sbox-checkin-date")).click();
        List<WebElement> seleccionIda = driver.findElements(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-3']//span[contains(text(),'1')]"));
        for (WebElement elemento:seleccionIda) {
            if(elemento.getText().equals("1")) {
                elemento.click();
                break;
            }
        }



        //inngresamos en el campo "fecha vuelta" y seleccionamos la fecha 11 de diciembre
        List<WebElement> options_list = driver.findElements(By.cssSelector("span._dpmg2--date._dpmg2--available"));
        for (WebElement l: options_list) {
            if (l.getText().contains("11")) {
                l.click();
                break;
            }
        }



        //click en el boton buscar
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='accommodation-name -eva-3-ellipsis' and contains(text(),'Broadway Hotel & Suites')]")));
        driver.findElement(By.xpath("//span[@class='accommodation-name -eva-3-ellipsis' and contains(text(),'Broadway Hotel & Suites')]")).click();



        Thread.sleep(5000);
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
         driver.switchTo().window((String) tabs.get(1));  //hacemos foco en la otra pestaña



        double valorAnterior = Double.parseDouble(driver.findElement(By.xpath("//span[@class='main-value']")).getText());
        String precio[]= driver.findElement(By.xpath("//p[@class='price']")).getText().split(" ");
        double valorSuite = Double.parseDouble(precio[1]);
        driver.findElement(By.xpath("//p[contains(text(),'Seleccionar')]")).click();
        double valorActual =  Double.parseDouble(driver.findElement(By.xpath("//span[@class='main-value']")).getText());
        assertTrue(valorActual==(valorSuite/2)+valorAnterior);


    }

    @After
    public void close() {
        if (driver != null) {
             driver.quit();
        }

    }

    @AfterClass
    public static void closeAll() {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");

    }

}

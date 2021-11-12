package viajesfalabella.equipo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPaquetes {

    private WebDriver driver;

    @BeforeClass
    public static void Setup(){
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void init(){
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.viajesfalabella.cl/");

    }




    @Test
    public void paqueteTuristicoVueloyAuto() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina

        driver.findElement(By.xpath("//label[contains(text(),'Paquetes')]")).click();

        driver.findElement(By.cssSelector("input[class='sbox-bundle-input sbox-radio-va sbox-radio-selected-box'] ")).click();




//Origen
        WebElement busqueda = driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline']"));

        busqueda.sendKeys("santiago");
        WebDriverWait wait =  new WebDriverWait(driver,15); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac-group-container']//child::ul/li[1]")));
        busqueda.sendKeys(Keys.ARROW_DOWN);
        busqueda.sendKeys(Keys.ENTER);
//Destino
        WebElement destino =  driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));

        //
        destino.sendKeys("Miami");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac-group-container']//child::ul/li[1]/span/em[contains(text(),Miami)]")));
        destino.sendKeys(Keys.ARROW_DOWN);
        destino.sendKeys(Keys.ENTER);

        //Fecha
        driver.findElement(By.xpath("//input[@placeholder='Ida']")).click();
        asignarFechaDisponible(2);
        driver.findElement(By.xpath("//input[@placeholder='Vuelta']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Vuelta']")).click();
        asignarFechaDisponible(3);
        //Click en Buscar
        driver.findElement(By.cssSelector("a.sbox-search")).click();


        //Espera que se carguen los resultados del viaje
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='itinerary-info-title']//child::span[contains(text(),'Tu viaje a Miami')]")));


        String esperado = driver.findElement(By.xpath("//div[@class='itinerary-info-title']//child::span[contains(text(),'Tu viaje a Miami')]")).getText();

        Assert.assertEquals(esperado,"Tu viaje a Miami");


    }

    @Test
    public void PaqueteTuristicoMasDe8Personas() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina
        driver.findElement(By.xpath("//label[contains(text(),'Paquetes')]")).click();
        driver.findElement(By.cssSelector("input[class='sbox-bundle-input sbox-radio-va sbox-radio-selected-box'] ")).click();
//Origen
        WebElement busqueda = driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline']"));
        busqueda.sendKeys("santiago");
        WebDriverWait wait =  new WebDriverWait(driver,10); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac-group-container']//child::ul/li[1]")));
        busqueda.sendKeys(Keys.ARROW_DOWN);
        busqueda.sendKeys(Keys.ENTER);
//Destino
        WebElement destino =  driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));
        //
        destino.sendKeys("Miami");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac-group-container']//child::ul/li[1]/span/em[contains(text(),Miami)]")));
        destino.sendKeys(Keys.ARROW_DOWN);
        destino.sendKeys(Keys.ENTER);
        //Fecha
        driver.findElement(By.xpath("//input[@placeholder='Ida']")).click();
        asignarFechaDisponible(2);
        driver.findElement(By.xpath("//input[@placeholder='Vuelta']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Vuelta']")).click();
        asignarFechaDisponible(3);
        driver.findElement(By.cssSelector(".sbox-distri-input > div:nth-child(1)")).click();
        for (int i = 0; i<5;i++ ) {
            driver.findElement(By.xpath("//div[@class='number-picker sbox-3-steppers -md']//child::a[@class='steppers-icon-right sbox-3-icon-plus']")).click();
        }

        driver.findElement(By.xpath("//div[@class='number-picker sbox-3-steppers -md']//child::a[@class='steppers-icon-right sbox-3-icon-plus']")).click();
        String q= driver.findElement(By.cssSelector("body > div.distpicker.distpicker-passengers-packages.sbox-v4-components > div > div._pnlpk-panel-scroll > div._pnlpk-panel__blocks > div > div._pnlpk-itemBlock__itemRows._pnlpk-dynamicContent > div > div:nth-child(1) > div._pnlpk-itemRow__item._pnlpk-stepper-adults.-medium-down-to-lg > div > div > div > span")).getText();
        //System.out.println("resultado: "+s);
        //   String mensaje = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/div/div")).getText();
        //String esperado = "Solo puedes hacer búsquedas de hasta 8 personas";
        Assert.assertEquals("Solo puedes hacer búsquedas de hasta 8 personas",q);
    }



    @Test
    public void atc03() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina

        driver.findElement(By.xpath("//label[contains(text(),'Paquetes')]")).click();

        driver.findElement(By.cssSelector("input[class='sbox-bundle-input sbox-radio-vhh sbox-radio-selected-box'] ")).click();


        WebElement busqueda = driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline']"));

        busqueda.sendKeys("Rancagua");
        WebDriverWait wait =  new WebDriverWait(driver,15); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac-group-container']//child::ul/li[1]/span[@class='item-text']/em[contains(text(),'Rancagua')]")));
        busqueda.sendKeys(Keys.ARROW_DOWN);
        busqueda.sendKeys(Keys.ENTER);

        WebElement destino =  driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));

        destino.sendKeys("ciudad de Buenos");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div[1]/ul")));
        destino.sendKeys(Keys.ARROW_DOWN);
        destino.sendKeys(Keys.ENTER);


// fecha de ida y regreso

        driver.findElement(By.xpath("//input[@placeholder='Ida']")).click();
        asignarFechaDisponible(2);
        driver.findElement(By.xpath("//input[@placeholder='Vuelta']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Vuelta']")).click();
        asignarFechaDisponible(9);




        //fecha alojamiento 1
        driver.findElement(By.cssSelector("input[class='input-tag sbox-hotel-first-checkout-date']")).click();
        asignarFechaDisponible(5);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/div[2]/button[2]/em")).click();
        //segundo destino
        WebElement destinoAlojo2 =  driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-hotel-second-destination sbox-primary undefined']"));

        destinoAlojo2.sendKeys("mendoza");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div/ul/li[1]")));
        destinoAlojo2.sendKeys(Keys.ARROW_DOWN);
        destinoAlojo2.sendKeys(Keys.ENTER);



        //habitaciones

        driver.findElement(By.cssSelector("div.sbox-distri-container")).click();
        int i=0;
        //click tres veces en (+) en campo "adultos"
        while(i<2) {
            driver.findElement(By.cssSelector("div._pnlpk-panel__blocks._pnlpk-dynamicContent  a.steppers-icon-right.sbox-3-icon-plus")).click();
            i++;
        }

        driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-hotel-second-destination sbox-primary undefined']")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();
        Thread.sleep(3000);
        //obtener mensaje de vuelos
        String vuelosEsperados = driver.findElement(By.xpath("//span[contains(text(), 'Este es el vuelo más conveniente ')]")).getText();
        String esperado= "Este es el vuelo más conveniente";
        Assert.assertEquals(esperado,vuelosEsperados);


    }
    public void asignarFechaDisponible(int dias) {
        List<WebElement> fechas = driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        fechas.get(dias).click();
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
package viajesfalabella.equipo5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Traslados {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public static void Setup(){
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);

        //Navegar a página
        driver.get("https://www.viajesfalabella.cl/");
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }

    }

    @Test
    public void Traslados01_TrasladosPrivados() {
        String origen = "Aeropuerto Arturo Merino Benitez, Santiago de Chile, Chile";
        String destino = "Hotel W Santiago - Isidora Goyenechea, Las Condes, Chile";

        //Cambio de pestaña
        driver.findElement(By.xpath("//label[contains(text(),'Traslados')]")).click();

        //Origen
        WebElement inputOrigen = driver.findElement(By.xpath("//label[contains(text(),'Desde')]/following-sibling::input"));
        inputTexto(inputOrigen, origen);

        //Destino
        WebElement inputDestino = driver.findElement(By.xpath("//label[contains(text(),'Hasta')]/following-sibling::input"));
        inputTexto(inputDestino, destino);

        //Fecha
        WebElement fecha = driver.findElement(By.xpath("//input[@placeholder='Arribo']"));
        fecha.click();
        asignarFechaDisponible(10);

        //Hora
        Select hora = new Select(driver.findElement(By.xpath("//span[contains(text(),'hora')]/following-sibling::div//select")));
        hora.selectByVisibleText("08:00");

        //Click en Buscar
        driver.findElement(By.cssSelector("a.sbox-search")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'Compra con tranquilidad. Si tus planes cambian, puedes modificar tu viaje.')]")));

        //Filtro privados
        driver.findElement(By.xpath("//span[contains(text(),'Traslados privados')]")).click();

        //Comprobacion
        boolean soloTrasladosPrivados = true;
        List<WebElement> trasladosPrivados = driver.findElements(By.xpath("//div[@class='search-cluster ng-scope']//h1/strong"));
        for(WebElement item : trasladosPrivados){
            if(!item.getText().contains("Privado")){
                soloTrasladosPrivados = false;
            }
        }
        assertTrue(soloTrasladosPrivados);
    }

    @Test
    public void Traslados02_DestinoModificado(){
        String origen = "Aeropuerto Arturo Merino Benitez";
        String destino = "Hotel W Santiago - Isidora Goyenechea, Las Condes, Chile";
        String nuevoDestino = "Hotel Marriott Santiago";

        //Cambio de pestaña
        driver.findElement(By.xpath("//label[contains(text(),'Traslados')]")).click();

        //Origen
        WebElement inputOrigen = driver.findElement(By.xpath("//label[contains(text(),'Desde')]/following-sibling::input"));
        inputTexto(inputOrigen, origen);

        //Destino
        WebElement inputDestino = driver.findElement(By.xpath("//label[contains(text(),'Hasta')]/following-sibling::input"));
        inputTexto(inputDestino, destino);

        //Fecha
        WebElement fecha = driver.findElement(By.xpath("//input[@placeholder='Arribo']"));
        fecha.click();
        asignarFechaDisponible(10);

        //hora
        Select hora = new Select(driver.findElement(By.xpath("//span[contains(text(),'hora')]/following-sibling::div//select")));
        hora.selectByVisibleText("08:00");

        //Buscar
        driver.findElement(By.cssSelector("a.sbox-search")).click();

        //Modificar
        WebElement btnModificar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//em[contains(text(),'Modificar')]")));
        btnModificar.click();

        //Cambia destino
        WebElement inputModificar = driver.findElement(By.xpath("//label[contains(text(),'Hasta')]/following-sibling::input"));
        inputModificar.clear();
        inputTexto(inputModificar, nuevoDestino);

        //Buscar
        driver.findElement(By.cssSelector("a.sbox-search")).click();

        //Espera
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[contains(text(),'"+ nuevoDestino + "')]")));

        //Abre mapa
        driver.findElement(By.xpath("//a[contains(text(),'Ver mapa')]")).click();

        //Obtiene resultados
        List<WebElement> markers = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.marker-container")));
        String resultado = "";
        for(WebElement item: markers){
            item.click();
            String texto = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".gm-style-iw .bold"))).getText();
            resultado += texto + " ";

        }
        resultado.trim();

        //Comprobacion
        assertTrue(resultado.contains(origen));
        assertTrue(resultado.contains(nuevoDestino));
    }

    @Test
    public void Traslados03_DetalleDeTraslado(){
        String destino = "Aeropuerto Arturo Merino Benitez";
        String origen = "Hotel W Santiago - Isidora Goyenechea, Las Condes, Chile";

        //Carga seccion
        driver.findElement(By.xpath("//label[contains(text(),'Traslados')]")).click();

        //Marca casilla
        driver.findElement(By.xpath("//span[contains(text(),' Hacia el aeropuerto')]")).click();

        //Origen
        WebElement inputOrigen = driver.findElement(By.xpath("//label[contains(text(),'Desde')]/following-sibling::input"));
        inputTexto(inputOrigen, origen);

        //Destino
        WebElement inputDestino = driver.findElement(By.xpath("//label[contains(text(),'Hasta')]/following-sibling::input"));
        inputTexto(inputDestino, destino);

        //Fecha
        driver.findElement(By.xpath("//input[@placeholder='Partida']")).click();
        asignarFechaDisponible(10);

        //Hora
        Select hora = new Select(driver.findElement(By.cssSelector("select.sbox-time-departure")));
        hora.selectByVisibleText("08:00");

        //Agrega pasajeros
        driver.findElement(By.cssSelector(".sbox-distribution .input-container")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._pnlpk-stepper-adults .sbox-3-icon-plus")));
        driver.findElement(By.cssSelector("._pnlpk-stepper-adults .sbox-3-icon-plus")).click();
        //Agrega menor
        driver.findElement(By.cssSelector("._pnlpk-stepper-minors .sbox-3-icon-plus")).click();
        Select menor = new Select(driver.findElement(By.cssSelector("._pnlpk-minors-age-select-wrapper select")));
        menor.selectByVisibleText("13 años");
        //Confirma
        driver.findElement(By.xpath("//a[contains(text(),'Aplicar')]")).click();

        //Click en Buscar
        driver.findElement(By.cssSelector("a.sbox-search")).click();

        //Espera página y selecciona traslado
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//em[contains(text(),'Comprar')]"))).click();

        //Espera que cargue la página
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'¡Falta poco! Completa tus datos y finaliza tu compra')]")));

        //Obtiene Resutlados
        String resultadoOrigen = driver.findElement(By.cssSelector("#transfer-pickup-T0 p")).getText();
        String resultadoDestino = driver.findElement(By.cssSelector("#transfer-dropoff-T0 p")).getText();
        String resultadoPasajeros = driver.findElement(By.cssSelector("#pricebox-list-detail p span")).getText();

        //Comprobacion
        assertTrue(origen.contains(resultadoOrigen));
        assertTrue(destino.contains(resultadoDestino));
        assertEquals("Traslado para 4 personas", resultadoPasajeros);
    }

    public void inputTexto(WebElement input, String valor){
        input.sendKeys(valor);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.ac-group-items")));
        input.sendKeys(Keys.ENTER);
    }

    public void asignarFechaDisponible(int dias){
        List<WebElement> fechas = driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        fechas.get(dias).click();
    }
}


package viajesfalabella.equipo5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Paquetes {
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
        wait = new WebDriverWait(driver, 30);

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
    public void Paquetes01_PaqueteRecomendado(){
        WebElement NavegadorPaquete = driver.findElement(By.cssSelector("a[title=Paquetes]"));
        NavegadorPaquete.click();
        List <WebElement> Paquetes = driver.findElements(By.cssSelector("a[class=offer-card-clickeable]"));
        Paquetes.get(0).click();
        WebElement modal = driver.findElement(By.cssSelector("a[class='date-box']"));
        modal.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs1.get(1));

        wait.until(ExpectedConditions.titleIs("Viajes Falabella"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Ver detalle')]"))).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs2.get(1));

        wait.until(ExpectedConditions.titleIs("Viajes Falabella"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='detail-wrapper eva-3-row -no-gutter']")));

        String VueloTitulo =  driver.findElement(By.cssSelector("span[class='title']")).getText();
        String Alojamiento = driver.findElement(By.cssSelector("ib-hotel .title")).getText();
        String traslado_compartido = driver.findElement(By.cssSelector("ib-transfer .title")).getText();
        String AlojamientoTituloEsperado = "ALOJAMIENTO";
        String TrasladoCompartido = "TRASLADO COMPARTIDO";
        String VueloTituloEsperado = "VUELO";

        Assert.assertEquals(AlojamientoTituloEsperado,Alojamiento);
        Assert.assertEquals(TrasladoCompartido,traslado_compartido);
        Assert.assertEquals(VueloTituloEsperado,VueloTitulo);
    }

    @Test
    public void Paquetes02_PrecioFinalCoincide() {

        String origen = "Santiago de Chile, Santiago, Chile";
        String destino = "Miami Beach, Florida, Estados Unidos";
        String segundoDestino = "Miami, Florida, Estados Unidos";

        //Cambio de pestaña
        driver.findElement(By.xpath("//label[contains(text(),'Paquetes')]")).click();

        driver.findElement(By.cssSelector(".sbox-bundle-vhh input")).click();

        //Origen
        WebElement inputOrigen = driver.findElement(By.xpath("//label[contains(text(),'Origen')]/following-sibling::input"));
        inputTexto(inputOrigen, origen);

        //Destino
        WebElement inputDestino = driver.findElement(By.xpath("//label[contains(text(),'Destino')]/following-sibling::input"));
        inputTexto(inputDestino, destino);

        //Fecha Ida
        driver.findElement(By.xpath("//input[@placeholder='Ida']")).click();
        asignarFechaDisponible(1);
        asignarFechaDisponible(7);

        //Fecha hasta
        driver.findElement(By.xpath("//input[@placeholder='Hasta']")).click();
        asignarFechaDisponible(4);

        //Segundo Destino
        WebElement inputSegundoDestino = driver.findElement(By.xpath("//label[contains(text(),'Segundo destino')]/following-sibling::input"));
        inputTexto(inputSegundoDestino, segundoDestino);

        //Click en Buscar
        driver.findElement(By.cssSelector("a.sbox-search")).click();

        //Espera que se carguen los resultados y navega por las paginas
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Este es el vuelo más conveniente')]")));
        driver.findElement(By.xpath("//trips-cluster-selected//buy-button//a")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//aloha-cluster-pricebox-container//aloha-button/button"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//aloha-infobox-wrapper-container//em[contains(text(),'Siguiente')]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//aloha-cluster-pricebox-container//aloha-button/button"))).click();

        //Toma el precio
        String precio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//aloha-summary-price//p/span"))).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//aloha-infobox-wrapper-container//em[contains(text(),'Siguiente')]"))).click();

        //Espera que cargue la página y toma el precio
        String resultado = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#chk-total-price span.amount"))).getText();

        //Limpia el precio
        precio = precio.replace("$ ", "");


        int precioFinal = Integer.parseInt(precio.replace(".",""));

        //Saca el digito mas pequeño
        int resultadoFinal = Integer.parseInt(resultado.replace(".",""));

        //Comprobacion
        Assert.assertEquals(precioFinal, resultadoFinal, 100);
    }

    @Test
    public void Paquetes03_DetalleDePaquete() {

        String origen = "Santiago de Chile, Santiago, Chile";
        String destino = "Miami Beach, Estados Unidos";

        //Cambio de pestaña
        driver.findElement(By.xpath("//label[contains(text(),'Paquetes')]")).click();

        //Origen
        WebElement inputOrigen = driver.findElement(By.xpath("//label[contains(text(),'Origen')]/following-sibling::input"));
        inputTexto(inputOrigen, origen);

        //Destino
        WebElement inputDestino = driver.findElement(By.xpath("//label[contains(text(),'Destino')]/following-sibling::input"));
        inputTexto(inputDestino, destino);

        //Fecha
        driver.findElement(By.xpath("//input[@placeholder='Ida']")).click();
        asignarFechaDisponible(10);
        asignarFechaDisponible(20);

        //Click en Buscar
        driver.findElement(By.cssSelector("a.sbox-search")).click();

        //Espera que se carguen los resultados
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Este es el paquete perfecto para tí. ¡Empieza a vivir tu viaje!')]")));

        //Toma Hotel
        String hotel = driver.findElement(By.cssSelector("span.accommodation-name")).getText();


        //Cambia pestaña
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.close();
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        //Toma habitacion
        String habitacion = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.room-name"))).getText();

        //Avanza
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Este es el vuelo más conveniente')]")));
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]")).click();

        //Agrega Traslado
        WebElement btnTraslado = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.highlight-card-container.TRANSFER")));
        btnTraslado.click();
        driver.findElement(By.xpath("//a/em[contains(text(),'Agregar')]")).click();
        String traslado = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("app-transfer-highlight-card .added-product-title"))).getText();

        //Agrega Auto
        WebElement btnAuto = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-car-card//button/em")));
        btnAuto.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-car-modal//a"))).click();
        String auto = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("app-car-card .added-product-title"))).getText();

        //Agrega Actividad
        WebElement btnActividad = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.highlight-card-container.ACTIVITY button em")));
        btnActividad.click();
        String actividad = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("app-activity-highlight-card .added-product-title"))).getText();

        //Toma el vuelo
        List<WebElement> vuelo = driver.findElements(By.cssSelector("wizard-step-content-flight .title span"));
        String vueloSalida = vuelo.get(0).getText();
        String vueloDestino = vuelo.get(1).getText();

        //Carga la pagina de pago
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pricebox-overlay\"]//em"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(.,'Detalle de pago')]")));

        //Comprobacion vuelo
        String resultadoVuelo = driver.findElement(By.cssSelector(".product-specific-modif-FLIGHT .eva-3-h3 ")).getText();
        assertTrue(resultadoVuelo.contains(vueloDestino));
        assertTrue(resultadoVuelo.contains(vueloSalida));

        //Comprobacion hotel
        String resultadoHotel = driver.findElement(By.cssSelector(".product-specific-modif-HOTEL .eva-3-h3 ")).getText();
        assertEquals(hotel, resultadoHotel);

        //Comprobacion Auto
        String resultadoAuto = driver.findElement(By.cssSelector(".product-specific-modif-CAR .eva-3-h3 ")).getText();
        assertEquals(auto, resultadoAuto);

        //Comprobacion Actividad
        String resultadoActividad = driver.findElement(By.cssSelector(".product-specific-modif-TICKET .eva-3-h3 ")).getText();
        assertEquals(actividad.toLowerCase(), resultadoActividad.toLowerCase());

        //Comprobacion Traslado
        String resultadoTraslado = driver.findElement(By.cssSelector(".product-specific-modif-TRANSFER .eva-3-h3 ")).getText();

        traslado = traslado.replace("Traslado Ida Y Vuelta", "");
        String[] trasladoPuntos = traslado.split("-");

        String trasladoOrigen = trasladoPuntos[0].trim();
        String trasladoDestino = trasladoPuntos[1].trim();
        assertTrue(resultadoTraslado.contains(trasladoOrigen));
        assertTrue(resultadoTraslado.contains(trasladoDestino));

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

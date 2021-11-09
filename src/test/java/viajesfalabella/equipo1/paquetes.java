package viajesfalabella.equipo1;

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

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class paquetes {
    private WebDriver driver;
    private int segundosEspera = 30;


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
        // ESPERA IMPLICITA
        esperaImplicita();
        // TOMAMOS LAS CATEGORIAS Y LAS METEMOS EN UNA LISTA
        List<WebElement> categorias = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
        // SELECCIONAMOS LA PAGINA DESTINO
        busqueda(categorias, "Paquetes");
        // ESPERA IMPLICITA PARA LA CARGA DE LA PAGINA
        esperaImplicita();
    }

    private void esperaImplicita(){
        driver.manage().timeouts().implicitlyWait(segundosEspera, TimeUnit.SECONDS);
    }

    private void busqueda(List<WebElement> lista,String palabra){
        for (WebElement l: lista){
            // System.out.println("- "+l.getText());
            // RECORREMOS LA LISTA HASTA ENCONTRAR LA PALABRA REQUERIDA
            if (l.getText().contains(palabra)){
                // HACEMOS CLICK EN LA CATEGORIA SELECCIONADA
                l.click();
                break;
            }
        }
    }

    private void mostrar(List<WebElement> lista){
        for (WebElement l: lista){
            System.out.println("elemento: "+l.getText());
        }
    }

    private void seleccionar (String texto, String comparar, String cssCuadro, String cssResultados){
        WebDriverWait espera = new WebDriverWait(driver,segundosEspera);
        driver.findElement(By.cssSelector(cssCuadro)).sendKeys(texto);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssResultados)));
        List<WebElement> resultados = driver.findElements(By.cssSelector(cssResultados));
        busqueda(resultados,comparar);
    }

    private void seleccionarxpath (String texto, String comparar, String cssCuadro, String cssResultados){
        WebDriverWait espera = new WebDriverWait(driver,segundosEspera);
        driver.findElement(By.xpath(cssCuadro)).sendKeys(texto);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssResultados)));
        List<WebElement> resultados = driver.findElements(By.cssSelector(cssResultados));
        busqueda(resultados,comparar);
    }

    private void buscarCalendario(int diaBuscado, List<WebElement> mes){
        String dia = Integer.toString(diaBuscado);
        busqueda(mes,dia);
    }

    private void adultos (int real, int esperado){
        while (esperado != real){
            if (real > esperado){
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-left.sbox-3-icon-minus")).click();
                real--;
            }
            else{
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-right.sbox-3-icon-plus")).click();
                real++;
            }
        }
    }

    private void calendario (int fecha1, int fecha2){
        // LISTA CALENTARIO ACTUAL
        List<WebElement> mesActual = driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        // INGRESAR FECHAS
        // TOMAMOS EL DIA ACTUAL
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        int diaActual = Integer.parseInt(dia);
        // ULTIMO DIA DEL CALENDARIO ACTUAL
        String diaMax = mesActual.get(mesActual.size()-1).getText();
        int diaUltimo = Integer.parseInt(diaMax);
        // LA FECHA ACTUAL + 1 DIA PASA AL SIGUIENTE MES?
        if (diaActual+fecha2 < diaUltimo){
            buscarCalendario(diaActual+fecha1,mesActual);
            buscarCalendario(diaActual+fecha2,mesActual);
        }
        else{
            if (diaActual+fecha1 < diaUltimo){
                buscarCalendario(diaActual+fecha1,mesActual);
                driver.findElement(By.cssSelector("body > div.datepicker-packages.sbox-v4-components > div > div._dpmg2--controlsWrapper > div._dpmg2--controls-next > i")).click();
                mesActual= driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
                buscarCalendario(diaActual+fecha2-diaUltimo,mesActual);
            }
            else {
                driver.findElement(By.cssSelector("body > div.datepicker-packages.sbox-v4-components > div > div._dpmg2--controlsWrapper > div._dpmg2--controls-next > i")).click();
                mesActual= driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
                buscarCalendario(diaActual+fecha1-diaUltimo,mesActual);
                buscarCalendario(diaActual+fecha2-diaUltimo,mesActual);
            }
        }
    }

    @Test
    public void CdP03_busquedaPaquetes() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver,segundosEspera);
        List<WebElement> paquetesTuristicos = driver.findElements(By.cssSelector("span.sbox-bundle input"));
        // OPCIONES:
        // vh: VUELO + 1 ALOJAMIENTO
        // vhh: VUELO + 2 ALOJAMIENTOS
        // va: VUELO + AUTO
        // SELECCIONAMOS VUELO + 1 ALOJAMIENTO
        busqueda(paquetesTuristicos,"vh");

        // SELECCIONAMOS LA CASILLA ORIGEN
        seleccionar("santiago","Santiago de Chile","div.sbox-place-container input","div.ac-container span");
        // SELECCIONAMOS LA CASILLA DESTINO
        seleccionar("san pedro","San Pedro de Atacama","div.sbox-second-place-container input","div.ac-container span");

        // LLENAMOS LOS CAMPOS DE FECHAS
        driver.findElement(By.cssSelector("[placeholder='Ida']")).click();
        // CALENDARIO
        // INGRESAR DIAS AGREGADOS A AMBAS FECHAS
        // EL PRIMER CAMPO DEBE SER MENOR QUE EL SEGUNDO
        calendario(1,2);
        // PASAJEROS
        driver.findElement(By.cssSelector("div.sbox-distri-input-container")).click();
        String num =driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        int valorActual = Integer.parseInt(num);
        // CANTIDAD DE ADULTOS DEBE SER IGUAL A 2
        adultos(valorActual,2);
        // BUSCAMOS RESULTADOS
        driver.findElement(By.cssSelector("div.sbox-button-container a")).click();
        // ESPERAMOS QUE CARGUE LA PAGINA
        esperaImplicita();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.results-cluster-container")));
        // CANTIDAD DE RESULTADOS
        int lista = driver.findElements(By.cssSelector("div.results-cluster-container")).size();
        assertTrue(lista>1);
    }

    @Test
    public void CdP02_busquedaPaquetes(){
        // ESPERA EXPLICITA
        WebDriverWait espera = new WebDriverWait(driver,segundosEspera);
        // SELECCIONAMOS LA CASILLA ORIGEN
        seleccionar("santiago","Santiago de Chile","div.sbox-place-container input","div.ac-container span");
        // SELECCIONAMOS LA CASILLA DESTINO
        seleccionar("buenos aires","Ciudad de Buenos Aires","div.sbox-second-place-container input","div.ac-container span");
        calendario(1,2);
        driver.findElement(By.cssSelector("div.sbox-button-container a")).click();
        esperaImplicita();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cluster-content")));
        String ciudad =  driver.findElement(By.cssSelector("div.cluster-content div.cluster-description-wrapper span.-eva-3-tc-gray-2")).getText();
        Pattern patron = Pattern.compile("Buenos Aires");
        Matcher m = patron.matcher(ciudad);
        boolean e = m.find();
        String res = String.valueOf(e);
        assertEquals("true",res);
    }

    @Test
    public void CdP01_agregarPaquete() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver,segundosEspera);
        List<WebElement> paquetesTuristicos = driver.findElements(By.cssSelector("span.sbox-bundle input"));
        // OPCIONES:
        // vh: VUELO + 1 ALOJAMIENTO
        // vhh: VUELO + 2 ALOJAMIENTOS
        // va: VUELO + AUTO
        // SELECCIONAMOS VUELO + 1 ALOJAMIENTO
        busqueda(paquetesTuristicos,"vhh");

        // SELECCIONAMOS LA CASILLA ORIGEN
        seleccionar("bue","Ciudad de Buenos Aires","div.sbox-place-container input","div.ac-container span");
        // SELECCIONAMOS LA CASILLA DESTINO
        seleccionar("esp","Cataluña","div.sbox-second-place-container input","div.ac-container span");

        // FECHAS IDA Y VUELTA
        driver.findElement(By.cssSelector("div.input-container.sbox-checkin-input-container input")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._dpmg2--show ._dpmg2--month-active span")));
        // dia actual

        // DIAS PAQUETE
        String busqIda = "4";
        String busqVuelta = "19";
        String busqHasta = "8";

        // TOMAMOS EL MES ACTUAL
        WebElement mes = driver.findElement(By.cssSelector("._dpmg2--show ._dpmg2--month-active span"));
        // ES ENERO?
        while (!mes.getText().contains("Enero")){
            // AVANZAMOS AL SIGUIENTE MES
            driver.findElement(By.cssSelector("body > div.datepicker-packages.sbox-v4-components > div > div._dpmg2--controlsWrapper > div._dpmg2--controls-next > i")).click();
            espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._dpmg2--show ._dpmg2--month-active span")));
            // TOMAMOS EL NOMBRE DEL MES SIGUIENTE
            mes = driver.findElement(By.cssSelector("._dpmg2--show ._dpmg2--month-active span"));
        }
        // TOMAMOS EL CALENDARIO DEL MES DE ENERO
        List<WebElement> mesEnero = driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        // BUSCAMOS Y SELECCIONAMOS LOS DIAS
        busqueda(mesEnero, busqIda);
        busqueda(mesEnero, busqVuelta);

        // FECHA HASTA
        // SACAMOS EL CALENDARIO ANTERIOR
        driver.findElement(By.cssSelector("div.sbox-bundles span.sbox-bundle.sbox-bundle-vhh")).click();
        // CLICK PARA INGRESAR LA 3ERA FECHA
        driver.findElement(By.cssSelector("div.input-container.sbox-hotel-first-date-end-input-container input")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._dpmg2--show ._dpmg2--month-active span")));
        mesEnero = driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        busqueda(mesEnero,busqHasta);

        // CASILLA SEGUNDO DESTINO
        seleccionarxpath("marbella","Andalucía","//label[contains(text(),'Segundo destino')]/following-sibling::input","div.ac-container span");

        /*
        driver.findElement(By.cssSelector("#searchbox > div > div > div > div.sbox-mobile-body.sbox-bind-disable-date.sbox-hotel-another-city-ui.sbox-hotel-partial-stay-ui.sbox-another-city-disabled-input.sbox-partial-stay-disabled > div.sbox-row.-wrap.-row-bottom > div.sbox-vhh-container.sbox-row.-mt2-l.-wrap > div.sbox-row.-wrap > div.sbox-row.vhh-module-container.-mb5-m.-mb3-s.-ml3-l.-wrap-s > div.sbox-places-group-container.sbox-row.-mb5-m.-wrap-s.-mr2-l.-mb3-s.sbox-places-without-rounded > div > div > div > div > input")).sendKeys("marbella");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-group-container ul li span")));
        List<WebElement> segundo = driver.findElements(By.cssSelector("div.ac-group-container ul li span"));
        busqueda(segundo, "Andalucía");
        */
        // HABITACIONES PERSONAS
        driver.findElement(By.cssSelector("div.sbox-distribution-picker-wrapper-ui")).click();
        String num =driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        int numero = Integer.parseInt(num);
        while (numero != 3){
            if (numero > 3){
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-left.sbox-3-icon-minus")).click();
                numero--;
            }
            else{
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-right.sbox-3-icon-plus")).click();
                numero++;
            }
        }

        driver.findElement(By.cssSelector("#searchbox > div > div > div > div.sbox-mobile-body.sbox-bind-disable-date.sbox-hotel-another-city-ui.sbox-hotel-partial-stay-ui.sbox-another-city-disabled-input.sbox-partial-stay-disabled > div.sbox-row.-wrap.-row-bottom > div.sbox-button.-ml3-l > div > a")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#currency")).click();
        List <WebElement> options = driver.findElements(By.cssSelector("#currency select option"));
        busqueda(options,"Dólares");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#order")).click();
        List <WebElement> options2 = driver.findElements(By.cssSelector("#order select option"));
        busqueda(options2, "convenientes");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#trips-cluster-selected-position > trips-cluster-selected > span > cluster > div > div > div.CLUSTER.cluster-pricebox-container > fare > span > span > div.mobile-container > buy-button > a > div")).click();
        Thread.sleep(2000);
        // List <WebElement> holiday = driver.findElements(By.cssSelector("body > aloha-app-root > aloha-results > div > div > div.results-wrapper.-eva-3-mt-xlg > div.results-column > div.results-items-wrapper > aloha-list-view-container > div.-eva-3-mb-xlg > aloha-cluster-container > div > div > div.cluster-content > div > div.cluster-description-wrapper.-eva-3-fwidth > div > aloha-cluster-accommodation-info-container > div.accommodation-name-wrapper > span"));
        List<WebElement> holiday = driver.findElements(By.cssSelector("body > aloha-app-root > aloha-results > div > div > div.results-wrapper.-eva-3-mt-xlg > div.results-column > div.results-items-wrapper > aloha-list-view-container > div.-eva-3-mb-xlg > aloha-cluster-container > div > div > div.cluster-content > div > div.cluster-description-wrapper.-eva-3-fwidth > div > aloha-cluster-accommodation-info-container > div.accommodation-name-wrapper > span"));
        mostrar(holiday);
        int contador = 0;
        for (WebElement l: holiday){
            // System.out.println("- "+l.getText());
            // RECORREMOS LA LISTA HASTA ENCONTRAR LA PALABRA REQUERIDA
            if (l.getText().contains("Holiday")){
                // HACEMOS CLICK EN LA CATEGORIA SELECCIONADA
                contador++;
                break;
            }
        }
        Assert.assertEquals(1,contador);
    }


    //div.pricebox-value-container > aloha-price-container > aloha-summary-price > p

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
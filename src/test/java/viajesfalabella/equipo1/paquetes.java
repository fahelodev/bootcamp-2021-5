package viajesfalabella.equipo1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private int segundosEspera = 25;
    private WebDriverWait espera;

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
        espera = new WebDriverWait(driver,segundosEspera);
        driver.findElement(By.cssSelector(cssCuadro)).sendKeys(texto);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssResultados)));
        List<WebElement> resultados = driver.findElements(By.cssSelector(cssResultados));
        busqueda(resultados,comparar);
    }

    private void seleccionarxpath (String texto, String comparar, String cssCuadro, String cssResultados){
        espera = new WebDriverWait(driver,segundosEspera);
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
                driver.findElement(By.cssSelector("div.distpicker.distpicker-rooms-packages.sbox-v4-components a.steppers-icon-left.sbox-3-icon-minus")).click();
                real--;
            }
            else{
                // body > div.distpicker.distpicker-rooms-packages.sbox-v4-components > div > div._pnlpk-panel-scroll > div._pnlpk-panel__blocks._pnlpk-dynamicContent > div:nth-child(1) > div._pnlpk-itemBlock__itemRows > div:nth-child(1) > div._pnlpk-itemRow__item._pnlpk-stepper-adults.-medium-down-to-lg > div > a.steppers-icon-right.sbox-3-icon-plus
                driver.findElement(By.cssSelector("div.distpicker.distpicker-rooms-packages.sbox-v4-components a.steppers-icon-right.sbox-3-icon-plus")).click();
                real++;
            }
        }
    }

    private void menor (int edad){
        // div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg a.steppers-icon-right.sbox-3-icon-plus
        // sumamos un menor
        // body > div.distpicker.distpicker-rooms-packages.sbox-v4-components > div > div._pnlpk-panel-scroll > div._pnlpk-panel__blocks._pnlpk-dynamicContent > div:nth-child(1) > div._pnlpk-itemBlock__itemRows > div:nth-child(2) > div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg > div > a.steppers-icon-right.sbox-3-icon-plus
        // SUMAMOS 1 NIÑO
        driver.findElement(By.cssSelector("div.distpicker.distpicker-rooms-packages.sbox-v4-components div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg a.steppers-icon-right.sbox-3-icon-plus")).click();
        // CLICK EN EDAD
        driver.findElement(By.cssSelector("div.distpicker.distpicker-rooms-packages.sbox-v4-components div._pnlpk-itemRow__item._pnlpk-select-minor-age select")).click();
        List <WebElement> edades = driver.findElements(By.cssSelector("div.distpicker.distpicker-rooms-packages.sbox-v4-components select option"));
        String dia = Integer.toString(edad);
        busqueda(edades,dia);
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
        espera = new WebDriverWait(driver,segundosEspera);
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
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sbox-bundle")));
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

        // HABITACIONES PERSONAS
        driver.findElement(By.cssSelector("div.sbox-distribution-picker-wrapper-ui")).click();
        String num =driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        int real = Integer.parseInt(num);
        // SELECCIONAR 2 ADULTOS
        adultos(real,2);
        // SELECCIONAR UN MENOR DE 2 AÑOS
        menor(2);

        driver.findElement(By.cssSelector("#searchbox > div > div > div > div.sbox-mobile-body.sbox-bind-disable-date.sbox-hotel-another-city-ui.sbox-hotel-partial-stay-ui.sbox-another-city-disabled-input.sbox-partial-stay-disabled > div.sbox-row.-wrap.-row-bottom > div.sbox-button.-ml3-l > div > a")).click();
        esperaImplicita();

        // SELECCIONAMOS EL TIPO DE MONEDA
        driver.findElement(By.cssSelector("#currency")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#currency select option")));
        List <WebElement> options = driver.findElements(By.cssSelector("#currency select option"));
        // CAMBIAMOS A DÓLARES ESTADOUNIDENSES
        busqueda(options,"Dólares");
        Thread.sleep(2000);
        // SELECCIONAMOS ORDENAR POR
        driver.findElement(By.cssSelector("#order")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#order select option")));
        List <WebElement> options2 = driver.findElements(By.cssSelector("#order select option"));
        // CAMBIAMOS A MÁS CONVENIENTES
        busqueda(options2, "convenientes");

        // CLICK EN SIGUIENTE EN LA PRIMERA OPCIÓN
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Siguiente')]")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]")).click();
        esperaImplicita();

        // CLICK EN EL HOTEL "Holiday Inn Express"
        driver.findElement(By.xpath("//span[@class='accommodation-name -eva-3-ellipsis' and contains(text(),'Holiday Inn Express')]")).click();
        esperaImplicita();

        // CLICK EN EL BOTON SIGUIENTE PARA SELECCIONAR EL HOTEL
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Siguiente')]")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]")).click();
        esperaImplicita();

        // CLICK EN EL BOTON SIGUIENTE EN PLAYA MARBELLA
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Siguiente')]")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]")).click();
        esperaImplicita();

        // CLICK EN EL BOTON SIGUIENTE PARA LA PARTE FINAL
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Siguiente')]")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]")).click();
        esperaImplicita();

        // List <WebElement> holiday = driver.findElements(By.cssSelector("body > aloha-app-root > aloha-results > div > div > div.results-wrapper.-eva-3-mt-xlg > div.results-column > div.results-items-wrapper > aloha-list-view-container > div.-eva-3-mb-xlg > aloha-cluster-container > div > div > div.cluster-content > div > div.cluster-description-wrapper.-eva-3-fwidth > div > aloha-cluster-accommodation-info-container > div.accommodation-name-wrapper > span"));
        WebElement holiday = driver.findElement(By.xpath("//div[@class='eva-3-h3 -eva-3-tc-gray-0' and contains(text(),'Holiday Inn Express')]"));
        String frase = "Holiday Inn Express Barcelona City 22@";
        Assert.assertTrue(holiday.getText().contains(frase));
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
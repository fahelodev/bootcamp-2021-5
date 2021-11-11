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

    private void seleccionarxpath (String texto, String comparar, String xpathCuadro, String xpathResultados){
        espera = new WebDriverWait(driver,segundosEspera);
        driver.findElement(By.xpath(xpathCuadro)).sendKeys(texto);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(xpathResultados)));
        List<WebElement> resultados = driver.findElements(By.cssSelector(xpathResultados));
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
                driver.findElement(By.cssSelector("div.distpicker.distpicker-rooms-packages.sbox-v4-components a.steppers-icon-right.sbox-3-icon-plus")).click();
                real++;
            }
        }
    }

    private void menor (int edad){
        /// SUMAMOS 1 NIÑO
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
                driver.findElement(By.xpath("//i[@class='_dpmg2--icon-ico-arrow']//ancestor::div[@class='datepicker-packages-car sbox-v4-components']")).click();
                mesActual= driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
                buscarCalendario(diaActual+fecha2-diaUltimo,mesActual);
            }
            else {
                driver.findElement(By.xpath("//i[@class='_dpmg2--icon-ico-arrow']//ancestor::div[@class='datepicker-packages-car sbox-v4-components']")).click();
                mesActual= driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
                buscarCalendario(diaActual+fecha1-diaUltimo,mesActual);
                buscarCalendario(diaActual+fecha2-diaUltimo,mesActual);
            }
        }
    }

    private void buscarMes (String mes){
        WebElement mesActual = driver.findElement(By.cssSelector("._dpmg2--show ._dpmg2--month-active span"));
        while (!mesActual.getText().contains(mes)){
            // AVANZAMOS AL SIGUIENTE MES
            driver.findElement(By.cssSelector("body > div.datepicker-packages.sbox-v4-components > div > div._dpmg2--controlsWrapper > div._dpmg2--controls-next > i")).click();
            espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._dpmg2--show ._dpmg2--month-active span")));
            // TOMAMOS EL NOMBRE DEL MES SIGUIENTE
            mesActual = driver.findElement(By.cssSelector("._dpmg2--show ._dpmg2--month-active span"));
        }
    }

    private void seleccionbox (String clase, String palabra) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(clase)).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(clase+" select option")));
        List <WebElement> options = driver.findElements(By.cssSelector(clase+" select option"));
        // CAMBIAMOS A DÓLARES ESTADOUNIDENSES
        busqueda(options,palabra);
    }

    @Test
    public void CdP03_busquedaPaquetes(){
        espera = new WebDriverWait(driver,segundosEspera);
        // OPCIONES:
        // vh: VUELO + 1 ALOJAMIENTO
        // vhh: VUELO + 2 ALOJAMIENTOS
        // va: VUELO + AUTO
        // SELECCIONAMOS VUELO + 1 ALOJAMIENTO
        driver.findElement(By.xpath("//input[@value='vh']")).click();

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
        espera = new WebDriverWait(driver,segundosEspera);
        // SELECCIONAMOS LA CASILLA ORIGEN
        seleccionar("santiago","Santiago de Chile","div.sbox-place-container input","div.ac-container span");
        // SELECCIONAMOS LA CASILLA DESTINO
        seleccionar("buenos aires","Ciudad de Buenos Aires","div.sbox-second-place-container input","div.ac-container span");

        // CLICK EN CALENDARIO CASILLA "IDA"
        driver.findElement(By.cssSelector("[placeholder='Ida']")).click();
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
        espera = new WebDriverWait(driver,segundosEspera);
        // OPCIONES:
        // vh: VUELO + 1 ALOJAMIENTO
        // vhh: VUELO + 2 ALOJAMIENTOS
        // va: VUELO + AUTO
        // SELECCIONAMOS VUELO + 1 ALOJAMIENTO
        driver.findElement(By.xpath("//input[@value='vhh']")).click();

        // SELECCIONAMOS LA CASILLA ORIGEN
        seleccionar("bue","Ciudad de Buenos Aires","div.sbox-place-container input","div.ac-container span");
        // SELECCIONAMOS LA CASILLA DESTINO
        seleccionar("esp","Cataluña","div.sbox-second-place-container input","div.ac-container span");

        // FECHAS IDA Y VUELTA
        String fechaIda = "4";
        String fechaHasta = "8";
        String fechaVuelta = "19";

        // FECHAS PARTE 1

        // CLICK EN FECHAS IDA
        driver.findElement(By.cssSelector("[placeholder='Ida']")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._dpmg2--show ._dpmg2--month-active span")));
        // BUSCAMOS EL MES DE ENERO
        buscarMes("Enero");
        // CREAMOS UNA LISTA CON EL MES DE ENERO
        List<WebElement> mesEnero = driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        // BUSCAMOS Y SELECCIONAMOS LOS DIAS
        busqueda(mesEnero, fechaIda);
        busqueda(mesEnero, fechaVuelta);

        // FECHAS PARTE 2

        // CERRAMOS EL CALENDARIO DE IDA Y VUELTA
        driver.findElement(By.xpath("//input[@value='vhh']")).click();

        // CLICK EN HASTA
        driver.findElement(By.cssSelector("[placeholder='Hasta']")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._dpmg2--show ._dpmg2--month-active span")));
        // MES TOMAMOS EL CALENDARIO DEL MES DE ENERO (HASTA)
        mesEnero = driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        // BUSCAMOS Y SELECCIONAMOS LA 3ERA FECHA
        busqueda(mesEnero,fechaHasta);

        // CASILLA SEGUNDO DESTINO
        // SELECCIONAMOS E INGRESAMOS EL SEGUNDO DESTINO
        seleccionarxpath("marbella","Andalucía","//label[contains(text(),'Segundo destino')]/following-sibling::input","div.ac-container span");

        // HABITACIONES PERSONAS
        driver.findElement(By.cssSelector("div.sbox-distribution-picker-wrapper-ui")).click();
        String num =driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        int real = Integer.parseInt(num);
        // SELECCIONAR 2 ADULTOS
        adultos(real,2);
        // SELECCIONAR UN MENOR DE 2 AÑOS
        menor(2);

        // DAMOS CLICK EN BUSCAR PARA VISUALIZAR LAS OPCIONES SIGUIENTES
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();
        esperaImplicita();

        // SIGUIENTE PAGINA
        // SELECT CURRENCY Y ORDER

        // SELECCIONAMOS EL TIPO DE MONEDA
        // CAMBIAMOS A DÓLARES ESTADOUNIDENSES
        seleccionbox("#currency","Dólares");
        // PAUSA DEBIDO A QUE NINGUN OTRO STOP FUNCIONO
        Thread.sleep(2000);
        // SELECCIONAMOS ORDENAR POR
        // CAMBIAMOS A MÁS CONVENIENTES
        seleccionbox("#order","convenientes");

        // CLICK EN SIGUIENTE EN LA PRIMERA OPCIÓN
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Siguiente')]//ancestor::a[@class='-md eva-3-btn -primary']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]//ancestor::a[@class='-md eva-3-btn -primary']")).click();
        esperaImplicita();

        // CLICK EN EL HOTEL "Holiday Inn Express"
        driver.findElement(By.xpath("//span[contains(text(),'Holiday Inn Express')]")).click();
        esperaImplicita();

        // CLICK EN EL BOTON SIGUIENTE PARA SELECCIONAR EL HOTEL
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Siguiente')]//ancestor::div[@class='pricebox-action -eva-3-mt-lg pricebox-button']")));
        // Thread.sleep(2000);
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]//ancestor::div[@class='pricebox-action -eva-3-mt-lg pricebox-button']")).click();
        esperaImplicita();

        // CLICK EN EL BOTON SIGUIENTE EN PLAYA MARBELLA
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Marbella Playa')]")));
        // Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Marbella Playa')]")).click();
        esperaImplicita();

        // CLICK EN EL BOTON SIGUIENTE PARA LA PARTE FINAL
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//em[contains(text(),'Siguiente')]//ancestor::div[@class='pricebox-action -eva-3-mt-lg pricebox-button']")));
        // Thread.sleep(2000);
        driver.findElement(By.xpath("//em[contains(text(),'Siguiente')]//ancestor::div[@class='pricebox-action -eva-3-mt-lg pricebox-button']")).click();
        esperaImplicita();

        WebElement holiday = driver.findElement(By.xpath("//div[@class='eva-3-h3 -eva-3-tc-gray-0' and contains(text(),'Holiday Inn Express')]"));
        String frase = "Holiday Inn Express Barcelona City 22@";
        Assert.assertTrue(holiday.getText().contains(frase));
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
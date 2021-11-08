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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class paquetes {
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

    @Test
    public void CdP01_agregarPaquete() throws InterruptedException {
        // 1.- CARGAR HOME
        // ESPERA
        WebDriverWait espera = new WebDriverWait(driver, 30);
        // 3.- SELECCIONAR CATEGORIA COCHES
        // CREAMOS LISTA
        List<WebElement> categorias = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
        busqueda(categorias, "Paquetes");
        driver.findElement(By.cssSelector("div.sbox-bundles span.sbox-bundle.sbox-bundle-vhh")).click();
        // CASILLA ORIGEN
        driver.findElement(By.cssSelector("div.sbox-place-container input")).sendKeys("bue");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        List<WebElement> origen = driver.findElements(By.cssSelector("div.ac-group-container span"));
        busqueda(origen, "Ciudad de Buenos Aires");
        // CASILLA DESTINO
        driver.findElement(By.cssSelector("div.sbox-second-place-container input")).sendKeys("esp");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        List<WebElement> destino = driver.findElements(By.cssSelector("div.ac-group-container span"));
        busqueda(destino, "Cataluña");
        // FECHAS IDA Y VUELTA
        driver.findElement(By.cssSelector("div.input-container.sbox-checkin-input-container input")).click();
        // dia actual

        String busqIda = "4";
        String busqVuelta = "19";
        String busqHasta = "8";
        String [ ]  nca = {"3","6","2","2","5","7","3","5","1","4","6","2"};
        int i = 0;
        WebElement mes = driver.findElement(By.cssSelector("body > div.datepicker-packages.sbox-v4-components > div > div._dpmg2--months > div._dpmg2--month._dpmg2--o-1._dpmg2--month-active > div._dpmg2--month-title > span._dpmg2--month-title-month"));
        while (!mes.getText().contains("Enero")){
            // System.out.println("Mes: " + mes.getText());
            driver.findElement(By.cssSelector("body > div.datepicker-packages.sbox-v4-components > div > div._dpmg2--controlsWrapper > div._dpmg2--controls-next > i")).click();
            Thread.sleep(2000);
            String dir = "body > div.datepicker-packages.sbox-v4-components > div > div._dpmg2--months > div._dpmg2--month._dpmg2--o-"+nca[i]+"._dpmg2--month-active > div._dpmg2--month-title > span._dpmg2--month-title-month";
            mes = driver.findElement(By.cssSelector(dir));
            i++;
        }
        List<WebElement> busq3 = driver.findElements(By.cssSelector("div._dpmg2--months span._dpmg2--date"));
        busqueda(busq3, busqIda);
        busqueda(busq3, busqVuelta);
        // FECHA HASTA
        driver.findElement(By.cssSelector("div.sbox-bundles span.sbox-bundle.sbox-bundle-vhh")).click();
        driver.findElement(By.cssSelector("#searchbox > div > div > div > div.sbox-mobile-body.sbox-bind-disable-date.sbox-hotel-another-city-ui.sbox-hotel-partial-stay-ui.sbox-another-city-disabled-input.sbox-partial-stay-disabled > div.sbox-row.-wrap.-row-bottom > div.sbox-vhh-container.sbox-row.-mt2-l.-wrap > div.sbox-row.-wrap > div:nth-child(1) > div.sbox-row.-wrap.sbox-dates-container.-mb3-m.-mb4-s > div > div.sbox-3-input.-md.sbox-3-validation.-top-right.-icon-left.sbox-dates-input.sbox-hotel-first-date-end-container > div > input")).click();
        List<WebElement> busq4 = driver.findElements(By.cssSelector("div._dpmg2--months span._dpmg2--date"));
        busqueda(busq4,busqHasta);
        // CASILLA SEGUNDO DESTINO
        driver.findElement(By.cssSelector("#searchbox > div > div > div > div.sbox-mobile-body.sbox-bind-disable-date.sbox-hotel-another-city-ui.sbox-hotel-partial-stay-ui.sbox-another-city-disabled-input.sbox-partial-stay-disabled > div.sbox-row.-wrap.-row-bottom > div.sbox-vhh-container.sbox-row.-mt2-l.-wrap > div.sbox-row.-wrap > div.sbox-row.vhh-module-container.-mb5-m.-mb3-s.-ml3-l.-wrap-s > div.sbox-places-group-container.sbox-row.-mb5-m.-wrap-s.-mr2-l.-mb3-s.sbox-places-without-rounded > div > div > div > div > input")).sendKeys("marbella");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-group-container ul li span")));
        List<WebElement> segundo = driver.findElements(By.cssSelector("div.ac-group-container ul li span"));
        busqueda(segundo, "Andalucía");
        // HABITACIONES PERSONAS
        /*
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
         */
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

    @Test
    public void CdP02_busquedaPaquetes(){
        WebDriverWait d = new WebDriverWait(driver,10);
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"header-products-container\"]/ul/li/a")));
        int size = driver.findElements(By.xpath("//div[@class=\"header-products-container\"]/ul/li/a")).size();
        for (int i=0; i<size;i++){
            String categoria = driver.findElements(By.xpath("//div[@class=\"header-products-container\"]/ul/li/a")).get(i).getAttribute("title");
            if (categoria.equals("Paquetes")){
                driver.findElements(By.xpath("//div[@class=\"header-products-container\"]/ul/li/a")).get(i).click();
                break;
            }
        }

        seleccionarOrigen("santiago","Santiago de Chile, Santiago, Chile");

        seleccionarDestino("Buenos aires","Buenos Aires, Ciudad de Buenos Aires, Argentina");

        seleccionarDias(1,2);

        driver.findElement(By.cssSelector("div.sbox-button-container a")).click();
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cluster-content")));
        String ciudad =  driver.findElement(By.cssSelector("div.cluster-content div.cluster-description-wrapper span.-eva-3-tc-gray-2")).getText();
        Pattern patron = Pattern.compile("Buenos Aires");
        Matcher m = patron.matcher(ciudad);
        boolean e = m.find();
        String res = String.valueOf(e);
        assertEquals("true",res);

    }

    //div.pricebox-value-container > aloha-price-container > aloha-summary-price > p
    @Test
    public void CdP03_busquedaPaquetes(){
        WebDriverWait d = new WebDriverWait(driver,10);

        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"header-products-container\"]/ul/li/a")));
        int size = driver.findElements(By.xpath("//div[@class=\"header-products-container\"]/ul/li/a")).size();
        for (int i=0; i<size;i++){
            String categoria = driver.findElements(By.xpath("//div[@class=\"header-products-container\"]/ul/li/a")).get(i).getAttribute("title");
            if (categoria.equals("Paquetes")){
                driver.findElements(By.xpath("//div[@class=\"header-products-container\"]/ul/li/a")).get(i).click();
                break;
            }
        }

        //puede ser vh,vhh o va
        seleccionarPaquete("vh");

        seleccionarOrigen("santiago","Santiago de Chile, Santiago, Chile");

        seleccionarDestino("San pedro", "San Pedro de Atacama, Antofagasta, Chile");

        //cantidad de dias a agregar a la primer fecha y la segunda fecha a seleccionar
        seleccionarDias(1,2);

        driver.findElement(By.cssSelector("div.sbox-distri-container")).click();
        String numero =driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        if(numero.equals("2")){
            driver.findElement(By.cssSelector("div.sbox-button-container a")).click();
        }else{

        }
// /html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[10]/aloha-filter/aloha-checkbox-filter/ul/aloha-view-more/div/div[2]/span
//body > aloha-app-root > aloha-results > div > div > div > div.filters-column > aloha-filter-list > div > ul > li:nth-child(10) > aloha-filter > aloha-checkbox-filter > ul > aloha-view-more > div > div.view-more-btn.-eva-3-mt-lg.-without-gradient > span
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.results-cluster-container")));
        int lista = driver.findElements(By.cssSelector("div.results-cluster-container")).size();

        assertTrue(lista>1);


    }

    private void seleccionarPaquete(String paquete){

        int s = driver.findElements(By.cssSelector("span.sbox-bundle input")).size();
        for (int i=0; i<s;i++){
            String tipo = driver.findElements(By.cssSelector("span.sbox-bundle input")).get(i).getAttribute("value");

            if (tipo.equals(paquete)){
                driver.findElements(By.cssSelector("span.sbox-bundle input")).get(i).click();
                break;
            }
        }
    }

    private void seleccionarOrigen (String palabra, String comparar){
        WebDriverWait d = new WebDriverWait(driver,10);
        driver.findElement(By.cssSelector("div.sbox-place-container input")).sendKeys(palabra);
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        int q =driver.findElements(By.cssSelector("div.ac-container span")).size();
        for (int i=0; i<q;i++){
            String origen = driver.findElements(By.cssSelector("div.ac-container span")).get(i).getText();
            if (origen.equals(comparar)){
                driver.findElements(By.cssSelector("div.ac-container span")).get(i).click();
                break;
            }
        }
    }

    private void seleccionarDestino (String palabra, String comparar){
        WebDriverWait d = new WebDriverWait(driver,10);
        driver.findElement(By.cssSelector("div.sbox-second-place-container input")).sendKeys(palabra);
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        int p =driver.findElements(By.cssSelector("div.ac-container span")).size();
        for (int i=0; i<p;i++){
            String destino = driver.findElements(By.cssSelector("div.ac-container span")).get(i).getText();
            if (destino.equals(comparar)){
                driver.findElements(By.cssSelector("div.ac-container span")).get(i).click();
                break;
            }
        }
    }

    private void seleccionarDias(int dia1 , int dia2){

        driver.findElement(By.cssSelector("div.sbox-checkin-input-container input")).click();
        int k =driver.findElements(By.cssSelector("div._dpmg2--month-active span")).size();
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        int o = Integer.parseInt(dia);
        o=o+dia1;
        String fech1 = Integer.toString(o);

        for (int i=0; i<k;i++){
            String fecha1 = driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).getText();
            if (fecha1.equals(fech1)){
                driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).click();
                break;
            }
        }

        int w = Integer.parseInt(dia);
        w=w+dia2;
        String fech2 = Integer.toString(w);
        for (int i=0; i<k;i++){
            String fecha2 = driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).getText();
            if (fecha2.equals(fech2)){
                driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).click();
                break;
            }
        }

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
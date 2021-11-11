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
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class alojamientos {

    private WebDriver driver;

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
        driver.get("https://www.viajesfalabella.cl/");

    }

    private void seleccionarDestino (String palabra, String comparar){
        WebDriverWait d = new WebDriverWait(driver,10);
        driver.findElement(By.cssSelector("div.sbox-place-container input")).sendKeys(palabra);
        d.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        List <WebElement> resultados =driver.findElements(By.cssSelector("div.ac-container span"));
        for (WebElement l: resultados){
            if (l.getText().contains(comparar)){
                l.click();
                break;
            }
        }
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

    private void buscarCalendario(int diaBuscado, List<WebElement> mes){
        String dia = Integer.toString(diaBuscado);
        busqueda(mes,dia);
    }

    private void  seleccionarAdultos(int cant){

        String num = driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        int numero = Integer.parseInt(num);


        while (numero != cant) {
            if (numero > cant) {
                // click izquierdo (-)
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-left.sbox-3-icon-minus")).click();
                numero--;
            } else {
                //click derecho (+)
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-right.sbox-3-icon-plus")).click();
                numero++;
            }
        }
    }
////select[@class='select-tag']/option[@value='total_price_ascending']
    private void filtrar (String filtro){
        WebDriverWait espera = new WebDriverWait(driver, 15);
        List<WebElement> optionsTO = driver.findElements(By.xpath("//aloha-select[@class='sorting-select']//select[@class='select-tag']/option"));
        System.out.println(optionsTO);

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".eva-3-select.-sm .select-tag")));
        for (WebElement l : optionsTO) {
            if (l.getText().contains("Precio: menor a mayor")) {
                l.click();
                break;
            }

        }

    }

    private String patron(String comparar, String selector){
        WebElement ubicacion = driver.findElement(By.xpath(selector));
        String nombre = ubicacion.getText();

        Pattern patron = Pattern.compile(comparar);
        Matcher m = patron.matcher(nombre);
        boolean e = m.find();
        String res = String.valueOf(e);

       return res;
    }

    @Test
    public void CdP09_busquedaAlojamiento() {

        WebDriverWait espera = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("li.header-product-item")).click();
        driver.findElement(By.cssSelector("label.checkbox-label")).click();

        seleccionarDestino("orlando","Orlando, Florida, Estados Unidos");
        driver.findElement(By.cssSelector("div.sbox-button")).click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.results-cluster-container")));
        int lista = driver.findElements(By.cssSelector("div.results-cluster-container")).size();

        Assert.assertTrue(lista > 1);
    }


    @Test
    public void CdP08_busquedaAlojamiento() throws InterruptedException {

        WebDriverWait espera = new WebDriverWait(driver, 15);
        driver.findElement(By.cssSelector("li.header-product-item")).click();
        //SELECCIONA EL DESTINO
        seleccionarDestino("dub","Dubái, Dubai, Emiratos Árabes Unidos");

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-dates-input.sbox-datein-container > div > input")));
        driver.findElement(By.xpath("//input[@placeholder='Entrada']")).click();

        //SELECCIONA LA FECHAS
        calendario(1,7);

        driver.findElement(By.cssSelector("div.sbox-distri-input-container")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._pnlpk-panel-scroll")));

        //SELECCIONA LA CANTIDAD DE ADULTOS
        seleccionarAdultos(1);
        driver.findElement(By.cssSelector("div.sbox-button")).click();

        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//aloha-select[@class='sorting-select']//select[@class='select-tag']")));
        driver.findElement(By.xpath("//aloha-select[@class='sorting-select']//select[@class='select-tag']")).click();
        //SE APLICA EL FILTRO DESEADO
        filtrar("Precio: menor a mayor");
        //UTILIZCION DE EXPRECION REGULAR PARA COMPARAR PALABRAS
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.eva-3-btn.-md.-primary.-eva-3-fwidth")));

        ////div[@class='cluster-description-wrapper -eva-3-fwidth']//span[@class='-eva-3-tc-gray-2']
        String res = patron("Dubái","//span[@class='-eva-3-tc-gray-2']");
        String res2 = patron("6","//p[@class='eva-3-p -eva-3-tc-gray-2 first-message']");


        assertEquals("true", res);
        assertEquals("true", res2);

    }

    @Test
    public void CdP07_agregarAlojamiento() throws InterruptedException {

        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.header-product-item")));
        driver.findElement(By.cssSelector("li.header-product-item")).click();

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-place-container input")));
        seleccionarDestino("lon","Londres, Inglaterra, Reino Unido");

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-dates-input.sbox-datein-container > div > input")));
        driver.findElement(By.cssSelector("div.sbox-dates-input.sbox-datein-container > div > input")).click();

        calendario(7,17);

        driver.findElement(By.cssSelector("div.sbox-distri-input-container")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._pnlpk-panel-scroll")));

        seleccionarAdultos(2);

        driver.findElement(By.cssSelector("._pnlpk-panel__button--link-left")).click();
        driver.findElement(By.cssSelector("._pnlpk-apply-button.sbox-3-btn.-primary")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-button")));
        driver.findElement(By.cssSelector("div.sbox-button")).click();

        //filtrar por reserva flexible
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.eva-3-filters-vertical.-eva-3-mb-lg.-show-filters")));
        driver.findElement(By.xpath("//li[contains(.,'Reserva flexible')]//em")).click();


        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.eva-3-filters-vertical.-eva-3-mb-lg.-show-filters")));
        List<WebElement> optionsTO = driver.findElements(By.xpath("//li[contains(.,'Tipo de Alojamiento')]//em"));
        System.out.println(optionsTO);
        for (WebElement dep : optionsTO) {
            if (dep.getText().contains("Departamentos")) {
                dep.click();
                break;
            }
        }
//
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pricebox-action']")));
        Thread.sleep(7000);
        driver.findElement(By.xpath("//button[@class='eva-3-btn -md -primary -eva-3-fwidth']")).click();

        //Metodo para cambiar de pestaña
        String mainTab = driver.getWindowHandle();
        String newTab = "";

        Set<String> handles = driver.getWindowHandles();
        for (String actual : handles) {

            if (!actual.equalsIgnoreCase(mainTab)) {
                driver.switchTo().window(actual);
                newTab = actual;
            }
        }



        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='pricebox-top-container']//button")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='-eva-3-mb-lg']//button")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='pricebox-content-container']//button")).click();

        Thread.sleep(5000);

        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='eva-3-message -success -eva-3-mb-md -eva-3-mt-md']//span")));
        Thread.sleep(5000);
        String res = patron("¡Felicitaciones! Seleccionaste la habitación más económica","//div[@class='eva-3-message -success -eva-3-mb-md -eva-3-mt-md']//span");

        assertEquals("true",res);

        driver.close();
        driver.switchTo().window(mainTab);


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

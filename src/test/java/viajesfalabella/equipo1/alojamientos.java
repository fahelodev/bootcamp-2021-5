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

    @Test
    public void alojamientoComplejidadBaja() {

        WebDriverWait espera = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("li.header-product-item")).click();
        driver.findElement(By.cssSelector("label.checkbox-label")).click();

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-place-container input")));
        WebElement destino = driver.findElement(By.cssSelector("div.sbox-place-container input"));
        destino.click();
        destino.sendKeys("orlando, florida, estados Unidos");

        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        int q = driver.findElements(By.cssSelector("div.ac-container span")).size();
        for (int i = 0; i < q; i++) {

            String origen = driver.findElements(By.cssSelector("div.ac-container span")).get(i).getText();
            if (origen.equals("Orlando, Florida, Estados Unidos")) {
                driver.findElements(By.cssSelector("div.ac-container span")).get(i).click();
                break;
            }
        }
        driver.findElement(By.cssSelector("div.sbox-button")).click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.results-cluster-container")));
        int lista = driver.findElements(By.cssSelector("div.results-cluster-container")).size();
        System.out.println("cantidad de lista: " + lista);


        Assert.assertTrue(lista > 1);
    }


    @Test
    public void alojamientoBusquedaMedia() throws InterruptedException {

        WebDriverWait espera = new WebDriverWait(driver, 15);
        driver.findElement(By.cssSelector("li.header-product-item")).click();

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-place-container input")));
        WebElement destino = driver.findElement(By.cssSelector("div.sbox-place-container input"));
        destino.click();
        destino.sendKeys("dub");

        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        int q = driver.findElements(By.cssSelector("div.ac-container span")).size();
        for (int i = 0; i < q; i++) {

            String origen = driver.findElements(By.cssSelector("div.ac-container span")).get(i).getText();
            if (origen.equals("Dubái, Dubai, Emiratos Árabes Unidos")) {
                driver.findElements(By.cssSelector("div.ac-container span")).get(i).click();
                break;
            }
        }

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-dates-input.sbox-datein-container > div > input")));
        WebElement fechaIda = driver.findElement(By.cssSelector("div.sbox-dates-input.sbox-datein-container > div > input"));
        fechaIda.click();

        int k = driver.findElements(By.cssSelector("div._dpmg2--month-active span")).size();
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        int o = Integer.parseInt(dia);
        o = o + 1;
        String fech1 = Integer.toString(o);
        for (int i = 0; i < k; i++) {
            String fecha1 = driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).getText();
            if (fecha1.equals(fech1)) {
                driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).click();
                break;
            }
        }

        int w = Integer.parseInt(dia);
        w = w + 7;
        String fech2 = Integer.toString(w);
        for (int i = 0; i < k; i++) {
            String fecha2 = driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).getText();
            if (fecha2.equals(fech2)) {
                driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).click();
                break;
            }
        }

        driver.findElement(By.cssSelector("div.sbox-distri-input-container")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._pnlpk-panel-scroll")));

        String num = driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        int numero = Integer.parseInt(num);


        while (numero != 1) {
            if (numero > 1) {
                // click izquierdo (-)
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-left.sbox-3-icon-minus")).click();
                numero--;
            } else {
                //click derecho (+)
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-right.sbox-3-icon-plus")).click();
                numero++;
            }
        }
        driver.findElement(By.cssSelector("div.sbox-button")).click();

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("aloha-select.sorting-select div.eva-3-select.-sm div.select-container select")));
        driver.findElement(By.cssSelector("aloha-select.sorting-select div.eva-3-select.-sm div.select-container select")).click();

        List<WebElement> optionsTO = driver.findElements(By.cssSelector("aloha-select.sorting-select div.eva-3-select.-sm div.select-container select option"));
        System.out.println(optionsTO);

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".eva-3-select.-sm .select-tag")));
        for (WebElement l : optionsTO) {
            if (l.getText().contains("Precio: menor a mayor")) {
                l.click();
                break;
            }

        }

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.eva-3-btn.-md.-primary.-eva-3-fwidth")));
        WebElement ubicacion = driver.findElement(By.cssSelector("aloha-cluster-accommodation-info-container > aloha-location-name > span"));
        String nombre = ubicacion.getText();
        System.out.println(nombre);

        Pattern patron = Pattern.compile("Dubái");
        Matcher m = patron.matcher(nombre);
        boolean e = m.find();
        String res = String.valueOf(e);

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.pricebox-value-container > aloha-price-container > aloha-summary-price > p.eva-3-p.-eva-3-tc-gray-2.first-message")));
        WebElement c = driver.findElement(By.cssSelector("div.pricebox-value-container > aloha-price-container > aloha-summary-price > p.eva-3-p.-eva-3-tc-gray-2.first-message"));
        String cantidad = c.getText();
        System.out.println(cantidad);

        Pattern patron2 = Pattern.compile("6");
        Matcher m2 = patron2.matcher(cantidad);
        boolean e2 = m2.find();
        String res2 = String.valueOf(e2);


        assertEquals("true", res);
        assertEquals("true", res2);

    }

    @Test
    public void alojamientoComplejidadAlta() throws InterruptedException {

        WebDriverWait espera = new WebDriverWait(driver, 20);
        driver.findElement(By.cssSelector("li.header-product-item")).click();

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-place-container input")));
        WebElement destino = driver.findElement(By.cssSelector("div.sbox-place-container input"));
        destino.click();
        destino.sendKeys("lon");

        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        int q = driver.findElements(By.cssSelector("div.ac-container span")).size();
        for (int i = 0; i < q; i++) {

            String origen = driver.findElements(By.cssSelector("div.ac-container span")).get(i).getText();
            if (origen.equals("Londres, Inglaterra, Reino Unido")) {
                driver.findElements(By.cssSelector("div.ac-container span")).get(i).click();
                break;
            }
        }

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-dates-input.sbox-datein-container > div > input")));
        WebElement fechaIda = driver.findElement(By.cssSelector("div.sbox-dates-input.sbox-datein-container > div > input"));
        fechaIda.click();

        int k = driver.findElements(By.cssSelector("div._dpmg2--month-active span")).size();
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        int o = Integer.parseInt(dia);
        o = o + 7;
        String fech1 = Integer.toString(o);
        for (int i = 0; i < k; i++) {
            String fecha1 = driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).getText();
            if (fecha1.equals(fech1)) {
                driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).click();
                break;
            }
        }

        int w = Integer.parseInt(dia);
        w = w + 17;
        String fech2 = Integer.toString(w);
        for (int i = 0; i < k; i++) {
            String fecha2 = driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).getText();
            if (fecha2.equals(fech2)) {
                driver.findElements(By.cssSelector("div._dpmg2--month-active span span._dpmg2--date-number")).get(i).click();
                break;
            }
        }

        driver.findElement(By.cssSelector("div.sbox-distri-input-container")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._pnlpk-panel-scroll")));

        String num = driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        int numero = Integer.parseInt(num);

        while (numero != 2) {
            if (numero > 1) {
                // click izquierdo (-)
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-left.sbox-3-icon-minus")).click();
                numero--;
            } else {
                //click derecho (+)
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-right.sbox-3-icon-plus")).click();
                numero++;
            }
        }

        driver.findElement(By.cssSelector("._pnlpk-panel__button--link-left")).click();
        driver.findElement(By.cssSelector("._pnlpk-apply-button.sbox-3-btn.-primary")).click();
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-button")));
        driver.findElement(By.cssSelector("div.sbox-button")).click();

        //filtrar por reserva flexible
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.eva-3-filters-vertical.-eva-3-mb-lg.-show-filters")));
        driver.findElement(By.cssSelector(".eva-3-dropdown .dropdown-item.-active .dropdown-subitem:first-of-type .dropdown-item-container")).click();

        //filtrar por reserva departamento
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.eva-3-filters-vertical.-eva-3-mb-lg.-show-filters")));
        List<WebElement> optionsTO = driver.findElements(By.cssSelector("div.eva-3-filters-vertical.-eva-3-mb-lg.-show-filters ul.eva-3-dropdown li.dropdown-item.-active aloha-checkbox-filter ul li.dropdown-subitem"));
        System.out.println(optionsTO);
        for (WebElement dep : optionsTO) {
            if (dep.getText().contains("Departamentos")) {
                dep.click();
                break;
            }
        }
    /*
            //filtrar por desayuno
            espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.eva-3-filters-vertical.-eva-3-mb-lg.-show-filters")));
            List<WebElement> optionsTO1 = driver.findElements(By.cssSelector("div.eva-3-filters-vertical.-eva-3-mb-lg.-show-filters ul.eva-3-dropdown li.dropdown-item.-active aloha-checkbox-filter ul li.dropdown-subitem"));
            for (WebElement des : optionsTO1) {
                if (des.getText().contains("Desayuno")) {
                    des.click();
                    break;
                }

            }

     */

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.eva-3-pricebox-cluster.-responsive div.pricebox-top-container div.pricebox-action button")));
        Thread.sleep(7000);
        driver.findElement(By.cssSelector("div.cluster-pricebox-container div.eva-3-pricebox-cluster.-responsive div.pricebox-top-container div.pricebox-action button")).click();

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
        driver.findElement(By.cssSelector("body > aloha-app-root > aloha-detail > div > div:nth-child(4) > div > div > aloha-infobox-container > aloha-infobox-wrapper-container > div > div > div > aloha-infobox-shopping-content > div > div.pricebox-action.-eva-3-mt-lg.pricebox-button > aloha-button > button")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#roompacks-container-wrapper > aloha-roompacks-container > aloha-roompacks-grid-container > div.body > div.col-6.-eva-3-bc-white > aloha-reservation-summary-container > div > aloha-next-step-button > aloha-button > button")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#pricebox-overlay > div.eva-3-pricebox-sticky.eva-3-shadow.price-box-sticky.price-box-shadow.-loyalty.-with-info > div > button > em")).click();

        Thread.sleep(5000);
        WebElement mensaje = driver.findElement(By.cssSelector("div.eva-3-message.-success.-eva-3-mb-md.-eva-3-mt-md div.message-header span"));
        String mensajeObtenido = mensaje.getText();

        Pattern patron = Pattern.compile("¡Felicitaciones! Seleccionaste la habitación más económica");
        Matcher m = patron.matcher(mensajeObtenido);
        boolean e = m.find();
        String res = String.valueOf(e);

        assertEquals("true",res);

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

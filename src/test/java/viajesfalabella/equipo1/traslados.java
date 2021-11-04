package viajesfalabella.equipo1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class traslados {
    private WebDriver driver;
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

    private static void limit_Is_Reached(WebDriver driver){
        while (Objects.equals(driver.getTitle(),"Resource Limit Is Reached")){
            driver.navigate().refresh();
        }
    }

    @BeforeClass
    public static void Setup(){
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() throws InterruptedException {
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        // driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();
        driver.get("https://www.viajesfalabella.cl/");
        limit_Is_Reached(driver);
    }

    @Test
    public void CdP04_agregarTraslado() throws InterruptedException {
        // 1.- CARGAR HOME
        // ESPERA
        WebDriverWait espera = new WebDriverWait(driver, 30);
        // 3.- SELECCIONAR CATEGORIA COCHES
        // CREAMOS LISTA
        List<WebElement> categorias = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
        busqueda(categorias, "Traslados");
        driver.findElement(By.cssSelector("div.sbox-place-container input")).sendKeys("arturo");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        // CASILLA DESDE
        List<WebElement> busq1 = driver.findElements(By.cssSelector("div.ac-container span"));
        busqueda(busq1, "Aeropuerto Arturo Merino Benitez");
        driver.findElement(By.cssSelector("div.sbox-second-place-container input")).sendKeys("avenida");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        // CASILLA HASTA
        List<WebElement> busq2 = driver.findElements(By.cssSelector("div.ac-container span"));
        busqueda(busq2, "AVENIDA ALEMANIA");
        // HABILITAR CHECK BOX
        driver.findElement(By.cssSelector("div.sbox-places-check span label i")).click();
        // CLICK EN EL CALENDARIO
        driver.findElement(By.cssSelector("div.sbox-moment-input input")).click();
        // TOMAMOS EL DIA ACTUAL
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        int d = Integer.parseInt(dia);
        // DIA BUSCADO, ACTUAL + 7 DIAS
        d = d + 7;
        int d2 = d + 2;
        String busqDia = Integer.toString(d);
        String busqDia2 = Integer.toString(d2);
        // TOMAMOS LA LISTA DEL CALENDARIO
        List<WebElement> busq3 = driver.findElements(By.cssSelector("div._dpmg2--months span span._dpmg2--date-number"));
        // SELECCIONAMOS LOS DIAS
        busqueda(busq3, busqDia); // FECHA ACTUAL + 7 DIAS
        busqueda(busq3, busqDia2); // FECHA ANTERIOR + 2 DIAS

        // SELECCIONAR HORA 1
        driver.findElement(By.cssSelector("div.sbox-moment-container select")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sbox-moment-container select option")));
        List<WebElement> busq4 = driver.findElements(By.cssSelector("div.sbox-moment-container select option"));
        busqueda(busq4,"00:00");
        Thread.sleep(2000);

        // SELECCIONAR HORA 2
        driver.findElement(By.cssSelector("div.sbox-moment-container.sbox-second-moment-container select")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sbox-moment-container.sbox-second-moment-container select option")));
        List<WebElement> busq5 = driver.findElements(By.cssSelector("div.sbox-moment-container.sbox-second-moment-container select option"));
        busqueda(busq5,"00:00");
        Thread.sleep(2000);

        // PASAJEROS
        driver.findElement(By.cssSelector("div.sbox-distri-input-container")).click();
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
        Thread.sleep(2000);
        // CLICK EN BUSCAR
        driver.findElement(By.cssSelector("div.sbox-button-container a")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.map-container")));
        driver.findElement(By.cssSelector("div.static-map-container img")).click();
        // APARECE PANTALLA MODAL?
        Thread.sleep(2000);
        // APARECE PANTALLA MODAL?
        // driver.findElement(By.cssSelector("#bodyID > div.ds-transfers-wrapper > div.ng-scope > div > div.search-view-container-wrapper > main > div:nth-child(3) > transfers-map-points > section > div.eva-3-modal.-no-padding.map.ng-scope.-show-modal > div.modal-header > i")).click();
        driver.findElement(By.cssSelector("div.eva-3-modal.-no-padding.map.ng-scope.-show-modal i")).click();
        Thread.sleep(2000);
        Select s = new Select(driver.findElement(By.id("currency-select")));
        s.selectByVisibleText("Dólares");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#bodyID > div.ds-transfers-wrapper > div.ng-scope > div > div.search-view-container-wrapper > main > div:nth-child(3) > div > div.search-view-items-container > div:nth-child(4) > search-item > div.eva-3-cluster-gallery.-eva-3-shadow-line.-eva-3-shadow-line-hover > div.cluster-container > div.cluster-pricebox-container > div > div.pricebox-top-container > div.pricebox-action > button")).click();
        // driver.findElement(By.cssSelector("div.eva-3-cluster-gallery.-eva-3-shadow-line.-eva-3-shadow-line-hover button")).click();
        Thread.sleep(10000);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#checkout-content > div.checkout-details.-fl-sm.col.-sm-12.-lg-4.desktop-qa > div > purchase-detail-component > div > products-detail-component-v2 > div > div > product-description-v2 > div > div > span")));
        WebElement Frase = driver.findElement(By.cssSelector("#checkout-content > div.checkout-details.-fl-sm.col.-sm-12.-lg-4.desktop-qa > div > purchase-detail-component > div > products-detail-component-v2 > div > div > product-description-v2 > div > div > span"));
        WebElement Frase2 = driver.findElement(By.cssSelector("#checkout-content > div.checkout-details.-fl-sm.col.-sm-12.-lg-4.desktop-qa > div > purchase-detail-component > div > products-detail-component-v2 > div > div > product-title-v2 > div > div.dm-title-container > div"));
        // String Frase = driver.findElement(By.cssSelector("div.product-description-v2 div div span")).getText();
        System.out.println("Frase:"+Frase.getText());
        int contador = 0;
        int contador2 = 0;
        if (Frase.getText().contains("Privado")){
            contador++;
        }
        if (Frase.getText().contains("Auto Estándar")){
            contador++;
        }
        if (Frase2.getText().contains("AVENIDA ALEMANIA 4658")){
            contador2++;
        }
        if (Frase2.getText().contains("Arturo Merino")){
            contador2++;
        }
        Assert.assertEquals(2, contador);
        Assert.assertEquals(2, contador2);
    }

    @Test
    public void CdP05_busquedaTraslado() throws InterruptedException {
        // 1.- CARGAR HOME
        // ESPERA
        WebDriverWait espera = new WebDriverWait(driver, 30);
        // 3.- SELECCIONAR CATEGORIA COCHES
        // CREAMOS LISTA
        List<WebElement> categorias = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
        busqueda(categorias, "Traslados");
        driver.findElement(By.cssSelector("div.sbox-place-container input")).sendKeys("arturo");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        // Thread.sleep(2000);
        List<WebElement> busq1 = driver.findElements(By.cssSelector("div.ac-container span"));
        busqueda(busq1, "Aeropuerto Arturo Merino Benitez");
        driver.findElement(By.cssSelector("div.sbox-second-place-container input")).sendKeys("sheraton");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        // Thread.sleep(2000);
        List<WebElement> busq2 = driver.findElements(By.cssSelector("div.ac-container span"));
        busqueda(busq2, "Sheraton Miramar");
        driver.findElement(By.cssSelector("div.sbox-moment-input input")).click();
        // dia actual
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        int d = Integer.parseInt(dia);
        d++;
        String busqDia = Integer.toString(d);
        List<WebElement> busq3 = driver.findElements(By.cssSelector("div._dpmg2--months span span._dpmg2--date-number"));
        busqueda(busq3, busqDia);
        driver.findElement(By.cssSelector("div.sbox-distri-input-container")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._pnlpk-panel-scroll")));
        // Thread.sleep(2000);
        String num =driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        int numero = Integer.parseInt(num);
        while (numero != 1){
            if (numero > 1){
                // click izquierdo (-)
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-left.sbox-3-icon-minus")).click();
                numero--;
            }
            else{
                //click derecho (+)
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-right.sbox-3-icon-plus")).click();
                numero++;
            }
        }
        // CLICK EN BUSCAR
        driver.findElement(By.cssSelector("div.sbox-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#bodyID > div.ds-transfers-wrapper > div.ng-scope > div > div.search-view-container-wrapper > main > div:nth-child(3) > div > div.search-view-items-container > div:nth-child(3) > search-item > div.eva-3-cluster-gallery.-eva-3-shadow-line.-eva-3-shadow-line-hover > div.cluster-container > div.cluster-pricebox-container > div > div.pricebox-top-container > div.pricebox-action > button > em")).click();
        Thread.sleep(2000);
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.-eva-3-mt-xlg")));
        String Minivan = driver.findElement(By.cssSelector("#checkout-content > div.checkout-details.-fl-sm.col.-sm-12.-lg-4.desktop-qa > div > purchase-detail-component > div > products-detail-component-v2 > div > div > product-description-v2 > div > div > span")).getText();
        Assert.assertTrue("True",Minivan.contains("Minivan"));
    }

    @Test
    public void CdP06_busquedaTraslado() throws InterruptedException {
        // 1.- CARGAR HOME
        // ESPERA
        WebDriverWait espera = new WebDriverWait(driver, 30);
        // 3.- SELECCIONAR CATEGORIA COCHES
        // CREAMOS LISTA
        List<WebElement> categorias = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
        busqueda(categorias, "Traslados");
        driver.findElement(By.cssSelector("div.sbox-place-container input")).sendKeys("arturo");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        // Thread.sleep(2000);
        List<WebElement> busq1 = driver.findElements(By.cssSelector("div.ac-container span"));
        busqueda(busq1, "Aeropuerto Arturo Merino Benitez");
        driver.findElement(By.cssSelector("div.sbox-second-place-container input")).sendKeys("sheraton");
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ac-container span")));
        // Thread.sleep(2000);
        List<WebElement> busq2 = driver.findElements(By.cssSelector("div.ac-container span"));
        busqueda(busq2, "Sheraton Miramar");
        driver.findElement(By.cssSelector("div.sbox-moment-input input")).click();
        // dia actual
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        int d = Integer.parseInt(dia);
        d = d + 2;
        String busqDia = Integer.toString(d);
        List<WebElement> busq3 = driver.findElements(By.cssSelector("div._dpmg2--months span span._dpmg2--date-number"));
        busqueda(busq3, busqDia);
        driver.findElement(By.cssSelector("div.sbox-distri-input-container")).click();
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._pnlpk-panel-scroll")));
        String num =driver.findElement(By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input")).getAttribute("value");
        int numero = Integer.parseInt(num);
        while (numero != 4){
            if (numero > 4){
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon.left")).click();
                numero--;
            }
            else{
                driver.findElement(By.cssSelector("div._pnlpk-itemRow__item a.steppers-icon-right.sbox-3-icon-plus")).click();
                numero++;
            }
        }
        driver.findElement(By.cssSelector("div.sbox-button")).click();
        Thread.sleep(2000);
        String Private = driver.findElement(By.cssSelector("#bodyID > div.ds-transfers-wrapper > div.ng-scope > div > div.search-view-container-wrapper > main > div:nth-child(3) > div > div.search-view-items-container > div:nth-child(2) > search-item > div.eva-3-cluster-gallery.-eva-3-shadow-line.-eva-3-shadow-line-hover > div.cluster-container > div.cluster-content > div > div.col.-sm-12.-md-7 > div > span > h1 > strong")).getText();
        String Minivan = driver.findElement(By.cssSelector("#bodyID > div.ds-transfers-wrapper > div.ng-scope > div > div.search-view-container-wrapper > main > div:nth-child(3) > div > div.search-view-items-container > div:nth-child(2) > search-item > div.eva-3-cluster-gallery.-eva-3-shadow-line.-eva-3-shadow-line-hover > div.cluster-container > div.cluster-content > div > div.col.-sm-12.-md-7 > div > span > h1 > span:nth-child(3)")).getText();
        Private = Private + " " + Minivan;
        Assert.assertEquals("Privado Minivan Estándar", Private);
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

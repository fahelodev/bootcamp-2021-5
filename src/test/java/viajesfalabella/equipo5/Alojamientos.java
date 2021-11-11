package viajesfalabella.equipo5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Alojamientos {
    private WebDriver driver;
    private String ORIGEN = "Madrid";
    private int CANTIDAD_DIAS = 7;

    @BeforeClass
    public static void Setup() {
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void Alojamientos01_tooltipsError() throws InterruptedException {
        WebElement seccionAlojamiento = driver.findElement(By.linkText("Alojamientos"));
        seccionAlojamiento.click();
        WebElement btnBuscar = driver.findElement(By.xpath("//*[@id='searchbox']//*[text()='Buscar']"));
        btnBuscar.click();

        List<WebElement> tooltips = driver.findElements(By.xpath("//*[@id='searchbox']//span[@class='validation-msg' and contains(text(),'fecha')]"));

        for (WebElement tooltip : tooltips) {
            Assert.assertTrue(tooltip.isDisplayed());
        }

    }

    @Test
    public void Alojamientos02_detallesFinalCoincide() throws InterruptedException {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        WebElement seccionAlojamiento = driver.findElement(By.linkText("Alojamientos"));
        seccionAlojamiento.click();


        WebElement inputDestino = driver.findElement(By.xpath("//*[@id=\"searchbox\"]//label[text()='Destino']/following::input[1]")),
                inputFechaEntrada = driver.findElement(By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Entrada']")),
                inputFechaSalida = driver.findElement(By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Salida']")),
                btnBuscar = driver.findElement(By.xpath("//*[@id='searchbox']//*[text()='Buscar']")),
                inputHabitaciones = driver.findElement(By.xpath("//*[@id=\"searchbox\"]//label[text()='Habitaciones']"));

        inputDestino.sendKeys(ORIGEN);
        driver.findElement(By.xpath("//div[contains(@class,'ac-wrapper') and contains(@class,'-show')]//li")).click();

        inputFechaEntrada.click();
        List<WebElement> dias = driver.findElements(By.cssSelector("div._dpmg2--months  span._dpmg2--available"));
        dias.get(2).click();
        dias.get(2 + CANTIDAD_DIAS).click();
        inputHabitaciones.click();
        WebElement btnSumarAdulto = driver.findElement(By.xpath("//div[contains(.,'Adultos') and @class='_pnlpk-itemRow']//a[contains(@class,'sbox-3-icon-plus')]"));
        btnSumarAdulto.click();

        //datos ingresados
        String fechaEntradaIngresada = inputFechaEntrada.getAttribute("value");
        String fechaSalidaIngresada = inputFechaSalida.getAttribute("value");

        btnBuscar.click();

        WebElement firstHotelResult = driver.findElement(By.className("results-cluster-container"));
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='results-cluster-container']//span[contains(@class,'main-value')]")));


        int priceSelectedHotel = Integer.parseInt(firstHotelResult.findElement(By.xpath("//div[@class='results-cluster-container']//span[contains(@class,'main-value')]"))
                .getText().replace(".", ""));
        firstHotelResult.findElement(By.xpath("//*[text()='Ver detalle']")).click();

        //cambio de pestana

        driverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.close();
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        driver.findElement(By.xpath("//button[contains(.,'Reservar ahora')]")).click();
        driver.findElement(By.xpath("//button[contains(.,'Siguiente')]")).click();
        //Detalles de pago
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("checkout-details")));
        WebElement detallesPago = driver.findElement(By.className("checkout-details"));
        List<WebElement> dates = detallesPago.findElements(By.xpath("//div[contains(@class,'dm-date')]"));

        int finalTotalPrice = Integer.parseInt(detallesPago.findElement(By.xpath("//span[contains(@upaconceptname,'totalPrice')]"))
                .getText().replace(".", ""));
        String startDate = dates.get(0).getText(),
                endDate = dates.get(1).getText(),
                description = detallesPago.findElement(By.xpath("//div[contains(@class,'dm-description')] ")).getText();

        Assert.assertEquals(finalTotalPrice, priceSelectedHotel, 100);
        Assert.assertTrue(startDate.contains(fechaEntradaIngresada.substring(4).trim()));
        Assert.assertTrue(endDate.contains(fechaSalidaIngresada.substring(4).trim()));
    }

    @Test
    public void Alojamientos03_busquedaYFiltros() throws InterruptedException {
        WebDriverWait driverWait = new WebDriverWait(driver, 10);
        WebElement seccionAlojamiento = driver.findElement(By.linkText("Alojamientos"));
        seccionAlojamiento.click();

        WebElement inputDestino = driver.findElement(By.xpath("//*[@id=\"searchbox\"]//label[text()='Destino']/following::input[1]")),
                inputFechaEntrada = driver.findElement(By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Entrada']")),
                inputFechaSalida = driver.findElement(By.xpath("//*[@id=\"searchbox\"]//input[@placeholder='Salida']")),
                btnBuscar = driver.findElement(By.xpath("//*[@id='searchbox']//*[text()='Buscar']")),
                inputHabitaciones = driver.findElement(By.xpath("//*[@id=\"searchbox\"]//label[text()='Habitaciones']"));

        inputDestino.sendKeys("Madrid");
        driver.findElement(By.xpath("//div[contains(@class,'ac-wrapper') and contains(@class,'-show')]//li")).click();

        inputFechaEntrada.click();
        List<WebElement> dias = driver.findElements(By.cssSelector("div._dpmg2--months  span._dpmg2--available"));
        int CANTIDAD_DIAS = 7;
        dias.get(2).click();
        dias.get(2 + CANTIDAD_DIAS).click();
        inputHabitaciones.click();
        WebElement btnSumarAdulto = driver.findElement(By.xpath("//div[contains(.,'Adultos') and @class='_pnlpk-itemRow']//a[contains(@class,'sbox-3-icon-plus')]"));
        btnSumarAdulto.click();

        //datos ingresados
        String fechaEntradaIngresada = inputFechaEntrada.getAttribute("value");
        String fechaSalidaIngresada = inputFechaSalida.getAttribute("value");

        btnBuscar.click();

        Thread.sleep(2000);

        // Filtros rango de precios
        List<WebElement> priceRangeInputs = driver.findElements(By.xpath("//aloha-input//input[@type='number']"));
        String minPriceInitial = priceRangeInputs.get(0).getAttribute("placeholder"),
                maxPriceInitial = priceRangeInputs.get(1).getAttribute("placeholder");
        int minPrice = (int)(Integer.parseInt(minPriceInitial) + Integer.parseInt(minPriceInitial)*0.25);
        int maxPrice = (int)(Integer.parseInt(maxPriceInitial) - Integer.parseInt(maxPriceInitial)*0.25);
        priceRangeInputs.get(0).sendKeys( String.valueOf(minPrice) );
        priceRangeInputs.get(1).sendKeys( String.valueOf(maxPrice) );
        driver.findElement(By.xpath("//li[contains(.,'Precio')]//aloha-button//button[contains(.,'Aplicar')]")).click();


        //Filtrar régimen por desayuno
        Thread.sleep(3000);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//li[contains(.,'Régimen')]//li[contains(.,'Desayuno')]/span"))));
        driver.findElement(By.xpath("//li[contains(.,'Régimen')]//li[contains(.,'Desayuno')]/span")).click();

        // filtrar hotel 4 estrellas
        Thread.sleep(3000);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//li[contains(.,'Estrellas')]//li[@class='dropdown-subitem'][3]"))));
        driver.findElement(By.xpath("//li[contains(.,'Estrellas')]//li[@class='dropdown-subitem'][3]")).click();


        //Filtrar tipo de alojamiento por hotel
        Thread.sleep(3000);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//li[contains(.,'Tipo de Alojamiento')]//li[contains(.,'Hoteles')]/span"))));
        driver.findElement(By.xpath("//li[contains(.,'Tipo de Alojamiento')]//li[contains(.,'Hoteles')]/span")).click();

        //filtrar por servicio (Wifi)
        Thread.sleep(3000);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(("//li[contains(.,'Servicios')]//div[contains(@class,'view-more-btn')]"))));
        driver.findElement(By.xpath("//li[contains(.,'Servicios')]//div[contains(@class,'view-more-btn')]")).click();
        driver.findElement(By.xpath("//li[contains(.,'Servicios')]//li[contains(.,'Wi-Fi gratis en zonas comunes')]/span")).click();

        Thread.sleep(3000);
        Select sortSelect = new Select(driver.findElement(By.xpath("//div[contains(@class,'sorting-options')]//select")));
        sortSelect.selectByValue("rate_descending");

        Thread.sleep(2000);
        //Corrobar en los hoteles resultados
        List<WebElement> hotels = driver.findElements(By.xpath("//div[@infinitescroll]//div[contains(@class, 'results-cluster-container')]"));

        double puntuacionAnterior = Double.parseDouble(hotels.get(0).findElement(By.xpath("//span[contains(@class,'rating-text')]")).getText());

        WebElement hotelesActive = driver.findElement(By.xpath("//aloha-results-toolbar//li[contains(.,'Hoteles') and contains(@class,'-active')]"));
        Assert.assertTrue(hotelesActive.isDisplayed());

        for (WebElement hotel : hotels) {
            int cantidadEstrellas = hotel.findElements(By.xpath("//div[@class='score-container']//i[@class='eva-3-icon-star']")).size();
            double puntuacionActual = Double.parseDouble(hotel.findElement(By.xpath("//span[contains(@class,'rating-text')]")).getText());
            WebElement wifi = hotel.findElement(By.xpath("//i[contains(@class, 'eva-3-icon-wifi')]"));
            WebElement desayuno = hotel.findElement(By.xpath("//div[contains(., 'Desayuno')]/img"));
            int precio = Integer.parseInt(hotel.findElement(By.xpath(" //span[@class='main-value']")).getText().replace(".",""));

            Assert.assertTrue(puntuacionActual <= puntuacionAnterior);
            Assert.assertTrue(wifi.isDisplayed());
            Assert.assertTrue(desayuno.isDisplayed());
            Assert.assertTrue(precio > minPrice & precio < maxPrice);

            puntuacionAnterior = puntuacionActual;
        }

    }

    @After
    public void after() {
        if (driver != null) {
            driver.close();
        }
    }
}

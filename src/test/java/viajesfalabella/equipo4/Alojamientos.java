package viajesfalabella.equipo4;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;




public class Alojamientos{

    private WebDriver driver;
    private WebDriverWait wait;
    private ArrayList<String> tabs2;
    private List<WebElement> categorias;

    @BeforeClass
    public static void Setup(){
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void init(){
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        categorias  = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
    }

    @Test
    public void T_Aloj_Bajo() throws InterruptedException {
        //Obtenemos una lista con todas las categorias y le hacemos click cuando encuentre Alojamientos
        busqueda(categorias,"Alojamientos");

        //Ingresamos Londres en la caja de busqueda Destino
       WebElement destino = driver.findElement(By.cssSelector("div.input-container .sbox-destination"));
       destino.sendKeys("Londres");
       //Esperamos a que se despliegue la lista y le damos ENTER a la primera opcion
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.item")));
       destino.sendKeys(Keys.ENTER);

       //Click en el checkbox Todavía no he decidido la fecha
        driver.findElement(By.xpath("//label[@class='checkbox-label']")).click();
        //Click en el boton Buscar
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        //Filtramos los resultados por Mejor puntuacion
        Select s1 = new Select(driver.findElement(By.id("sorting")));
        s1.selectByVisibleText("Mejor puntuación");

        //Filtramos los resultados por moneda Dolar
        Select s = new Select(driver.findElement(By.id("currency")));
        s.selectByVisibleText("Dólar");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[starts-with(@class,'checkbox-label')]")));

        //Listamos de los resultados todos los nombres de los alojamientos y le damos click al encontrar el solicitado
        busquedaAlojamiento("The Chelsea Harbour Hotel");

        //Obtenemos una lista de cada FAQ y las desplegamos una por una
        int count = driver.findElements(By.cssSelector(".-detail-section-padding .dropdown-item")).size();
        for (int i = 0; i < count; i++) {
            driver.findElements(By.cssSelector(".-detail-section-padding .dropdown-item")).get(i).click();
        }

        //Capturamos el titulo del alojamiento seleccionado
        String TituloHotel = driver.findElement(By.xpath("//span[@class='accommodation-name eva-3-h2']")).getText();

        String checkTituloHotel = "The Chelsea Harbour Hotel";

        Assert.assertEquals(checkTituloHotel,TituloHotel);

    }

    @Test
    public void T_Aloj_Medio() throws InterruptedException {

        busqueda(categorias,"Alojamientos");

        WebElement destino = driver.findElement(By.cssSelector("div.input-container .sbox-destination"));
        destino.sendKeys("El Cairo");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.item")));
        destino.sendKeys(Keys.ENTER);

        Thread.sleep(1500);
        driver.findElement(By.cssSelector("div.sbox-distri-container")).click();
        driver.findElement(By.cssSelector("a.steppers-icon-left ")).click();
        driver.findElement(By.cssSelector("a._pnlpk-apply-button")).click();
        driver.findElement(By.xpath("//label[@class='checkbox-label']")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        Thread.sleep(1500);
        busquedaFiltro("Wi-Fi gratis en zonas comunes");

        Select s = new Select(driver.findElement(By.id("sorting")));
        s.selectByValue("price_ascending");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#hotels .results-cluster-container .hf-cluster-title")));
        Thread.sleep(1500);


        busquedaAlojamiento("Ramses Hilton");

        driver.findElement(By.cssSelector("a.scroll-to-reviews")).click();
        driver.findElement(By.xpath("//label[contains(text(),'En solitario')]")).click();


    }

    @Test
    public void T_Aloj_Alto() throws InterruptedException {

        busqueda(categorias,"Alojamientos");

        WebElement destino = driver.findElement(By.cssSelector("div.input-container .sbox-destination"));
        destino.sendKeys("montego bay");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.item")));
        destino.sendKeys(Keys.ENTER);


        driver.findElement(By.cssSelector("div.input-container .sbox-checkin-date")).click();
        busquedaFecha("1","8");

        driver.findElement(By.cssSelector("div.sbox-distri-container")).click();
        agregarMenores(3);

        for (int i = 0; i < 3; i++) {
            int count = driver.findElements(By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']//select[@class='select-tag'] ")).size();
            driver.findElements(By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']//select[@class='select-tag'] ")).get(i).click();
            driver.findElements(By.xpath("//select[@class='select-tag'] //option[@value='4']")).get(i).click();
        }
        driver.findElement(By.cssSelector("a._pnlpk-apply-button")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        Select s = new Select(driver.findElement(By.xpath("//div[@class='currency-selection'] //select[@class='select-tag']")));
        s.selectByValue("USD");


        busquedaAlojamiento("Iberostar Rose Hall Beach");



        assertTrue(true);
    }

    private void busqueda(List<WebElement> lista, String palabra){
        for (WebElement l: lista){
            if (l.getText().contains(palabra)){
                l.click();
                break;
            }
        }
    }

    private void busquedaFecha(String fechaEntrada,String fechaSalida){
        int count = driver.findElements(By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number")).size();
        Calendar calendario = Calendar.getInstance();

        for (int i = 0; i < count; i++) {
            String fechas = driver.findElements(By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number")).get(i).getText();
            if(fechas.equals(fechaEntrada)){
                driver.findElements(By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number")).get(i).click();
                break;
            }
        }
        for (int i = Integer.parseInt(fechaEntrada); i < count; i++) {
            String fechas = driver.findElements(By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number")).get(i).getText();
            if(fechas.equals(fechaSalida)){
                driver.findElements(By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number")).get(i).click();
                driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]")).click();
                break;
            }
        }
    }

    private void busquedaDireccion(String direccion){
        int count = driver.findElements(By.cssSelector("div.ac-container span")).size();

        for (int i = 0; i < count; i++) {
            String direcciones = driver.findElements(By.cssSelector("div.ac-container span")).get(i).getText();
            if (direcciones.equals(direccion)){
                driver.findElements(By.cssSelector("div.ac-container span")).get(i).click();
                break;
            }
        }
    }

    private void busquedaFiltro(String filtro){
        int count = driver.findElements(By.cssSelector("ul.eva-3-dropdown .filters-text-label")).size();

        for (int i = 0; i < count; i++) {
            String filtros = driver.findElements(By.cssSelector("ul.eva-3-dropdown .filters-text-label")).get(i).getText();
            if (filtros.equals(filtro)){
                driver.findElements(By.cssSelector("ul.eva-3-dropdown .filters-text-label")).get(i).click();
                break;
            }
        }
    }

    private void busquedaAlojamiento(String alojamiento) throws InterruptedException {
        int count = driver.findElements(By.xpath("//a[contains(text(),'"+alojamiento+"')]")).size();
        for (int i = 0; i < count; i++) {
            String alojamientos = driver.findElements(By.xpath("//a[contains(text(),'"+alojamiento+"')]")).get(i).getText();
            if(alojamientos.equals(alojamiento)){
                driver.findElements(By.xpath("//a[contains(text(),'"+alojamiento+"')]")).get(i).click();
                Thread.sleep(1500);
                selectPestana(1);
                break;
            }
        }
    }

    public void selectPestana(int index) {
        tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(index));
    }

    public void agregarMenores(int menores) {
        for (int i = 0; i < menores; i++) {
            driver.findElement(By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg'] //a[@class='steppers-icon-right sbox-3-icon-plus']")).click();
        }
    }

    @After
    public void close() throws InterruptedException {
        if(driver != null){
            Thread.sleep(4000);
            driver.quit();
        }

    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");

    }


}






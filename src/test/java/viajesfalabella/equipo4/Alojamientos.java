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
    private ArrayList<String> tabs2;

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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void T_Aloj_Bajo() throws InterruptedException {
        List<WebElement> categorias  = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
        WebDriverWait wait = new WebDriverWait(driver,10);
        busqueda(categorias,"Alojamientos");

       WebElement destino = driver.findElement(By.cssSelector("div.input-container .sbox-destination"));
       destino.sendKeys("Londres");
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.item")));
       destino.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//label[@class='checkbox-label']")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        Select s = new Select(driver.findElement(By.id("currency")));
        s.selectByValue("USD");
        s = new Select(driver.findElement(By.id("sorting")));
        s.selectByValue("rate_descending");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#hotels .results-cluster-container .hf-cluster-title")));
<<<<<<< HEAD
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@slot,'element')]")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[starts-with(@class,'checkbox-label')]")));
=======
>>>>>>> ab5dd0eaaef19246c94e1e18b1e3d9ab78bd0cfa
        Thread.sleep(1500);
        busquedaAlojamiento("The Chelsea Harbour Hotel");

        int count = driver.findElements(By.cssSelector(".-detail-section-padding .dropdown-item")).size();
        for (int i = 0; i < count; i++) {
            driver.findElements(By.cssSelector(".-detail-section-padding .dropdown-item")).get(i).click();
        }


<<<<<<< HEAD
=======
        int moneda = driver.findElements(By.cssSelector("span.hf-pricebox-price-currency")).size();
        boolean errorDolar = false;
        for (int i = 0; i < moneda; i++) {
            String marca = driver.findElements(By.cssSelector("span.hf-pricebox-price-currency")).get(i).getText();
            if(!marca.equals("US$ ")){
                errorDolar = true;
                break;
            }
        }

>>>>>>> ab5dd0eaaef19246c94e1e18b1e3d9ab78bd0cfa
        String TituloHotel = driver.findElement(By.xpath("//span[@class='accommodation-name eva-3-h2']")).getText();
        String checkTituloHotel = "The Chelsea Harbour Hotel";


<<<<<<< HEAD
=======
        assertFalse(errorDolar); //Comprobacion de filtro dolar aplicado
>>>>>>> ab5dd0eaaef19246c94e1e18b1e3d9ab78bd0cfa
        Assert.assertEquals(checkTituloHotel,TituloHotel);

    }

    @Test
    public void T_Aloj_Medio() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        List<WebElement> categorias = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
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
        WebDriverWait wait = new WebDriverWait(driver,10);
        List<WebElement> categorias = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
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
        int count = driver.findElements(By.cssSelector("#hotels .results-cluster-container .hf-cluster-title")).size();
        for (int i = 0; i < count; i++) {
            String alojamientos = driver.findElements(By.cssSelector("#hotels .results-cluster-container .hf-cluster-title")).get(i).getText();
            if(alojamientos.equals(alojamiento)){
                driver.findElements(By.cssSelector("#hotels .results-cluster-container .hf-cluster-title")).get(i).click();
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






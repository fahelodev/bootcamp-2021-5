package viajesfalabella.equipo4;

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

import static org.junit.Assert.assertTrue;

public class Autos {
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
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://www.viajesfalabella.cl/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void T_Autos_Bajo(){
        List<WebElement> categorias = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
        busqueda(categorias,"Autos");

        driver.findElement(By.cssSelector("div.sbox-moments .sbox-checkin")).click();

        busquedaFecha("17","24");
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();
        String Error = driver.findElement(By.xpath("//span[contains(text(),'Ingresa un lugar de arriendo.')]")).getText();

        String checkError = "Ingresa un lugar de arriendo.";
        Assert.assertEquals(checkError,Error);
    }

    @Test
    public void T_Autos_Medio(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        List<WebElement> categorias = driver.findElements(By.cssSelector("div.header-products-container ul li a"));
        busqueda(categorias,"Autos");

        driver.findElement(By.xpath("//label[@class='checkbox-label']")).click();
        driver.findElement(By.cssSelector("div.sbox-place-container input")).sendKeys("miam");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ac-container")));

        busquedaDireccion("Aeropuerto Internacional Miami, Miami, Estados Unidos");


        driver.findElement(By.cssSelector("div.sbox-second-place-container input")).sendKeys("orlando");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ac-container")));

        busquedaDireccion("Aeropuerto Internacional Orlando, Orlando, Estados Unidos");

        driver.findElement(By.cssSelector("div.sbox-moments .sbox-checkin")).click();
        busquedaFecha("17","24");
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();


        busquedaFiltro("Avis");
        busquedaFiltro("5 Personas");




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

    private void busquedaFecha(String fechaRetiro,String fechaDevolucion){
        int count = driver.findElements(By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number")).size();
        Calendar calendario = Calendar.getInstance();

        for (int i = 0; i < count; i++) {
           String fechas = driver.findElements(By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number")).get(i).getText();
            if(fechas.equals(fechaRetiro)){
                driver.findElements(By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number")).get(i).click();
                break;
            }
        }
        for (int i = Integer.parseInt(fechaRetiro); i < count; i++) {
            String fechas = driver.findElements(By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number")).get(i).getText();
            if(fechas.equals(fechaDevolucion)){
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
        int count = driver.findElements(By.cssSelector("ul.eva-3-dropdown .filters-checkbox")).size();

        for (int i = 0; i < count; i++) {
            String filtros = driver.findElements(By.cssSelector("ul.eva-3-dropdown .filters-checkbox")).get(i).getText();
            if (filtros.equals(filtro)){
                driver.findElements(By.cssSelector("ul.eva-3-dropdown .filters-checkbox")).get(i).click();
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

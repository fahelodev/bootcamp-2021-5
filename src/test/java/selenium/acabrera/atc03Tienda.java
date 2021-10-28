package selenium.acabrera;

import com.google.common.util.concurrent.ListenableFuture;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class atc03Tienda {

    private WebDriver driver;

    @BeforeClass
    public static void Setup(){


        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        String pagina = "http://automationpractice.com/";
        driver.get(pagina);
        String titulo = driver.getTitle();
        String errorCarga = "508 Resource Limit Is Reached";


        while (Objects.equals(titulo,errorCarga)){
            driver.navigate().refresh();
        }
    }



    /*@Test
    public void act01busquedaPalabra() throws InterruptedException {

        String mensajePrueba = "dress";
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys(mensajePrueba);
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).click();
        Thread.sleep(3000);
        WebElement ul_element = driver.findElement(By.xpath("//*[@id=\'best-sellers_block_right\']/div/ul"));

        List<WebElement> li_All = ul_element.findElements(By.tagName("li"));

        System.out.println(li_All.size());


        int resultado = 0;


        if (li_All.size() > 1){
            resultado = 2;
        }
        else{
            resultado = 0;
        }

        assertEquals(2,resultado);
    }*/

    /*@Test
    public  void  atc02busquedaDirecta() throws InterruptedException {
        String mensajePrueba = "printed chiffon dress";
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys(mensajePrueba);
        driver.findElement(By.cssSelector("#searchbox > button")).click();
        Thread.sleep(3000);



    }*/

   /* @Test
    public void atc03Mensaje() throws InterruptedException {

        String mensaje = "liquido matapulgas";
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys(mensaje);
        driver.findElement(By.xpath("//*[@id=\'searchbox\']/button")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String resultado = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText().replaceAll("\"", "");
        String mensajeEsperado = "No results were found for your search liquido matapulgas";
        assertEquals(mensajeEsperado,resultado);
    }*/

   /* @Test
    public void atc04Encontrar() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver,15);
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("blo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results > ul > li")));
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String categoria = driver.findElement(By.cssSelector("#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > h1")).getText();
        String modelo = driver.findElement(By.cssSelector("#product_reference")).getText();
        String resultado = categoria + " " + modelo;
        String mensajeEsperado = "Blouse Model demo_2";
        assertEquals(resultado,mensajeEsperado);

        System.out.println(resultado);
        System.out.println(mensajeEsperado);
    }*/

    @Test
    public void atc05agregarProducto() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,15);
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("blo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#index > div.ac_results > ul > li")));
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys(Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy (0,300)", "");
        Thread.sleep(3000);
        Select s = new Select(driver.findElement(By.id("group_1")));
        s.selectByVisibleText("L");
        driver.findElement(By.id("color_8")).click();
        driver.findElement(By.xpath("//*[@id=\'add_to_cart\']/button/span")).click();
        Thread.sleep(3000);
        String productoAgregado = driver.findElement(By.xpath("//*[@id=\'layer_cart_product_attributes\']")).getText();
        String productoEsperado = "White, L";

        assertEquals(productoEsperado,productoAgregado);




    }


    @After
    public void cerrar() {


        if (driver != null) {
            driver.close();
        }
    }

}

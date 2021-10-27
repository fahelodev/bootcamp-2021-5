package selenium.clopez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.Keys.*;

public class act03_tiendaEmiteMensajeProductoNoEncontrado {

    private WebDriver driver;

    @BeforeClass
    public static void Setup(){
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void init() throws InterruptedException {
        System.out.println("init para instanciar");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        // 1.- Cargar Home
        driver.get("http://automationpractice.com//");
        // Esperamos
        Thread.sleep(2000);
        while (driver.getTitle() == "508 Error - Resource Limit Reached"){
            driver.navigate().refresh();
            // Esperamos
            Thread.sleep(1000);
        }
    }

    @Test
    public void atc02_busquedaDirectaProductoExistente() throws InterruptedException {
        // 2.- Introdrucir "liquido matapulgas"
        // 3.- Hacer la búsqueda introduciendo Enter en el campo de búsqueda
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("liquido matapulgas"+ Keys.ENTER);
        // 4.- Esperar a que cargue la página de Resultados.
        Thread.sleep(2000);
        // Tomamos la frase encontrada y la pasamos a un String
        String frase = driver.findElement(By.cssSelector("p.alert.alert-warning")).getText();
        // System.out.println("frase: "+frase);
        // Reemplazamos comillas dobles por simples de la frase para luego poder comparar
        frase = frase.replaceAll("\"", "\'");
        // 5.- Si muestra el mensaje el test es positivo
        Assert.assertEquals( "No results were found for your search 'liquido matapulgas'", frase);
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
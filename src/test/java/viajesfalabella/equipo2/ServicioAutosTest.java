package viajesfalabella.equipo2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class ServicioAutosTest {

    private WebDriver driver;
    private WebDriverWait espera;

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
        driver.get("https://www.viajesfalabella.cl");
        espera= new WebDriverWait(driver, 7);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

    }

    @Test
    public void caso06() {

        //click en autos
        driver.findElement(By.xpath("//label[contains(text(),'Autos')]")).click();

        //ingresamos "buenos aires" en el campo "lugar de entrega"
        espera.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("input.input-tag.sbox-main-focus"))));
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus")).sendKeys("Buenos Aires");

        espera.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div.ac-container ul li"))));
        List<WebElement> listaAlojamientos = driver.findElements(By.cssSelector("div.ac-container ul li"));
        System.out.println(listaAlojamientos.size());

        /*recorre la lista y compara cual es igual a Aeropuerto Buenos Aires Ministro Pistarini Ezeiza,
         Buenos Aires, Argentina y en caso que se encuentre hace click*/
        for (WebElement elemento : listaAlojamientos) {
            if (elemento.getText().equals("Aeropuerto Buenos Aires Ministro Pistarini Ezeiza, Buenos Aires, Argentina")) {
                elemento.click();
                break;
            }
        }
        //ingreamos la fecha de retiro
        driver.findElement(By.xpath("//input[@placeholder='Retiro']")).click();

        //seleccionamos la fecha de hoy
        driver.findElement(By.xpath("//span[contains(text(),'Hoy')]")).click();
        //seleccionamos la hora "13:00"
        Select horaRetiro = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-timein")));
        horaRetiro.selectByVisibleText("13:00");

        //ingreamos la fecha de devolucion
        driver.findElement(By.xpath("//input[@placeholder='Devolución']")).click();
        //seleccionamos la fecha de hoy
        driver.findElement(By.xpath("//span[contains(text(),'Hoy')]")).click();
        Select horaDevolucion = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-timeout")));
        //seleccionamos la hora "23:00"
        horaDevolucion.selectByVisibleText("23:00");

        //click en el boton buscar
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        String resultado= driver.findElement(By.cssSelector("p.message-text.eva-3-p.error-message-description")).getText();
        assertEquals("La fecha en la que buscaste es anterior al día de hoy. Por favor, cambia la fecha para ver autos disponibles.",resultado);
    }

    @Test
    public void caso07() {
        //click en autos
        driver.findElement(By.xpath("//label[contains(text(),'Autos')]")).click();

        //ingresamos en el campo "lugar de entrega"
        espera.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("input.input-tag.sbox-main-focus"))));
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus")).sendKeys("Córdoba");

        espera.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div.ac-container ul li"))));
        List<WebElement> listaAlojamientos = driver.findElements(By.cssSelector("div.ac-container ul li"));

        //recorre la lista y compara cual es igual a Córdoba, Córdoba, Argentina y en caso que se encuentre hace click

        for (WebElement elemento : listaAlojamientos) {
            if (elemento.getText().equals("Córdoba, Córdoba, Argentina")) {
                elemento.click();
                break;
            }
        }

        //click en fecha de retiro
        driver.findElement(By.xpath("//input[@placeholder='Retiro']")).click();

        //seleccionamos la fecha "8 de noviembre"
        driver.findElement(By.xpath("//span[contains(text(),'8')]")).click();
        //seleccionamos la hora "13:00"
        Select horaRetiro = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-timein")));
        horaRetiro.selectByVisibleText("13:00");

        //click en fecha de devolucion
        driver.findElement(By.xpath("//input[@placeholder='Devolución']")).click();
        //seleccionamos la fecha "13 de noviembre"
        driver.findElement(By.xpath("//span[contains(text(),'13')]")).click();
        //seleccionamos la hora "13:00"
        Select horaDevolucion = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-timeout")));
        horaDevolucion.selectByVisibleText("13:00");

        //click en boton buscar
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

    }

    @Test
    public void caso08(){

        //click en autos
        driver.findElement(By.xpath("//label[contains(text(),'Autos')]")).click();

        //hace click en devolver en otro lugar
        driver.findElement(By.xpath("//label[contains(text(),'Devolverlo en otro destino')]")).click();

        //ingresamos la palabra "cordoba" en el campo "lugar de devolucion"
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus")).sendKeys("Cordoba");

        //recorre la lista y compara cual es igual a Cordoba, Argentina y en caso que se encuentre hace click
        List<WebElement> listaEntrega = driver.findElements(By.cssSelector("div.ac-container ul li"));
        for (WebElement elemento : listaEntrega) {
            if (elemento.getText().equals("Taravella International Airport, Córdoba, Argentina")) {
                elemento.click();
                break;
            }
        }
        //ingresa buenos aires en el campo "lugar de entrega"
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus.sbox-devolution.sbox-secondary.undefined")).sendKeys("Buenos Aires");

        /*recorre la lista y compara cual es igual a Aeropuerto Buenos Aires Ministro Pistarini Ezeiza, Buenos Aires, Argentina
         y en caso que se encuentre hace click*/
        List<WebElement> listaDevolucion = driver.findElements(By.cssSelector("div.ac-container ul li"));
        for (WebElement elemento : listaDevolucion) {
            if (elemento.getText().equals("Aeropuerto Buenos Aires Ministro Pistarini Ezeiza, Buenos Aires, Argentina")) {
                elemento.click();
                break;
            }
        }

        //click en "fecha de retiro"
        driver.findElement(By.xpath("//input[@placeholder='Retiro']")).click();

        //seleccionamos la fecha "8 de noviembre"
        driver.findElement(By.xpath("//span[contains(text(),'8')]")).click();
        //seleccionamos la hora "13:00"
        Select horaRetiro = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-timein")));
        horaRetiro.selectByVisibleText("13:00");

        //click en "fecha de devolucion"
        driver.findElement(By.xpath("//input[@placeholder='Devolución']")).click();
        //seleccionamos la fecha "11 de noviembre"
        driver.findElement(By.xpath("//span[contains(text(),'11')]")).click();
        //seleccionamos la hora "13:00"
        Select horaDevolucion = new Select(driver.findElement(By.cssSelector("select.select-tag.sbox-timeout")));
        horaDevolucion.selectByVisibleText("13:00");

        //click en el boton buscar
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

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

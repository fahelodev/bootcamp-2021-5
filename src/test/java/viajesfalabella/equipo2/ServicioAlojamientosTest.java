package viajesfalabella.equipo2;

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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServicioAlojamientosTest {

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
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }

    @Test
    public void caso00() {
        driver.findElement(By.xpath("//label[contains(text(),'Alojamientos')]")).click();

        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-distri-container")));
        driver.findElement(By.cssSelector("div.sbox-distri-container")).click();
        driver.findElement(By.cssSelector("div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus")).click();;
        driver.findElement(By.xpath("//a[contains(text(),'Aplicar')]")).click();
        String resultado=driver.findElement(By.xpath("//p[contains(text(),'Ingresa la edad del menor')]")).getText();

        assertEquals("Ingresa la edad del menor",resultado);
    }

    @Test
    public void caso01() {
        driver.findElement(By.xpath("//label[contains(text(),'Alojamientos')]")).click();
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus")).sendKeys("cordoba");

        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Córdoba, Córdoba, Argentina')]")));
        List<WebElement> listaAlojamientos = driver.findElements(By.cssSelector("div.ac-container ul>li"));

        //recorro la lista y comparo cual es igual a Córdoba, Córdoba, Argentina y en casp que se encuentre hago click
        for (WebElement elemento:listaAlojamientos) {
            if(elemento.getText().equals("Córdoba, Córdoba, Argentina")) {
                elemento.click();
                break;
            }
        }
        driver.findElement(By.cssSelector("input.input-tag.sbox-checkin-date")).click();
        driver.findElement(By.xpath("//span[contains(text(),'8')]")).click();
        driver.findElement(By.cssSelector(" input.input-tag.sbox-checkout-date")).click();
        driver.findElement(By.xpath("//span[contains(text(),'12')]")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.dropdown-item-container.disabled-item")));
        //  String a=  driver.findElement(By.cssSelector("span.dropdown-item-container.disabled-item")).getText();
        Integer resultado= Integer.parseInt(driver.findElement(By.cssSelector("span.dropdown-item-container.disabled-item span.filters-quantity")).getText());
        System.out.println(resultado);
        assertTrue(resultado>=1);
    }


        @After
        public void close() {
            if (driver != null) {
                //driver.close();
            }

        }

        @AfterClass
        public static void closeAll() {
            System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");

        }

    }

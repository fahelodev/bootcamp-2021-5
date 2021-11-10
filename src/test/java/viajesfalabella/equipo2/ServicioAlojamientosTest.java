package viajesfalabella.equipo2;

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
import java.util.List;
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
        espera = new WebDriverWait(driver, 7);

    }

    @Test
    public void caso00() {

        //click en alojamiento
        driver.findElement(By.xpath("//label[contains(text(),'Alojamientos')]")).click();

        //tiempo de espera para que cargue el desplegable de "Habitaciones"
        espera.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.sbox-distri-container")));

        //click en Habitaciones
        driver.findElement(By.cssSelector("div.sbox-distri-container")).click();
        //Clic en (+) en la opcion de menores
        driver.findElement(By.cssSelector("div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus")).click();
        //Click en el boton "Aplicar"
        driver.findElement(By.xpath("//a[contains(text(),'Aplicar')]")).click();
        //Se pasa el texto del mensaje a una variable de tipo String
        String resultado = driver.findElement(By.xpath("//p[contains(text(),'Ingresa la edad del menor')]")).getText();

        assertEquals("Ingresa la edad del menor", resultado);
    }

    @Test
    public void caso01() {

        //Click en la opcion de alojamientos
        driver.findElement(By.xpath("//label[contains(text(),'Alojamientos')]")).click();

        //Ingresa la palabra "cordoba" en el campo "Destino"
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus")).sendKeys("cordoba");

        //Se obtiene la lista y se selecciona la opcion cordoba
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Córdoba, Córdoba, Argentina')]")));
        List<WebElement> listaAlojamientos = driver.findElements(By.cssSelector("div.ac-container ul>li"));

        //recorre la lista y compara cual es igual a Córdoba, Córdoba, Argentina y en cas0 que se encuentre hace click
        for (WebElement elemento : listaAlojamientos) {
            if (elemento.getText().equals("Córdoba, Córdoba, Argentina")) {
                elemento.click();
                break;
            }
        }

        //Seleccionamos el campo fecha de entrada
        driver.findElement(By.cssSelector("input.input-tag.sbox-checkin-date")).click();

        //selecciona el dia 8 del mes actual
        driver.findElement(By.xpath("//span[contains(text(),'22')]")).click();

        //selecciona el campo de salida
        driver.findElement(By.cssSelector(" input.input-tag.sbox-checkout-date")).click();
        //selecciona el dia 12 del mes actual
        driver.findElement(By.xpath("//span[contains(text(),'26')]")).click();

        //click en el boton buscar
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.dropdown-item-container.disabled-item")));
        //Se obtiene la cantidad de alojamientos
        Integer resultado = Integer.parseInt(driver.findElement(By.cssSelector("span.dropdown-item-container.disabled-item span.filters-quantity")).getText());
        //Se valida que existe al menos un alojamiento
        assertTrue(resultado >= 1);
    }

    @Test
    public void caso02() {
        //click en alojamiento
        driver.findElement(By.xpath("//label[contains(text(),'Alojamientos')]")).click();

        //ingresa la palabra "cordoba"
        driver.findElement(By.cssSelector("input.input-tag.sbox-main-focus")).sendKeys("cordoba");
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Córdoba, Córdoba, Argentina')]")));

        //recorre la lista y compara cual es igual a Córdoba, Córdoba, Argentina y en caso que se encuentre hace click
        List<WebElement> listaAlojamientos = driver.findElements(By.cssSelector("div.ac-container ul>li"));
        for (WebElement elemento : listaAlojamientos) {
            if (elemento.getText().equals("Córdoba, Córdoba, Argentina")) {
                elemento.click();
                break;
            }
        }
        //Seleccion de la fecha de entrada
        driver.findElement(By.cssSelector("input.input-tag.sbox-checkin-date")).click();

        //seleccion la fecha de entrada 22 de noviembre
        driver.findElement(By.xpath("//span[contains(text(),'22')]")).click();

        //Seleccion de la fecha de salida
        driver.findElement(By.cssSelector(" input.input-tag.sbox-checkout-date")).click();

        //seleccion fecha de salida 26 noviembre
        driver.findElement(By.xpath("//span[contains(text(),'26')]")).click();

        //Click en el boton buscar
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();


        //seleccion de la moneda en Dolares
        Select moneda = new Select(driver.findElement(By.cssSelector("Select.select-tag")));
        moneda.selectByValue("USD");

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='input-tag' and @placeholder=@min]")));
        //se ingresa en el campo de valor minimo
        driver.findElement(By.xpath("//input[@class='input-tag' and @placeholder=@min]")).sendKeys("110");



        //ingresamos el valor maximo
        driver.findElement(By.xpath("//input[@class='input-tag' and @placeholder=@max]")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        driver.findElement(By.xpath("//input[@class='input-tag' and @placeholder=@max]")).sendKeys("400");
       // espera.until(ExpectedConditions.textToBe( By.xpath("//input[@class='input-tag' and @placeholder=@max]"),"400"));

        //Click en el boton aplicar
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]")).click();

        //se obtiene una lista de los filtros y se selecciona la opcion centro
        List<WebElement> listaFiltros = driver.findElements(By.xpath("//ul[@class='eva-3-dropdown']//ul[@class='dropdown-subcontent']/li[@class='dropdown-subitem']//span[@class='eva-3-checkbox']//span[contains(.,'Centro')]"));
        //System.out.println(listaFiltros.size());
        String a = driver.findElement(By.xpath("//ul[@class='eva-3-dropdown']//ul[@class='dropdown-subcontent']/li[@class='dropdown-subitem']//span[@class='eva-3-checkbox']//span[contains(.,'Centro')]")).getText();
        //System.out.println(a);

        //recorre la lista y compara cual es igual a centro y en caso que se encuentre hace click
        for (WebElement elemento : listaFiltros) {
            if (elemento.getText().equals("Centro")) {
                elemento.click();
            }
        }

        espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//ul[@class='eva-3-dropdown']//ul[@class='dropdown-subcontent']/li[@class='dropdown-subitem']//span[contains(.,'Centro')]//span [@class='filters-quantity']"))));
        String resultadoFinal = driver.findElement(By.xpath("//ul[@class='eva-3-dropdown']//ul[@class='dropdown-subcontent']/li[@class='dropdown-subitem']//span[contains(.,'Centro')]//span [@class='filters-quantity']")).getText();
        System.out.println(resultadoFinal);
        Integer res = Integer.valueOf(resultadoFinal);
        assertTrue("El numero total de alojaminetos es" + res, res > 1);
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
package viajesfalabella.equipo6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class AutomationVuelosFalabella {

    private WebDriver driver;

    @BeforeClass
    public static void Setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.viajesfalabella.cl");
    }

    @Test
    public void vuelo_falabella001(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.cssSelector("a[title='Vuelos']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Ingresa desde dónde viajas']")).sendKeys("Buenos Aires");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Buenos Aires, Ciudad de Buenos Aires, Argentina']"))).click();
        driver.findElement(By.xpath("//input[contains(@placeholder,'Ingresa hacia dónde viajas')]")).sendKeys("Cordoba Arg");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Córdoba, Córdoba, Argentina']"))).click();
        driver.findElement(By.xpath("//label[.='Todavía no he decidido la fecha']")).click();
        driver.findElement(By.xpath("//em[.='Buscar']")).click();
    }

    @Test
    public void vuelo_falabella002(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(By.cssSelector("a[title='Vuelos']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Solo ida')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Ingresa desde dónde viajas']")).sendKeys("Cordoba Arg");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Córdoba, Córdoba, Argentina']"))).click();
        driver.findElement(By.xpath("//input[contains(@placeholder,'Ingresa hacia dónde viajas')]")).sendKeys("Ile de France, Francia");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='París, Ile de France, Francia']"))).click();
        //Seleccionamos la fecha de ida
        driver.findElement(By.cssSelector("[placeholder='Ida']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--dates']/span[.='22']"))).click();
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]")).click();
        //Se agregan los pasajeros
        driver.findElement(By.cssSelector(".sbox-flights-double-distribution-picker")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._pnlpk-panel--show ._pnlpk-stepper-minors .steppers-icon-right"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._pnlpk-panel--show ._pnlpk-minor-age-select-last-item .select-tag"))).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']/div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//option[.='5 años']")).click();
        // Selecciona la clase
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_pnlpk-itemRow_item _pnlpk-select-flight-class-type -medium-down-to-lg']//select[@class='select-tag']"))).click();
        driver.findElement(By.xpath("//option[.='Premium economy']")).click();
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-apply-button")).click();
        driver.findElement(By.cssSelector("a.-md.sbox-search")).click();
    }
    @Test
    public void vuelo_falabella003() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(By.cssSelector("a[title='Vuelos']")).click();
        driver.findElement(By.xpath("//span[@class='radio-label'][normalize-space()='Ida y vuelta']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Ingresa desde dónde viajas']")).sendKeys("Buenos Aires");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Buenos Aires, Ciudad de Buenos Aires, Argentina']"))).click();
        driver.findElement(By.xpath("//input[contains(@placeholder,'Ingresa hacia dónde viajas')]")).sendKeys("Londres");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Londres, Inglaterra, Reino Unido']"))).click();
        //Seleecionamos la fecha de ida y vuelta
        driver.findElement(By.cssSelector("[placeholder='Ida']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--dates']/span[.='22']"))).click();
        driver.findElement(By.cssSelector("[placeholder='Vuelta']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--has-start-range _dpmg2--month-active']//span[.='26DíaDías']"))).click();
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]")).click();
        //Se agregan pasajeros
        driver.findElement(By.cssSelector(".sbox-flights-double-distribution-picker")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._pnlpk-panel--show ._pnlpk-stepper-minors .steppers-icon-right"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("._pnlpk-panel--show ._pnlpk-minor-age-select-last-item .select-tag"))).click();
        driver.findElement(By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']/div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//option[.='8 años']")).click();
        //Se seleeciona la clase
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_pnlpk-itemRow_item _pnlpk-select-flight-class-type -medium-down-to-lg']//select[@class='select-tag']"))).click();
        driver.findElement(By.xpath("//option[.='Ejecutiva/Business']")).click();
        driver.findElement(By.cssSelector("._pnlpk-panel--show ._pnlpk-apply-button")).click();
        driver.findElement(By.xpath("//div[@class='sbox-button -ml3-l']//em[@class='btn-text']")).click();
        //Se utilizan los filtros
        driver.findElement(By.xpath("//checkbox-filter[@class='stops']//span[@class='eva-3-checkbox']//span[.='1 Escala']")).click();
        WebElement loader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".loader-modal-content")));
        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//checkbox-filter[@class='baggage']/checkbox-filter-item[2]//i[@class='checkbox-check eva-3-icon-checkmark filters-checkbox-left']"))).click();
        loader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".loader-modal-content")));
        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='eva-select']"))).click();
        driver.findElement(By.xpath("//option[contains(.,'Dólares estadounidenses')]")).click();
        loader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".loader-modal-content")));
        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='order'] select[id='eva-select']"))).click();
        driver.findElement(By.xpath("//option[contains(.,'Más convenientes')]")).click();
        loader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".loader-modal-content")));
        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='clusters']/span[1]//em[@class='btn-text']"))).click();

    }
    @After
    public void close() {
        if (driver != null) {
            driver.close();
        }
    }
    @AfterClass
    public static void closeAll() {
    }
}

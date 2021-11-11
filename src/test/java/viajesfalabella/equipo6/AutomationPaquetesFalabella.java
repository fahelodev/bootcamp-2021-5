package viajesfalabella.equipo6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AutomationPaquetesFalabella {
    private WebDriver driver;
    @BeforeClass
    public static void Setup(){
        //Initialization del web driver con chrome
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void Init(){
        driver = new ChromeDriver();

        //Metodo para iniciar siempre con la pantalla maximizada
        driver.manage().window().maximize();

        //Cargar la página
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.viajesfalabella.cl/");
    }
    @Test
    public void paquetes_falabella001(){
        //Seleccionamos paquetes
        driver.findElement(By.xpath("//label[.='Paquetes']"));

        //Elegimos origen
        WebElement simpleOrigen = driver.findElement(By.xpath("//input[@placeholder='Ingresa una ciudad']"));
        simpleOrigen.click();
        simpleOrigen.sendKeys("Buenos");
        WebElement origen = driver.findElement(By.xpath("//span[contains(.,'Buenos Aires, Ciudad de Buenos Aires, Argentina')]"));
        origen.click();

        //Elegimos Destino
        WebElement simpleDestino = driver.findElement(By.cssSelector(".sbox-destination"));
        simpleDestino.click();
        simpleDestino.sendKeys("Esp");
        driver.findElement(By.xpath("//span[.='Barcelona, Cataluña, España']")).click();

        //Seleccionamos aun no me decido la fecha y buscamos
        driver.findElement(By.cssSelector(".switch-circle")).click();
        driver.findElement(By.xpath("//em[.='Buscar']")).click();
        //Verificamos que los datos ingresados sean correctos
        WebElement check = driver.findElement(By.cssSelector(".eva-3-h1"));
        Assert.assertEquals("Paquetes a Barcelona",check.getText());

    }
    @Test
    public void paquetes_falabella002(){
        //Seleccionamos la seccion paquetes
        driver.findElement(By.xpath("//label[.='Paquetes']"));

        //Elegimos origen
        WebElement simpleOrigen = driver.findElement(By.xpath("//input[@placeholder='Ingresa una ciudad']"));
        simpleOrigen.click();
        simpleOrigen.sendKeys("Buenos");
        WebElement origen = driver.findElement(By.xpath("//span[contains(.,'Buenos Aires, Ciudad de Buenos Aires, Argentina')]"));
        origen.click();


        //Elegimos Destino
        WebElement simpleDestino = driver.findElement(By.cssSelector(".sbox-destination"));
        simpleDestino.click();
        simpleDestino.sendKeys("Medellin");
        driver.findElement(By.xpath("//span[contains(normalize-space(),', Antioquia, Colombia')]")).click();


        //Elegimos Fecha de ida y vuelta
        driver.findElement(By.cssSelector("[placeholder='Ida']")).click();
        WebDriverWait fechaWait = new WebDriverWait(driver,10);
        fechaWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--month-active']//span[@class='_dpmg2--date _dpmg2--available']/span[.='18']")));
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--month-active']//span[@class='_dpmg2--date _dpmg2--available']/span[.='18']")).click();
        //Seleccionamos fecha de vuelta
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--has-start-range _dpmg2--month-active']//span[.='25NocheNoches']")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]//following::em[8]")).click();

        //Elegimos habitaciones
        WebElement simpleHabitacion = driver.findElement(By.cssSelector(".sbox-distri-input > .input-container"));
        simpleHabitacion.click();

        //Agregamos un mayor
        driver.findElement(By.xpath("//a[@class='steppers-icon-right sbox-3-icon-plus']//following::a[6]")).click();
        //Agregamos un menor
        driver.findElement(By.xpath("//a[@class='steppers-icon-right sbox-3-icon-plus']//following::a[8]")).click();
        //Select la edad del nino y aplicamos
        driver.findElement(By.xpath("//select[@class='select-tag']//following::select[7]")).click();
        driver.findElement(By.xpath("//select[@class='select-tag']//following::select[7]//option[@value='3']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Aplicar')]//following::a[21]")).click();

        //Realizamos nuestra busqueda
        driver.findElement(By.cssSelector(".sbox-search")).click();

        //Ordenamos de menor a mayor
        fechaWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='select-tag']//following::select[37]"))).click();
        driver.findElement(By.xpath("//option[contains(.,'Precio: menor a mayor')]")).click();

        //Verificamos que la busqueda nos direccione los datos solicitados correctamente
        WebElement check = driver.findElement(By.cssSelector("#packages-subtitle"));
        Assert.assertEquals("Otros alojamientos", check.getText());
    }
    @Test
    public void paquetes_falabella003(){
        //Seleccionamos la seccion paquetes
        driver.findElement(By.xpath("//label[.='Paquetes']"));

        //Seleccionamos vuelo mas dos alojamientos
        driver.findElement(By.cssSelector(".sbox-radio-vhh")).click();

        //Elegimos Origen
        WebElement altoOrigen = driver.findElement(By.cssSelector(".sbox-origin"));
        altoOrigen.click();
        altoOrigen.sendKeys("Buenos");
        driver.findElement(By.xpath("//span[.='Buenos Aires, Ciudad de Buenos Aires, Argentina']")).click();

        //Elegimos Destino
        WebElement altoDestino = driver.findElement(By.cssSelector(".sbox-destination"));
        altoDestino.click();
        altoDestino.sendKeys("Medellin");
        driver.findElement(By.xpath("//li[.='Medellín, Antioquia, Colombia']")).click();

        //Seleccionamos Fecha de ida y vuelta
        driver.findElement(By.cssSelector("[placeholder='Ida']")).click();
        WebDriverWait fechaWait = new WebDriverWait(driver,30);
        fechaWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--month-active']/div[@class='_dpmg2--dates']/span[.='18']")));
        //Seleccionamos la primer fecha
        driver.findElement(By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--month-active']/div[@class='_dpmg2--dates']/span[.='18']")).click();
        //Aqui seleccionamos la fecha de vuelta y aplicamos
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--has-start-range _dpmg2--month-active']//span[.='25NocheNoches']")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]//following::em[8]")).click();

        //Elegimos misma ciudad de origen para alojarnos
        WebElement altoOrigenDos = driver.findElement(By.cssSelector(".sbox-hotel-first-destination"));
        altoOrigenDos.click();
        altoOrigenDos.sendKeys("Buenos");
        driver.findElement(By.xpath("//span[.='Buenos Aires, Ciudad de Buenos Aires, Argentina']")).click();

        //Elegimos segunda fecha de la ciudad donde nos alojamos
        driver.findElement(By.cssSelector(".sbox-hotel-first-checkout-date")).click();
        driver.findElement(By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--has-start-range _dpmg2--has-limit-date _dpmg2--month-active']//span[.='24']")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Aplicar')]//following::em[2]")).click();

        //Elegimos la segunda ciudad donde alojarnos
        WebElement altoDestinoDos = driver.findElement(By.cssSelector(".sbox-hotel-second-destination"));
        altoDestinoDos.click();
        altoDestinoDos.sendKeys("Buenos");
        driver.findElement(By.xpath("//span[.='Buenos Aires, Ciudad de Buenos Aires, Argentina']")).click();

        //Elegimos las habitaciones, además elegimos los adultos y ninos
        driver.findElement(By.cssSelector(".sbox-distri-input > .input-container")).click();
        driver.findElement(By.xpath("//input[@class='steppers-tag']//following::a[8]")).click();
        driver.findElement(By.xpath("//input[@class='steppers-tag']//following::a[10]")).click();
        //Select para elegir la edad del nino
        driver.findElement(By.xpath("//select[@class='select-tag']//following::select[7]")).click();
        driver.findElement(By.xpath("//select[@class='select-tag']//following::select[7]//option[@value='3']")).click();

        //Agregamos habitacion
        driver.findElement(By.xpath("//div[@class='_pnlpk-panel__footer -medium-down-to-lg']//following::a[22]")).click();
        //Agregamos Adulto y aplicamos
        driver.findElement(By.xpath("//input[@class='steppers-tag']//following::a[13]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Aplicar')]//following::a[21]")).click();
        //Buscamos
        driver.findElement(By.xpath("//em[.='Buscar']")).click();

        WebElement check = driver.findElement(By.cssSelector(".sbox-hotel-second-destination-different-from-origin-error"));
        Assert.assertEquals("El destino debe ser diferente del origen.", check.getText());
    }
    @After
    public void Close(){
        if (driver != null) {
            //
            driver.close();
        }
    }
}

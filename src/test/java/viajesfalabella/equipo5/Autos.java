package viajesfalabella.equipo5;

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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Autos {

    private WebDriver driver;


    @BeforeClass
    public static void Setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.viajesfalabella.cl");
    }



    @Test
    public void Autos01_FechaAnteriorActual() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("H"); //Hora en numero del 1 al 24
        String formattedTime = sdf.format(now); //paso a string

        int hora_actual = Integer.parseInt(formattedTime); //paso a entero
        int horaCalcularXvalue;

        if (hora_actual == 0){
            horaCalcularXvalue = 0;
        }else{
            horaCalcularXvalue= (hora_actual - 1) * 60;
        }

        System.out.println(horaCalcularXvalue);
        WebElement NavegadorAuto = driver.findElement(By.cssSelector("a[title=Autos]")); //obtengo el titulo autos

        NavegadorAuto.click(); //le doy click para irme a esa seccion

        WebElement LugarDeEntrega = driver.findElement(By.cssSelector("input[placeholder='Ingresa una ciudad o aeropuerto']")); //obtengo el input del lugar con el placeholder
        LugarDeEntrega.sendKeys("Aeropuerto Arturo Merino Benitez"); //le envio el siguiente dato para que busque
        espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.ac-group-items"))); //espera hasta que me muestre la opc disponible
        LugarDeEntrega.sendKeys(Keys.ENTER); //le doy enter para que se ingrese
        WebElement Fecha = driver.findElement(By.cssSelector("input[placeholder='Retiro']")); //almaceno el input de la fecha por el placeholder


        Fecha.click();
        List<WebElement> fechas = driver.findElements(By.cssSelector("div._dpmg2--months  span._dpmg2--available")); //busco las fechas disponibles
        fechas.get(0).click();

        Select horaRetiro = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-timein']")));
        horaRetiro.selectByValue(String.valueOf(horaCalcularXvalue));


        Select horaDevolucion = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-timeout sbox-bind-disable-timeout']")));
        horaDevolucion.selectByVisibleText("09:00");

        WebElement fechaDevolucion = driver.findElement(By.cssSelector("input[placeholder='Devolución']"));
        fechaDevolucion.click();
        fechas.get(2).click();

        WebElement botonBuscar = driver.findElement(By.cssSelector("em[class='btn-text']"));
        botonBuscar.click();

        WebElement mensajeError = driver.findElement(By.cssSelector("div[class='message-body'] > p"));
        mensajeError.getText();


        String ResultadoEsperado= "La fecha en la que buscaste es anterior al día de hoy. Por favor, cambia la fecha para ver autos disponibles.";

        Assert.assertEquals(mensajeError.getText(),ResultadoEsperado);

    }


    @After
    public void close(){
        if(driver != null){
            driver.close();
        }

    }

}


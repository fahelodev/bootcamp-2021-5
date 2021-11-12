package viajesfalabella.equipo3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AutomationPaquetes {

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
        driver.manage().window().maximize();
        driver.get("https://www.viajesfalabella.cl/");

    }




    @Test
    public void paqueteTuristicoVueloyAuto() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina

        driver.findElement(By.xpath("//label[contains(text(),'Paquetes')]")).click();

        driver.findElement(By.cssSelector("input[class='sbox-bundle-input sbox-radio-va sbox-radio-selected-box'] ")).click();





        WebElement busqueda = driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline']"));

        busqueda.sendKeys("santiago");
        WebDriverWait wait =  new WebDriverWait(driver,15); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div[1]/ul")));
        busqueda.sendKeys(Keys.ARROW_DOWN);
        busqueda.sendKeys(Keys.ENTER);

        WebElement destino =  driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));
//input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline
        destino.sendKeys("Miami");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div[1]/ul")));
        destino.sendKeys(Keys.ARROW_DOWN);
        destino.sendKeys(Keys.ENTER);
// fecha de ida y regreso
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div[1]/div/input")).click();
        driver.findElement(By.xpath("//body/div[5]/div[1]/div[5]/div[2]/div[4]/span[1]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div[5]/div[2]/div[4]/span[10]")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div/div[6]/div[2]/button[2]")).click();


        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[5]/div/div/div[5]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        driver.findElement(By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/cluster/div/div/div[2]/fare/span/span/div[2]/buy-button/a/div/em")).click();
//assert

    }

    @Test
    public void PaqueteTuristicoMasDe8Personas() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina

        driver.findElement(By.xpath("//label[contains(text(),'Paquetes')]")).click();

        driver.findElement(By.cssSelector("input[class='sbox-bundle-input sbox-radio-va sbox-radio-selected-box'] ")).click();
        //input[class='sbox-bundle-input sbox-radio-va sbox-radio-selected-box']



// Origen
        WebElement busqueda = driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline']"));

        busqueda.sendKeys("santiago");
        WebDriverWait wait =  new WebDriverWait(driver,15); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div[1]/ul")));
        busqueda.sendKeys(Keys.ARROW_DOWN);
        busqueda.sendKeys(Keys.ENTER);
//Destino
        WebElement destino = driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));

        destino.sendKeys("Miami");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div[1]/ul")));
        destino.sendKeys(Keys.ARROW_DOWN);
        destino.sendKeys(Keys.ENTER);
// fecha de ida y regreso
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div[1]/div/input")).click();
        driver.findElement(By.xpath("//body/div[5]/div[1]/div[5]/div[2]/div[4]/span[1]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div[5]/div[2]/div[4]/span[10]")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div/div[6]/div[2]/button[2]")).click();
// seleccionar cantidad de pasajeros


        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[5]/div/div/div[5]/div/div")).click();
        for (int i =0; i <8;i++) {
            driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]")).click();
            break;

        }
        String al = driver.findElement(By.cssSelector("div[class'_pnlpk-tooltip']")).getText();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        driver.findElement(By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/cluster/div/div/div[2]/fare/span/span/div[2]/buy-button/a/div/em")).click();


        Assert.assertEquals("Solo puedes hacer búsquedas de hasta 8 personas",al);
//Solo puedes hacer búsquedas de hasta 8 personas
    }

    @Test
    public void atc03() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina

        driver.findElement(By.xpath("//label[contains(text(),'Paquetes')]")).click();

        driver.findElement(By.cssSelector("input[class='sbox-bundle-input sbox-radio-vhh sbox-radio-selected-box'] ")).click();





        WebElement busqueda = driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline']"));

        busqueda.sendKeys("santiago");
        WebDriverWait wait =  new WebDriverWait(driver,15); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div[1]/ul")));
        busqueda.sendKeys(Keys.ARROW_DOWN);
        busqueda.sendKeys(Keys.ENTER);

        WebElement destino =  driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']"));

        destino.sendKeys("bue");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div[1]/ul")));
        destino.sendKeys(Keys.ARROW_DOWN);
        destino.sendKeys(Keys.ENTER);


// fecha de ida y regreso
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div[1]/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div[5]/div[2]/div[4]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div[5]/div[2]/div[4]/span[10]")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div/div[6]/div[2]/button[2]/em")).click();


        //fecha alojamiento 1
        driver.findElement(By.cssSelector("input[class='input-tag sbox-hotel-first-checkout-date']")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[2]/div[4]/span[6]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/div[2]/button[2]/em")).click();
        //segundo destino
        WebElement destinoAlojo2 =  driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-hotel-second-destination sbox-primary undefined']"));

        destinoAlojo2.sendKeys("La rioja");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[12]/div/div/ul/li[1]")));
        destinoAlojo2.sendKeys(Keys.ARROW_DOWN);
        destinoAlojo2.sendKeys(Keys.ENTER);



//habitaciones
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[5]/div/div/div[5]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/a[2]")).click();

        driver.findElement(By.cssSelector("input[class='input-tag sbox-main-focus sbox-hotel-second-destination sbox-primary undefined']")).click();
        driver.findElement(By.xpath("//em[contains(text(),'Buscar')]")).click();

        driver.findElement(By.xpath("//*[@id=\"clusters\"]/span[1]/div/span/cluster/div/div/div[2]/fare/span/span/div[2]/buy-button/a/div/em")).click();



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
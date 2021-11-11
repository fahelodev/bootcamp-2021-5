package viajesfalabella.equipo3;

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

import java.util.concurrent.TimeUnit;

public class Traslado {

    private WebDriver driver;


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
        driver.get("https://www.viajesfalabella.cl/");
    }

    @Test
    public void atc01() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina
        driver.findElement(By.xpath("//label[contains(text(),'Traslados')]")).click();
        //CheckBox Hacia
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[1]/div[2]/span[2]/label/i\n")).click();
        //TextBox Desde
        WebElement Desde = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input"));
        Desde.sendKeys("Costanera Center");
        WebDriverWait wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/ul/li")));
        Desde.sendKeys(Keys.ENTER);
        //TextBox Hasta
        WebElement Hasta = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input"));
        Hasta.sendKeys("Aeropuerto Arturo");
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/ul/li")));
        Hasta.sendKeys(Keys.ENTER);
        //Fecha
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[1]\n")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[1]/div[4]/span[10]")).click();
        Hasta.sendKeys(Keys.ENTER);
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[2]")).click();
        Select horaRetiro = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-time-departure']")));
        horaRetiro.selectByVisibleText("06:00");
        Desde.sendKeys(Keys.ENTER);
        //Cantidad Pasajeros
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[4]/div/div/div[2]/div/div\n")).click();
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]")).click();
        }
    }

    @Test
    public void atc02() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina
        driver.findElement(By.xpath("//label[contains(text(),'Traslados')]")).click();
        //CheckBox Desde
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div[3]/span/label/i")).click();
        //TextBox Desde
        WebElement Desde = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input"));
        Desde.sendKeys("Aeropuerto Arturo");
        WebDriverWait wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/ul/li")));
        Desde.sendKeys(Keys.ENTER);
        //TextBox Hasta
        WebElement Hasta = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input"));
        Hasta.sendKeys("Costanera Center");
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/ul/li")));
        Hasta.sendKeys(Keys.ENTER);
        //Fecha Llegada
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div[1]/div/div/div[1]/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[2]/div[4]/span[1]")).click();
        Hasta.sendKeys(Keys.ENTER);
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        Select horaLlegada = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-time-arrival']")));
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        horaLlegada.selectByVisibleText("10:00");
        Desde.sendKeys(Keys.ENTER);
        // Fecha Regreso
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[2]/div[4]/span[8]")).click();
        Hasta.sendKeys(Keys.ENTER);
        Select horaRegreso = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-time-departure']")));
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        horaRegreso.selectByVisibleText("16:00");
            //Cantidad Pasajeros Niños
            driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[4]/div/div/div[2]/div/div\n")).click();
            for (int j = 0; j < 1; j++) {
                driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div/a[2]")).click();

                Select Edad = new Select(driver.findElement(By.cssSelector("select[class='select-tag']")));
                Edad.selectByVisibleText("10 años");
                }
            //Botón buscar
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[5]/div")).click();
       //Filtro Dolares
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        driver.findElement(By.xpath("//*[@id=\"currency-select\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"currency-select\"]/option[2] ")).click();

     //  driver.findElement(By.cssSelector("div[class='select-container'] > select[class='select-tag ng-valid ng-not-empty ng-dirty ng-valid-parse ng-touched'] > option[value='string:USD']")).click();
        }

    @Test
    public void atc03() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina
        driver.findElement(By.xpath("//label[contains(text(),'Traslados')]")).click();
        //CheckBox Desde
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div[3]/span/label/i")).click();
        //TextBox Desde
        WebElement Desde = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div[1]/div/div/div/input"));
        Desde.sendKeys("Aeropuerto Arturo");
        WebDriverWait wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/ul/li")));
        Desde.sendKeys(Keys.ENTER);
        //TextBox Hasta
        WebElement Hasta = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/div/div/input"));
        Hasta.sendKeys("Costanera Center");
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/ul/li")));
        Hasta.sendKeys(Keys.ENTER);
        //Fecha Llegada
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div[1]/div/div/div[1]/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[2]/div[4]/span[1]")).click();
        Hasta.sendKeys(Keys.ENTER);
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        Select horaLlegada = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-time-arrival']")));
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        horaLlegada.selectByVisibleText("10:00");
        Desde.sendKeys(Keys.ENTER);
        // Fecha Regreso
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[5]/div[2]/div[4]/span[8]")).click();
        Hasta.sendKeys(Keys.ENTER);
        Select horaRegreso = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-time-departure']")));
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        horaRegreso.selectByVisibleText("16:00");
        //Cantidad Pasajeros Niños
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[4]/div/div/div[2]/div/div\n")).click();
        for (int j = 0; j < 1; j++) {
            driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div/a[2]")).click();

            Select Edad = new Select(driver.findElement(By.cssSelector("select[class='select-tag']")));
            Edad.selectByVisibleText("10 años");
        }
        //Botón buscar
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[5]/div")).click();
        //Filtro Dolares
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        driver.findElement(By.xpath("//*[@id=\"currency-select\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"currency-select\"]/option[2] ")).click();

        driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/ul/li[4]/a[1]/em")).click();
        driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div[1]/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[3]/div/div[5]/div[2]/div[4]/span[10]")).click();

        Select horamod = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-time-departure']")));
        wait = new WebDriverWait(driver, 5); // tiempo de espera explicito
        horamod.selectByVisibleText("20:00");


        driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[1]/div/div/div/div/div/div[3]/div[2]/div[5]/div/a")).click();

        driver.findElement(By.xpath("//*[@id=\"bodyID\"]/div[6]/div[1]/div/div[2]/main/div[3]/div/div[2]/div[3]/search-item/div[2]/div[2]/div[2]/div/div[1]/div[2]/button")).click();
        //  driver.findElement(By.cssSelector("div[class='select-container'] > select[class='select-tag ng-valid ng-not-empty ng-dirty ng-valid-parse ng-touched'] > option[value='string:USD']")).click();
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

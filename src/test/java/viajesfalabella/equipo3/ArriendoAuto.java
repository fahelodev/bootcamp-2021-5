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

public class ArriendoAuto {

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
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina
        driver.findElement(By.xpath("//label[contains(text(),'Autos')]")).click();
        WebElement busqueda = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input"));
        busqueda.sendKeys("miami");
        WebDriverWait wait =  new WebDriverWait(driver,5); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/ul")));
        //busqueda.sendKeys(Keys.ARROW_DOWN);
        busqueda.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div/div/input\n")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[19]")).click();
        //Fecha entrega
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[4]/span[18]")).click();
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]\n")).click();
        //Hora entrega
        Select horaRetiro = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-timeout sbox-bind-disable-timeout']")));
        horaRetiro.selectByVisibleText("12:30");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[4]/div\n")).click();
    }

    @Test
    public void atc02() {
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina
        driver.findElement(By.xpath("//label[contains(text(),'Autos')]")).click();
        WebElement busqueda = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input"));
        busqueda.sendKeys("Rio de Janeiro");
        WebDriverWait wait =  new WebDriverWait(driver,5); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/ul")));
        busqueda.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div/div/input\n")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[4]/span[1]")).click();
        //Fecha entrega
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[4]/span[8]")).click();
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]\n")).click();
        //Hora entrega
        Select horaRetiro = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-timeout sbox-bind-disable-timeout']")));
        horaRetiro.selectByVisibleText("12:30");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[4]/div\n")).click();
        driver.findElement(By.xpath("//*[@id=\"results-page\"]/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div/clusters-by-categories/div/div[1]/cluster-by-category/div[2]/div/div[2]/div/div[2]/pricebox-by-category/div/div[1]/div[1]/div/div[2]/next-step-button/div/a")).click();

    }

    @Test
    public void atc03() {
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina
        driver.findElement(By.xpath("//label[contains(text(),'Autos')]")).click();
        WebElement busqueda = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input"));
        busqueda.sendKeys("Rio de Janeiro");
        WebDriverWait wait =  new WebDriverWait(driver,5); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div[1]/ul")));
        busqueda.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div[1]/div/div/input\n")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[4]/span[3]")).click();
        //Fecha entrega
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[4]/span[6]")).click();
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]\n")).click();
        //Hora entrega
        Select horaRetiro = new Select(driver.findElement(By.cssSelector("select[class='select-tag sbox-timeout sbox-bind-disable-timeout']")));
        horaRetiro.selectByVisibleText("11:00");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[4]/div\n")).click();
        driver.findElement(By.xpath("//*[@id=\"results-page\"]/div/div/div[2]/div/div/div/div[2]/div/div/div/div[1]/div/clusters-by-categories/div/div[1]/cluster-by-category/div[2]/div/div[2]/div/div[2]/pricebox-by-category/div/div[1]/div[1]/div/div[2]/next-step-button/div/a")).click();
        //Filtro ordenar por
        driver.findElement(By.xpath("//*[@id=\"eva-select\"]")).click();
        Select Mejor = new Select(driver.findElement(By.xpath("//*[@id=\"eva-select\"]/option[3]")));
        Mejor.selectByVisibleText("Mejor Puntuación");
        //Rentadoras
        driver.findElement(By.xpath("//*[@id=\"results-page\"]/div/div/div[2]/div/div/div/div[1]/div/div/vertical-filters/div/div/ul/li[1]/ul/li[4]/span/span/span/label/i")).click();
        //Cantidad Personas
        driver.findElement(By.xpath("//*[@id=\"results-page\"]/div/div/div[2]/div/div/div/div[1]/div/div/vertical-filters/div/div/ul/li[2]/ul/li[2]/span/span/span/label/i\n")).click();
        //Modalidad Entrega
        driver.findElement(By.xpath("//*[@id=\"results-page\"]/div/div/div[2]/div/div/div/div[1]/div/div/vertical-filters/div/div/ul/li[3]/ul/li[4]/span/span/span/label/i\n")).click();
        //modalidad de pago
        driver.findElement(By.xpath("//*[@id=\"results-page\"]/div/div/div[2]/div/div/div/div[1]/div/div/vertical-filters/div/div/ul/li[6]/span/label")).click();
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


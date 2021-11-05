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

public class ViajesFalabella {

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
    public void atc03(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina

        driver.findElement(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"button-circle-label\", \" \" ))]")).click();
        WebElement busqueda = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input"));
        busqueda.sendKeys("pinchas");

        String b= "No se encontraron resultados que coincidan con  ";
        String selected = driver.findElement(By.cssSelector(".ac-group-hint-error")).getText();
        Assert.assertEquals("No se encontraron resultados que coincidan con  " + "pinchas",b+selected);


    }

    @Test
    public void atc01() {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina

        driver.findElement(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"button-circle-label\", \" \" ))]")).click();
        WebElement busqueda = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input"));
        busqueda.sendKeys("miami");
        WebDriverWait wait =  new WebDriverWait(driver,15); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div/ul")));
        busqueda.sendKeys(Keys.ARROW_DOWN);
        busqueda.sendKeys(Keys.ENTER);


        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[4]/span[10]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[4]/span[17]/span[1]\n")).click();

        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[4]/div/a/em")).click();



        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[5]/div/div/div[5]/div/div")).click();

        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/a[2]\n")).click();

        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]\n")).click();

        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[4]/div/a\n")).click();


    }


    @Test
    public void atc02(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implicito para toda la pagina

        driver.findElement(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"button-circle-label\", \" \" ))]")).click();
        WebElement busqueda = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input"));
        busqueda.sendKeys("bue");
        WebDriverWait wait =  new WebDriverWait(driver,15); // tiempo de espera explicito
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div[1]/ul/li[1]/span")));
        busqueda.sendKeys(Keys.ENTER);
//fechas
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[20]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[27]/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[6]/div[2]/button[2]/em")).click();

//adultos y ni;os
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[3]/div/div/div[2]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select/option[9]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div/div/select/option[14]")).click();



//buscar
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/div/div/div/div[3]/div[2]/div[4]/div/a/em")).click();

        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[6]/aloha-filter/aloha-checkbox-filter/ul/li[3]/span/span[1]/aloha-checkbox/span/label/i")).click();
        //Filtro todas las ofertas
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[5]/aloha-filter/aloha-checkbox-filter/ul/li[1]/span/span[1]/aloha-checkbox/span/label/i")).click();
        driver.findElement(By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[1]/div/aloha-select/div/div/select/option[1]")).click();

//ordenar mayor a menor
        driver.findElement(By.cssSelector("div[class='select-container'] > select[class='select-tag'] > option[value='total_price_ascending']")).click();
//elegir el primer hotel
        //driver.findElement(By.xpath("//body/aloha-app-root[1]/aloha-results[1]/div[1]/div[1]/div[1]/div[2]/div[2]/aloha-list-view-container[1]/div[2]/div[1]/aloha-cluster-container[1]/div[1]/div[1]/div[2]/aloha-cluster-pricebox-container[1]/div[1]/div[2]/div[2]/aloha-button[1]/button[1]")).click();

    }



    @After
    public void close(){
        if(driver != null){
            //  driver.close();
        }
    }

    @AfterClass
    public static void closeAll(){
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizadas en el test");

    }

}






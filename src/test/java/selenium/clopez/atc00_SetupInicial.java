package selenium.clopez;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class atc00_SetupInicial {


    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        //Inicialización del WebDriver con Firefox
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Inicialización del WebDriver con Edge
        //WebDriverManager.edgedriver().setup();
        //driver = new EdgeDriver();

        //Cargar la página
        driver.get("http://google.cl");

        // Prueba añadir texto en la casilla del buscador
        //driver.findElement(By.name("q")).sendKeys("nopor");

        //Thread.sleep(2000);

        // Prueba clear
        //driver.findElement(By.name("q")).clear();

        //Thread.sleep(2000);

        // Prueba linktest y click
        // driver.findElement(By.linkText("English")).click();

        // Prueba de un print
        // System.out.println(driver.getTitle());

        // Prueba obtener direccion final
        //System.out.println("URL:");
        //System.out.println(driver.getCurrentUrl());

        // Thread.sleep(2000);
        // CARGAR OTRA PAGINA
        // driver.get("https://www.futbolenvivochile.com/");

        // PRUEBA VOLVER ATRAS
        // driver.navigate().back();

        Thread.sleep(2000);
        driver.close();

        // avanzar a una pagina antes vista (si es que se volvio antes)
        // driver.navigate().forward();

        // cierra todas las ventanas y navegadores abiertos por selenium
        // driver.quit();

    }

}

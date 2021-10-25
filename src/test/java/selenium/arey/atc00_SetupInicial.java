package selenium.arey;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc00_SetupInicial {


    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver;

        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Inicialización del WebDriver con Firefox
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();

        //Cargar la página
//        driver.get("http://coto.com.ar/");

//        Thread.sleep(2000);
//        Verificar si estamos en el sitio web correcto
//        System.out.println("la url de la pagina es: " + driver.getCurrentUrl());

//        Cargo otra pagina
        driver.get("https://login.salesforce.com/?locale=es");
//       Espera dos segundos y Regresa a la primera pagina con la funcion navigate().back()
        Thread.sleep(2000);
//        driver.navigate().back(); No funciona


//        SI QUERES INTERACTUAR CON LA PAGINA WEB, TENES QUE USAR LA FUNCION FINDELEMENT(BY.~~)
//        ADENTRO DEL BY VAN LA ID, CLASS(sin espacios, se tendria que usar xpath o css), NAME, LINKTEXT (mandas el texto de un tag a),
//        XPATH (click derecho copiar xpath) O CSS (lo mismo que xpath pero aparece css selector)

        driver.findElement(By.id("username")).sendKeys("MODS");
        driver.findElement(By.name("pw")).sendKeys("iofnweiofwe");
        driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Probar de forma gratuita")).click(); // si necesitas escribir, es con sendKeys("texto")
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        driver.quit(); // driver.quit y .close -- quit cierra todas las pestañas abiertas por selenium y close cierra la pestaña que se trabaja actualmente

    }

}

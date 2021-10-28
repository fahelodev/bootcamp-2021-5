package selenium.landres;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class atc00_SetupInicial {

        public static void main(String[] args) throws InterruptedException {
             WebDriver driver;



                //Inicialización del WebDriver con Chrome
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();



            //Cargar la página
            driver.get("http://automationpractice.com/");

            driver.findElement(By.id("search_query_top")).sendKeys("dress");
            driver.findElement(By.xpath("//*[@id='searchbox']/button")).click();
            int Listado;
            Listado = driver.findElements(By.xpath("//*[@id='center_column']/ul/li")).size();
            System.out.println(Listado);
            if (Listado > 2) {

                System.out.println("Se mostro al menos 2 resultados");
            }
            Assert.assertNotNull(Listado);

        }

    }
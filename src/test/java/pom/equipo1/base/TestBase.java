package pom.equipo1.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    //conteniene las configuraciones basicas de los test a ejecutar
    //atributos
    protected WebDriver driver; // navegador
    private int segundosEspera = 10;

    @BeforeClass
    public static void initialiseBrowser(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(segundosEspera, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(segundosEspera,TimeUnit.SECONDS);
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
}

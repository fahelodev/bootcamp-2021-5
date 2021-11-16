package pom.equipo6.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    //Contiene las configuraciones basicas para ejecutar los test

    //Atributos
    protected WebDriver driver; //Navegador

    @BeforeClass
    public static void initialiseBrowser(){
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    }
    @After
    public void close(){
        if (driver != null) {
            driver.close();
        }
    }
}

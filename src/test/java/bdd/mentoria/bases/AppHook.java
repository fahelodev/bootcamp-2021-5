package bdd.mentoria.bases;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class AppHook {
    //atributos
    protected static WebDriver driver;


    @Before(order = 0)
    public static void initialiseBrowser() {
        System.out.println("WebDriverManager Setup");
        WebDriverManager.chromedriver().setup();
    }

    @Before(order = 1)
    public void setupBrowser() {
        System.out.println("Capabilities Browser");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void cleanup() {
        if (driver != null) driver.close();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}

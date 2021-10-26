package selenium.clopez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class atc01_BusquedaPalabrasClaves {
    public static void main(String[] args) throws InterruptedException, IOException {
        // configuramos la vista maximizada
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
        // Inicialización del WedDriver
        WebDriver driver;
        // Caso sera realizado en firefox con xpath
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        // 1.- Cargar Home
        driver.get("http://automationpractice.com//");
        // espera
        Thread.sleep(2000);
        // 2.- Introducir "dress" en el campo de búsqueda
        // se cambian las comillas dobles del cogido copiapo por comillas simples
        // //*[@id="search_query_top"] -> //*[@id='search_query_top']
        driver.findElement(By.xpath("//*[@id=\'search_query_top\']")).sendKeys("dress");
        // 3.- Hacer clic en botón "Search"
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")).click();
        // espera
        Thread.sleep(2000);
        // 4.- Observar los resultados de la búsqueda.
        // bajamos un poco en la pagina
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        Thread.sleep(2000);
        // buscamos elementos señalados
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("BusquedaPalabrasClaves"+".png"));
    }
}

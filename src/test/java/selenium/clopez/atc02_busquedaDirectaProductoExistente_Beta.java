package selenium.clopez;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class atc02_busquedaDirectaProductoExistente_Beta {
    public static void main(String[] args) throws InterruptedException, IOException {
        // configuramos la vista maximizada
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--start-fullscreen");
        // Inicialización del WedDriver
        WebDriver driver;
        // Caso sera realizado en firefox con css
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        // 1.- Cargar Home
        driver.get("http://automationpractice.com//");
        // Espera
        Thread.sleep(2000);
        // 2.- Introducir "printed chiffon dress" en el campo de búsqueda
        driver.findElement(By.cssSelector("#search_query_top")).sendKeys("printed chiffon dress");
        // 3.- Hacer clic en botón "Search"
        driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click();
        // Espera
        Thread.sleep(2000);
        // 4.- Observar los resultados de la búsqueda.
        // Bajamos un poco en la pagina
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        // Nos posicionamos sobre el elemento buscado
        WebElement element = driver.findElement(By.cssSelector("li.ajax_block_product:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > img:nth-child(1)"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        Thread.sleep(2000);
        // buscamos elementos señalados
        // File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // FileUtils.copyFile(screenshotFile, new File("busquedaDirectaProductoExistente"+".png"));
        // Esperamos
        Thread.sleep(2000);
        // Cerramos la ventana
        driver.close();
    }
}

package selenium.arey;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class atc02_AutomationPracticeChiffonDress {
//TODO: IF SEARCH = OBJETO PARA VALIDAR LA CANTIDAD DE RESULTADOS
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;


        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        while(driver.getTitle()==" 508 Resource Limit Is Reached")
        {
            driver.navigate().refresh();
        }
        String strBuscado = "#search_query_top";
        WebElement objetobuscado = driver.findElement(By.cssSelector(strBuscado));
        Thread.sleep(2000);
        objetobuscado.sendKeys("printed chiffon dress");
        if (objetobuscado.getText() == "printed chiffon dress")
        {
            Thread.sleep(500);
            driver.findElement(By.cssSelector("#searchbox > button")).click();

        }else {
            System.out.println("No se busca el string solicitado");
        }
        Thread.sleep(1500);
        driver.close();
    }
}

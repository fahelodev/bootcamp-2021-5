package selenium.landres;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class atc05 {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        //Inicialización del WebDriver con Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Cargar la página
        driver.get("http://automationpractice.com/");

        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("blouses");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='index']/div[2]/ul/li")));
        WebElement b = driver.findElement(By.xpath("//*[@id='search_query_top']"));
        b.sendKeys(Keys.ARROW_DOWN);
        b.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='group_1']")).click();
        Select Talla = new Select(driver.findElement(By.id("group_1")));
        Talla.selectByValue("3");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='color_8']")).click();

        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2")));
        String compra = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2")).getText();
        Assert.assertEquals("Product successfully added to your shopping cart",compra);




    }


}


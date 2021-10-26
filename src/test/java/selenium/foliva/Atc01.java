package selenium.foliva;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Atc01 {
    private WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
    }
    @Test
    public void searchDress(){
        driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("dress");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
        List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));

        Assert.assertTrue(products.size() > 2);
    }
    @After
    public void after(){
        driver.close();
    }
}

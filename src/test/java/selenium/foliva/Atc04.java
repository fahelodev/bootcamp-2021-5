package selenium.foliva;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Atc04 {
    private WebDriver driver;
    @BeforeClass
    public static void Setup(){
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }
    @Test
    public void autocompleteWork() throws InterruptedException {
        WebElement inputSearch = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
        inputSearch.sendKeys("blo");

        WebDriverWait driverWait = new WebDriverWait(driver,5);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"index\"]/div[2]/ul/li")));

        WebElement autocompleteItem = driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li"));
        autocompleteItem.click();

        WebElement textElement = driver.findElement(By.xpath("//*[@id=\"product_reference\"]"));
        Assert.assertEquals("Model demo_2", textElement.getText());
        Thread.sleep(1000);
    }
    @After
    public void after(){
        if(driver != null){
            driver.close();
        }
    }
}

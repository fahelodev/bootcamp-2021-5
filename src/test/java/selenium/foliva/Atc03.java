package selenium.foliva;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Atc03 {
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
    public void resultNotFound(){
        WebElement inputSearch = driver.findElement(By.cssSelector("#search_query_top"));
        inputSearch.sendKeys("liquido matapulgas");

        WebElement buttonSearch = driver.findElement(By.cssSelector("#searchbox > button"));
        buttonSearch.click();

        WebElement messageElement = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
        String message = messageElement.getText();

        Assert.assertEquals("No results were found for your search \"liquido matapulgas\"", message);
    }
    @After
    public void after(){
        if(driver != null){
            driver.close();
        }
    }
}

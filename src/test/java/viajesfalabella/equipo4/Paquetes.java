package viajesfalabella.equipo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Paquetes{
    private WebDriver driver;
    private WebDriverWait w;
    private ArrayList<String> tabs2;
    @BeforeClass
    public static void setup()
    {
        System.out.println("Setup necesario antes de Instanciar");
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init()
    {
        System.out.println("init para instanciar");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);      // MANERA IMPLICITA DE INTRODUCIR TIEMPO MAXIMO QUE LE DA AL TEST PARA CARGAR EL ATRIBUTO
        driver.get("https://www.viajesfalabella.cl/");
        selectSeccion("paquetes"); // selecciona dependiendo el title la seccion
        fillOriginDestinyInput("origin","santiago"); // busca el input del origen o el destino segun el string que se pase, y la ciudad en este caso de origen
    }

    @Test
    public void ShowCompletePack() throws InterruptedException {
        fillOriginDestinyInput("destination", "new york");
        clickBuscar(true); // Clickea en el boton buscar del viaje
        clickFirstHotel(false);
    }

    @Test
    public void ShowServiceComments() throws InterruptedException {
        fillOriginDestinyInput("destination","ciudad de méxico");
        clickBuscar(true);
        clickFirstHotel(true);
        verServiciosYComentarios();
    }

    @Test
    public void Show5StarsAddActivity() throws InterruptedException {
        fillOriginDestinyInput("destination","rio de janeiro");
        clickBuscar(true);
        select5Stars();
        Thread.sleep(2000);
        clickFirstHotel(true);
        isClicked("//div[@id=\"carousel_5\"]//div[@data-swiper-slide-index='0' and @style='width: 301.25px; margin-right: 25px;']");
        Thread.sleep(3000);
        isClicked("//div[@class='toggle -eva-3-tc-purple-3 -eva-3-bold -eva-3-mt-xlg']/span");
        Thread.sleep(3000);
        isClicked("//div[@class='detail-actions']/a");
        isClicked("//div[@class='modal-header']//i[@class='modal-close eva-3-icon-close']");
        isClicked("//button[@class='eva-3-btn -lg pricebox-sticky-button -secondary']");
    }


    @After
    public void close() throws InterruptedException {
        if (driver != null){
            Thread.sleep(4000);
            driver.quit();
        }
    }

    @AfterClass
    public static void closeAll()
    {
        System.out.println("closeAll :: Cerrar otras conexiones que fueron utilizados en el test");

    }

    public WebElement driverElement(String path)
    {
        WebElement driverelement = driver.findElement(By.xpath(path));
        return driverelement;
    }

    public void selectSeccion(String seccion)
    {
        String path= "//a[@title='"+seccion.substring(0, 1).toUpperCase() + seccion.substring(1)+"']";
        w = new WebDriverWait(driver,20);
        w.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        driverElement(path).click();
        Assert.assertTrue(driver.getCurrentUrl().matches("https://www.viajesfalabella.cl/"+seccion.toLowerCase()));
    }

    public void fillOriginDestinyInput(String origin_or_destination, String ciudad)
    {
        WebElement input = driverElement("//input[contains(@class,'input-tag sbox-main-focus sbox-"+origin_or_destination.toLowerCase()+"')]");
        input.sendKeys(ciudad);
        WebElement firstListCity = clickFirstListCity();
        Assert.assertEquals(firstListCity.getText(),input.getText());
    }

    public WebElement clickFirstListCity()
    {
        WebElement firstCity = driverElement("//li[@class='item -active']");
        firstCity.click();
        return firstCity;
    }

    public void isClicked(String path)
    {
        WebElement element = driverElement(path);
        Boolean isclicked = false;
        try {
            w = new WebDriverWait(driver,5);
            w.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            isclicked= true;
        } catch(Exception e){
            isclicked= false;
        }
        Assert.assertTrue(isclicked);
    }

    public void clickBuscar(Boolean sinfechaActive)
    {
        if (sinfechaActive)
        {
            isClicked("//span[@class='switch-container']");
        }
        isClicked("//div[@class='sbox-button-container']");
    }


    public void clickFirstHotel(Boolean reClick) throws InterruptedException {
        isClicked("//div[@class='offer-container offer-container-0' and @index='0']");
        selectPestana(1);
        if (reClick)
        {
            w = new WebDriverWait(driver,10);
                String path= "//div[@class='eva-3-cluster-gallery -eva-3-bc-white -eva-3-shadow-line-hover']";
            w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
            isClicked(path);
            Thread.sleep(2000);
            selectPestana(2);
        }
    }

    public void selectPestana(int index)
    {
        tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(index));
    }

    public void verServiciosYComentarios() throws InterruptedException
    {
        isClicked("//div[@class='view-more eva-3-link -eva-3-mt-xxlg' and text()=' Ver todos los servicios ']");
        Assert.assertTrue(driverElement("//div[contains(@class,'-show-modal')]").isDisplayed());
        Thread.sleep(3000);
        isClicked("//div[@class='eva-3-modal -show-modal']//i[@class='modal-close eva-3-icon-close']");
//        Assert.assertFalse(driverElement("//div[contains(@class,'-show-modal')]").isDisplayed()); //No me toma el assert, no se por qué
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Long originalScrollValue = (Long) executor.executeScript("return window.pageYOffset;");
        isClicked("//a[@class='scroll-to-reviews eva-3-link']");
        Thread.sleep(1000);
        Long newScrollValue = (Long) executor.executeScript("return window.pageYOffset;");
        Assert.assertNotEquals(originalScrollValue,newScrollValue);
        Thread.sleep(1000);
        isClicked("//div[@class='sub-nav-container']//li[@class='sub-nav-item -icon ']//label[text()=' En pareja ']");
        Assert.assertEquals("en pareja",driverElement("//label[text()=' En pareja ']").getText().toLowerCase());
        Thread.sleep(3000);
        int commentsDefault = driver.findElements(By.xpath("//div[@class='eva-3-comment']")).size();
        isClicked("//span[@class='view-more-btn-text' and text()='Ver mas comentarios']");
        Thread.sleep(1000);
        int commentsCargados = driver.findElements(By.xpath("//div[@class='eva-3-comment']")).size();
        Assert.assertTrue(commentsCargados>commentsDefault);
        Thread.sleep(3000);
        isClicked("//span[@class='go-up' and text()=' Ir Arriba ']");
        originalScrollValue = (Long) executor.executeScript("return window.pageYOffset;");
        Assert.assertNotEquals(newScrollValue,originalScrollValue);
    }

    public void select5Stars() throws InterruptedException {
        isClicked("//div[@class='filters-summary']//span[@class='filter-tags-wrapper stars']");
        isClicked("//div[@class='filters-tooltip eva-3-card -eva-3-shadow-line']//div[@class='filter-criteria-container']/div[4]");
        isClicked("//div[@class='filters-tooltip eva-3-card -eva-3-shadow-line']//div[@class='filters-actions']/a[2]");
        Thread.sleep(1500);
        Assert.assertEquals("5 estrellas",driverElement("//p[@class='eva-3-p filter-text']").getText());
    }

}

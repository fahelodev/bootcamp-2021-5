package viajesfalabella.equipo4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.xpath.operations.Bool;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Traslados {
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
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);      // MANERA IMPLICITA DE INTRODUCIR TIEMPO MAXIMO QUE LE DA AL TEST PARA CARGAR EL ATRIBUTO
            driver.get("https://www.viajesfalabella.cl/");
            selectSeccion("Traslados");
        }

        @Test
        public void UbicacionEnMapa() throws InterruptedException {
            isClicked("//div[@class='offer-card-container']//div[text()='Traslado en Orlando']");
            selectPestana(1);
            isClicked("//div[@class='see-map']");
            Thread.sleep(3000);
            isClicked("//div[@class='eva-3-modal -no-padding map ng-scope -show-modal']//i[@class='modal-close eva-3-icon-close']");
        }

        @Test
        public void CambioHoraYMoneda() throws InterruptedException {
            fillOriginDestinyInput("origin","ezeiza");
            fillOriginDestinyInput("destination","hilton");
            selectArriboOPartida('a',"1");
            clickBuscar(false);
            Thread.sleep(3000);
            isClicked("//a[@class='-md -eva-3-hide-small eva-3-btn -secondary']");
            selectDropDown("//select[@class='select-tag sbox-time-arrival']","420");
            isClicked("//div[@class='sbox-button-container']");
            Thread.sleep(4000);
            selectDropDown("//select[@id='currency-select']","string:USD");
        }

        @Test
        public void ShowPuntosCanjeYFormasPago() throws InterruptedException {
            fillOriginDestinyInput("origin","ezeiza");
            fillOriginDestinyInput("destination","hilton");
            isClicked("//div[@class='sbox-radio-buttons']//span[2]//i"); // cambiar desde el aeropuerto hasta el aeropuerto
            selectArriboOPartida('p',"1"); // selecciona si es el calendario de arribo o partida, y selecciona el dia de diciembre
            selectDropDown("//select[@class='select-tag sbox-time-departure']","420"); // selecciona horario a las 7am
            isClicked("//div[@class='sbox-distri-container']"); // Parte pasajeros
            isClicked("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[@class='steppers-icon-right sbox-3-icon-plus']"); // suma un menor
            isClicked("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[@class='steppers-icon-right sbox-3-icon-plus']"); // suma otro menor
            selectDropDown("//div[@class='_pnlpk-minors-age-select-wrapper']//select[@class='select-tag']","8"); // Añadir edad de menores
            selectDropDown("//div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//select[@class='select-tag']","12"); // Añadir edad menores
            isClicked("//a[@class='_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg']"); // aplicar los participantes
            clickBuscar(false); // busca los datos, cambia depende si tiene o no fecha
            Thread.sleep(3000);
            selectDropDown("//select[@id='currency-select']","string:USD"); // cambia moneda
            isClicked("//div[@class='results']//div[@class='search-cluster ng-scope'][1]//button"); //le da al boton comprar
            Thread.sleep(7000);
            isClicked("//span[text()='¿Quieres canjear tus CMR Puntos?']//ancestor::span"); // selecciona la opcion de canjear puntos
            Assert.assertTrue(driverElement("//input[@class='checkbox-tag ng-untouched ng-pristine ng-valid']").isSelected()); // Testea si la checkbox
            Thread.sleep(3000);
            isClicked("//div[@class='eva-3-row -no-gutter']//a"); // Selecciona las promociones y formas de pago
            Thread.sleep(3000);
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
        w = new WebDriverWait(driver,5);
        w.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
        driverElement(path).click();
        changesPage("https://www.viajesfalabella.cl/"+seccion.toLowerCase());
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

    public void changesPage(String url)
    {
        w = new WebDriverWait(driver,10);
        Boolean result = w.until(ExpectedConditions.urlContains(url));
        Assert.assertTrue(result);
    }

    public void clickBuscar(Boolean sinfechaActive)
    {
        if (sinfechaActive)
        {
            isClicked("//span[@class='switch-container']");
        }
        isClicked("//div[@class='sbox-button-container']");
    }

    public void selectArriboOPartida(char arribo_o_partida,String arribo)
    {
        if (arribo_o_partida == 'a')
        {
            isClicked("//div[contains(@class,'sbox-checkin-container')]");
//        isClicked("//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--has-start-range _dpmg2--month-active']//span[text()="+arribo+"]"); no anda
            isClicked("/html/body/div[3]/div/div[5]/div[2]/div[4]/span[1]"); //tengo que usar este
            isClicked("//div[@class='_dpmg2--date-footer']//button[@class='_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary']");

        } else if (arribo_o_partida == 'p')
        {
            isClicked("//div[contains(@class,'sbox-second-moment-global-container sbox-js-show')]");
//        isClicked("//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--has-start-range _dpmg2--month-active']//span[text()="+arribo+"]"); NO ANDA NO SE POR QUE
            isClicked("/html/body/div[2]/div/div[5]/div[2]/div[4]/span[1]"); //TENGO QUE USAR ESTE PARA QUE ANDE
            isClicked("//div[@class='_dpmg2--date-footer']//button[@class='_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary']");

        }

    }

    public void selectPestana(int index)
    {
        tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(index));
    }

    public void selectDropDown(String path,String value)
    {
        Select s = new Select(driverElement(path));
        s.selectByValue(value);
        Assert.assertNotNull(s.getFirstSelectedOption());
    }
}

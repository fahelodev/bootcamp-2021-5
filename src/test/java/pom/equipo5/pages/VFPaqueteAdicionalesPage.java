package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo5.base.SeleniumBase;

import java.util.List;

public class VFPaqueteAdicionalesPage extends SeleniumBase {
    public VFPaqueteAdicionalesPage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnAgregarTraslado = By.cssSelector("div.highlight-card-container.TRANSFER");
    By btnAgregarAuto = By.cssSelector("div.highlight-card-container.CAR");
    By btnAgregarActividad = By.cssSelector("div.highlight-card-container.ACTIVITY");
    By btnPago = By.xpath("//*[@id=\"pricebox-overlay\"]//em");
    By btnConfirmarModalTraslado = By.xpath("//a/em[contains(text(),'Agregar')]");
    By btnConfirmarModalAuto = By.xpath("//app-car-modal//a/em");
    By btnConfirmarActividad = By.xpath("//app-activity-modal//a/em[contains(text(),'Agregar')]");
    By txtTraslado = By.cssSelector("app-transfer-highlight-card .added-product-title");
    By txtAuto = By.cssSelector("app-car-highlight-card .added-product-title");
    By txtActividad = By.cssSelector("app-activity-highlight-card .added-product-title");
    By vuelos = By.cssSelector("wizard-step-content-flight .title span");

    //Datos obtenidos
    private String actividad;
    private String auto;
    private String vueloSalida;
    private String vueloDestino;
    private String traslado;

    //Acciones
    public void seleccionarActividad(){
        esperarElementoClickeable(btnAgregarActividad, 20);
        clickear(btnAgregarActividad);
        clickear(btnConfirmarActividad);
        actividad = obtenerTexto(txtActividad);
    }

    public void seleccionarTraslado(){
        esperarElementoClickeable(btnAgregarTraslado, 20);
        clickear(btnAgregarTraslado);
        clickear(btnConfirmarModalTraslado);
        traslado = obtenerTexto(txtTraslado);
    }

    public void seleccionarAuto(){
        esperarElementoClickeable(btnAgregarAuto, 20);
        clickear(btnAgregarAuto);
        clickear(btnConfirmarModalAuto);
        auto = obtenerTexto(txtAuto);
    }

    public void obtenerVuelos(){
        List<WebElement> vuelosObtenidos = encontrarElementos(vuelos);
        vueloSalida = obtenerTexto(vuelosObtenidos.get(0));
        vueloDestino = obtenerTexto(vuelosObtenidos.get(1));
    }

    public String getActividad(){return actividad.toLowerCase();}
    public String getAuto(){return auto;}
    public String getVueloSalida(){return vueloSalida;}
    public String getVueloDestino(){return vueloDestino;}

    public void confirmarPaquete(){
        clickear(btnPago);
    }

}

package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBase;

public class VFPaqueteAlojamientosPage extends SeleniumBase {
    public VFPaqueteAlojamientosPage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnSeleccionarAlojamiento = By.xpath("//aloha-cluster-pricebox-container//aloha-button/button");
    By btnVerDetalles = By.xpath("//em[contains(text(),'Ver detalle')]");
    By alojamientoNombre =  By.cssSelector("span.accommodation-name");

    //Datos ingresados
    private String alojamiento;

    //Acciones
    public void seleccionarAlojamientoRecomendado(){
        esperarPresenciaElemento(btnSeleccionarAlojamiento, 15);
        alojamiento = obtenerTexto(alojamientoNombre);
        clickear(btnSeleccionarAlojamiento);
    }

    public void seleccionarPaqueteSugerido(){
        esperarElementoClickeable(btnVerDetalles,15);
        clickear(btnVerDetalles);
        cambiarVentana();
    }

    public void seleccionarPrimerAlojamiento(){
        esperarPresenciaElemento(btnSeleccionarAlojamiento, 15);
        alojamiento = obtenerTexto(alojamientoNombre);
        clickear(btnSeleccionarAlojamiento);
        cambiarVentana();
    }

    public String getAlojamiento(){
        return alojamiento;
    }

}

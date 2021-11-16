package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBase;

public class VFPaqueteVuelosPage extends SeleniumBase {
    public VFPaqueteVuelosPage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnSeleccionarVuelo = By.xpath("//trips-cluster-selected//buy-button//a");

    //Acciones
    public void seleccionarPrimerVuelo(){
        esperarPresenciaElemento(btnSeleccionarVuelo, 20);
        clickear(btnSeleccionarVuelo);
    }
}

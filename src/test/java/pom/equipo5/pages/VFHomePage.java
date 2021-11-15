package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {
    By btnAlojamiento = By.linkText("Alojamientos");
    By btnTraslado = By.linkText("Traslados");
    By btnPaquete = By.linkText("Paquetes");

    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    //metodo - KeywordDriven
    public void irHomePage(){
        irUrl("https://www.viajesfalabella.cl");
    }

    public void irAlojamiento(){
        clickear(btnAlojamiento);
    }

    public void irTraslado() { clickear(btnTraslado); }

    public void irPaquete() { clickear(btnPaquete); }

}

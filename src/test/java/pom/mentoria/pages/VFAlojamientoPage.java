package pom.mentoria.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.mentoria.base.SeleniumBase;

public class VFAlojamientoPage extends SeleniumBase {
    public VFAlojamientoPage(WebDriver driver) {
        super(driver);
    }
    //atributos - objeto a guardar
    By btnAlojamiento = By.xpath("//label[contains(text(),'Alojamientos')]");
    By desplegableHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnMasHabitaciones = By.cssSelector("div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus");
    By btnAplicar = By.xpath("//a[contains(text(),'Aplicar')]");

    public void irAlojamientoDesdeHome(){
        clickear(btnAlojamiento);
        esperaExplicitaElementoClickeable(desplegableHabitaciones,7);
    }
    public void agregarHabitacionMenor(){
        clickear(btnHabitaciones);
        clickear(btnMasHabitaciones);
    }
    public void confirmarSeleccionHabitacionMenor(){
        clickear(btnAplicar);
    }
}

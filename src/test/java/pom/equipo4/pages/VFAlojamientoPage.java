package pom.equipo4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo4.base.SeleniumBase;

public class VFAlojamientoPage extends SeleniumBase {
    public VFAlojamientoPage(WebDriver driver) {
        super(driver);
    }
    //atributos - objeto a guardar
    By desplegableHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnMasHabitaciones = By.cssSelector("div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus");
    By btnAplicar = By.xpath("//a[contains(text(),'Aplicar')]");

    public void agregarHabitacionMenor(){
        clickear(btnHabitaciones);
        clickear(btnMasHabitaciones);
    }
    public void confirmarSeleccionHabitacionMenor(){
        clickear(btnAplicar);
    }
}

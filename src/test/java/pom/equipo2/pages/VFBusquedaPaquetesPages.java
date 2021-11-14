package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo2.base.SeleniumBase;

public class VFBusquedaPaquetesPages extends SeleniumBase {

    public VFBusquedaPaquetesPages(WebDriver driver) {
            super(driver);
        }

        //atributos - objeto a guardar

        By btnSiguiuente = By.xpath("//span[@class='accommodation-name -eva-3-ellipsis' and contains(text(),'Broadway Hotel & Suites')]");
    public void seleccionarHotel(){
        esperaExplicitaElementoClickeable(btnSiguiuente, 15);
        clickear(btnSiguiuente);
    }
}


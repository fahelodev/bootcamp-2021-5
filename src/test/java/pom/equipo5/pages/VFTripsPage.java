package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBase;

public class VFTripsPage extends SeleniumBase {
    public VFTripsPage (WebDriver driver) {
        super(driver);
    }

    By btnSiguiente = By.xpath("//button[contains(.,'Siguiente')]");

    public void irCheckout(){
        clickear(btnSiguiente);
    }

}

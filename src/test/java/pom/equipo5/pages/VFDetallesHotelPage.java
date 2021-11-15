package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBase;

public class VFDetallesHotelPage extends SeleniumBase {
    public VFDetallesHotelPage (WebDriver driver) {
        super(driver);
    }

    By btnReservarAhora = By.xpath("//button[contains(.,'Reservar ahora')]");

    public void reservarHabitacion(){
        clickear(btnReservarAhora);
    }
}

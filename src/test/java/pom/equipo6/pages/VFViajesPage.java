package pom.equipo6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo6.base.SeleniumBase;

public class VFViajesPage extends SeleniumBase {

    public VFViajesPage(WebDriver driver) {
        super(driver);
    }
    //Atributos - objeto a guardar
    By btnVuelos = By.cssSelector("a[title='Vuelos']");


    public void goVuelosToHome(){
        click(btnVuelos);
        waitExplicitClick(btnVuelos, 7);
    }

}

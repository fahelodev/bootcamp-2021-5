package pom.equipo4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.equipo4.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {

    By divDatosViaje = By.xpath("//div[@class='sbox-show-hide-container -sbox-3-shadow-static']");

    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    //metodo - KeywordDriven
    public void irHomePage(){
        irUrl("https://www.viajesfalabella.cl");
    }

    public void irSeccionDesdeHome(String nombreSeccion){
        clickear(By.xpath("//a[@title='"+nombreSeccion.substring(0, 1).toUpperCase() + nombreSeccion.substring(1)+"']"));
        esperaExplicitaElementoClickeable(divDatosViaje,10);
//        Assert.assertTrue(driver.getCurrentUrl().matches("https://www.viajesfalabella.cl/"+seccion.toLowerCase()));
    }
}

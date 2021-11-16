package pom.equipo6.pages;

import org.openqa.selenium.WebDriver;
import pom.equipo6.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {

    public VFHomePage(WebDriver driver) {
        super(driver);
    }
    //Metodo KeywordDriven
    public void goHomePage(){
        goUrl("https://www.viajesfalabella.cl");
    }
}

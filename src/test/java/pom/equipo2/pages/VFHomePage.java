package pom.equipo2.pages;

import org.openqa.selenium.WebDriver;
import pom.equipo2.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {


    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    //metodo - KeywordDriven
    public void irHomePage(){
        irUrl("https://www.viajesfalabella.cl");
    }



}

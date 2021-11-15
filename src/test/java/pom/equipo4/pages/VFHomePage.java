package pom.equipo4.pages;

import org.openqa.selenium.WebDriver;

public class VFHomePage extends SeleniumBase {


    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    //metodo - KeywordDriven
    public void irHomePage(){
        irUrl("https://www.viajesfalabella.cl");
    }



}

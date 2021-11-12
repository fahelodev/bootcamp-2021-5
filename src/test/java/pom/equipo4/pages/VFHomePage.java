package pom.equipo4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo4.base.SeleniumBase;

public class VFHomePage extends SeleniumBase {


    public VFHomePage(WebDriver driver) {
        super(driver);
    }

    //metodo - KeywordDriven
    public void irHomePage(){
        irUrl("https://www.viajesfalabella.cl");
    }



}

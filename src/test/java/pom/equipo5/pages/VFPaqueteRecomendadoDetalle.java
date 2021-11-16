package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBase;

public class VFPaqueteRecomendadoDetalle extends SeleniumBase {
    public VFPaqueteRecomendadoDetalle(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By Detalles = By.cssSelector("div[class='detail-wrapper eva-3-row -no-gutter']");
    By Vuelo = By.cssSelector("ib-flight .title");
    By Alojamiento = By.cssSelector("ib-hotel .title");

    //Acciones
    public void esperarDetallesPaquete(){
        esperarPresenciaElemento(Detalles, 15);

    }

    public String getVuelo(){
        esperarPresenciaElemento(Vuelo, 15);
        return obtenerTexto(Vuelo);
    }

    public String getAlojamiento(){
        esperarPresenciaElemento(Alojamiento, 15);
        return obtenerTexto(Alojamiento);
    }




}

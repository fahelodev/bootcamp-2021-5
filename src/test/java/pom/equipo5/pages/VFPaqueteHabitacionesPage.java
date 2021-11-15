package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBase;

public class VFPaqueteHabitacionesPage extends SeleniumBase {
    public VFPaqueteHabitacionesPage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnSeleccionarHabitacion = By.xpath("//aloha-infobox-wrapper-container//button");
    By precioPaquete = By.xpath("//aloha-summary-price//p/span");
    By habitacionNombre = By.cssSelector("p.room-name");

    //Datos obtenidos
    private String precioDelPaquete;
    private String habitacion;

    //Acciones
    public void seleccionarHabitacionRecomendada(){
        esperarElementoClickeable(btnSeleccionarHabitacion, 15);
        precioDelPaquete = obtenerTexto(precioPaquete);
        habitacion = obtenerTexto(habitacionNombre);
        clickear(btnSeleccionarHabitacion);
    }

    public int obtenerPrecioDePaquete() {
        return Integer.parseInt(precioDelPaquete.replace("$ ","").replace(".",""));
    }
}

package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo2.base.SeleniumBase;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

public class VFAlojamientoPage extends SeleniumBase {
    public VFAlojamientoPage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnAlojamiento = By.xpath("//label[contains(text(),'Alojamientos')]");
    By btnHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnMasHabitaciones = By.cssSelector("div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus");
    By btnAplicar = By.xpath("//a[contains(text(),'Aplicar')]");
    By campoDestino = By.xpath("//input[contains(@class,'sbox-main')]");
    By campoFechaEntrada = By.xpath("//input[contains(@class,'checkin')]");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");
    By listaElementos = By.cssSelector("div.ac-container ul>li");
    By listaFechasMes= By.xpath("//span[@class='_dpmg2--date-number']");
    By mensajeError = By.xpath("//p[contains(text(),'Ingresa la edad del menor')]");
    String resultado;

    public void irAlojamientoDesdeHome(){
        clickear(btnAlojamiento);

       // esperaExplicitaElementoClickeable(desplegableHabitaciones,7);

    }
    public void agregarMenorHabitacion(){

        clickear(btnHabitaciones);
        clickear(btnMasHabitaciones);
    }
    public void confirmarSeleccionHabitacionMenor(){
        clickear(btnAplicar);
    }
    public void cargarDestino(){
        ingresarTexto(campoDestino,"Cordoba");
        seleccionarTextoLista(listaElementos,"Córdoba, Córdoba, Argentina");
    }
    public void cargarFechas(){
        clickear(campoFechaEntrada);
        seleccionarFecha(listaFechasMes, "22");
        seleccionarFecha(listaFechasMes, "26");
    }
    public void confirmarBusqueda(){
        clickear(btnBuscar);
    }


    public void verificarBusquedaSinEdad(){

         resultado = obtenerTexto(mensajeError);

        assertEquals("Ingresa la edad del menor", resultado);
    }


}

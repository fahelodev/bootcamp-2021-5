package pom.equipo1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo1.base.SeleniumBase;

import java.util.List;

public class VFpaquetesPage extends SeleniumBase {
    public VFpaquetesPage(WebDriver driver) {
        super(driver);
    }
    // atributos - objeto a guardar
    By btnAlojamiento = By.xpath("//label[contains(text(),'Alojamientos')]");
    By desplegableHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnMasHabitaciones = By.cssSelector("div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus");
    By btnAplicar = By.xpath("//a[contains(text(),'Aplicar')]");
    // Equipo 1 By:
    By categorias = By.cssSelector("div.header-products-container ul li a");
    By darClickVuelo1Alojamiento = By.xpath("//input[@value='vh']");
    By campoOrigen = By.cssSelector("div.sbox-place-container input");
    By esperaCampoOrigen = By.cssSelector("div.ac-container span");
    By campoDestino = By.cssSelector("div.sbox-second-place-container input");
    By esperaCampoDestino = By.cssSelector("div.ac-container span");
    By darClickCampoFechaIda = By.cssSelector("[placeholder='Ida']");
    By darClickPasajeros = By.cssSelector("div.sbox-distri-input-container");
    By pasajeros = By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input");
    By btnBuscar = By.cssSelector("div.sbox-button-container a");
    By contenedorResultados = By.cssSelector("div.results-cluster-container");

    public void irPaquetesDesdeHome(){
        // generar la lista categorias
        List <WebElement> listaCategorias = generarLista(categorias);
        // seleccionar el elemento paquetes de la lista
        busquedaElemento(listaCategorias,"Paquetes");
    }
    public void seleccionarVuelo1Alojamiento(){
        darClick(darClickVuelo1Alojamiento);
    }

    public void llenarCasillaOrigen(String origen, String seleccion){
        // llenar la casilla Origen
        ingresarDestino(origen,seleccion,campoOrigen,esperaCampoOrigen);
    }

    public void llenarCasillaDestino(String destino, String seleccion){
        //llenar la casilla Destino
        ingresarDestino(destino,seleccion,campoDestino,esperaCampoDestino);
    }

    public void seleccionarFechas(int fecha1, int fecha2){
        darClick(darClickCampoFechaIda);
        calendario(fecha1,fecha2);
    }

    public void seleccionarCantidadPasajeros(int numero){
        darClick(darClickPasajeros);
        cantidadPasajeros(numero,pasajeros);
    }

    public void darClickBuscar(){
        darClick(btnBuscar);
        esperaImplicita();
    }

    public int resultadosBusqueda(){
        return contarElementos(contenedorResultados);
    }

    public void agregarHabitacionMenor(){
        darClick(btnHabitaciones);
        darClick(btnMasHabitaciones);
    }
    public void confirmarSeleccionHabitacionMenor(){
        darClick(btnAplicar);
    }
}

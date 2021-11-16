package pom.equipo1.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo1.base.SeleniumBase;

import java.util.List;

public class VFTrasladosPage extends SeleniumBase {

    public VFTrasladosPage(WebDriver driver) {
        super(driver);
    }
    By categorias = By.cssSelector("div.header-products-container ul li a");
    By campoOrigen = By.cssSelector("div.sbox-place-container input");
    By campoDestino = By.cssSelector("div.sbox-second-place-container input");
    By esperaCasilla = By.cssSelector("div.ac-container span");
    By clickCampoFecha = By.cssSelector("div.sbox-moment-input input");
    By calendario = By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number");
    By darClickFechaArribo= By.cssSelector("div._dpmg2--months span span._dpmg2--date-number");
    By darClickPasajeros = By.cssSelector("div.sbox-distri-input-container");
    By cantidadPasajeros = By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input");
    By botonBuscar = By.cssSelector("div.sbox-button");
    By mensajeVerificar1= By.cssSelector("");
    By getMensajeVerificar2 = By.cssSelector("");

    public void irPaquetesDesdeHome(){
        // generar la lista categorias
        List<WebElement> listaCategorias = generarLista(categorias);
        // seleccionar el elemento paquetes de la lista
        busquedaElemento(listaCategorias,"Traslados");
    }

    public void llenarCasillaOrigen(String origen, String seleccion){
        // llenar la casilla Origen
        ingresarDestino(origen,seleccion,campoOrigen,esperaCasilla);
    }

    public void llenarCasillaDestino(String destino, String seleccion){
        //llenar la casilla Destino
        ingresarDestino(destino,seleccion,campoDestino,esperaCasilla);
    }

    public void fechaArriedo(int fecha1) {
        esperaExplicitaElementoClickeable(darClickFechaArribo);
        darClick(darClickFechaArribo);
        ingresarFechaHasta(fecha1);

    }

    public void seleccionarCantidadOcupantesHabitacion(int numero){
        darClick(darClickPasajeros);
        cantidadOcupantesHabitacion(numero,cantidadPasajeros);
    }

    public void darClickBotonBuscar(){darClick(botonBuscar);}

    public String validadmensaje1(String privado){
        esperaImplicita();
        return validarDatos(privado,mensajeVerificar1);

    }

    public String validarmensaje2(String minivan){
        esperaImplicita();
        return validarDatos(minivan,getMensajeVerificar2);

    }












}

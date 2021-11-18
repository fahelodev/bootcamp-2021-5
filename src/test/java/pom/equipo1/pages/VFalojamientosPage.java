package pom.equipo1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo1.base.SeleniumBase;

import java.util.List;

public class VFalojamientosPage extends SeleniumBase {
    public VFalojamientosPage(WebDriver driver) {
        super(driver);
    }
    // Equipo 1 By:
    By categorias = By.cssSelector("div.header-products-container ul li a");
    By darClickNoHeDecidoFecha=By.cssSelector("label.checkbox-label");
    By campoDestino=By.cssSelector("div.sbox-place-container input");
    By esperaDestino=By.cssSelector("div.ac-container span");
    By botonBuscar = By.cssSelector("div.sbox-button");
    By busqueda = By.cssSelector("div.results-cluster-container");
    By clickEntrada=By.xpath("//input[@placeholder='Entrada']");
    By clickHabitaciones=By.cssSelector("div.sbox-distri-input-container");
    By ocupantesHabitacion = By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input");
    By calendario = By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number");
    By clikOrdenarPor= By.xpath("//aloha-select[@class='sorting-select']//select[@class='select-tag']");
    By opcionesOrdenarPor= By.xpath("//aloha-select[@class='sorting-select']//select[@class='select-tag']/option");
    By mensajeLugar=By.xpath("//span[@class='-eva-3-tc-gray-2']");
    By mensajeDias=By.xpath("//p[@class='eva-3-p -eva-3-tc-gray-2 first-message']");
    By verDetallePrimeraOpcionBusquedaPorFitro =By.xpath("//button[@class='eva-3-btn -md -primary -eva-3-fwidth']");
    By clickVerHabitaciones=By.xpath("//div[@class='pricebox-top-container']//button");
    By clickReservarAhoraPrimeraOpcion=By.xpath("//div[@class='-eva-3-mb-lg']//button");
    By clickSiguiente=By.xpath("//div[@class='pricebox-content-container']//button");
    By mensajeFelicitaciones=By.xpath("//div[@class='eva-3-message -success -eva-3-mb-md -eva-3-mt-md']//span");
    By iconoSiguientesMes= By.xpath("//div[@class='_dpmg2--controls-next']//i");

    public void irAlojamientosDesdeHome(){
        // generar la lista categorias
        List <WebElement> listaCategorias = generarLista(categorias);
        // seleccionar el elemento paquetes de la lista
        busquedaElemento(listaCategorias,"Alojamientos");
    }
    public void seleccionarNoHedecidoFecha(){darClick(darClickNoHeDecidoFecha);}

    public void llenarCasillaDestino(String destino, String seleccion){
        ingresarDestino(destino,seleccion,campoDestino,esperaDestino);

    }

    public void darClickBotonBuscar(){darClick(botonBuscar);}

    public int resultadosBusquedaAlojamientos(){
        return contarElementos(busqueda);
    }

    public void seleccionarFechas(int fecha1, int fecha2){
        darClick(clickEntrada);
        buscarEnCalendario(fecha1,fecha2,calendario,iconoSiguientesMes);
    }

    public void seleccionarCantidadOcupantesHabitacion(int numero){
        darClick(clickHabitaciones);
        cantidadOcupantesHabitacion(numero,ocupantesHabitacion);
    }

    public void seleccionarFiltroOrdenarPor(String filtro){
        esperaImplicita();
        esperaExplicitaElementoClickeable(clikOrdenarPor);
        darClick(clikOrdenarPor);
        filtrar(filtro,opcionesOrdenarPor);
        esperaExplicitaElementoClickeable(clikOrdenarPor);
        esperaImplicita();
    }

    public String validarLugar(String lugar){
        esperaImplicita();
        return validarDatos(lugar,mensajeLugar);
    }

    public String validarDias(String dias){
        esperaImplicita();
        return validarDatos(dias,mensajeDias);
    }

    public void darClickPrimerResultadoBusquedaPorFiltro(){
        esperaExplicitaElementoClickeable(verDetallePrimeraOpcionBusquedaPorFitro);
        darClick(verDetallePrimeraOpcionBusquedaPorFitro);
    }

    public void cambiarANuevaPestaña(){
        cambiarPestaña();
    }

    public void darClickVerHabitaciones(){
        // esperaExplicitaElementoClickeable(clickHabitaciones);
        darClick(clickVerHabitaciones);
        esperaImplicita();
    }

    public void darClickReservarAhora(){
        // esperaExplicitaElementoClickeable(clickReservarAhoraPrimeraOpcion);
        darClick(clickReservarAhoraPrimeraOpcion);
        esperaImplicita();
    }

    public void darClickEnSiguiente(){
        // esperaExplicitaElementoClickeable(clickSiguiente);
        darClick(clickSiguiente);
        esperaImplicita();
    }

    public String validarMensajeFelicitaciones(String mensaje){
        esperaImplicita();
        return validarDatos(mensaje,mensajeFelicitaciones);
    }

    public void cerrarPestañaSecundaria(){
        cerrarPestaña();
    }

    public void volverPestañaInicial(){
        cambiarPestañaInicial();
    }
}

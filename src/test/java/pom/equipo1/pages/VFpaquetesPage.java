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
    // Equipo 1 String
    String boxTipoDeMoneda = "#currency";
    String boxOrdenarPor = "#order";
    // Equipo 1 By:
    By categorias = By.cssSelector("div.header-products-container ul li a");
    By darClickVuelo1Alojamiento = By.xpath("//input[@value='vh']");
    By darClickVuelo2Alojamientos = By.xpath("//input[@value='vhh']");
    By campoOrigen = By.cssSelector("div.sbox-place-container input");
    By campoDestino = By.cssSelector("div.sbox-second-place-container input");
    By campoSegundoDestino = By.xpath("//label[contains(text(),'Segundo destino')]/following-sibling::input");
    By esperaCasilla = By.cssSelector("div.ac-container span");
    By darClickCampoFechaIda = By.cssSelector("[placeholder='Ida']");
    By darClickCampoFechaHasta = By.cssSelector("[placeholder='Hasta']");
    By darClickPasajeros = By.cssSelector("div.sbox-distri-input-container");
    By pasajeros = By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");
    By contenedorResultados = By.cssSelector("div.results-cluster-container");
    By calendario = By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number");
    By paqueteMasConveniente = By.xpath("//em[contains(text(),'Siguiente')]//ancestor::a[@class='-md eva-3-btn -primary']");
    By darClickHotelHoliday = By.xpath("//span[contains(text(),'Holiday Inn Express')]");
    By hotelHoliday = By.xpath("//em[contains(text(),'Siguiente')]//ancestor::div[@class='pricebox-action -eva-3-mt-lg pricebox-button']");
    By darClickHotelMarbella = By.xpath("//span[contains(text(),'Marbella Playa')]");
    By hotelMarbella = By.xpath("//em[contains(text(),'Siguiente')]//ancestor::div[@class='pricebox-action -eva-3-mt-lg pricebox-button']");
    By mensajePaquete = By.xpath("//div[@class='eva-3-h3 -eva-3-tc-gray-0' and contains(text(),'Holiday Inn Express')]");
    By ubicacionHotel = By.cssSelector("div.cluster-content div.cluster-description-wrapper span.-eva-3-tc-gray-2");
    By btnSiguienteCalendario = By.cssSelector("div.datepicker-packages.sbox-v4-components div._dpmg2--controls-next i");

    public void irPaquetesDesdeHome(){
        // generar la lista categorias
        List <WebElement> listaCategorias = generarLista(categorias);
        // seleccionar el elemento paquetes de la lista
        busquedaElemento(listaCategorias,"Paquetes");
    }

    public void seleccionarVuelo1Alojamiento(){
        darClick(darClickVuelo1Alojamiento);
    }

    public void seleccionarVuelo2Alojamientos(){
        darClick(darClickVuelo2Alojamientos);
    }

    public void llenarCasillaOrigen(String origen, String seleccion){
        // llenar la casilla Origen
        ingresarDestino(origen,seleccion,campoOrigen,esperaCasilla);
    }

    public void llenarCasillaDestino(String destino, String seleccion){
        //llenar la casilla Destino
        ingresarDestino(destino,seleccion,campoDestino,esperaCasilla);
    }

    public void llenarCasillaSegundoDestino (String destino, String seleccion){
        // llenar la casilla Segundo Destino
        ingresarDestino(destino,seleccion,campoSegundoDestino,esperaCasilla);
    }

    public void seleccionarFechas(int fecha1, int fecha2){
        darClick(darClickCampoFechaIda);
        buscarEnCalendario(fecha1,fecha2,calendario,btnSiguienteCalendario);
    }

    public void seleccionarFechasLejanas(String mes, int fechaInicio, int fechaFin, int fechaParada){
        darClick(darClickCampoFechaIda);
        fechasLejanas(mes,fechaInicio,fechaFin, calendario);
        darClick(darClickVuelo2Alojamientos);
        darClick(darClickCampoFechaHasta);
        ingresarUnaFechaEspecifica(fechaParada,calendario);
    }

    public void seleccionarCantidadPasajeros(int numero){
        darClick(darClickPasajeros);
        cantidadPasajeros(numero,pasajeros);
    }

    public void darClickBuscar(){
        esperaExplicitaElementoClickeable(btnBuscar);
        darClick(btnBuscar);
        esperaImplicita();
    }

    public void agregarUnMenorDeEdad(int edad){
        edadMenor(edad);
    }

    public int resultadosBusqueda(){
        return contarElementos(contenedorResultados);
    }

    public String obtenerUbicacionHotel(){
        esperaExplicitaElementoVisible(ubicacionHotel);
        return obtenerTexto(ubicacionHotel);
    }

    public String validarMensaje(){
        esperaExplicitaElementoVisible(mensajePaquete);
        return obtenerTexto(mensajePaquete);
    }

    public void cambiarBoxTipoMoneda(String seleccion) throws InterruptedException {
        seleccionbox(boxTipoDeMoneda,seleccion);
        esperaImplicita();
    }
    public void cambiarBoxOrdenarPor(String seleccion) throws InterruptedException {
        seleccionbox(boxOrdenarPor,seleccion);
        esperaImplicita();
    }

    public void selecionarPaqueteMasConveniente(){
        esperaExplicitaElementoClickeable(paqueteMasConveniente);
        darClick(paqueteMasConveniente);
        esperaImplicita();
    }

    public void seleccionarHotelHoliday(){
        esperaExplicitaElementoClickeable(darClickHotelHoliday);
        darClick(darClickHotelHoliday);
        esperaImplicita();
        esperaExplicitaElementoClickeable(hotelHoliday);
        darClick(hotelHoliday);
        esperaImplicita();
    }

    public void selccionarHotelMarbella(){
        esperaExplicitaElementoClickeable(darClickHotelMarbella);
        darClick(darClickHotelMarbella);
        esperaImplicita();
        esperaExplicitaElementoClickeable(hotelMarbella);
        darClick(hotelMarbella);
        esperaImplicita();
    }
}

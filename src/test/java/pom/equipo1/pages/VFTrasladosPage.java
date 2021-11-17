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
    By darClickCampoFechaIda = By.cssSelector("[placeholder='Arribo']");
    By calendario = By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number");
    By darClickPasajeros = By.cssSelector("div.sbox-distri-input-container");
    By pasajeros = By.cssSelector("div.sbox-distri-container div.sbox-passengers-container input");
    By botonBuscar = By.cssSelector("div.sbox-button-container a");
    By mensajeVerificar1= By.xpath("//div[@class= 'dm-description -eva-3-mt-xsm']//span");


    //segundo caso
    By listaComprar = By.cssSelector(".eva-3-btn .btn-text");

    //tercer caso
    By clickAgregarRegreso= By.cssSelector("div.sbox-places-check span label i");
    By clickEntrada=By.xpath(".//input[@placeholder='Arribo']");
    By clickHora= By.cssSelector("div.sbox-moment-container select");
    By listaHora = By.cssSelector("div.sbox-moment-container.sbox-second-moment-container select option");
    By clickAplicar = By.xpath("//div[@class='_pnlpk-panel__footer -medium-down-to-lg']/child::a");
    By mensajeVerificar2 = By.xpath("//*[@class='dm-d-text eva-3-p -eva-3-tc-gray-2 -eva-3-mb-xsm']//child::span");
    By clickListaDolares= By.xpath("//select[@id='currency-select']");
    By cambioDolares= By.xpath("//select[@id='currency-select']//option");
    By clickComprar = By.cssSelector("#bodyID > div.ds-transfers-wrapper > div.ng-scope > div > div.search-view-container-wrapper > main > div:nth-child(3) > div > div.search-view-items-container > div:nth-child(2) > search-item > div.eva-3-cluster-gallery.-eva-3-shadow-line.-eva-3-shadow-line-hover > div.cluster-container > div.cluster-pricebox-container > div > div.pricebox-top-container > div.pricebox-action > button > em");
    By btnCambiarMes = By.xpath("//i[@class='_dpmg2--icon-ico-arrow']//ancestor::div[@class='datepicker-packages-car sbox-v4-components']");

    //primer caso
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

    public void seleccionarFecha(int fecha1){
        darClick(darClickCampoFechaIda);
        seleccionarEnfechaArriedo(fecha1,calendario);
    }

    public void seleccionarCantidadPasajeros(int numero){
        darClick(darClickPasajeros);
        cantpasajerosTraslado(numero,pasajeros);
    }

    public String validarTransporte(String mensaje){
        return validarDatos(mensaje, mensajeVerificar1);
    }

    //segundo caso

    public void clickComprar(String compra){
        esperaImplicita();
        esperaExplicitaElementoClickeable(listaComprar);
        seleccionarEnComprar(compra,listaComprar);
    }

    public void cantidadPasajeroMenorADos(int numero){
        darClick(darClickPasajeros);
        cantidadPasajeros(numero,pasajeros);
    }

    public String validarTransporte2(String mensaje){
        return validarDatos(mensaje, mensajeVerificar2);
    }

    public void cambiarADolares(String ingresar) throws InterruptedException {
        darClick(clickListaDolares);
        cambiarPesos(ingresar, cambioDolares);
    }

    //tercer caso

    public void clickCheckAgregarRegreso(){
        darClick(clickAgregarRegreso);

    }
    public void ingresarFechaDesdeyHasta(int fecha1, int fecha2){
        esperaImplicita();
        darClick(clickEntrada);
        esperaExplicitaElementoClickeable(clickEntrada);
        esperaExplicitaElementoClickeable(calendario);
        buscarEnCalendario(fecha1,fecha2,calendario,btnCambiarMes);
    }

    public void seleccionarAplicar(){
        clickBotoAplicar(clickAplicar);
    }

    public void darClickBotonBuscar(){
        darClick(botonBuscar);}

    public void darClickComprar(){
        esperaExplicitaElementoClickeable(clickComprar);
        darClick(clickComprar);
    }
}

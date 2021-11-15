package pom.equipo3.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo3.base.SeleniumBase;

public class VFPaquetesPage extends SeleniumBase {
    public VFPaquetesPage(WebDriver driver) { super(driver); }

    By btnPaquetes = By.xpath("//label[contains(text(),'Paquetes')]");
    By divDatosViaje = By.xpath("//div[@class='sbox-show-hide-container -sbox-3-shadow-static']");
    By btnCheckVueloAutos = By.cssSelector("input[class='sbox-bundle-input sbox-radio-va sbox-radio-selected-box'] ");
    By btnBuscar = By.cssSelector("a.sbox-search");
    By btnOrigen = By.cssSelector("input[class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first sbox-origin-container places-inline']");
    By btnDestino = By.cssSelector("input[class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']");
    By listaViajes = By.xpath("//div[@class='ac-group-container']//child::ul/li[1]");
    By btnfechaIda = By.xpath("//input[@placeholder='Ida']");
    By listaFechas= By.xpath("//span[@class='_dpmg2--date-number']");
    By btnCheckVuelosMas2Alojamientos = By.cssSelector("input[class='sbox-bundle-input sbox-radio-vhh sbox-radio-selected-box'] ");
    By btnPasajeros = By.cssSelector(".sbox-distri-input > div:nth-child(1)");
    By btnAgregarPasajero = By.xpath("//div[@class='number-picker sbox-3-steppers -md']//child::a[@class='steppers-icon-right sbox-3-icon-plus']");
    By btnBuscarVuelosAlojamientos = By.xpath("//em[contains(text(),'Buscar')]");
    By btnDestinoAlojamiento = By.xpath("//label[contains(text(),'Segundo destino')]/following::input");
    By btnfechaHasta = By.xpath("//input[@placeholder='Hasta']");


    //Funciones que se usan en todos los tests de paquetes

    public void irPaquetesDesdeHome(){
        clickear(btnPaquetes);
        esperaExplicitaElementoClickeable(divDatosViaje,5);

    }
    public void irVuelosAutos(){
        clickear(btnCheckVueloAutos);


    }
    public void irVuelosMas2Alojamientos(){
        clickear(btnCheckVuelosMas2Alojamientos);

    }
    public void agregar8Pasajeros() {
        clickear(btnPasajeros);
        for (int i = 0; i < 6; i++) {

            clickear(btnAgregarPasajero);
        }
    }
    public void agregarPasajeros(){
        clickear(btnPasajeros);
        clickear(btnAgregarPasajero);

    }


    public void ingresarOrigenDestino(){

        ingresarTexto(btnOrigen,"Santiago");
        clickear(listaViajes);
        ingresarTexto(btnDestino,"Miami");
        clickear(listaViajes);

    }

    public void ingresarOrigenDestinoVuelosAlojamientos(){

        ingresarTexto(btnOrigen,"Rancagua");
        clickear(listaViajes);
        ingresarTexto(btnDestino,"Ciudad de Buenos Aires");
        clickear(listaViajes);

    }
    public void ingresarFechas(){
        clickear(btnfechaIda);
        seleccionarFecha(listaFechas, "20");
        seleccionarFecha(listaFechas, "27");

    }

    public void ingresarfechaAlojamiento(){
        clickear(btnfechaIda);
        seleccionarFecha(listaFechas, "20");
        seleccionarFecha(listaFechas, "27");
        clickear(btnfechaHasta);
        seleccionarFecha(listaFechas,"24");

    }

    public void ingresarDestinoAlojamiento(){
        ingresarTexto(btnDestinoAlojamiento,"mendoza");
        clickear(listaViajes);

    }



    public void buscarPaquete()
    {

        clickear(btnBuscar);
    }
    public  void buscarVueloMasAlojamientos(){
        clickear(btnBuscarVuelosAlojamientos);
    }


}
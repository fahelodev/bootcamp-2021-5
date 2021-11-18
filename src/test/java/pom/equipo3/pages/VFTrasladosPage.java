package pom.equipo3.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo3.base.SeleniumBase;

public class VFTrasladosPage extends SeleniumBase  {
    public VFTrasladosPage(WebDriver driver) {super(driver);}

    By btnTraslados = By.xpath("//label[contains(text(),'Traslados')]");
    By btnCheckHaciaAeropuerto = By.xpath("//span[contains(text(),' Hacia el aeropuerto')]");
    By btnCheckAgregarRegreso = By.cssSelector("span.sbox-3-checkbox.-md");
    By btnBuscar = By.cssSelector("a.sbox-search");
    //Hacia el Aeropuerto
    By btnDesde = By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By btnHacia = By.xpath("//input[@placeholder='Ingresa un aeropuerto']");
    //Desde el aeropuerto
    By btnDesdeAeropuerto = By.xpath("//input[@placeholder='Ingresa un aeropuerto']");
    By btnHaciaHotel = By.xpath("//input[@placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By listaViajes = By.xpath("//div[@class='ac-group-container']//child::ul/li[1]");
    By btnfechaArribo = By.xpath("//input[@placeholder='Arribo']");
    By btnfechaPartida = By.xpath("//input[@placeholder='Partida']");
    By listaFechas= By.xpath("//span[@class='_dpmg2--date-number']");
    By campoHoraArrival = By.xpath("//select[contains(@class,'time-arrival')]");
    By campoHoraDeparture = By.xpath("//select[contains(@class,'time-departure')]");
    By listaHora = By.cssSelector("select.select-tag.sbox-time-departure");
    By btnPasajeros = By.cssSelector(".sbox-distri-input > div:nth-child(1)");
    By btnAgregarPasajero = By.xpath("//div[@class='number-picker sbox-3-steppers -md']//child::a[@class='steppers-icon-right sbox-3-icon-plus']");

    By btnAgregarMenores = By.cssSelector("._pnlpk-stepper-minors .sbox-3-icon-plus");
    By btnBuscarVuelosAlojamientos = By.xpath("//em[contains(text(),'Buscar')]");

    By listaEdad = By.cssSelector("._pnlpk-minors-age-select-wrapper select");
    By btnListaMoneda = By.xpath("//*[@id='currency-select']");
    By btnDolares = By.xpath("//*[@id='currency-select']/option[2]");


    //Funciones que se usan en todos los tests de Traslados

    public void irTrasladosDesdeHome(){
        clickear(btnTraslados);
        esperaExplicitaElementoClickeable(btnCheckHaciaAeropuerto,5);

    }
    public void irHaciaAeropuerto(){
        clickear(btnCheckHaciaAeropuerto);


    }
    public void irAgregarRegreso(){
        clickear(btnCheckAgregarRegreso);


    }

    public void agregar4Pasajeros() {
        clickear(btnPasajeros);
        for (int i = 0; i < 2; i++) {

            clickear(btnAgregarPasajero);
        }

    }

    public void agregarMenores() {
        clickear(btnPasajeros);
        for (int j = 0; j < 1; j++){

            clickear(btnAgregarMenores);
        }
        seleccionarElementoPorTexto(listaEdad ,"10 años");
    }


   /* public void agregarPasajeros(){
        clickear(btnPasajeros);
        clickear(btnAgregarPasajero);

    }*/


    public void ingresarDesdeHacia(){

        ingresarTexto(btnDesde,"Costanera Center");
        clickear(listaViajes);
        ingresarTexto(btnHacia,"Aeropuerto Arturo");
        clickear(listaViajes);

    }

    public void ingresarAeropuertoHotel(){

        ingresarTexto(btnDesdeAeropuerto,"Aeropuerto Arturo");
        clickear(listaViajes);
        ingresarTexto(btnHaciaHotel,"Costanera Center");
        clickear(listaViajes);

    }

    public void ingresarFechaArribo(){
        clickear(btnfechaArribo);
        seleccionarFecha(listaFechas, "20");

    }
    public void cargarHoraArrival(){
        clickear(campoHoraArrival);
        seleccionarElementoPorTexto(listaHora ,"16:00");

    }

    public void ingresarFechaPartida(){
        clickear(btnfechaPartida);
        seleccionarFecha(listaFechas, "25");
    }
    public void cargarHoraDeparture(){
        clickear(campoHoraDeparture);
        seleccionarElementoPorTexto(listaHora ,"10:00");

    }


    public void ingresarTipoMoneda(){
        clickear(btnListaMoneda);
        clickear(btnDolares);

    }

    public void buscarPaquete()
    {

        clickear(btnBuscar);
    }
    public  void buscarVueloMasAlojamientos(){
        clickear(btnBuscarVuelosAlojamientos);
    }


}


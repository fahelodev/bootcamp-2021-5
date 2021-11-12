package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo2.base.SeleniumBase;

public class VFTrasladoPage extends SeleniumBase {

    public VFTrasladoPage(WebDriver driver){
        super(driver);
    }

    //atributos - objeto a guardar
    By btnTraslado = By.xpath("//label[contains(text(),'Traslados')]");
    By campoOrigen = By.cssSelector("input.input-tag.sbox-main-focus.sbox-origin");
    By listaOrigen =By.xpath("//span[contains(text(),'Taravella')]");
    By campoDestino = By.cssSelector("input[placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By listaDestino = By.cssSelector("div.ac-container ul li");
    By campoFecha = By.cssSelector("input.input-tag.sbox-checkin");
    By listadofechas = By.xpath("//span[@class='_dpmg2--date-number']");
    By campoHora = By.xpath("//select[contains(@class,'time-arrival')]");
    By listaHora = By.cssSelector("select.select-tag.sbox-time-arrival");
    By btnPasajeros = By.cssSelector("div.sbox-3-input.-md.sbox-distri-input");
    By sumarPasajeros = By.cssSelector("a.steppers-icon-right.sbox-3-icon-plus");
    By btnBuscar = By.cssSelector("i.input-icon.sbox-3-icon-search");
    By radioHaciaAeropuerto = By.xpath("//span[contains(text(),' Hacia el aeropuerto')]");
    By listaOrigenTest09 = By.xpath("//span[contains(text(),'Vicente Almando')]");
    By seleccionarCampoFechaTest09 = By.xpath("//input[contains(@class,'checkout')]");
    By listaHoraTest09 = By.cssSelector("select.select-tag.sbox-time-departure");
    By campoHoraTest09 = By.cssSelector("//select[contains(@class,'time-departure')]");



    public void irTrasladoDesdeHome(){
        clickear(btnTraslado);
    }

    public void cargarOrigen(){
        ingresarCampo(campoOrigen,"Cordoba");
        seleccionarTexto(listaOrigen,"Taravella");
    }

    public void cargarDestino(){
        ingresarCampo(campoDestino,"Sava");
        seleccionarTexto(listaDestino,"");
    }

    public void cargarFecha(){
        clickear(campoFecha);
        seleccionarFecha(listadofechas,"22");
    }

    public void cargarHora(){
        clickear(campoHora);
        seleccionarSelect(listaHora,"07:00");

    }

    public void btnPasajeros(){
        clickear(btnPasajeros);
    }

    public void cargarPasajero(){
        seleccionarPasajeros(sumarPasajeros,12);
    }

    public void realizarbusqueda(){
        clickear(btnBuscar);
    }

    public void cargarAdultoPasajero(){
        seleccionarPasajeros(sumarPasajeros,3);
    }

    public void seleccionarHaciaAeropuerto(){
        clickear(radioHaciaAeropuerto);
    }

    public void cargarDestinoTest09(){
        ingresarCampo(campoDestino,"Naindo");
        seleccionarTexto(listaDestino,"Naindo");
    }

    public void cargarOrigenTest09(){
        ingresarCampo(campoOrigen,"La rioja");
        seleccionarTexto(listaOrigenTest09,"Vicente Almando");
    }

    public void cargarFechaTest09(){
        clickear(seleccionarCampoFechaTest09);
        seleccionarFecha(listadofechas,"22");
        clickear(campoHoraTest09);
        seleccionarSelect(listaHora,"07:00");

    }







}

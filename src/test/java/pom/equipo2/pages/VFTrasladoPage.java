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
    By campoOrigen = By.xpath("//input[contains(@class,'sbox-places-first')]");
    By campoDestino = By.cssSelector("input[placeholder='Ingresa un hotel o dirección adónde quieras ir']");
    By origen =By.xpath("//span[contains(text(),'Taravella')]");
    By destino = By.xpath("//span[contains(text(),'Savannah')]");
    By campoFecha = By.cssSelector("input.input-tag.sbox-checkin");
    By listadofechas = By.xpath("//span[@class='_dpmg2--date-number']");
    By campoHora = By.xpath("//select[contains(@class,'time-arrival')]");
    By listaHora = By.cssSelector("select.select-tag.sbox-time-arrival");
    By btnPasajeros = By.cssSelector("div.sbox-3-input.-md.sbox-distri-input");
    By sumarPasajeros = By.cssSelector("a.steppers-icon-right.sbox-3-icon-plus");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");
    By radioHaciaAeropuerto = By.xpath("//span[contains(text(),' Hacia el aeropuerto')]");
    By destinoTest09 = By.xpath("//span[contains(text(),'Naindo')]");
    By origenTest09 = By.xpath("//span[contains(text(),'Vicente Almando')]");
    By seleccionarCampoFechaTest09 = By.xpath("//input[contains(@class,'checkout')]");
    By listaHoraTest09 = By.cssSelector("select.select-tag.sbox-time-departure");
    By campoHoraTest09 = By.cssSelector("//select[contains(@class,'time-departure')]");

    public void irTrasladoDesdeHome(){
        clickear(btnTraslado);
    }

    public void cargarOrigen(){
        ingresarTexto(campoOrigen,"Cordoba");
        clickear(origen);
    }

   public void cargarDestino(){
        ingresarTexto(campoDestino,"Sava");
        clickear(destino);
    }

    public void cargarFecha(){
        clickear(campoFecha);
        seleccionarFecha(listadofechas,"22");
    }

    public void cargarHora(){
        clickear(campoHora);
        seleccionarElementoPorTexto(listaHora,"07:00");

    }

    public void cargarPasajeroTest11(){
      clickear(btnPasajeros);
        seleccionarPersonas(sumarPasajeros,12);
    }

    public void realizarbusqueda(){
        clickear(btnBuscar);
    }

    public void cargarPasajeroTest10(){
        clickear(btnPasajeros);
        seleccionarPersonas(sumarPasajeros,3);
    }

    public void seleccionarHaciaAeropuerto(){
        clickear(radioHaciaAeropuerto);
    }

    public void cargarDestinoTest09(){
        ingresarTexto(campoDestino,"Naindo");
        clickear(destinoTest09);
    }

    public void cargarOrigenTest09(){
        ingresarTexto(campoOrigen,"La rioja");
        clickear(origenTest09);
    }

    public void cargarFechaTest09(){
        clickear(seleccionarCampoFechaTest09);
        seleccionarFecha(listadofechas,"22");
    }

    public void cargarHoraTest09(){
        //clickear(campoHoraTest09);
        seleccionarElementoPorTexto(listaHoraTest09,"07:00");
    }
}

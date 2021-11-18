package pom.equipo6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo6.base.SeleniumBase;

public class VFAlojamientoPage extends SeleniumBase {

    public VFAlojamientoPage(WebDriver driver) {super(driver);}
    //Atributos - objeto a guardar
    By btnAlojamiento = By.xpath("//label[.='Alojamientos']");
    By textFieldDestino = By.cssSelector("[placeholder='Ingresa una ciudad, alojamiento o atracción']");
    By selectFirtsDestino = By.xpath("//li[.='Córdoba, Córdoba, Argentina']");
    By btnCheckBoxNoFecha = By.cssSelector(".checkbox-label");
    By btnSearch = By.cssSelector(".sbox-search");
    //Atributos - objeto a guardar caso de prueba 002
    By btnFechaIda = By.cssSelector("[placeholder='Entrada']");
    By btnFechaVuelta = By.cssSelector("[placeholder='Salida']");
    By selectFirstFechaIda = By.xpath("//div[@class='_dpmg2--dates']/child::span[18]");
    By selectFirstFechaVuelta = By.xpath("//span[.='25NocheNoches']");
    By btnApplyFechas = By.xpath("//em[contains(text(),'Aplicar')]");
    By btnApplyFechasHotel = By.cssSelector("._dpmg2--desktopFooter-button-apply");
    By textFieldSecondDestino = By.cssSelector("[placeholder='Ingresá una ciudad, alojamiento o atracción']");
    By selectSecondDestino = By.xpath("//li[.='Buenos Aires, Ciudad de Buenos Aires, Argentina']");
    By btnCheckBoxSecondNoFecha = By.cssSelector(".sbox5-label-ovr");
    By verifyText002 = By.xpath("//h1[@id='landingsTitle']");
    //Atributos - objeto a guardar caso de prueba 003
    By btnSecondSearch = By.cssSelector(".sbox5-box-button-ovr");
    By btnHotel = By.xpath("//div[.='qp Hotels Lima']");
    By btnSecondHotel = By.cssSelector("[index='0'] .eva-3-btn");
    By btnReservarAhora = By.xpath("//em[contains(text(),'Reservar ahora')]");
    By btnSelectAeroPuerto = By.id("select-test");
    By selectAeroPuerto = By.xpath("//option[.='LIM, Aeropuerto Internacional Jorge Chavez']");
    By btnVueloDestino = By.id("arrivalTime");
    By selectHoraDestino = By.xpath("//select[@id='arrivalTime']/option[.='01:30']");
    By btnVueloRegreso = By.id("departureTime");
    By selectHoraRegreso = By.xpath("//select[@id='departureTime']/option[.='06:00']");
    By btnBuscarAeroPuerto = By.xpath("//em[contains(text(),'Buscar')]");
    By btnAgregarTraslado = By.xpath("//div[@class='highlight-card-container -eva-3-shadow-1-hover -eva-3-bc-white TRANSFER REGULAR']//em[@class='btn-text']");
    By btnVerDetalle = By.xpath("//a[.='Ver detalle']");
    By verifyText003 = By.xpath("//span[@class='added-product-title']");

    public void goAlojamientoToHome(){
        click(btnAlojamiento);
        waitExplicitClick(btnAlojamiento, 7);
    }
    public void selectDestino(){
        click(textFieldDestino);
        fieldsTextDestino(textFieldDestino);
        click(selectFirtsDestino);
    }
    public void selectNoFecha(){
        click(btnCheckBoxNoFecha);
    }
    public void confirmAlojamiento(){
        click(btnSearch);
    }
    public void confirmFechaAlojamiento(){
        click(btnFechaIda);
        waitExplicitClick(selectFirstFechaIda, 10);
        click(selectFirstFechaIda);
        click(selectFirstFechaVuelta);
        click(btnApplyFechas);
    }
    public void otherAlojamiento(){
        click(textFieldSecondDestino);
        clear(textFieldSecondDestino);
        click(textFieldSecondDestino);
        fieldSecondTextDestino(textFieldSecondDestino);
        click(selectSecondDestino);
    }
    public void selectSecondNoFecha(){
        click(btnCheckBoxSecondNoFecha);
    }
    public void confirmSecondAlojamiento(){
        click(btnSecondSearch);
    }
    public void selectHotel(){
        click(btnHotel);
        switchVentana(btnFechaIda,2);
    }
    public void confirmFechaHotel(){
        click(btnFechaIda);
        click(selectFirstFechaIda);
        click(btnFechaVuelta);
        click(selectFirstFechaVuelta);
        click(btnApplyFechasHotel);
        click(btnSearch);
    }
    public void confirmSecondHotel(){
        waitExplicitClick(btnSecondHotel,10);
        click(btnSecondHotel);
    }
    public void confirmReservaSecondHotel(){
        switchVentana(btnReservarAhora,2);
        click(btnReservarAhora);
    }
    public void confirmAeroPuerto(){
        click(btnSelectAeroPuerto);
        click(selectAeroPuerto);
        click(btnVueloDestino);
        click(selectHoraDestino);
        click(btnVueloRegreso);
        click(selectHoraRegreso);
        click(btnBuscarAeroPuerto);
    }
    public void confirmTraslado() throws InterruptedException {
        waitExplicitClick(btnAgregarTraslado,50);
        click(btnAgregarTraslado);
        loadEmergent(btnVerDetalle);
        click(btnVerDetalle);
    }

    public void checkText002(){verifyTextAlojamiento002(verifyText002);}

    public void checkText003(){
        verifyTextAlojamiento003(verifyText003);}
}

package pom.equipo6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo6.base.SeleniumBase;

public class VFPaquetesPage extends SeleniumBase {
    public VFPaquetesPage(WebDriver driver) {
        super(driver);
    }
    //Atributos - objeto a guardar
    By btnPaquetes = By.xpath("//label[.='Paquetes']");
    By textFieldCiudadOrigen = By.xpath("//input[@placeholder='Ingresa una ciudad']");
    By selectCiudadOrigen = By.xpath("//span[contains(.,'Buenos Aires, Ciudad de Buenos Aires, Argentina')]");
    By textFieldCiudadDestino = By.cssSelector(".sbox-destination");
    By selectCiudadDestino = By.xpath("//span[.='Barcelona, Cataluña, España']");
    By checkBoxNoFecha = By.cssSelector(".switch-circle");
    By btnSearch = By.xpath("//em[.='Buscar']");
    By verifyText001 = By.cssSelector(".eva-3-h1");
    //Atributos - objeto a guardar caso de prueba 002
    By btnFechaIda = By.cssSelector("[placeholder='Ida']");
    By selectFechaIda = By.xpath("//div[@class='_dpmg2--wrapper _dpmg2--roundtrip _dpmg2--show-info _dpmg2--show']//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--month-active']//span[@class='_dpmg2--date _dpmg2--available']/span[.='18']");
    By selectFechaVuelta = By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--has-start-range _dpmg2--month-active']//span[.='25NocheNoches']");
    By btnApplyFecha = By.xpath("//em[contains(text(),'Aplicar')]//following::em[8]");
    By btnHabitaciones = By.cssSelector(".sbox-distri-input > .input-container");
    By btnAddAdult = By.xpath("//a[@class='steppers-icon-right sbox-3-icon-plus']//following::a[6]");
    By btnAddChild = By.xpath("//a[@class='steppers-icon-right sbox-3-icon-plus']//following::a[8]");
    By btnSelectAgeChild = By.xpath("//select[@class='select-tag']//following::select[7]");
    By selectAgeChild = By.xpath("//select[@class='select-tag']//following::select[7]//option[@value='3']");
    By btnApplyHabitaciones = By.xpath("//a[contains(text(),'Aplicar')]//following::a[21]");
    By btnOrderBy = By.xpath("//select[@class='select-tag']//following::select[37]");
    By selectOrderBy = By.xpath("//option[contains(.,'Precio: menor a mayor')]");
    By verifyText002 = By.cssSelector("#packages-subtitle");
    //Atributos - objeto a guardar caso de prueba 003
    By btnVueloTwoAlojamientos = By.cssSelector(".sbox-radio-vhh");
    By textFieldCiudadOrigenTwo = By.cssSelector(".sbox-hotel-first-destination");
    By btnFechaHasta = By.cssSelector(".sbox-hotel-first-checkout-date");
    By selectFechaHasta = By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--has-start-range _dpmg2--has-limit-date _dpmg2--month-active']//span[.='24']");
    By btnApplyFechaHasta = By.xpath("//em[contains(text(),'Aplicar')]//following::em[2]");
    By textFieldCiudadDestinoTwo = By.cssSelector(".sbox-hotel-second-destination");
    By btnHabitacionesVueloTwoAlojamientos = By.cssSelector(".sbox-distri-input > .input-container");
    By btnAddAdultVueloTwoAlojamientos = By.xpath("//input[@class='steppers-tag']//following::a[8]");
    By btnAddChildVueloTwoAlojamientos = By.xpath("//input[@class='steppers-tag']//following::a[10]");
    By btnSelectAgeChildVueloTwoAlojamientos = By.xpath("//select[@class='select-tag']//following::select[7]");
    By selectAgeChildVueloTwoAlojamientos = By.xpath("//select[@class='select-tag']//following::select[7]//option[@value='3']");
    By btnAddHabitacionVueloTwoAlojamientos = By.xpath("//div[@class='_pnlpk-panel__footer -medium-down-to-lg']//following::a[22]");
    By btnAddAdultNewHabitacionVueloTwoAlojamientos = By.xpath("//input[@class='steppers-tag']//following::a[13]");
    By btnApplyVueloTwoAlojamientos = By.xpath("//a[contains(text(),'Aplicar')]//following::a[21]");
    By btnBuscarVueloTwoAlojamientos = By.xpath("//em[.='Buscar']");
    By windowEmergentError = By.cssSelector(".sbox-hotel-second-destination-different-from-origin-error");

    public void goPaquetesToHome(){
        click(btnPaquetes);
    }

    public void selectCiudadOrigen(){
        click(textFieldCiudadOrigen);
        fieldTextPaquetesOrigen(textFieldCiudadOrigen);
        click(selectCiudadOrigen);
    }

    public void selectCiudadDestino(){
        click(textFieldCiudadDestino);
        fieldTextPaquetesDestino(textFieldCiudadDestino);
        click(selectCiudadDestino);
    }

    public void selectNoFecha(){
        click(checkBoxNoFecha);
    }

    public void applySearch(){
        click(btnSearch);
    }

    public void checkText001(){
        verifyTextPaquetes001(verifyText001);
    }

    public void defineFechaPaquete(){
        click(btnFechaIda);
        click(selectFechaIda);
        click(selectFechaVuelta);
        click(btnApplyFecha);
    }

    public void addAdultAndChildHabitaciones(){
        click(btnHabitaciones);
        click(btnAddAdult);
        click(btnAddChild);
        click(btnSelectAgeChild);
        click(selectAgeChild);
        click(btnApplyHabitaciones);
    }

    public void orderByMenorCosto(){
        click(btnOrderBy);
        click(selectOrderBy);
    }

    public void checkText002(){verifyTextPaquete002(verifyText002);}

    public void optionVueloDosAlojamientos(){click(btnVueloTwoAlojamientos);}

    public void selectCiudadOrigenTwo(){
        click(textFieldCiudadOrigenTwo);
        fieldTextPaquetesOrigen(textFieldCiudadOrigenTwo);
        click(selectCiudadOrigen);
    }

    public void defineFechaHastaOrigenTwo(){
        click(btnFechaHasta);
        click(selectFechaHasta);
        click(btnApplyFechaHasta);
    }

    public void selectCiudadDestinoTwo(){
        click(textFieldCiudadDestinoTwo);
        fieldTextPaquetesOrigen(textFieldCiudadDestinoTwo);
        click(selectCiudadOrigen);
    }

    public void addAdultChildHabitacionVueloTwoAlojamientos(){
        click(btnHabitacionesVueloTwoAlojamientos);
        click(btnAddAdultVueloTwoAlojamientos);
        click(btnAddChildVueloTwoAlojamientos);
        click(btnSelectAgeChildVueloTwoAlojamientos);
        click(selectAgeChildVueloTwoAlojamientos);
        click(btnAddHabitacionVueloTwoAlojamientos);
        click(btnAddAdultNewHabitacionVueloTwoAlojamientos);
        click(btnApplyVueloTwoAlojamientos);
    }

    public void applyBuscarVueloTwoAlojamientos(){click(btnBuscarVueloTwoAlojamientos);}

    public void checkText003(){verifyTextPaquete003(windowEmergentError);}

}

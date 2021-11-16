package pom.equipo4.pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pom.equipo4.base.SeleniumBase;

public class VFTrasladosPage extends SeleniumBase {
    public VFTrasladosPage(WebDriver driver) { super(driver); }
    By divTrasladoOrlandoCard = By.xpath("//div[@class='offer-card-container']//div[text()='Traslado en Orlando']");
    By divMapa = By.xpath("//div[@class='see-map']");
    By cerrarMapa = By.xpath("//div[@class='eva-3-modal -no-padding map ng-scope -show-modal']//i[@class='modal-close eva-3-icon-close']");
    By listaNombresHotelesPrimero = By.xpath("//li[@class='item -active']");
    By btnBusquedaViaje = By.xpath("//div[@class='sbox-button-container']");
    By switchSinFechaViaje = By.xpath("//span[@class='switch-container']");
    By divResultadosHotelesUsarPrimero = By.xpath("//div[@class='offer-container offer-container-0' and @index='0'][1]");
    By getDivResultadosHotelesUsarPrimeroSegundaVez = By.xpath("//div[@class='eva-3-cluster-gallery -eva-3-bc-white -eva-3-shadow-line-hover'][1]");
    By divCalendarioArribo = By.xpath("//div[contains(@class,'sbox-checkin-container')]");
    By calendarioDia1Arribo = By.xpath("/html/body/div[3]/div/div[5]/div[2]/div[4]/span[1]");
    By calendarioDia1Partida = By.xpath("/html/body/div[2]/div/div[5]/div[2]/div[4]/span[1]");
    By btnAplicarDia = By.xpath("//div[@class='_dpmg2--date-footer']//button[@class='_dpmg2--desktopFooter-button _dpmg2--desktopFooter-button-apply sbox-3-btn -lg -primary']");
    By divCalendarioPartida = By.xpath("//div[contains(@class,'sbox-second-moment-global-container sbox-js-show')]");
    By btnModificarDatosViaje = By.xpath("//a[@class='-md -eva-3-hide-small eva-3-btn -secondary']");
    By dropDownHoraViaje = By.xpath("//select[@class='select-tag sbox-time-arrival']");
    By btnAplicarCambiosModificados = By.xpath("//div[@class='sbox-button-container']");
    By dropDownTipoMoneda = By.xpath("//select[@id='currency-select']");
    By radioTrasladoHasta = By.xpath("//div[@class='sbox-radio-buttons']//span[2]//i");
    By agregarHoraViaje = By.xpath("//select[@class='select-tag sbox-time-departure']");
    By divCantidadPasajeros = By.xpath("//div[@class='sbox-distri-container']");
    By agregarPasajerosMenores = By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg']//a[@class='steppers-icon-right sbox-3-icon-plus']");
    By dropDownPasajerosMenoresEdad = By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']//select[@class='select-tag']");
    By dropDownPasajerosMenoresEdad2 = By.xpath("//div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//select[@class='select-tag']");
    By aplicarCambiosPasajeros = By.xpath("//a[@class='_pnlpk-apply-button sbox-3-btn -primary _pnlpk-panel__button--link-right -lg']");
    By btnComprarTraslado = By.xpath("//div[@class='results']//div[@class='search-cluster ng-scope'][1]//button");
    By checkCanjearPuntos = By.xpath("//span[text()='¿Quieres canjear tus CMR Puntos?']//ancestor::span");
    By btnPromocionesYFormasPago = By.xpath("//div[@class='eva-3-row -no-gutter']//a");

    //Funciones que se usan en todos los tests de paquetes

    public void ingresarOrigenDestinoVuelo(String origin_or_destination, String ciudad){
        By inputOrigenYDestino = By.xpath("//input[contains(@class,'input-tag sbox-main-focus sbox-"+origin_or_destination.toLowerCase()+"')]");
        ingresarTexto(inputOrigenYDestino,ciudad);
        esperaExplicitaPrescenciaElemento(listaNombresHotelesPrimero,10);
        clickear(listaNombresHotelesPrimero);
        Assert.assertEquals(obtenerTexto(listaNombresHotelesPrimero),obtenerTexto(inputOrigenYDestino));
    }

    public void aplicarBusqueda(Boolean sinFechaViaje)
    {
        if (sinFechaViaje)
        {
            clickear(switchSinFechaViaje);
        }
        clickear(btnBusquedaViaje);
    }

    // Funciones usadas en el primer Test

    public void clickearTrasladoCard(){
        clickear(divTrasladoOrlandoCard);
        selectPestana(1);
    }

    public void abrirMapaYCerrarlo(){
        esperaExplicitaPrescenciaElemento(divMapa,10);
        clickear(divMapa);
        esperaExplicitaElementoClickeable(cerrarMapa,10);
        clickear(cerrarMapa);
    }

    // Funciones usadas en el segundo Test

    public void selectArriboOPartida(char arribo_o_partida,String arribo)
    {
        if (arribo_o_partida == 'a')
        {
            clickear(divCalendarioArribo);
//        isClicked("//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--has-start-range _dpmg2--month-active']//span[text()="+arribo+"]"); no anda
            clickear(calendarioDia1Arribo); //tengo que usar este
            clickear(btnAplicarDia);

        } else if (arribo_o_partida == 'p')
        {
            clickear(divCalendarioPartida);
//        isClicked("//div[@class='_dpmg2--month _dpmg2--o-3 _dpmg2--has-start-range _dpmg2--month-active']//span[text()="+arribo+"]"); NO ANDA NO SE POR QUE
            clickear(calendarioDia1Partida); //TENGO QUE USAR ESTE PARA QUE ANDE
            clickear(btnAplicarDia);
        }

    }

    public void modificarDatosViaje(){
        esperaExplicitaElementoClickeable(btnModificarDatosViaje,10);
        clickear(btnModificarDatosViaje);
        selectDropDown(dropDownHoraViaje,"420");
        clickear(btnAplicarCambiosModificados);
    }

    public void cambiarMoneda()
    {
        esperaExplicitaElementoClickeable(dropDownTipoMoneda,10);
        selectDropDown(dropDownTipoMoneda,"string:USD");
    }

    public void selectDropDown(By path,String value)
    {
        Select s = new Select(encontrarElemento(path));
        s.selectByValue(value);
        Assert.assertNotNull(s.getFirstSelectedOption());
    }

    //Funciones usadas en el tercer Test

            public void cambiarDesdeAeropuertoHasta()
            {
                clickear(radioTrasladoHasta);
            }

            public void agregarHoraViaje()
            {
                selectDropDown(agregarHoraViaje,"420");
            }

            public void agregarPasajeros()
            {
                clickear(divCantidadPasajeros);
                for (int i=0;i<2;i++)
                {
                    clickear(agregarPasajerosMenores);
                    if (i==0)
                    {
                        selectDropDown(dropDownPasajerosMenoresEdad,"8");
                    } else {
                        selectDropDown(dropDownPasajerosMenoresEdad2,"12");
                    }
                }
                clickear(aplicarCambiosPasajeros);
            }

            public void comprarTraslado()
            {
                clickear(btnComprarTraslado);
            }

            public void checkearCanjePuntosYPromocionesConFormasPago()
            {
                esperaExplicitaElementoClickeable(checkCanjearPuntos,10);
                clickear(checkCanjearPuntos);
                Assert.assertTrue(encontrarElemento(By.xpath("//input[@class='checkbox-tag ng-untouched ng-pristine ng-valid']")).isSelected());
                esperaExplicitaElementoClickeable(btnPromocionesYFormasPago,10);
                clickear(btnPromocionesYFormasPago);
            }
}

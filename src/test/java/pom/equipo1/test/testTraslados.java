package pom.equipo1.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.equipo1.pages.VFHomePage;
import pom.equipo1.pages.VFTrasladosPage;
import pom.equipo2.base.TestBase;

public class testTraslados extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFTrasladosPage paginaTraslado = null;

    @Test
    public void Cdp06_BusquedaTraslado(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslado = new VFTrasladosPage(driver);
        paginaTraslado.irPaquetesDesdeHome();
        paginaTraslado.llenarCasillaOrigen("arturo", "Aeropuerto Arturo Merino Benitez");
        paginaTraslado.llenarCasillaDestino("sheraton","Sheraton Miramar");
        paginaTraslado.seleccionarFecha(20);
        paginaTraslado.seleccionarCantidadPasajeros(4);
        paginaTraslado.darClickBotonBuscar();
        paginaTraslado.clickComprar("Comprar");
        String validarMensaje = paginaTraslado.validarTransporte("Traslado Privado en Valparaiso: Minivan Estándar");
        Assert.assertEquals("true", validarMensaje);
    }

    @Test
    public void Cdp07_BusquedaTraslado(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslado = new VFTrasladosPage(driver);
        paginaTraslado.irPaquetesDesdeHome();
        paginaTraslado.llenarCasillaOrigen("arturo", "Aeropuerto Arturo Merino Benitez");
        paginaTraslado.llenarCasillaDestino("sheraton","Sheraton Miramar");
        paginaTraslado.seleccionarFecha(20);
        paginaTraslado.cantidadPasajeroMenorADos(2);
        paginaTraslado.darClickBotonBuscar();
        paginaTraslado.clickComprar("Comprar");
        String validarMensaje2 = paginaTraslado.validarTransporte2("Minivan");
        Assert.assertEquals("true",validarMensaje2);
    }

    @Test
    public void Cp08_AgregarTraslado() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslado = new VFTrasladosPage(driver);
        paginaTraslado.irPaquetesDesdeHome();
        paginaTraslado.llenarCasillaOrigen("arturo", "Aeropuerto Arturo Merino Benitez");
        paginaTraslado.llenarCasillaDestino("avenida ale","AVENIDA ALEMANIA");
        paginaTraslado.clickCheckAgregarRegreso();
        paginaTraslado.ingresarFechaDesdeyHasta(1,7);
        //paginaTraslado.ingresarHora(00);
        paginaTraslado.seleccionarCantidadPasajeros(4);
        paginaTraslado.seleccionarAplicar();
        paginaTraslado.darClickBotonBuscar();
        Thread.sleep(3000);
        paginaTraslado.cambiarADolares("Dólares");
        Thread.sleep(10000);
        paginaTraslado.darClickComprar();
    }
}

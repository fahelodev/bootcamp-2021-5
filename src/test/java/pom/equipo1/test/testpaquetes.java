package pom.equipo1.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pom.equipo1.base.TestBase;
import pom.equipo1.pages.VFHomePage;
import pom.equipo1.pages.VFpaquetesPage;

import static org.junit.Assert.assertTrue;

public class testpaquetes extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFpaquetesPage paginaPaquetes = null;

    @Before
    public void init(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFpaquetesPage(driver);
        paginaPaquetes.irPaquetesDesdeHome();
    }

    @Test
    public void CdP03_busquedaPaquetes(){
        paginaPaquetes.seleccionarVuelo1Alojamiento();
        paginaPaquetes.llenarCasillaOrigen("santiago","Santiago de Chile");
        paginaPaquetes.llenarCasillaDestino("san pedro","San Pedro de Atacama");
        paginaPaquetes.seleccionarFechas(1,2);
        paginaPaquetes.seleccionarCantidadPasajeros(2);
        paginaPaquetes.darClickBuscar();
        int lista = paginaPaquetes.resultadosBusqueda();
        assertTrue(lista>1);
    }

    @Test
    public void CdP02_busquedaPaquetes(){
        paginaPaquetes.llenarCasillaOrigen("santiago","Santiago de Chile");
        paginaPaquetes.llenarCasillaDestino("buenos aires","Ciudad de Buenos Aires");
        paginaPaquetes.seleccionarFechas(1,2);
        paginaPaquetes.darClickBuscar();
        String validar = paginaPaquetes.obtenerUbicacionHotel();
        Assert.assertTrue(validar.contains("Buenos Aires"));
    }

    @Test
    public void CdP01_agregarPaquete() throws InterruptedException {
        paginaPaquetes.seleccionarVuelo2Alojamientos();
        paginaPaquetes.llenarCasillaOrigen("bue","Ciudad de Buenos Aires");
        paginaPaquetes.llenarCasillaDestino("esp","Cataluña");
        paginaPaquetes.seleccionarFechasLejanas("Enero",4,19,8);
        paginaPaquetes.llenarCasillaSegundoDestino("marbella","Andalucía");
        paginaPaquetes.seleccionarCantidadPasajeros(2);
        paginaPaquetes.agregarUnMenorDeEdad(2);
        paginaPaquetes.darClickBuscar();
        paginaPaquetes.cambiarBoxTipoMoneda("Dólares");
        paginaPaquetes.cambiarBoxOrdenarPor("convenientes");
        paginaPaquetes.selecionarPaqueteMasConveniente();
        paginaPaquetes.seleccionarHotelHoliday();
        paginaPaquetes.selccionarHotelMarbella();
        String validar = paginaPaquetes.validarMensaje();
        Assert.assertTrue(validar.contains("Holiday Inn Express Barcelona City 22@"));
    }
}

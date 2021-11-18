package pom.equipo1.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.equipo1.base.TestBase;
import pom.equipo1.pages.VFHomePage;
import pom.equipo1.pages.VFalojamientosPage;
import pom.equipo1.pages.VFpaquetesPage;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testalojamientos extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFalojamientosPage paginaAlojamientos = null;

    @Test
    public void CdP09_busquedaAlojamiento(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamientos = new VFalojamientosPage(driver);
        paginaAlojamientos.irAlojamientosDesdeHome();
        paginaAlojamientos.seleccionarNoHedecidoFecha();
        ////se cae sin una espera(ver)
        paginaAlojamientos.llenarCasillaDestino("orlando","Orlando, Florida, Estados Unidos");
        paginaAlojamientos.darClickBotonBuscar();
        int cantidadResultados=paginaAlojamientos.resultadosBusquedaAlojamientos();
        assertTrue(cantidadResultados>1);
    }

    @Test
    public void CdP08_busquedaAlojamiento() {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamientos = new VFalojamientosPage(driver);
        paginaAlojamientos.irAlojamientosDesdeHome();
        paginaAlojamientos.llenarCasillaDestino("dub","Dubái, Dubai, Emiratos Árabes Unidos");
        //se cae sin una espera(ver)
        paginaAlojamientos.seleccionarFechas(1,7);
        paginaAlojamientos.seleccionarCantidadOcupantesHabitacion(1);
        paginaAlojamientos.darClickBotonBuscar();
        paginaAlojamientos.seleccionarFiltroOrdenarPor("Precio: menor a mayor");
        String validarLugar = paginaAlojamientos.validarLugar("Dubái");
        String validarDias = paginaAlojamientos.validarDias("6");

        assertEquals("true",validarLugar);
        assertEquals("true",validarDias);


    }

    @Test
    public void CdP07_agregarAlojamiento() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamientos = new VFalojamientosPage(driver);
        paginaAlojamientos.irAlojamientosDesdeHome();
        //se cae sin una espera
        paginaAlojamientos.llenarCasillaDestino("lon","Londres, Inglaterra, Reino Unido");
        paginaAlojamientos.seleccionarFechas(7,17);
        paginaAlojamientos.seleccionarCantidadOcupantesHabitacion(2);
        paginaAlojamientos.darClickBotonBuscar();
        paginaAlojamientos.buscarPorFiltro("Reserva flexible","reserva flexible");
        Thread.sleep(2000);
        paginaAlojamientos.buscarPorFiltro("Tipo de Alojamiento","Departamentos");
        Thread.sleep(2000);
        paginaAlojamientos.darClickPrimerResultadoBusquedaPorFiltro();
        paginaAlojamientos.cambiarANuevaPestaña();
        Thread.sleep(2000);
        paginaAlojamientos.darClickVerHabitaciones();
        paginaAlojamientos.darClickReservarAhora();
        paginaAlojamientos.darClickEnSiguiente();
        Thread.sleep(5000);
        String validarMensajeFelicitaciones=paginaAlojamientos.validarMensajeFelicitaciones("¡Felicitaciones! Seleccionaste la habitación más económica");
        assertEquals("true",validarMensajeFelicitaciones);
        // paginaAlojamientos.cerrarPestañaSecundaria();
        // paginaAlojamientos.volverPestañaInicial();
    }
}

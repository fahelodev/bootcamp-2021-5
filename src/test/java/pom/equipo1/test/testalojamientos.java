package pom.equipo1.test;

import org.junit.Before;
import org.junit.Test;
import pom.equipo1.base.TestBase;
import pom.equipo1.pages.VFHomePage;
import pom.equipo1.pages.VFalojamientosPage;
import pom.equipo1.pages.VFpaquetesPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testalojamientos extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFalojamientosPage paginaAlojamientos = null;

    @Before
    public void init(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamientos = new VFalojamientosPage(driver);
        paginaAlojamientos.irAlojamientosDesdeHome();
    }

    @Test
    public void CdP09_busquedaAlojamiento(){
        paginaAlojamientos.seleccionarNoHedecidoFecha();
        ////se cae sin una espera(ver)
        paginaAlojamientos.llenarCasillaDestino("orlando","Orlando, Florida, Estados Unidos");
        paginaAlojamientos.darClickBotonBuscar();
        int cantidadResultados=paginaAlojamientos.resultadosBusquedaAlojamientos();
        assertTrue(cantidadResultados>1);
    }

    @Test
    public void CdP08_busquedaAlojamiento() throws InterruptedException {
        paginaAlojamientos.llenarCasillaDestino("dub","Dubái, Dubai, Emiratos Árabes Unidos");
        //se cae sin una espera(ver)
        paginaAlojamientos.seleccionarFechas(1,7);
        paginaAlojamientos.seleccionarCantidadOcupantesHabitacion(1);
        paginaAlojamientos.darClickBotonBuscar();
        paginaAlojamientos.seleccionarFiltroOrdenarPor("Precio: menor a mayor");
        Thread.sleep(2000);
        String validarLugar = paginaAlojamientos.validarLugar("Dubái");
        String validarDias = paginaAlojamientos.validarDias("6");

        assertEquals("true",validarLugar);
        assertEquals("true",validarDias);


    }

}

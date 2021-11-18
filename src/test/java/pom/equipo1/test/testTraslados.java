package pom.equipo1.test;

import org.junit.Before;
import org.junit.Test;
import pom.equipo1.pages.VFHomePage;
import pom.equipo1.pages.VFTrasladosPage;
import pom.equipo2.base.TestBase;

public class testTraslados extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFTrasladosPage paginaTraslado = null;

    @Before
    public void init(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaTraslado = new VFTrasladosPage(driver);
        paginaTraslado.irPaquetesDesdeHome();
    }

    @Test
    public void Cdp06_BusquedaTraslado(){
        paginaTraslado.llenarCasillaOrigen("arturo", "Aeropuerto Arturo Merino Benitez");
        paginaTraslado.llenarCasillaDestino("sheraton","Sheraton Miramar");
        paginaTraslado.fechaArriedo(1);
        paginaTraslado.darClickBotonBuscar();


    }

}

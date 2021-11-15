package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFServicioPaquetesPages;

public class act03_paquetesBusquedaLimitePersonas extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFServicioPaquetesPages paginaPaquetes = null;


    @Test
    public void paquetesBusquedaLimitePersonas() {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFServicioPaquetesPages(driver);
        paginaPaquetes.agregarPersonasHabitacion();
        paginaPaquetes.agregarTresAdultos();
        paginaPaquetes.agregarTresMenores();
        paginaPaquetes.verificarLimitePersonas();
    }


}
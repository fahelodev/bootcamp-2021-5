package pom.equipo2.test;

import org.junit.Test;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFPaquetesPages;

public class act03_paquetesBusquedaLimitePersonas extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFPaquetesPages paginaPaquetes = null;


    @Test
    public void paquetesBusquedaLimitePersonas() {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPages(driver);
        paginaPaquetes.agregarPersonasHabitacion();
        paginaPaquetes.agregarTresAdultos();
        paginaPaquetes.agregarTresMenores();
        paginaPaquetes.verificarLimitePersonas();
    }


}

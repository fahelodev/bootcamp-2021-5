package pom.equipo5.test;

import org.junit.Test;
import pom.equipo5.base.TestBase;
import pom.equipo5.pages.VFAlojamientoPage;
import pom.equipo5.pages.VFHomePage;


public class Alojamientos01_tooltipsError extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFAlojamientoPage paginaAlojamiento = null;

    @Test
    public void tooltipsError(){
        paginaHome = new VFHomePage(driver);
        paginaAlojamiento = new VFAlojamientoPage(driver);
        paginaHome.irHomePage();
        paginaHome.irAlojamiento();
        paginaAlojamiento.realizarLaBusqueda();
        paginaAlojamiento.verificarPresenciaTooltipsFecha();
    }

}

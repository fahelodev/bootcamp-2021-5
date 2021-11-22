package pom.equipo3.test;


import org.junit.Test;
import pom.equipo3.base.TestBase;
import pom.equipo3.pages.VFAlojamientosPage;
import pom.equipo3.pages.VFHomePage;


public class AlojamientoTest extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFAlojamientosPage paginaAlojamiento = null;

    @Test
    public void act01() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientosPage(driver);
        paginaAlojamiento.irAlojamiento();
        paginaAlojamiento.cargarDestinoMiami();
        paginaAlojamiento.cargarFechas();
        paginaAlojamiento.botonBuscar();
        paginaAlojamiento.filtroOfertas();
        paginaAlojamiento.dormir(2000);
        paginaAlojamiento.filtro4estrellas();
        paginaAlojamiento.ValidacioOferta();


    }


    @Test
    public void act02() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientosPage(driver);
        paginaAlojamiento.irAlojamiento();
        paginaAlojamiento.cargarDestinoBSAS();
        paginaAlojamiento.cargarFechas();
        paginaAlojamiento.agregarMenores();
        paginaAlojamiento.botonBuscar();
        paginaAlojamiento.filtroOfertas();
        paginaAlojamiento.dormir(2000);
        paginaAlojamiento.filtro5estrellas();
        paginaAlojamiento.dormir(2000);
        paginaAlojamiento.filtroOrdenar();
        paginaAlojamiento.Hotel();
        paginaAlojamiento.ValidacionHotel();

    }


    @Test
    public void act03(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientosPage(driver);
        paginaAlojamiento.irAlojamiento();
        paginaAlojamiento.cargarDestinoPinchas();
        paginaAlojamiento.ValidacionExistencia();


    }

}

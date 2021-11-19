package pom.equipo4.test;

import org.junit.Test;
import pom.equipo4.base.TestBase;
import pom.equipo4.pages.VFAlojamientosPage;
import pom.equipo4.pages.VFHomePage;

public class atc03_Alojamientos extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFAlojamientosPage paginaAlojamiento = null;

    @Test
    public void busquedaAlojamientoSegunMejorPuntuacionYMostrarFAQ() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientosPage(driver);
        paginaAlojamiento.irAlojamientoDesdeHome();
        paginaAlojamiento.ingresarDestino("Londres");
        paginaAlojamiento.selectSinFecha();
        paginaAlojamiento.confirmarBusqueda();
        paginaAlojamiento.filtrarMejorPuntuacion();
        paginaAlojamiento.filtrarMonedaDolarPorLista();
        paginaAlojamiento.selectAlojamiento("London Hilton on Park Lane");
        paginaAlojamiento.mostrarFAQ();
        paginaAlojamiento.checkTituloText("London Hilton on Park Lane");
    }


    @Test
    public void busquedaAlojamientoSegunPrecioMenorAMayorYWifiGratisEnZonasComunes() throws InterruptedException{

        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientosPage(driver);
        paginaAlojamiento.irAlojamientoDesdeHome();
        paginaAlojamiento.ingresarDestino("El Cairo");
        paginaAlojamiento.diminuirUnAdultoEnHabitacion();
        paginaAlojamiento.selectSinFecha();
        paginaAlojamiento.confirmarBusqueda();
        paginaAlojamiento.filtrarZonaWifiGratisEnZonasComunes();
        paginaAlojamiento.filtrarPrecioMayorAMenor();
        paginaAlojamiento.selectAlojamientoHotel("Ramses Hilton");
        paginaAlojamiento.irSeccionComentariosEnSolitario();
        paginaAlojamiento.checkTituloText("Ramses Hilton");
        paginaAlojamiento.checkComentarioSolitario("Viajó solo/a");


    }

    @Test
    public void busquedaAlojamientoConPrecioMaximo5000usYElegirAeropuertoDestino() throws InterruptedException{

        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaAlojamiento = new VFAlojamientosPage(driver);
        paginaAlojamiento.irAlojamientoDesdeHome();
        paginaAlojamiento.ingresarDestino("montego bay");
        paginaAlojamiento.ingresoDeFechaEntradaYSalida("1", "8");
        paginaAlojamiento.agregarTresMenoresDeCuatroAnios();
        paginaAlojamiento.confirmarBusqueda();
        paginaAlojamiento.filtroPrecioADolar();
        paginaAlojamiento.filtrarPrecioMaximo5000US();
        paginaAlojamiento.goAlojamiento("Iberostar Rose Hall Beach");
        paginaAlojamiento.reservarAlojamiento();
        paginaAlojamiento.cambioAeropuerto("OCJ, Aeropuerto Boscobel");
        paginaAlojamiento.chkErrorMsjIngreseUnaHora("Ingresa una hora");

    }

}


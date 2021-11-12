package pom.equipo2.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pom.equipo2.base.TestBase;
import pom.equipo2.pages.VFHomePage;
import pom.equipo2.pages.VFPaquetesPages;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

        List<WebElement> options_list = driver.findElements(By.cssSelector("div._pnlpk-tooltip"));
        String resultado = "";
        for (WebElement l : options_list) {

            resultado += l.getText();

        }

        assertEquals("Solo puedes hacer búsquedas de hasta 8 personas", resultado);
    }


}

package pom.equipo3.test;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo3.base.TestBase;
import pom.equipo3.pages.VFHomePage;
import pom.equipo3.pages.VFPaquetesPage;

public class act02_PaquetesMasDe8Personas extends TestBase {
    protected VFHomePage paginaHome = null;
    protected VFPaquetesPage paginaPaquetes = null;

    @Test
    public void paqueteTuristicoVueloauto() throws InterruptedException {
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFPaquetesPage(driver);
        paginaPaquetes.irPaquetesDesdeHome();
        paginaPaquetes.irVuelosAutos();
        paginaPaquetes.ingresarOrigenDestino();
        paginaPaquetes.dormir(2000);
        paginaPaquetes.ingresarFechas();
        paginaPaquetes.dormir(2000);
        paginaPaquetes.agregar8Pasajeros();


        String alerta = driver.findElement(By.xpath("//div[@class='_pnlpk-itemBlock__itemRows _pnlpk-dynamicContent']//div//div[1]//div[2]//div//div//div//span[contains(text(),'Solo puedes hacer búsquedas de hasta 8 personas')]")).getText();
        //validar mensaje de alerja al ingresar mas de 8 personas
        String esperado = "Solo puedes hacer búsquedas de hasta 8 personas";
        Assert.assertEquals(esperado,alerta);

    }


}
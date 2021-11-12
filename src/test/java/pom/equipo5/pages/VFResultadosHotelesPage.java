package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo5.base.SeleniumBase;

public class VFResultadosHotelesPage  extends SeleniumBase {
    public VFResultadosHotelesPage (WebDriver driver) {
        super(driver);
    }

    private String precioHotelSeleccionado;

    By hotelesResultados = By.className("results-cluster-container");
    By btnVerDetallesHotel = By.xpath("//*[text()='Ver detalle']");
    By precioHotel = By.xpath("//div[@class='results-cluster-container']//span[contains(@class,'main-value')]");

    public void seleccionarPrimerHotel(){
        encontrarElemento(hotelesResultados);
        esperarPresenciaElemento(precioHotel, 10);
        precioHotelSeleccionado = obtenerTexto(precioHotel);
        clickear(btnVerDetallesHotel);
        cambiarVentana();
    }

    public int getPrecioHotelSeleccionado() {
        return Integer.parseInt(precioHotelSeleccionado.replace(".",""));
    }
}

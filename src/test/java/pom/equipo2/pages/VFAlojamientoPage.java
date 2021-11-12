package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo2.base.SeleniumBase;

public class VFAlojamientoPage extends SeleniumBase {
    public VFAlojamientoPage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnAlojamiento = By.xpath("//label[contains(text(),'Alojamientos')]");
    By desplegableHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnMasHabitaciones = By.cssSelector("div._pnlpk-itemRow__item._pnlpk-stepper-minors.-medium-down-to-lg  a.steppers-icon-right.sbox-3-icon-plus");
    By btnAplicar = By.xpath("//a[contains(text(),'Aplicar')]");
    By campoDestino = By.xpath("//input[contains(@class,'sbox-main')]");
    By campoFechaEntrada = By.xpath("//input[contains(@class,'checkin')]");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");
    By listaElementos = By.cssSelector("div.ac-container ul>li");
    By listaFechasMes= By.xpath("//span[@class='_dpmg2--date-number']");
    By etiqueteCentro= By.xpath("//span[contains(text(),'Centro') and not(contains(text(),'de'))]/ancestor::em");
    By listaMoneda = By.cssSelector("Select.select-tag");
    By campoMinimo = By.xpath("//input[@class='input-tag' and @placeholder=@min]");
    By campoMaximo = By.xpath("//input[@class='input-tag' and @placeholder=@max]");
    By btnAplicarMoneda = By.xpath("//em[contains(text(),'Aplicar')]");

    public void irAlojamientoDesdeHome(){
        clickear(btnAlojamiento);
        esperaExplicitaElementoClickeable(desplegableHabitaciones,7);
    }
    public void agregarMenorHabitacion(){

        clickear(btnHabitaciones);
        clickear(btnMasHabitaciones);
    }
    public void confirmarSeleccionHabitacionMenor(){

        clickear(btnAplicar);
    }
    public void cargarDestino(){
        ingresarTexto(campoDestino,"Cordoba");
        seleccionarTextoLista(listaElementos,"Córdoba, Córdoba, Argentina");
      }
    public void cargarFechas(){
        clickear(campoFechaEntrada);
        seleccionarFecha(listaFechasMes, "22");
        seleccionarFecha(listaFechasMes, "26");
    }
    public void confirmarBusqueda(){
        clickear(btnBuscar);
    }
    public void confirmarCentro(){
        clickear(etiqueteCentro);
    }
    public void confirmarMoneda (){
        seleccionarMoneda(listaMoneda);
        esperaExplicitaPrecenciaElementos(campoMinimo,7);
        ingresarValorMinimo(campoMinimo,"110");
        ingresarValorMaximo(campoMaximo,"400");
        clickear(btnAplicarMoneda);

    }
}

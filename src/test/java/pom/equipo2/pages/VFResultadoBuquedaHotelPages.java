package pom.equipo2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.equipo2.base.SeleniumBase;


import static org.junit.Assert.assertTrue;

public class VFResultadoBuquedaHotelPages extends SeleniumBase {


    public VFResultadoBuquedaHotelPages(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar

    By textoPrecioEstandarHabitacion = By.xpath("//span[@class='main-value']");
    By btnSeleccionar = By.xpath("//p[contains(text(),'Seleccionar')]");
    By listaPreciosHabitaciones = By.xpath("//p[@class='price']");
    By precioHabitacionActualizado = By.xpath("//span[@class='main-value']");
    double valorHabitacionSuiteJunior;
    double valorHabitacionSuperior;
    double valorHabitacionSuiteParaDosPersonas;
    String precio[];

    public void confirmarHabitacionSuperior() {
        valorHabitacionSuiteJunior = Double.parseDouble(obtenerTexto(textoPrecioEstandarHabitacion));

        precio = obtenerTexto(listaPreciosHabitaciones).split(" ");
        valorHabitacionSuiteParaDosPersonas = Double.parseDouble(precio[1]);

        clickear(btnSeleccionar);
    }

    public void verificarDiferenciaPrecioHabitacion() {
        valorHabitacionSuperior = Double.parseDouble(obtenerTexto(precioHabitacionActualizado));

        double resultado = (valorHabitacionSuiteParaDosPersonas / 2) + valorHabitacionSuiteJunior;
        double resultadoFinal = Math.round(resultado * 1000.0) / 1000.0;


        assertTrue(valorHabitacionSuperior == resultadoFinal);

    }


}
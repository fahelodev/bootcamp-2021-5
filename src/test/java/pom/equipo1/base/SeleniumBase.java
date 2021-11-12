package pom.equipo1.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumBase {

    //Atributos
    WebDriver driver;
    private int segundosEspera = 10;

    //Constructor para traernos driver
    public SeleniumBase(WebDriver driver){
        this.driver = driver;
    }

    //Metodos Wrapper - Envoltorio
    public WebElement encontrarElemento(By localizador){
        return driver.findElement(localizador);
    }

    public void irUrl(String URL){
        driver.get(URL);
    }

    public void darClick(By localizador){
        // esperaExplicitaElementoClickeable(localizador);
        encontrarElemento(localizador).click();
    }

    public void esperaImplicita(){
        driver.manage().timeouts().implicitlyWait(segundosEspera, TimeUnit.SECONDS);
    }

    public void esperaExplicitaElementoClickeable(By localizador){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,segundosEspera);
        espera.until(ExpectedConditions.elementToBeClickable(localizador));
    }
    public void esperaExplicitaElementoVisible(By localizador){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,segundosEspera);
        espera.until(ExpectedConditions.visibilityOfElementLocated(localizador));
    }

    public String obtenerTexto(By localizador){
        return encontrarElemento(localizador).getText();
    }

    public List<WebElement> generarLista(By localizador){
        List<WebElement> lista = driver.findElements(localizador);
        return lista;
    }

    public void busquedaElemento (List<WebElement> lista,String palabra){
        for (WebElement l: lista){
            // RECORREMOS LA LISTA HASTA ENCONTRAR LA PALABRA REQUERIDA
            if (l.getText().contains(palabra)){
                // HACEMOS CLICK EN LA CATEGORIA SELECCIONADA
                l.click();
                break;
            }
        }
    }

    public void ingresarDestino (String textoIngresado, String seleccionar, By localizador, By espera){
        esperaExplicitaElementoVisible(localizador);
        driver.findElement(localizador).sendKeys(textoIngresado);
        esperaExplicitaElementoVisible(espera);
        List<WebElement> resultados = generarLista(espera);
        busquedaElemento(resultados,seleccionar);
    }

    public void calendario (int fecha1, int fecha2){
        // LISTA CALENTARIO ACTUAL
        esperaExplicitaElementoVisible(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        List<WebElement> mesActual = driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
        // INGRESAR FECHAS
        // TOMAMOS EL DIA ACTUAL
        Calendar c1 = Calendar.getInstance();
        String dia = Integer.toString(c1.get(Calendar.DATE));
        int diaActual = Integer.parseInt(dia);
        // ULTIMO DIA DEL CALENDARIO ACTUAL
        String diaMax = mesActual.get(mesActual.size()-1).getText();
        int diaUltimo = Integer.parseInt(diaMax);
        // LA FECHA ACTUAL + 1 DIA PASA AL SIGUIENTE MES?
        if (diaActual+fecha2 < diaUltimo){
            buscarCalendario(diaActual+fecha1,mesActual);
            buscarCalendario(diaActual+fecha2,mesActual);
        }
        else{
            if (diaActual+fecha1 < diaUltimo){
                buscarCalendario(diaActual+fecha1,mesActual);
                driver.findElement(By.xpath("//i[@class='_dpmg2--icon-ico-arrow']//ancestor::div[@class='datepicker-packages-car sbox-v4-components']")).click();
                mesActual= driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
                buscarCalendario(diaActual+fecha2-diaUltimo,mesActual);
            }
            else {
                driver.findElement(By.xpath("//i[@class='_dpmg2--icon-ico-arrow']//ancestor::div[@class='datepicker-packages-car sbox-v4-components']")).click();
                mesActual= driver.findElements(By.cssSelector("._dpmg2--show ._dpmg2--month-active ._dpmg2--available span._dpmg2--date-number"));
                buscarCalendario(diaActual+fecha1-diaUltimo,mesActual);
                buscarCalendario(diaActual+fecha2-diaUltimo,mesActual);
            }
        }
    }

    private void buscarCalendario(int diaBuscado, List<WebElement> mes){
        String dia = Integer.toString(diaBuscado);
        busquedaElemento(mes,dia);
    }

    public void cantidadPasajeros (int esperado, By localizador){
        String num =driver.findElement(localizador).getAttribute("value");
        int valorActual = Integer.parseInt(num);
        adultos(valorActual,esperado);
    }

    private void adultos (int real, int esperado){
        while (esperado != real){
            if (real > esperado){
                driver.findElement(By.cssSelector("div.distpicker.distpicker-rooms-packages.sbox-v4-components a.steppers-icon-left.sbox-3-icon-minus")).click();
                real--;
            }
            else{
                driver.findElement(By.cssSelector("div.distpicker.distpicker-rooms-packages.sbox-v4-components a.steppers-icon-right.sbox-3-icon-plus")).click();
                real++;
            }
        }
    }

    public int contarElementos (By localizador){
        esperaExplicitaElementoVisible(localizador);
        int lista = driver.findElements(localizador).size();
        return lista;
    }
}

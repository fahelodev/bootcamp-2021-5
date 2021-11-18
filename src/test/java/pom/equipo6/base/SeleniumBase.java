package pom.equipo6.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBase {
    //Atributos
    WebDriver driver;

    //Constructor para traernos el driver
    public SeleniumBase(WebDriver driver){
        this.driver=driver;
    }
    //Metodo Wrapper - Envoltorio
    public WebElement findItem(By locator){
        return driver.findElement(locator);
    }


    public void goUrl(String URL){
        driver.get(URL);
    }

    public void click(By locator){
        findItem(locator).click();
    }

    public void clear(By locator){
        findItem(locator).clear();
    }

    public void waitExplicitClick(By locator, int time){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,time);
        espera.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitExplicitWindows(By locator, int time){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,time);
        espera.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public void fieldsTextDestino(By locator){
        findItem(locator).sendKeys("Cordoba");
    }

    public void fieldSecondTextDestino(By locator){
        findItem(locator).sendKeys("Buenos Aires");
    }

    public void fieldTextPaquetesOrigen(By locator){findItem(locator).sendKeys("Buenos");}

    public void fieldTextPaquetesDestino(By locator){findItem(locator).sendKeys("Esp");}

    public void switchVentana(By locator,int number){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,number);
        espera.until(ExpectedConditions.numberOfWindowsToBe(2));
        String originalWindow = driver.getWindowHandle();

        //Si aparece una nueva ventana, debe trabajar en la nueva ventana
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.close();
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void verifyTextAlojamiento002(By locator){
        WebElement check = findItem(locator);
        Assert.assertEquals("Alojamientos y Hoteles en Buenos Aires - Argentina", check.getText());
    }

    public void verifyTextAlojamiento003(By locator){
        WebElement check = findItem(locator);
        Assert.assertEquals("Traslado Privado Ida Y Vuelta", check.getText());
    }

    public void verifyTextPaquetes001(By locator){
        WebElement check = findItem(locator);
        Assert.assertEquals("Paquetes a Barcelona",check.getText());
    }
    public void verifyTextPaquete002(By locator){
        WebElement check = findItem(locator);
        Assert.assertEquals("Otros alojamientos", check.getText());
    }
    public void verifyTextPaquete003(By locator){
        WebElement check = findItem(locator);
        Assert.assertEquals("El destino debe ser diferente del origen.", check.getText());
    }
    public void loadEmergent(By locator) throws InterruptedException {
        findItem(locator);
        Thread.sleep(30);}


    public WebElement waitExplicitVisibility(By locator, int time){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,time);
        return espera.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitExplicitInvisibility(WebElement locator, int time){
        WebDriverWait espera;
        espera = new WebDriverWait(driver,time);
        espera.until(ExpectedConditions.invisibilityOf(locator));
    }

}


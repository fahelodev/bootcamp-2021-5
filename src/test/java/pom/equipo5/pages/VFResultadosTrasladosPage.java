package pom.equipo5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo5.base.SeleniumBase;

public class VFResultadosTrasladosPage extends SeleniumBase {
    public VFResultadosTrasladosPage(WebDriver driver) {
        super(driver);
    }

    //Datos ingresados
    private String destinoModificado = "Hotel Marriott Santiago";

    //atributos - objeto a guardar
    By btnBuscar = By.cssSelector("a.sbox-search");
    By btnModificar = By.xpath("//em[contains(text(),'Modificar')]");
    By inputDestino = By.xpath("//label[contains(text(),'Hasta')]/following-sibling::input");
    By primeraSugerencia = By.xpath("//div[contains(@class,'ac-wrapper') and contains(@class,'-show')]//li");
    By btnOpcionsTrasladosPrivados = By.xpath("//span[contains(text(),'Traslados privados')]");
    By resultados = By.xpath("//div[@class='search-cluster ng-scope']//h1/strong");
    By btnMapa = By.xpath("//a[contains(text(),'Ver mapa')]");
    By marcadores = By.cssSelector("div.marker-container");
    By descripcionDeMarcador = By.cssSelector(".gm-style-iw .bold");
    By descripcionMapa = By.xpath("//div/span[contains(text(),'"+ destinoModificado + "')]");
    By btnComprar = By.xpath("//div[contains(@class, 'search-cluster') and not(contains(@class, 'ng-hide'))]//button");

    //Acciones
    public void realizarLaBusqueda(){
        clickear(btnBuscar);
    }

    public void modificarFormulario(){
        clickear(btnModificar);
        limpiarInput(inputDestino);
        escribirEnInput(inputDestino, destinoModificado);
        clickear(primeraSugerencia);
    }

    public void seleccionarPrimerTraslado(){
        clickear(btnComprar);
    }

    public void filtrarPorPrivados(){
        clickear(btnOpcionsTrasladosPrivados);
    }

    public void abrirMapa(){
        esperarPresenciaElemento(descripcionMapa, 15);
        clickear(btnMapa);
        esperarPresenciaElemento(marcadores, 15);
    }

    public String obtenerDescripcionDeMarcadores(){
        String descripcionDeMarcadores = "";
        for(WebElement marcador: encontrarElementos(marcadores)){
            clickear(marcador);
            WebElement descripcion = esperarElementoClickeable(descripcionDeMarcador, 15);
            descripcionDeMarcadores += obtenerTexto(descripcion) + " ";
        }
        return descripcionDeMarcadores.trim();
    }

    public boolean confirmarTipoDeResultados(String tipo){
        for(WebElement item : encontrarElementos((resultados))){
            if(!item.getText().contains(tipo)){
                return false;
            }
        }
        return true;
    }

    public String getDestinoModificado() {
        return destinoModificado;
    }
}

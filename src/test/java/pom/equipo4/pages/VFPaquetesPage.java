package pom.equipo4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VFPaquetesPage extends SeleniumBase {
    public VFPaquetesPage(WebDriver driver) { super(driver); }

    By btnPaquetes = By.xpath("//a[@title='Paquetes']");
    By divDatosViaje = By.xpath("//div[@class='sbox-show-hide-container -sbox-3-shadow-static']");
    By listaNombresHotelesPrimero = By.xpath("//li[@class='item -active']");
    By btnBusquedaViaje = By.xpath("//div[@class='sbox-button-container']");
    By switchSinFechaViaje = By.xpath("//span[@class='switch-container']");
    By divResultadosHotelesUsarPrimero = By.xpath("//div[@class='offer-container offer-container-0' and @index='0'][1]");
    By getDivResultadosHotelesUsarPrimeroSegundaVez = By.xpath("//div[@class='eva-3-cluster-gallery -eva-3-bc-white -eva-3-shadow-line-hover'][1]");
    By divServiciosHotel = By.xpath("//div[@class='view-more eva-3-link -eva-3-mt-xxlg' and text()=' Ver todos los servicios ']");
    By cerrarDivServiciosHotel = By.xpath("//div[@class='eva-3-modal -show-modal']//i[@class='modal-close eva-3-icon-close']");
    By BajarAComentarios = By.xpath("//a[@class='scroll-to-reviews eva-3-link']");
    By comentariosSeccionEnPareja = By.xpath("//div[@class='sub-nav-container']//li[@class='sub-nav-item -icon ']//label[text()=' En pareja ']");
    By divComentario = By.xpath("//div[@class='eva-3-comment']");
    By verMasComentarios = By.xpath("//span[@class='view-more-btn-text' and text()='Ver mas comentarios']");
    By volverArriba = By.xpath("//span[@class='go-up' and text()=' Ir Arriba ']");
    By divFiltro5estrellas = By.xpath("//div[@class='filters-summary']//span[@class='filter-tags-wrapper stars']");
    By listaOpcion5estrellas = By.xpath("//div[@class='filters-tooltip eva-3-card -eva-3-shadow-line']//div[@class='filter-criteria-container']/div[4]");
    By cerrarFiltro5estrellas = By.xpath("//div[@class='filters-tooltip eva-3-card -eva-3-shadow-line']//div[@class='filters-actions']/a[2]");
    By btnProcederCompraHotel = By.xpath("//button[@class='eva-3-btn -md -primary -eva-3-fwidth'][1]");
    By btnElegirVuelo = By.xpath("//a[@class='-md eva-3-btn -primary']");
    By divElegirActividad = By.xpath("//div[@class='highlight-card']//span[@class='-eva-3-bold driver-text' and text()=' Actividad destacada ']/ancestor::div[@class='highlight-card']");
    By verMasInforActividad = By.xpath("//div[@class='toggle -eva-3-tc-purple-3 -eva-3-bold -eva-3-mt-xlg']//span");
    By btnagregarActividad = By.xpath("//div[@class='detail-actions']/a");
    By btnEntrarFormularioCompra = By.xpath("//button[@class='eva-3-btn -lg pricebox-sticky-button -secondary']");


    //Funciones que se usan en todos los tests de paquetes

    public void irPaquetesDesdeHome(){
        clickear(btnPaquetes);
        esperaExplicitaElementoClickeable(divDatosViaje,7);
    }

    public void ingresarOrigenDestinoVuelo(String origin_or_destination, String ciudad){
        By inputOrigenYDestino = By.xpath("//input[contains(@class,'input-tag sbox-main-focus sbox-"+origin_or_destination.toLowerCase()+"')]");
        ingresarTexto(inputOrigenYDestino,ciudad);
        clickear(listaNombresHotelesPrimero);
        Assert.assertEquals(obtenerTexto(listaNombresHotelesPrimero),obtenerTexto(inputOrigenYDestino));
    }

    public void aplicarBusqueda(Boolean sinFechaViaje)
    {
        if (sinFechaViaje)
        {
            clickear(switchSinFechaViaje);
        }
        clickear(btnBusquedaViaje);
    }

    public void seleccionarPrimerHotelResultadosBusqueda(Boolean repetirClick) throws InterruptedException {
        esperaExplicitaElementoClickeable(divResultadosHotelesUsarPrimero,10);
        clickear(divResultadosHotelesUsarPrimero);
        selectPestana(1);
        if (repetirClick)
        {
            esperaExplicitaPrescenciaElemento(getDivResultadosHotelesUsarPrimeroSegundaVez,30);
            clickear(getDivResultadosHotelesUsarPrimeroSegundaVez);
            dormir(2000);
            selectPestana(2);
        }
    }

    //Funciones usadas en el segundo test

    public void verServiciosYComentarios()
    {
        clickear(divServiciosHotel);
        Assert.assertTrue(encontrarElemento(cerrarDivServiciosHotel).isDisplayed());
        esperaExplicitaElementoClickeable(cerrarDivServiciosHotel,10);
        clickear(cerrarDivServiciosHotel);
//        JavascriptExecutor executor = (JavascriptExecutor) super(driver);
//        Long originalScrollValue = (Long) executor.executeScript("return window.pageYOffset;");
        clickear(BajarAComentarios);
//        dormir(1000);
//        Long newScrollValue = (Long) executor.executeScript("return window.pageYOffset;");
//        Assert.assertNotEquals(originalScrollValue,newScrollValue);
        esperaExplicitaElementoClickeable(comentariosSeccionEnPareja,10);
        clickear(comentariosSeccionEnPareja);
        Assert.assertEquals("en pareja",obtenerTexto(By.xpath("//label[text()=' En pareja ']")).toLowerCase());
        esperaExplicitaElementoClickeable(verMasComentarios,10);
//        int commentsDefault = driver.findElements(divComentario).size();
        clickear(verMasComentarios);
//        dormir(1000);
//        int commentsCargados = driver.findElements(divComentario).size();
//        Assert.assertTrue(commentsCargados>commentsDefault);
        esperaExplicitaElementoClickeable(volverArriba,10);
        clickear(volverArriba);
//        originalScrollValue = (Long) executor.executeScript("return window.pageYOffset;");
//        Assert.assertNotEquals(newScrollValue,originalScrollValue);
    }

    //Funciones usadas en el tercer test


    public void seleccionarFiltro5Estrellas() throws InterruptedException {
        clickear(divFiltro5estrellas);
        clickear(listaOpcion5estrellas);
        clickear(cerrarFiltro5estrellas);
        dormir(3000);
        Assert.assertEquals("5 estrellas",obtenerTexto(By.xpath("//p[@class='eva-3-p filter-text']")));
    }

    public void procederCompra() {
        clickear(btnProcederCompraHotel);
        esperaExplicitaElementoClickeable(btnElegirVuelo,10);
        clickear(btnElegirVuelo);
    }

    public void agregarActividadYEntrarCompraViaje()
    {
        esperaExplicitaPrescenciaElemento(divElegirActividad,10);
        clickear(divElegirActividad);
        esperaExplicitaPrescenciaElemento(verMasInforActividad, 10);
        clickear(verMasInforActividad);
        clickear(btnagregarActividad);
        clickear(btnEntrarFormularioCompra);
    }

}

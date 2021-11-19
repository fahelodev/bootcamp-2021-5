package pom.equipo4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import pom.equipo4.base.SeleniumBase;

public class VFAlojamientosPage extends SeleniumBase {

    public VFAlojamientosPage(WebDriver driver) {
        super(driver);
    }

    //atributos - objeto a guardar
    By btnAlojamiento = By.xpath("//label[contains(text(),'Alojamientos')]");
    By cajaBusquedaDestino = By.cssSelector("div.input-container .sbox-destination");
    By listaDestinoDesplegable = By.cssSelector("li.item");
    By chkNoHeDecididoFecha = By.xpath("//label[@class='checkbox-label']");
    By btnBuscar = By.xpath("//em[contains(text(),'Buscar')]");
    By cbOrdenarPor = By.id("sorting");
    By cbCambioMoneda = By.id("currency");
    By chkList = By.xpath("//label[starts-with(@class,'checkbox-label')]");
    By FAQList = By.cssSelector(".-detail-section-padding .dropdown-item");
    By tituloAlojamientoSelect = By.xpath("//span[@class='accommodation-name eva-3-h2']");
    By seccionHabitaciones = By.cssSelector("div.sbox-distri-container");
    By btnRestar = By.cssSelector("a.steppers-icon-left ");
    By btnAplicar = By.cssSelector("a._pnlpk-apply-button");
    By chkfiltros = By.xpath("//label[starts-with(@class,'checkbox-label')]");
    By chkFiltroWifiZonasComunes = By.xpath("//span[contains(text(),'Wi-Fi gratis en zonas comunes')]");
    By filtroWifiZonasComunes = By.xpath("//em[contains(text(),'Wi-Fi gratis en zonas comunes')]");
    By resultHotels = By.id("hotels");
    By textComentario = By.cssSelector("a.scroll-to-reviews");
    By seccSolitario = By.xpath("//label[contains(text(),'En solitario')]");
    By comentarioSolitario = By.xpath("//span[contains(text(),'Viajó solo/a ')]");
    By sboxEntrada = By.cssSelector("div.input-container .sbox-checkin-date");
    By calendar = By.cssSelector("div._dpmg2--months ._dpmg2--available ._dpmg2--date-number");
    By btnAplicarCalendar = By.xpath("//em[contains(text(),'Aplicar')]");
    By btnAddMenor = By.xpath("//div[@class='_pnlpk-itemRow__item _pnlpk-stepper-minors -medium-down-to-lg'] //a[@class='steppers-icon-right sbox-3-icon-plus']");
    By seccionEdad = By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']//select[@class='select-tag']");
    By edadCuatro = By.xpath("//select[@class='select-tag'] //option[@value='4']");
    By cbCambioDeMonedaFiltroIzquierdo = By.xpath("//div[@class='currency-selection'] //select[@class='select-tag']");
    By sboxPrecio = By.xpath("//input[@class='input-tag' and @type='number']");
    By btnAplicarFiltroPrecio = By.xpath("//button[@class='eva-3-btn -md -primary']//following::em[1]");
    By ventanaEmergente = By.xpath("//div[contains(@class,'tooltip-container -eva-3-shadow-1')]");
    By closeVentanaEmergente = By.xpath("//i[contains(@class,'tooltip-close eva-3-icon-close')]");
    By seccionAlojamiento = By.xpath("//div[contains(@class,'results-cluster-container')]");
    By btnReservarAhora = By.xpath("//button[@class='eva-3-btn -md -secondary -eva-3-fwidth']//following::em[1]");
    By sboxAeropuestoLlegada = By.id("select-test");
    By textIngresoHora = By.xpath("//span[text()='Ingresa una hora']");
    //By btnAplicar = By.xpath("//a[contains(text(),'Aplicar')]");

    public void irAlojamientoDesdeHome(){
        clickear(btnAlojamiento);
    }

    public void ingresarDestino(String destino){
        ingresarTexto(cajaBusquedaDestino,destino);
        esperaExplicitaElementoClickeable(listaDestinoDesplegable,10);
        ingresarKeyEnter(cajaBusquedaDestino);
    }

    public void selectSinFecha(){
        clickear(chkNoHeDecididoFecha);
    }

    public void confirmarBusqueda(){
        clickear(btnBuscar);
    }

    public void filtrarMejorPuntuacion(){
        selectMejorPuntuacion(cbOrdenarPor);
    }

    public void filtrarMonedaDolarPorLista(){
        selectMonedaDolar(cbCambioMoneda);
    }


    public void selectAlojamiento(String alojamiento) throws InterruptedException {
        esperaExplicitaPrescenciaElemento(chkList,10);
        busquedaAlojamiento(alojamiento);
    }

    public void mostrarFAQ(){
        recorrerLista(FAQList);
    }

    public void checkTituloText(String titulo){
        assertComparaString(titulo, tituloAlojamientoSelect);
    }


    public void selectMejorPuntuacion(By localizador){
        Select s = new Select(encontrarElemento(localizador));
        s.selectByVisibleText("Mejor puntuación");
    }

    public void selectMonedaDolar(By localizador){
        Select s = new Select(encontrarElemento(localizador));
        s.selectByVisibleText("Dólar");
    }


    public void busquedaAlojamiento(String alojamiento) throws InterruptedException {
        Thread.sleep(1500);
        encontrarElemento(By.xpath("//a[contains(text(),'" + alojamiento + "')]")).click();
        Thread.sleep(1500);
        selectPestana(1);
    }

    public void diminuirUnAdultoEnHabitacion() {
        clickear(seccionHabitaciones);
        clickear(btnRestar);
        clickear(btnAplicar);
    }


    public void filtrarZonaWifiGratisEnZonasComunes() {

        esperaExplicitaPrescenciaElemento(chkfiltros, 10);
        clickear(filtroWifiZonasComunes);
        esperaExplicitaPrescenciaElemento(chkFiltroWifiZonasComunes, 10);
    }


    public void filtrarPrecioMayorAMenor() {

        selectprecioMayorAMenor(cbOrdenarPor);
    }

    public void selectprecioMayorAMenor(By localizador) {
        Select s = new Select(encontrarElemento(localizador));
        s.selectByVisibleText("Precio: mayor a menor");
    }

    public void selectAlojamientoHotel(String alojamiento) throws InterruptedException {
        esperaExplicitaPrescenciaElemento(resultHotels, 10);
        busquedaAlojamiento(alojamiento);
    }


    public void irSeccionComentariosEnSolitario(){
        clickear(textComentario);
        clickear(seccSolitario);
    }


    public void checkComentarioSolitario(String comentario){assertComparaString(comentario, comentarioSolitario);
    }

    public void ingresoDeFechaEntradaYSalida (String fechaEntrada,String fechaSalida){
        clickear(sboxEntrada);
        busquedaFecha(calendar, btnAplicarCalendar, fechaEntrada, fechaSalida );
    }



    public void agregarTresMenoresDeCuatroAnios(){

        clickear(seccionHabitaciones);
        tresMenoresDeEdad4(btnAddMenor, seccionEdad, edadCuatro, btnAplicar );

    }

    public void filtroPrecioADolar(){

        esperaExplicitaPrescenciaElemento(chkfiltros, 10);
        selectMonedaDolar(cbCambioDeMonedaFiltroIzquierdo);
        esperaExplicitaPrescenciaElemento(chkfiltros, 10);
    }



    private void busquedaAlojamientoGlobal(String alojamiento) throws InterruptedException {
        Thread.sleep(1500);
        encontrarElemento(By.xpath("//*[contains(text(),'" + alojamiento + "')]")).click();
        Thread.sleep(1500);
        selectPestana(1);
    }



    public void filtrarPrecioMaximo5000US(){

        precioMaximoDolar(sboxPrecio, "5000");
        clickear(btnAplicarFiltroPrecio);
    }


      public void cerrarVentanaEmergente(){
          esperaExplicitaPrescenciaElemento(chkfiltros, 10);

         if(encontrarElemento(ventanaEmergente)!= null) {
           clickear(closeVentanaEmergente);
        }
    }

    public void goAlojamiento(String alojamiento) throws InterruptedException{
        cerrarVentanaEmergente();
        esperaExplicitaPrescenciaElemento(seccionAlojamiento, 10);
        busquedaAlojamientoGlobal(alojamiento);

    }

    public void reservarAlojamiento(){
     clickear(btnReservarAhora);
    }

    public void cambioAeropuerto(String Aeropuerto){
        Select s = new Select(encontrarElemento(sboxAeropuestoLlegada)) ;
        s.selectByVisibleText(Aeropuerto);
        clickear(btnBuscar);
    }

    public void chkErrorMsjIngreseUnaHora(String MsjErrorHora){
      assertComparaString(MsjErrorHora, textIngresoHora);

   }
}



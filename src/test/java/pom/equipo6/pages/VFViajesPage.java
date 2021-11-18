package pom.equipo6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.equipo6.base.SeleniumBase;

public class VFViajesPage extends SeleniumBase {

    public VFViajesPage(WebDriver driver) {
        super(driver);
    }

    //Atributos - objeto a guardar
    By buttonFlies = By.cssSelector("a[title='Vuelos']");
    By textOriginCity = By.xpath("//input[@placeholder='Ingresa desde dónde viajas']");
    By optionOriginCityBsAs = By.xpath("//span[.='Buenos Aires, Ciudad de Buenos Aires, Argentina']");
    By textDestinationsCity = By.xpath("//input[contains(@placeholder,'Ingresa hacia dónde viajas')]");
    By optionDestinationsCityCordoba = By.xpath("//span[.='Córdoba, Córdoba, Argentina']");
    By checkNoDate = By.xpath("//label[.='Todavía no he decidido la fecha']");
    By searchButton = By.xpath("//em[.='Buscar']");

    //Atributos a guardar segundo caso

    By radioButtonOneWayFly = By.xpath("//span[contains(text(),'Solo ida')]");
    By optionOriginCityCordoba = By.xpath("//span[.='Córdoba, Córdoba, Argentina']");
    By textFieldDepartureDate = By.cssSelector("[placeholder='Ida']");
    By optionDestinationsCityParis = By.xpath("//span[.='París, Ile de France, Francia']");
    By calendarDay = By.xpath("//div[@class='_dpmg2--dates']/span[.='22']");
    By buttonApplyDates = By.xpath("//em[contains(text(),'Aplicar')]");
    By buttonPassengers = By.cssSelector(".sbox-flights-double-distribution-picker");
    By addMinor = By.cssSelector("._pnlpk-panel--show ._pnlpk-stepper-minors .steppers-icon-right");
    By buttonMinorAge = By.cssSelector("._pnlpk-panel--show ._pnlpk-minor-age-select-last-item .select-tag");
    By ageMinor = By.xpath("//div[@class='_pnlpk-minors-age-select-wrapper']/div[@class='_pnlpk-itemRow _pnlpk-minor-age-select _pnlpk-minor-age-select-last-item']//option[.='5 años']");
    By buttonClassFly = By.xpath("//div[@class='_pnlpk-itemRow_item _pnlpk-select-flight-class-type -medium-down-to-lg']//select[@class='select-tag']");
    By optionPremiumEconomyClassFly = By.xpath("//option[.='Premium economy']");
    By buttonApplyClassPassengers = By.cssSelector("._pnlpk-panel--show ._pnlpk-apply-button");

    //Atributos a guardar tercer caso

    By optionDestinationsCityLondres = By.xpath("//span[.='Londres, Inglaterra, Reino Unido']");
    By calendarDayBack = By.xpath("//div[@class='_dpmg2--month _dpmg2--o-1 _dpmg2--has-start-range _dpmg2--month-active']//span[.='26DíaDías']");
    By optionBusinessEconomyClassFly = By.xpath("//option[.='Ejecutiva/Business']");
    By checkScaleFilter = By.xpath("//checkbox-filter[@class='stops']//span[@class='eva-3-checkbox']//span[.='1 Escala']");
    By checkBaggageFilter = By.xpath("//checkbox-filter[@class='baggage']/checkbox-filter-item[2]//i[@class='checkbox-check eva-3-icon-checkmark filters-checkbox-left']");
    By checkCurrencyFilter = By.xpath("//option[contains(.,'Dólares estadounidenses')]");
    By checkOrderBy = By.xpath("//option[contains(.,'Más convenientes')]");
    By buttonSelectFly = By.xpath("//div[@id='clusters']/span[1]//em[@class='btn-text']");
    By loader = By.cssSelector(".loader-modal-content");


    public static enum origins {
        BuenosAires,
        Cordoba
    }

    public void goToVuelosPage() {
        click(buttonFlies);
    }

    public void selectOriginCity(origins origin) {

        switch (origin) {
            case BuenosAires:
                selectCity(textOriginCity, optionOriginCityBsAs, "Buenos Aires");
                break;
            case Cordoba:
                selectCity(textOriginCity, optionOriginCityCordoba, "Cordoba");
                break;
        }
    }

    public static enum destinations {
        Cordoba,
        Paris,
        Londres,
    }


    public void selectDestinationCity(destinations destiny) {

        switch (destiny) {
            case Cordoba:
                selectCity(textDestinationsCity, optionDestinationsCityCordoba, "Cordoba Arg");
                break;
            case Paris:
                selectCity(textDestinationsCity, optionDestinationsCityParis, "Ile de France, Francia");
            case Londres:
                selectCity(textDestinationsCity, optionDestinationsCityLondres, "Londres, Inglaterra, Reino Unido");
        }
    }

    public void selectCity(By textField, By option, String text) {
        click(textField);
        findItem(textField).sendKeys(text);
        waitExplicitClick(option, 20);
        click(option);
    }

    public void checkNoDecidatedDate() {
        click(checkNoDate);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    //Segundo caso

    public void checkOneWayFly() {
        click(radioButtonOneWayFly);
    }

    public void selectDepartureDay() {
        click(textFieldDepartureDate);
        waitExplicitClick(calendarDay, 20);
        click(calendarDay);
    }

    public void clickApplyDatesButton() {
        click(buttonApplyDates);
    }

    public void selectArrivalDay(){
        waitExplicitClick(calendarDayBack, 20);
        click(calendarDayBack);

    }


    public void settMinorPassengers() {
        click(buttonPassengers);
        waitExplicitClick(addMinor, 20);
        click(addMinor);
        waitExplicitClick(buttonMinorAge, 20);
        click(buttonMinorAge);
        click(ageMinor);
    }

    //tercer caso

    public static enum classFly{
        premiumEconomy,
        ejecutivaBusiness,
    }

    public void selectFlyClass(classFly cls){

        switch (cls){
            case premiumEconomy:
                setFlyClass(optionPremiumEconomyClassFly);
                break;
            case ejecutivaBusiness:
                setFlyClass(optionBusinessEconomyClassFly);
                break;
        }

    }
    public void setFlyClass(By option){
        waitExplicitClick(buttonClassFly, 20);
        click(buttonClassFly);
        click(option);
        click(buttonApplyClassPassengers);
    }

    public void waitForLoader(){
        WebElement el = waitExplicitVisibility(loader, 20);
        waitExplicitInvisibility(el, 20);
    }

    public void filterByScale(){
        click(checkScaleFilter);
        waitForLoader();
    }

    public void filterByBaggage(){
        click(checkBaggageFilter);
        waitForLoader();
    }

    public void filterByCurrency(){
        click(checkCurrencyFilter);
        waitForLoader();
    }

    public void filterByOrder(){
        click(checkOrderBy);
        waitForLoader();
    }
    public void clickSelectButton(){
        WebElement el = waitExplicitVisibility(buttonSelectFly,20);
        el.click();
    }
}
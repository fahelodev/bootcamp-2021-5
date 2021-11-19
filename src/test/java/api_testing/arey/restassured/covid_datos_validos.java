package api_testing.arey.restassured;

import io.restassured.response.Response;
import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class covid_datos_validos {

    //variables del encabezado
    String key;
    String host;

    //parametros
    String country_name;
    String fecha;

    Response respuesta;

    @Before
    public void init(){
        baseURI = "https://covid-19-data.p.rapidapi.com";

        //parametros
        this.country_name = "USA";
        this.fecha = "2020-04-01";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";

        this.respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.country_name).
                param("date",this.fecha).
                get("/report/country/name");

    }

    @Test
    public void ATC_Nombre_Pais_Exacto() throws InterruptedException {
       this.respuesta.
        then().
                body("country[0]",equalTo("USA"));
        dormir();
    }

    @Test
    public void ATC_Respuesta_JSON() throws InterruptedException {
     this.respuesta.
        then().
                contentType(JSON);
        dormir();
    }

    @Test
    public void ATC_Atributos_Localizacion() throws InterruptedException {
        Response rta = this.respuesta;
        rta.
        then().
                assertThat().statusCode(200);
        System.out.println(rta.asPrettyString());
        dormir();
    }

    @Test
    public void ATC_Estructura() throws InterruptedException {
        File file = new File("src/test/java/api_testing/arey/restassured/covid-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.respuesta
                .then().assertThat().body(not(empty()))
                .and().assertThat().body(matchesJsonSchema(fileInputStream));
    dormir();
    }

    @Test
    public void ATC_Validar_Pais_Ingresado() throws InterruptedException {
        this.respuesta.
                then().body("country[0]",equalTo("USA"));
        Assert.assertEquals(given().body("country[0]").toString().getClass().getSimpleName(),"String");
        dormir();
    }

    @Test
    public void ATC_Validar_Fecha_Ingresada() throws InterruptedException {
        this.respuesta.
                then().body("date[0]",equalTo("2020-04-01"));
        Assert.assertEquals(given().body("date[0]").toString().getClass().getSimpleName(),"String");
        dormir();
    }

    @Test
    public void ATC_Validar_Existencia_Parametros() throws InterruptedException {
        this.respuesta.
                then().assertThat().body("[0]",hasKey("provinces")).
                and().assertThat().body("[0]",hasKey("latitude")).
                and().assertThat().body("[0]",hasKey("date")).
                and().assertThat().body("[0]",hasKey("country")).
                and().assertThat().body("[0]",hasKey("longitude"));
        dormir();
    }

    @Test
    public void ATC_Validar_NY_USA() throws InterruptedException {
        Validar_Estados_USA("New York");
        dormir();
    }

    @Test
    public void ATC_Validar_OHIO_USA() throws InterruptedException {
        Validar_Estados_USA("Ohio");
        dormir();
    }

    public void Validar_Estados_USA(String nombreEstado) throws InterruptedException {
        List<String> api = this.respuesta.getBody().jsonPath().getList("provinces[0].province");
        Assert.assertEquals(api.get(api.indexOf(nombreEstado)),nombreEstado);
        Assert.assertEquals(api.get(api.indexOf(nombreEstado)).getClass().getSimpleName(),"String");
        dormir();
    }

    public void dormir() throws InterruptedException {
        Thread.sleep(600);
    }
}

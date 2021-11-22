package api_testing.maraya.restassured;

import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class covidTest1
{
    //variables del encabezado
    String key;
    String host;

    //parametros
    String name;
    String date;

    @Before
    public void init(){
        baseURI = "https://covid-19-data.p.rapidapi.com";

        //parametros
        this.name = "USA";
        this.date = "2020-04-01";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";

    }

    @Test
    public void ATC_Impresion_Respuesta()
    {
        String respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                get("/report/country/name").asPrettyString();

        System.out.println(respuesta);
    }

    @Test
    public void ATC_Respuesta_Valida()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("/report/country/name").
                then().assertThat().statusCode(200);

    }



    @Test
    public void ATC_Propiedades()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("/report/country/name").
                then().assertThat().statusCode(200).
                body("[0]", hasKey("country")).
                body("[0]", hasKey("provinces")).
                body("[0]", hasKey("latitude")).
                body("[0]", hasKey("longitude")).
                body("[0]", hasKey("date"));
    }

    @Test
    public void ATC_DatoExacto()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("/report/country/name").
                then().assertThat().statusCode(200).
                body("[0].country", equalTo("USA")).
                body("[0].provinces[0].province", equalTo("Alabama"));


    }

    @Test
    public void ATC_Respuesta_Json()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("/report/country/name").
                then().assertThat().statusCode(200).
                header("Content-type","application/json");

    }

}
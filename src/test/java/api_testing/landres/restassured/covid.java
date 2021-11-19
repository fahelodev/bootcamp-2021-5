package api_testing.landres.restassured;
import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class covid
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
    public void ATC_Body()
    {
        String respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                get("/report/country/name.json").asPrettyString();

        System.out.println(respuesta);
    }

    @Test
    public void ATC_Respuesta_200()
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
    public void ATC_json()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("/report/country/name").
                then().assertThat().header("Content-type","application/json");;

    }

    @Test
    public void ATC_alabama()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("/report/country/name").
                then().
                assertThat().statusCode(200).
                body("provinces[0].province[0]",equalTo("Alabama"));
    }

    @Test
    public void ATC_USA()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("/report/country/name").
                then().
                assertThat().statusCode(200).
                body("country[0]",equalTo("USA"));
    }



    @Test
    public void ATC_ESTRUCTURA()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when().
                get("/report/country/name").
                then().
                body("[0]", hasKey("country")).
                body("[0]", hasKey("provinces")).
                body("[0]", hasKey("latitude")).
                body("[0]", hasKey("longitude")).
                body("[0]", hasKey("date"));


    }

}
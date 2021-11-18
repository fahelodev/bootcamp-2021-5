package api_testing.clopez.restassured;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class test_covid
{
    //variables del encabezado
    String key;
    String host;

    //parametros
    String name;
    String date;

    @Before
    public void init(){
        baseURI = "https://covid-19-data.p.rapidapi.com/report/country/name";

        //parametros
        this.name = "USA";
        this.date = "2020-04-01";

        //encabezados
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";
    }

    @Test
    public void Test_00_Imprimir_Contenido()
    {
        String respuesta = given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name", this.name).
                param("date", this.date).
                get().asPrettyString();

        System.out.println(respuesta);
    }

    @Test
    public void Test_00_Respuesta_Valida(){
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name", this.name).
                param("date", this.date).
                when().get().
                then().assertThat().statusCode(200);
    }

    @Test
    public void Test_01_Tipo_de_Datos(){
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name", this.name).
                param("date", this.date).
                when().get().then().statusCode(200).
                body("provinces[0].deaths[4]",equalTo("199"));
    }

    @Test
    public void Test_02_Dado_Exacto(){
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name", this.name).
                param("date", this.date).
                when().get().then().statusCode(200).
                body("country[0]",equalTo("USA"));

        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name", this.name).
                param("date", this.date).
                when().get().then().statusCode(200).
                body("provinces[0].province[4]",equalTo("California"));

        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name", this.name).
                param("date", this.date).
                when().get().then().statusCode(200).
                body("provinces[0].deaths[4]",equalTo("199"));
    }

    @Test
    public void Test_03_Estructura(){
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name", this.name).
                param("date", this.date).
                when().get().then().statusCode(200).
                body("provinces[0].province[0]*.length().sum()",greaterThan(50));
    }


    @Test
    public void Test_04_Respuesta_Json() {
        File file = new File("src/test/java/api_testing/clopez/restassured/covid-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name", this.name).
                param("date", this.date).
        when().
                get().
        then().
                assertThat().body(matchesJsonSchema(fileInputStream));
    }
}

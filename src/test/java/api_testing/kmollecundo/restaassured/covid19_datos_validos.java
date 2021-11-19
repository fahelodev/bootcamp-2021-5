package api_testing.kmollecundo.restaassured;

import org.junit.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class covid19_datos_validos {
    //Variables de encabezado
    String key;
    String host;

    //Parameters
    String name;
    String date;

    @Before
    public void init(){
        baseURI = "https://covid-19-data.p.rapidapi.com";

        //parameters
        this.name = "USA";
        this.date = "2020-04-1";

        //Encabezado
        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";
    }
    @Test
    public void ATC_country(){
        given().header("x-rapidapi-key",this.key).and().header("x-rapidapi-host",this.host).
                param("name",this.name).param("date",this.date).
                when().
                        get("/country").
                then().
                        assertThat().statusCode(200).
                        body("country[0]",equalTo("USA"));
    }
    @Test
    public void ATC_validoJson(){
        File file = new File("src/test/java/api_testing/kmollecundo/restaassured/covid19-schema-kmollecundo.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        assert fileInputStream != null;
        given().header("x-rapidapi-key",this.key).and().header("x-rapidapi-host",this.host).
                param("name",this.name).param("date",this.date).
                when().
                get("/country").
                then().
                assertThat().statusCode(200).
                body(matchesJsonSchema(fileInputStream));
    }
    @Test
    public void ATC_estructura(){
         String extraeDatos = given().header("x-rapidapi-key",this.key).and().header("x-rapidapi-host",this.host).
                param("name",this.name).param("date",this.date).
                when().
                get("https://covid-19-data.p.rapidapi.com/report/country/name?name=USA&date=2020-04-01").
                then().
                assertThat().statusCode(200).
                extract().response().jsonPath().getString("provinces[0]");
         System.out.println(extraeDatos);
    }
    @Test
    public void ATC_ValidoProvince(){
        String extraeDatos = String.valueOf(given().header("x-rapidapi-key",this.key).and().header("x-rapidapi-host",this.host).
                param("name",this.name).param("date",this.date).
                when().
                get("https://covid-19-data.p.rapidapi.com/report/country/name?name=USA&date=2020-04-01").
                then().
                assertThat().statusCode(200).
                extract().response().jsonPath().getString("provinces[0].province[2]").equals("Arizona"));
        System.out.println(extraeDatos);
    }
}

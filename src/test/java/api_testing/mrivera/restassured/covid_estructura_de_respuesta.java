package api_testing.mrivera.restassured;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class covid_estructura_de_respuesta
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
    public void ATC02_EstructuraDeRespuesta()
    {
        File file = new File("src/test/java/api_testing/mrivera/restassured/covid-schema.json");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host)
                .param("name",this.name)
                .param("date", this.date)
                .when()
                .get("/report/country/name/")
                .then()
                .assertThat().body(matchesJsonSchema(fileInputStream));
    }
}

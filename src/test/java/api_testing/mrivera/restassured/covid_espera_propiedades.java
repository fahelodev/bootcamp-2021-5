package api_testing.mrivera.restassured;

import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class covid_espera_propiedades
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
    public void ATC_EsperaPropiedades()
    {
        given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date).
                when()
                .get("/report/country/name/")
                .then()
                .body("[0]", hasKey("country"))
                .body("[0]", hasKey("provinces"))
                .body("[0]", hasKey("latitude"))
                .body("[0]", hasKey("longitude"))
                .body("[0]", hasKey("date"));
    }

}

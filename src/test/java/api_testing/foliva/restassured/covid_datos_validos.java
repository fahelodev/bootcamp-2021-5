package api_testing.foliva.restassured;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.*;
import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class covid_datos_validos {
    //variables del encabezado
    String key;
    String host;
    //parametros
    String name;
    String date;

    Response request;

    @Before
    public void init(){
        baseURI = "https://covid-19-data.p.rapidapi.com";

        this.name = "usa";
        this.date = "2020-04-01";

        this.key = "65c3a8ec1emsh38db88917d7c333p1cd20ajsn923976797f86";
        this.host = "covid-19-data.p.rapidapi.com";

        this.request =  given().header("x-rapidapi-key",this.key).
                and().header("x-rapidapi-host",this.host).
                param("name",this.name).
                param("date", this.date)
                .get("/report/country/name");
    }

    @Test
    public void ATC_Impresion_Respuesta()
    {
        String respuesta = request.asPrettyString();

        System.out.println(respuesta);
    }

    @Test
    public void ATC_RespuestaValida()
    {
        request.then().assertThat().statusCode(200);

    }

    @Test
    public void ATC_ElPaisEsElElegido()
    {
        request.then().assertThat().statusCode(200)
                .body("[0].country", equalTo("USA"));
    }
    @Test
    public void ATC_ProvinciasEsUnArray()
    {
        request.then().assertThat().statusCode(200)
                .body("[0].provinces", not(emptyArray()));
    }


    @Test
    public void ATC_LaRespuestaEsJSON()
    {
        request.then().assertThat().statusCode(200).header("Content-Type", "application/json");
    }

    @Test
    public void ATC_RespuestaConPropiedades()
    {
        ResponseBody blabla = request.body();
        request.then().assertThat().statusCode(200)
                .body("[0]", hasKey("provinces"))
                .body("[0]", hasKey("country"))
                .body("[0]", hasKey("latitude"))
                .body("[0]", hasKey("longitude"))
                .body("[0]", hasKey("date"));
    }
}

package API.restassured;

import API.pogo.StatePojo;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import utils.Constants;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Deserialization {

    @Test
    public void  test(){

        RestAssured.baseURI="https://corona.lmao.ninja/v2/states/Illinois";
        Response response = given().accept("application/json")
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json").extract().response();

        Map <String, Object> parsedResponse = response.as(new TypeRef<Map <String, Object>>() {
        });

        MatcherAssert.assertThat(parsedResponse.get("state"), Matchers.is("Illinois"));
        
                
    }

    @Test
    public void  test1() {

        RestAssured.baseURI = "https://corona.lmao.ninja/v2/states/Illinois";
        Response response = given().accept("application/json")
                .get()
                .then()
                .statusCode(200)
                .contentType(Constants.APPLICATION_JSON)
                .extract().response();
        StatePojo parsedResponse= response.as(StatePojo.class);
        MatcherAssert.assertThat(parsedResponse.getPopulation(), Matchers.equalTo(12671821l));

    }

}

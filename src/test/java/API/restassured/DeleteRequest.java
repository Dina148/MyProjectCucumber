package API.restassured;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;
import utils.Constants;

import static io.restassured.RestAssured.given;

public class DeleteRequest {


    @Test
    public  void test(){

        RestAssured.baseURI="https://petstore.swagger.io/v2/pet/201";

        given().accept(Constants.APPLICATION_JSON)
                .when()
                .get()
                .then()
                .statusCode(200);

                given().accept(Constants.APPLICATION_JSON)
                        .when()
                        .delete()
                        .then()
                        .statusCode(200)
                        .body("type", Matchers.equalTo("error"));

        given().accept(Constants.APPLICATION_JSON)
                .when()
                .get()
                .then()
                .statusCode(404);

    }



}

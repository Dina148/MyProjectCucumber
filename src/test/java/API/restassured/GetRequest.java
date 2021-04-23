package API.restassured;

import org.hamcrest.Matchers;
import org.junit.Test;
import utils.Constants;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest {

    @Test
    public void test1() {

        given().accept("application/json").log().all()
                .when().get("https://petstore.swagger.io/v2/pet/1090")
                .then()
                .statusCode(200).contentType("application/json").log().body();


    }

    @Test
    public void test2() {

        given().accept("application/json").log().uri()
                .when().get("https://api.got.show/api/show/characters")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/json").log().ifValidationFails();
    }


    @Test
    public void test3() {

        given().accept(Constants.APPLICATION_JSON)
                .when()
                .get("https://petstore.swagger.io/v2/pet/1")
                .then()
                .statusCode(404)
                .and()
                .contentType(Constants.APPLICATION_JSON)
                .body("type", equalTo("error"))
                .body("message", is("Pet not found"));

    }


    @Test
    public void test4() {

        given().accept(Constants.APPLICATION_JSON)
                .param("page", "3")
                .when()
                .get("http://swapi.dev/api/starships/")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .and()
                .body("count", is(36))
                .and()
                .body("results[0].name", equalTo("Scimitar"));
        //.body("[0].name", equalTo("Eddard Stark"));

        //  .body("[0].gender", is("male"));

    }

    @Test
    public void test5() {

        given().accept(Constants.APPLICATION_JSON)
                .when()
                .get("https://api.got.show/api/show/characters")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .body("[0].name", Matchers.equalTo("Eddard Stark"))
                .body("[0].gender", Matchers.is("male"));

    }

    @Test
    public void test6() {

        given().accept(Constants.APPLICATION_JSON)
                .when()
                .get("https://petstore.swagger.io/v2/pet/10900000")
                .then()
                .contentType(Constants.APPLICATION_JSON)
                .body("category.id", Matchers.equalTo(700))
                .and()
                .body("photoUrls", Matchers.hasSize(0));
    }


}
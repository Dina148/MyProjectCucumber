package API.restassured;

import org.junit.Test;
import utils.Constants;
import utils.PayloadUtils;

import static io.restassured.RestAssured.given;

public class PutRequest {

    @Test
    public  void test(){

        given().header(Constants. ACCEPT, Constants.APPLICATION_JSON)
                .header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON )
                .body(PayloadUtils.getPetPayload(4444))
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .contentType(Constants.APPLICATION_JSON);


    }






}

package API.restassured;

import API.pogo.PetPojo;

import org.junit.Test;


import java.io.File;


import static io.restassured.RestAssured.given;

public class PostRequest {


    @Test
    public  void  test1(){

//        String petBody= PayloadUtils.getPetPayload(4343);
//        Response response=  given().header("Accept", "application/json"
//                .header("Accept", "application/json")
//                .body(petBody)
//                .when()
//                .post("https://petstore.swagger.io/v2/pet/")
//                .then()
//                .statusCode(200)
//                .contentType("application/json")
//                .log().body()
//                .extract().response();
//



    }


@Test
    public void test2(){

       //RestAssured.baseURI="https://petstore.swagger.io/v2/pet";
        PetPojo petPojo=new PetPojo();
        petPojo.setId(123);
        petPojo.setName("Lisa");
        petPojo.setStatus("RestAssured test");

        given().header("Accept" , "application/json")
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .contentType("application/json");

    }





    @Test
    public void test3() {
        File jsonFile=new File("src/test/resources/pet.json");
        given().header("Accept" , "application/json")
                .header("Content-Type", "application/json")
                .body(jsonFile)
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .contentType("application/json");

    }

}

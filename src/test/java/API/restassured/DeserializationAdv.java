package API.restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import utils.Constants;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class DeserializationAdv {

    @Test
    public  void test(){

        //http://swapi.dev/api/people?page=4

        RestAssured.baseURI="http://swapi.dev";
        RestAssured.basePath="api/starships/";

       Response response = given().header(Constants.ACCEPT, Constants.APPLICATION_JSON)
                .param("page","4")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType(Constants.APPLICATION_JSON).time(Matchers.lessThan(5000l), TimeUnit.MILLISECONDS)
                .extract().response();

       JsonPath jsonPath = response.jsonPath();
      int countNumber = jsonPath.get("count");
     List<Map<String, Object>>  resultsOfList = jsonPath.getList("results");

        MatcherAssert.assertThat(countNumber, Matchers.equalTo(36));
        MatcherAssert.assertThat(resultsOfList, Matchers.hasSize(6));

    }

@Test
    public void test2(){
    RestAssured.baseURI="http://swapi.dev";
    RestAssured.basePath="api/starships/";

       Response response = given().header("Accept", "application/json")
                .param("page", "3")
                .when()
                .get()
                .then()
                .statusCode(200)
                .and()
                .contentType(Constants.APPLICATION_JSON).extract().response();

       Map <String, Object> landoObject=response.path("results.find { it.name == 'Boba Fett' }");
    System.out.println(landoObject);

}
//Cristiano Ronaldo
@Test
public void test3() {
    RestAssured.baseURI = "http://api.football-data.org/v2/competitions/2000/scorers";


    Response response = given()
            .header("Accept", "application/json")
            .header("X-Auth-Token", "c55b7a64e8424d46a52051bce36d1c0a")
            .when()
            .get()
            .then()
            .statusCode(200)
            .and()
            .contentType(Constants.APPLICATION_JSON)
            .extract().response();

    Map<String, Object> ronaldo = response.path("scorers.find { it.player.name == 'Cristiano Ronaldo'}");
    System.out.println(ronaldo);

    String position = response.path("scorers.find { it.player.name == 'Cristiano Ronaldo'}.player.position");
    System.out.println("position is- " +position);

}


@Test
    public  void test4(){

      Response response =  given().header(Constants.ACCEPT, Constants.APPLICATION_JSON)
                .header("X-Auth-Token", "c55b7a64e8424d46a52051bce36d1c0a")
                .when()
                .get("http://api.football-data.org/v2/competitions/2000/scorers")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/json")
                .extract().response();


         List <String> attackerList  =response.path("scorers.findAll { it.player.position == 'Attacker'}.player.name");
    System.out.println(attackerList);


    MatcherAssert.assertThat(attackerList, Matchers.hasItem("Harry Kane"));
    MatcherAssert.assertThat(attackerList, Matchers.hasSize(8));



}
}

package automationAPI.stores;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyStoresGetTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
    }

    @Test
    public void getAllStoresInformation() {

        Response response = given()
                .when()
                .get();

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    public void getStoresByName() {

        Response response = given()
                .param("name", "Roseville")
                .when()
                .get();

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get("?name=Roseville")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStoreByValidId() {
        Response response = given()
                .when()
                .get("/7");

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get("/7")
                .then()
                .statusCode(200);
    }


    @Test
    public void getStoreByInvalidId() {
        Response response = given()
                .when()
                .get("/111111111");

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get("/111111111")
                .then()
                .statusCode(404);
    }

}

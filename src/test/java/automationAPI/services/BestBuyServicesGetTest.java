package automationAPI.services;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyServicesGetTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
    }

    @Test
    public void getAllServicesInformation() {

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
    public void getServicesByName() {

        Response response = given()
                .param("name", "Best Buy Mobile")
                .when()
                .get();

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get("?name=Best Buy Mobile")
                .then()
                .statusCode(200);
    }

    @Test
    public void getServiceByValidId() {
        Response response = given()
                .when()
                .get("/1");

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }


    @Test
    public void getServiceByInvalidId() {
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

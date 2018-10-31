package automationAPI.products;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyProductsGetTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
    }

    @Test
    public void getAllProductsInformation() {

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
    public void getAllProductsByManufacturer() {
        Response response = given()
                .param("manufacturer", "Pioneer")
                .when()
                .get();

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get("?manufacturer=Pioneer")
                .then()
                .statusCode(200);
    }

    @Test
    public void getProductByValidId() {
        Response response = given()
                .when()
                .get("/43900");

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get("/43900")
                .then()
                .statusCode(200);
    }


    @Test
    public void getProductByInvalidId() {
        Response response = given()
                .when()
                .get("/43900");

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get("/111111111")
                .then()
                .statusCode(404);
    }

}

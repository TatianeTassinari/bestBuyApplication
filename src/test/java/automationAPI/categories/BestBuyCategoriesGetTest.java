package automationAPI.categories;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyCategoriesGetTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
    }

    @Test
    public void getAllCategoriesInformation() {

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
    public void getCategorieByName(){
        Response response = given()
                .param("name", "TVs")
                .when()
                .get();

        System.out.println(response.body().prettyPrint());

        //validate status code
        given()
                .when()
                .get("?name=TVs")
                .then()
                .statusCode(200);
    }

    @Test
    public void getCategorieByValidId() {
        Response response = given()
                .when()
                .get("/abcat0010000");

               //validate status code
        given()
                .when()
                .get("/abcat0010000")
                .then()
                .statusCode(200);

        System.out.println(response.body().prettyPrint());
    }


    @Test
    public void getCategorieByInvalidId(){

        given()
                .when()
                .get("/111111111")
                .then()
                .statusCode(404);
    }
}

package automationAPI.categories;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyCategoriesPatchTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
    }

    @Test
    public void updateCategorieNotFound() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .patch("/1111111")
                .then()
                .statusCode(404);


        System.out.println("Update not possible, Categorie not found in database");
    }
}

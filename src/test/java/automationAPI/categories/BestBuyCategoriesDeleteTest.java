package automationAPI.categories;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyCategoriesDeleteTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
    }

    @Test
    public void deleteCategorieNotExisting() {
        given()
                .when()
                .delete("/127687")
                .then()
                .statusCode(404);

        System.out.println("Categorie can't be deleted because it was not found in the database");
    }
}

package automationAPI.categories;

import com.categorie.model.Categorie;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyCategoriesPostTest {


    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
    }

    @Test
    public void createNewValidCategorie() {
        //ID must be unique
        Categorie categorie = new Categorie();
        categorie.setName("Test1234");
        String name = categorie.getName();
        String id = categorie.setId();

        given()
                .contentType(ContentType.JSON)
                .body(categorie)
                .when()
                .post();

        System.out.println("New categorie created: " + id);
    }
}

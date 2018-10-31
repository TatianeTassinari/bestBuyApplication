package automationAPI.services;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.product.model.Product;
import com.services.model.Services;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyServicesPatchTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
    }

    @Test
    public void updateExistingService() {
        Services service = new Services();
        service.setName("Name of this service");


        String id = given()
                .contentType(ContentType.JSON)
                .when()
                .body(service)
                .post()
                .then()
                .statusCode(201)
                .extract()
                .path("id").toString();

        System.out.println("New service created: " + id);


        service.setName("Name of this service updated");

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(service)
                .patch(id)
                .then()
                .statusCode(200)
                .extract()
                .path("name").toString().equalsIgnoreCase("updated");


        System.out.println("Name of the service was updated");
    }


    @Test
    public void updateServiceNotFound() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .patch("/1111111")
                .then()
                .statusCode(404);


        System.out.println("Update not possible, Service not found in database");
    }
}

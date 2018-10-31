package automationAPI.services;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.services.model.Services;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyServicesDeleteTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
    }

    @Test
    public void deleteExistingService() {
        //first create a service
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

        //then delete the service just created
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(service)
                .delete(id)
                .then()
                .statusCode(200);

        //to make sure the service was deleted try to search by its id
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(service)
                .get(id)
                .then()
                .statusCode(404);

        System.out.println("Service " + id + " deleted with success");
    }

    @Test
    public void deleteServiceNotExisting() {
        given()
                .when()
                .delete("/127687")
                .then()
                .statusCode(404);

        System.out.println("Service can't be deleted because it was not found in the database");
    }
}

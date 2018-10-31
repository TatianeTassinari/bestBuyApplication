package automationAPI.services;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.services.model.Services;
import com.store.model.Store;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyServicesPostTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
    }

    @Test
    public void createValidNewService() {

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
    }

    @Test
    public void createNewServiceWithMissingParameter() {

        Services service = new Services();
       // service.setName("Name of this service");


        given()
                .contentType(ContentType.JSON)
                .when()
                .body(service)
                .post()
                .then()
                .statusCode(400);


        System.out.println("This service can't be created because there is a missing parameter");
    }
}

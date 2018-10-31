package automationAPI.stores;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.services.model.Services;
import com.store.model.Store;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyStoresPatchTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
    }

    @Test
    public void updateExistingStore() {
        Store store = new Store();
        store.setName("Name of this store");
        store.setAddress("Adress 1 street 10");
        store.setCity("Los Angeles");
        store.setState("California");
        store.setZip("70950");


        String id = given()
                .contentType(ContentType.JSON)
                .when()
                .body(store)
                .post()
                .then()
                .statusCode(201)
                .extract()
                .path("id").toString();

        System.out.println("New store created: " + id);

        store.setCity("San Diego");

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(store)
                .patch(id)
                .then()
                .statusCode(200)
                .extract()
                .path("city").toString().equalsIgnoreCase("Sand Diego");


        System.out.println("Name of the city was updated");
    }


    @Test
    public void updateStoreNotFound() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .patch("/1111111")
                .then()
                .statusCode(404);


        System.out.println("Update not possible, Store not found in database");
    }
}

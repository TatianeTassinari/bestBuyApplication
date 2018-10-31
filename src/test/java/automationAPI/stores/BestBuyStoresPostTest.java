package automationAPI.stores;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.store.model.Store;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyStoresPostTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
    }

    @Test
    public void createValidNewStore() {

        Store store = new Store();
        store.setName("Name of this store112210");
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
    }

    @Test
    public void createNewStoreWithMissingParameter() {

        Store store = new Store();
        //store.setName("Name of this store112210");
        store.setAddress("Adress 1 street 10");
        store.setCity("Los Angeles");
        store.setState("California");
        store.setZip("70950");


       given()
                .contentType(ContentType.JSON)
                .when()
                .body(store)
                .post()
                .then()
                .statusCode(400);

        System.out.println("This store can't be created because there is a missing parameter");
    }

}

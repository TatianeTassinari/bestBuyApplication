package automationAPI.stores;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.store.model.Store;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyStoresDeletePost {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";
    }

    @Test
    public void deleteExistingStore() {
        //first create a store
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

        //then delete the store just created
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(store)
                .delete(id)
                .then()
                .statusCode(200);

        //to make sure the store was deleted try to search by its id
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(store)
                .get(id)
                .then()
                .statusCode(404);

        System.out.println("Store " + id + " deleted with success");
    }

    @Test
    public void deleteStoreNotExisting() {
        given()
                .when()
                .delete("/127687")
                .then()
                .statusCode(404);

        System.out.println("Store can't be deleted because it was not found in the database");
    }
}

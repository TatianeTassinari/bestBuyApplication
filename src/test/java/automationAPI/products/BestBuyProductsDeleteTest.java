package automationAPI.products;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.product.model.Product;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyProductsDeleteTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
    }

    @Test
    public void deleteExistingProduct() {
        //first create a product
        Product product = new Product();
        product.setName("Duracell - A Batteries (7-Pack)");
        product.setType("HardGood");
        product.setPrice(10);
        product.setUpc("34566");
        product.setShipping(1);
        product.setDescription("Compatible with select electronic devices");
        product.setManufacturer("Pioneer");
        product.setModel("MN2400B41Z");
        product.setUrl("http://www.bestbuy.com/site/duracell-aaa-batteries");
        product.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");

        String id = given()
                .contentType(ContentType.JSON)
                .when()
                .body(product)
                .post()
                .then()
                .statusCode(201)
                .extract()
                .path("id").toString();


        System.out.println("New product created: " + id);

        //then delete the product just created
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(product)
                .delete(id)
                .then()
                .statusCode(200);

        //to make sure the product was deleted try to search by its id
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(product)
                .get(id)
                .then()
                .statusCode(404);

        System.out.println("Product " + id + " deleted with success");
    }

    @Test
    public void deleteProductNotExisting() {
        given()
                .when()
                .delete("/127687")
                .then()
                .statusCode(404);

        System.out.println("Product can't be deleted because it was not found in the database");
    }
}

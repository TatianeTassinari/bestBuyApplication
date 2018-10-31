package automationAPI.products;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.product.model.Product;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyProductsPatchTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/products";
    }

    @Test
    public void updateExistingProduct() {
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

        product.setType("HardWell");

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(product)
                .patch(id)
                .then()
                .statusCode(200)
                .extract()
                .path("type").toString().equalsIgnoreCase("Hardwell");


        System.out.println("Type of the product was updated");
    }


    @Test
    public void updateProductNotFound() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .patch("/1111111")
                .then()
                .statusCode(404);


        System.out.println("Update not possible, Product not found in database");
    }
}

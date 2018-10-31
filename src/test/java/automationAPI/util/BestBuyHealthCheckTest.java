package automationAPI.util;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyHealthCheckTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/healthcheck";
    }

    @Test
    public void makeSureThatApiIsUp() {
        given()
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200);

        System.out.println("The API is up and running");
    }
}

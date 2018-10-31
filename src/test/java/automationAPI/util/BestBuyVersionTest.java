package automationAPI.util;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class BestBuyVersionTest {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/version";
    }

    @Test
    public void checkCurrentAPIVersion() {
        String version = given()
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("version").toString();

        System.out.println("Current API version is: " + version);
    }
}

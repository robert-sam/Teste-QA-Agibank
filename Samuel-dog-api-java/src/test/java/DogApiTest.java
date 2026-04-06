import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class DogApiTest {

    private final String BASE_URL = "https://dog.ceo/api";

    @Test
    public void deveListarTodasAsRacas() {
        Response response = given()
                .when()
                .get(BASE_URL + "/breeds/list/all");

        assertEquals(200, response.statusCode());
        assertEquals("success", response.jsonPath().getString("status"));
        assertNotNull(response.jsonPath().get("message"));
    }

    @Test
    public void deveRetornarImagensDeUmaRaca() {
        Response response = given()
                .when()
                .get(BASE_URL + "/breed/hound/images");

        assertEquals(200, response.statusCode());
        assertEquals("success", response.jsonPath().getString("status"));

        java.util.List<?> images = response.jsonPath().getList("message");

        assertTrue(images.size() > 0);
        assertTrue(images.get(0).toString().contains("http"));
    }


    @Test
    public void deveRetornarImagemAleatoria() {
        Response response = given()
                .when()
                .get(BASE_URL + "/breeds/image/random");

        assertEquals(200, response.statusCode());

        String imageUrl = response.jsonPath().getString("message");
        assertNotNull(imageUrl);
        assertTrue(imageUrl.contains("http"));
    }
}

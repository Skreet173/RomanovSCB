package api.shortUrlLinks;

import modelData.urldata.CorrectResponseUrl;
import modelData.urldata.IncorrectResponseUrl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ShortUrlLinksTests {

    private static final String FILE_WITH_URL = "./src/main/resources/urlForShortening.txt";
    private static final String BASE_URI_DOMEN = "https://cleanuri.com/";

    @Test
    @DisplayName("Сокращение URL адреса. Позитивный сценарий")
    public void shortUrlLink() {
        File file = new File(FILE_WITH_URL);
        CorrectResponseUrl response = given()
                .body(file)
                .contentType("application/json")
                .when()
                .post(BASE_URI_DOMEN + "api/v1/shorten")
                .then()
                .statusCode(200)
                .log().all()
                .extract().as(CorrectResponseUrl.class);
        assertThat(response)
                .isNotNull()
                .extracting(CorrectResponseUrl::getResultUrl)
                .matches(s -> s.startsWith(BASE_URI_DOMEN));
    }

    @Test
    @DisplayName("Сокращение URL адреса. Негативный сценарий. Пустой URL")
    public void shortUrlLinkWithVoid() {
        IncorrectResponseUrl error = given()
                .contentType("application/json")
                .when()
                .post(BASE_URI_DOMEN + "api/v1/shorten")
                .then()
                .statusCode(400)
                .log().all()
                .extract().as(IncorrectResponseUrl.class);
        assertThat(error)
                .isNotNull()
                .extracting(IncorrectResponseUrl::getError)
                .isEqualTo("API Error: URL is empty");
    }

    @Test
    @DisplayName("Сокращение URL адреса. Негативный сценарий. Некорректный URL")
    public void shortUrlLinkIncorrect() {
        File file = new File(FILE_WITH_URL);
        IncorrectResponseUrl error = given()
                .body(file)
                .contentType("application/json")
                .when()
                .post(BASE_URI_DOMEN + "api/v1/shorten")
                .then()
                .statusCode(400)
                .log().all()
                .extract().as((IncorrectResponseUrl.class));
        assertThat(error)
                .isNotNull()
                .extracting(IncorrectResponseUrl::getError)
                .matches(s -> s.startsWith("API Error: URL is invalid"));
    }
}

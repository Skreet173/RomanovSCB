package api.randomUsers;

import io.restassured.http.ContentType;
import modelData.usersData.Info;
import modelData.usersData.ResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomUsersPositiveTests {

    private final static String BASE_URL = "https://randomuser.me/";


    @Test
    @DisplayName("Герация пользователя")
    public void generateUser() {
        given()
                .when()
                .contentType(ContentType.JSON)
                .get(BASE_URL + "api/")
                .then()
                .log().all()
                .assertThat().body(matchesJsonSchemaInClasspath("responseModelJsonSchema.json"));
    }

    @Test
    @DisplayName("Генерация пользователя с Query параметрами")
    public void generateUserWithParams() {

        String gender = "gender=male";
        String nat = "nat=RS";
        int result = 2;

        ResponseModel user = given()
                .when()
                .contentType(ContentType.JSON)
                .get(BASE_URL + "api/?" + gender + "&" + nat + "&results=" + result)
                .then()
                .log().all()
                .extract().as(ResponseModel.class);
        user.getResults().stream().forEach(x -> assertThat(x.getGender()).isEqualTo("male"));
        user.getResults().stream().forEach(x -> assertThat(x.getNat()).isEqualTo("RS"));
        assertThat(user.getInfo())
                .isNotNull()
                .extracting(Info::getResults)
                .matches(s -> s.equals(result));
    }
}

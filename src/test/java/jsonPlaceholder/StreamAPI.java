package jsonPlaceholder;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class StreamAPI {
    @Test
    public void checkTable(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://computer-database.gatling.io/computers?p=1&n=10&s=name&d=asc").
                then().log().all();
    }
}

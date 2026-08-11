import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class CheckAPITest {
    @Test
    public void GET() {
            RestAssured
                    .given()
                    .when()
                    .get("https://jsonplaceholder.typicode.com/posts/1")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .body("id", equalTo(1))
                    .body("userId", equalTo(1))
                    .body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }
    @Test
    public void POST() {
        String requestBody = "{ \"title\": \"Мой пост\", \"body\": \"Текст поста\", \"userId\": 1 }";
        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .log().all()
                .statusCode(201)
                .body("title", equalTo("Мой пост"));

    }
    @Test
    public void PUT() {
        String requestBody = "{ \"title\": \"Новый пост\", \"body\": \"Новый Текст\", \"userId\": 1 }";
        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("title", equalTo("Новый пост"));
    }
    @Test
    public void PATCH() {
        String requestBody = "{ \"title\": \"Мой пост\"}";
        RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void GETALL() {
        RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void GETCOMENTS() {
        RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .log().all()
                .statusCode(200);
    }
}

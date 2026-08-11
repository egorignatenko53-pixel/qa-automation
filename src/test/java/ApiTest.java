import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void testGetPost() {
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
    public void testCreatePost() {
        String requestBody = "{ \"title\": \"Мой пост\", \"body\": \"Текст поста\", \"userId\": 1 }";

        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("Мой пост"));
    }

    @Test
    public void testUpdatePost() {
        String requestBody = "{ \"title\": \"Обновлённый пост\", \"body\": \"Новый текст\", \"userId\": 1 }";

        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200)
                .body("title", equalTo("Обновлённый пост"));
    }

    @Test
    public void testDeletePost() {
        RestAssured
                .given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(200);
    }
}
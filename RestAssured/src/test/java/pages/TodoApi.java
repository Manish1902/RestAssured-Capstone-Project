package pages;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TodoApi {

    public Response createTodo(String title, boolean completed) {
        return given()
                .header("Content-Type", "application/json")
                .body("{\"title\":\"" + title + "\", \"completed\":" + completed + "}")
                .post("/todos");
    }

    public Response partialUpdateTodoTitle(int id, String newTitle) {
        return given()
                .header("Content-Type", "application/json")
                .body("{\"title\":\"" + newTitle + "\"}")
                .patch("/todos/" + id);
    }

    public Response getAllTodos() {
        return given()
                .header("Accept", "application/json")
                .get("/todos");
    }

    public Response getTodosByCompletedStatus(boolean completed) {
        return given()
                .header("Accept", "application/json")
                .param("completed", completed)
                .get("/todos");
    }

    public Response getTodoById(int id) {
        return given()
                .header("Accept", "application/json")
                .get("/todos/" + id);
    }

    public Response deleteTodoById(int id) {
        return given()
                .header("Accept", "application/json")
                .delete("/todos/" + id);
    }
}

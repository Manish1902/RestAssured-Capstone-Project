package stepDefinations;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.TodoApi;

public class TodoDefination {

    private TodoApi todoApi = new TodoApi();
    private Response response;

    @Given("The JSONPlaceholder API is available")
    public void the_json_placeholder_api_is_available() {
        // API is already set up in BaseTest
    }

    @When("I partially update the title of todo with ID {string} to {string}")
    public void i_partially_update_the_title_of_todo_with_id_to(String id, String newTitle) {
        response = todoApi.partialUpdateTodoTitle(Integer.parseInt(id), newTitle);
    }

    @Then("The response should return a status code of {int}")
    public void the_response_should_return_a_status_code_of(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("The todo title should be {string}")
    public void the_todo_title_should_be(String title) {
        Assert.assertEquals(response.jsonPath().getString("title"), title);
    }

    @When("I fetch all todos")
    public void i_fetch_all_todos() {
        response = todoApi.getAllTodos();
    }

    @Then("The list of todos should not be empty")
    public void the_list_of_todos_should_not_be_empty() {
        Assert.assertTrue(response.jsonPath().getList("").size() > 0);
    }

    @When("I fetch all todos with completed status {string}")
    public void i_fetch_all_todos_with_completed_status(String completedStatus) {
        boolean completed = Boolean.parseBoolean(completedStatus);
        response = todoApi.getTodosByCompletedStatus(completed);
    }

    @Then("All fetched todos should be completed")
    public void all_fetched_todos_should_be_completed() {
        response.jsonPath().getList("completed").forEach(status -> 
            Assert.assertTrue((Boolean) status)
        );
    }

    @When("I fetch details for todo with ID {string}")
    public void i_fetch_details_for_todo_with_id(String id) {
        response = todoApi.getTodoById(Integer.parseInt(id));
    }

    @Then("The response message should be {string}")
    public void the_response_message_should_be(String message) {
        Assert.assertEquals(response.jsonPath().getString("message"), message);
    }
}

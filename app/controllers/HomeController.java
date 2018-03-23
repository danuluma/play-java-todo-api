package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Task;
import play.Logger;
import play.api.data.Form;
import play.data.DynamicForm;
import play.libs.Json;
import play.mvc.*;
import java.util.HashMap;
import java.util.Map;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */

public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        Logger.info("Loading the index page");
        return ok(views.html.index.render());
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result createTask() {
        Map<String, String> result = new HashMap<>();

        JsonNode json = request().body().asJson();
        if (json == null) {
            result.put("code", "201");
            result.put("message", "Error occurred, Json request body expected");
            return ok(Json.toJson(result));
        } else {
            String name = json.findPath("name").textValue();
            String description = json.findPath("description").textValue();
            if (name == null) {
                //return badRequest("Missing parameter [name]");
                result.put("code", "201");
                result.put("message", "Error occurred, Missing parameter [name]");
                return ok(Json.toJson(result));
            }
            if (description == null) {
                //return badRequest("Missing parameter [name]");
                result.put("code", "201");
                result.put("message", "Error occurred, Missing parameter [description]");
                return ok(Json.toJson(result));
            }

            Task task=new Task();
            task.name = name;
            task.description = description;

            result.put("code", "200");
            result.put("message", "Task added successfully!");
            return ok(Json.toJson(result));
        }
    }

    public Result updateTask(){
        return ok();
    }


    public Result fetchAllTasks(){
        return ok();
    }

    public Result deleteTask(){
        return ok();
    }

    //CAn BOB confirm that he s using ECB nad not CCB
}

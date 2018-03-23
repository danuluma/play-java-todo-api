package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Task;
import play.Logger;
import play.libs.Json;
import play.mvc.*;
import java.util.HashMap;
import java.util.List;
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
            task.save();

            result.put("code", "200");
            result.put("message", "Task added successfully!");
            return ok(Json.toJson(result));
        }
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result updateTask(){
        Map<String, String> result = new HashMap<>();
        JsonNode json = request().body().asJson();
        if (json == null) {
            result.put("code", "201");
            result.put("message", "Error occurred, Json request body expected");
            return ok(Json.toJson(result));
        } else {
            String id = json.findPath("id").textValue();
            String name = json.findPath("name").textValue();
            String description = json.findPath("description").textValue();
            if (id == null) {
                //return badRequest("Missing parameter [name]");
                result.put("code", "201");
                result.put("message", "Error occurred, Missing parameter [id]");
                return ok(Json.toJson(result));
            }

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

            Task task=Task.find.byId(Long.valueOf(id));
            if (task==null){
                result.put("code", "201");
                result.put("message", "Error occurred, Task of id "+id+" Not Found");
                return ok(Json.toJson(result));
            }

            task.name = name;
            task.description = description;
            task.update();
            result.put("code", "200");
            result.put("message", "Task updated successfully!");
            return ok(Json.toJson(result));
        }
    }


    /**
     *
     * @return
     */
    public Result fetchAllTasks(){
        List<Task> allTasks = Task.find.all();
        return ok(Json.toJson(allTasks));
    }

    public Result deleteTask(Long id){
        Map<String, String> result = new HashMap<>();
        Task task=Task.find.byId(Long.valueOf(id));
        if (task==null){
            result.put("code", "201");
            result.put("message", "Error occurred, Task of id "+id+" Not Found");
            return ok(Json.toJson(result));
        }
        task.delete();
        result.put("code", "200");
        result.put("message", "Task of id "+id+" removed successfully!");
        return ok(Json.toJson(result));
    }

    //Can BOB confirm that he is using ECB nad not CCB
}

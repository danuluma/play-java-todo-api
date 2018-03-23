package controllers;

import play.Logger;
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
        Logger.info("Loadng the index page");
        return ok(views.html.index.render());
    }

    public Result createUser(){
        Map<String,String> result=new HashMap<>();
        result.put("name","kibet");
        result.put("id","1");
        return ok(Json.toJson(result));
    }

}

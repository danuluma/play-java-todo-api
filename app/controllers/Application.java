package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public Result sayHelloTo(String name){
        return ok("Hello "+name);
    }


}

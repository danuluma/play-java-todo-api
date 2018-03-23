// @GENERATOR:play-routes-compiler
// @SOURCE:F:/play_java/java-todo-api/conf/routes
// @DATE:Fri Mar 23 18:51:59 EAT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def fetchAllTasks(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks")
    }
  
    // @LINE:12
    def deleteTask(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "delete_task/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:6
    def createTask(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "add_task")
    }
  
    // @LINE:11
    def updateTask(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "update_task")
    }
  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:16
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:8
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def sayHelloTo(name:String): Call = {
    
      (name: @unchecked) match {
      
        // @LINE:8
        case (name) if name == "Play Developer" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("name", "Play Developer"))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "hello")
      
        // @LINE:9
        case (name)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "hello/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
      
      }
    
    }
  
  }


}

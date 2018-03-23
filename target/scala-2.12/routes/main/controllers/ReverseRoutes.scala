// @GENERATOR:play-routes-compiler
// @SOURCE:F:/play_java/java-todo-api/conf/routes
// @DATE:Fri Mar 23 10:06:27 EAT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:7
    def createUser(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "create")
    }
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:9
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def sayHelloTo(name:String): Call = {
    
      (name: @unchecked) match {
      
        // @LINE:9
        case (name) if name == "Play Developer" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("name", "Play Developer"))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "hello")
      
        // @LINE:10
        case (name)  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "hello/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
      
      }
    
    }
  
  }


}

// @GENERATOR:play-routes-compiler
// @SOURCE:F:/play_java/java-todo-api/conf/routes
// @DATE:Fri Mar 23 14:19:57 EAT 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:11
    def fetchAllTasks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.fetchAllTasks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks"})
        }
      """
    )
  
    // @LINE:7
    def createTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.createTask",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "add_task"})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def sayHelloTo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.sayHelloTo",
      """
        function(name0) {
        
          if (name0 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("Play Developer") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hello"})
          }
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "hello/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0))})
          }
        
        }
      """
    )
  
  }


}

// @GENERATOR:play-routes-compiler
// @SOURCE:F:/play_java/java-todo-api/conf/routes
// @DATE:Fri Mar 23 12:46:01 EAT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}

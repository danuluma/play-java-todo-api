name := """java-todo-api"""
organization := "com.thecodevillage"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += guice

libraryDependencies += jdbc

libraryDependencies += "com.h2database" % "h2" % "1.4.196"

libraryDependencies +=   "mysql" % "mysql-connector-java" % "5.1.27"






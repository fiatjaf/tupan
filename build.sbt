enablePlugins(ScalaJSPlugin)

name := "tupan"
scalaVersion := "3.1.1"

scalaJSUseMainModuleInitializer := true

libraryDependencies ++= Seq(
  "io.circe" %%% "circe-core" % "0.14.1",
  "io.circe" %%% "circe-generic" % "0.14.1",
  "io.circe" %%% "circe-parser" % "0.14.1",
  "com.raquo" %%% "laminar" % "0.14.2",
  "com.lihaoyi" %%% "upickle" % "1.6.0",
  "org.scala-js" %%% "scala-js-macrotask-executor" % "1.0.0"
)

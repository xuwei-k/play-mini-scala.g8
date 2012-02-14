import sbt._
import Keys._

object MinimalBuild extends Build {
  
  lazy val buildVersion =  "$play_mini_version$"
  
  lazy val typesafe = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  lazy val typesafeSnapshot = "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"

  lazy val repo = if (buildVersion.endsWith("SNAPSHOT")) typesafeSnapshot else typesafe  

  lazy val root = Project(id = "$application_name$", base = file("."), settings = Project.defaultSettings).settings(
    version := buildVersion,
    organization := "$organization$",
    resolvers += repo,
    libraryDependencies += "com.typesafe" %% "play-mini" % buildVersion,
    mainClass in (Compile, run) := Some("play.core.server.NettyServer")
  )
}

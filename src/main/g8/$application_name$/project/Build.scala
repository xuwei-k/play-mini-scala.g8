import sbt._
import Keys._

object MinimalBuild extends Build {

  lazy val buildVersion =  "$play_mini_version$"
  
  lazy val typesafe = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  lazy val typesafeSnapshot = "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"

  lazy val root = Project(id = "$application_name$", base = file("."), settings = Project.defaultSettings).settings(
    version := buildVersion,
    organization := "$organization$",
    resolvers += typesafe,
    resolvers += typesafeSnapshot,
    libraryDependencies += "com.typesafe" %% "play-mini" % buildVersion,
    mainClass in (Compile, run) := Some("play.core.server.NettyServer")
  ).settings(seq(AssemblyKeys.assemblySettings: _*))
}

import sbt._
import Keys._
import sbtassembly.Plugin._
import AssemblyKeys._

object MinimalBuild extends Build {

  lazy val buildVersion =  "$play_mini_version$"
  
  lazy val typesafe = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  lazy val typesafeSnapshot = "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
  val netty = Some("play.core.server.NettyServer") 
  lazy val root = Project(id = "$application_name$", base = file("."), settings = Project.defaultSettings ++ assemblySettings).settings(
    version := buildVersion,
    organization := "$organization$",
    resolvers += typesafe,
    resolvers += typesafeSnapshot,
    logManager <<= extraLoggers(com.typesafe.util.Sbt.logger),
    libraryDependencies += "com.typesafe" %% "play-mini" % buildVersion,
    mainClass in (Compile, run) := netty,
    mainClass in assembly := netty,
    ivyXML := <dependencies> <exclude org="org.springframework"/> </dependencies>
  )
}

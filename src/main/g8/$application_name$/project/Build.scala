import sbt._
import Keys._
import sbtassembly.Plugin._
import AssemblyKeys._

object MinimalBuild extends Build with ConfigureScalaBuild{

  lazy val root = scalaMiniProject("$organization$","$application_name$","$application_version$").settings(
     //custom settings come here ie 
     //libraryDependencies += "organization" %% "group.id" % "version"
    )
  
}

trait ConfigureScalaBuild {

  
  lazy val typesafe = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
  
  lazy val typesafeSnapshot = "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
  
  val netty = Some("play.core.server.NettyServer") 

  def scalaMiniProject(org: String, name: String, buildVersion: String, baseFile: java.io.File = file(".")) = Project(id = name, base = baseFile, settings = Project.defaultSettings ++ assemblySettings).settings(
    version := buildVersion,
    scalaVersion := "2.10.0",
    organization := org,
    resolvers += typesafe,
    resolvers += typesafeSnapshot,
    libraryDependencies += "com.typesafe" %% "play-mini" % "$play_mini_version$",
    mainClass in (Compile, run) := netty,
    mainClass in assembly := netty,
    ivyXML := <dependencies> <exclude org="org.springframework"/> </dependencies>
  )
}

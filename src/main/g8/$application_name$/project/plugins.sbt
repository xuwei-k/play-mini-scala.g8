addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.8.1")

addSbtPlugin("com.typesafe" % "play-plugins-logger" % "0.1")

logLevel := Level.Warn

resolvers += Resolver.url("sbt-plugin-releases",
  new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)


// resolvers += Resolver.url("scala-sbt-plugin-releases", url("https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)
// val url = "https://repo1.maven.org/maven2"

resolvers += "Maven Central" at "https://repo1.maven.org/maven2"
// resolvers += Resolver.url("maven-repo", url("https://repo1.maven.org/maven2/[organisation]/[module]/[module]_[revision]/[artifact]-[revision].[ext]"))
// resolvers += Resolver.url("maven-repo")(Patterns("[organisation]/[module]/[revision]/[artifact]-[revision].[ext]"))
// resolvers += Resolver.url("my-test-repo", url)( Patterns("[organisation]/[module]/[revision]/[artifact].[ext]") )

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.9.9") //2.6.25
addSbtPlugin("com.typesafe.play" % "sbt-twirl" % "1.5.2")
// addSbtPlugin("com.typesafe.play" % "twirl-api" % "1.6.8") //2.0.9
addSbtPlugin("com.github.sbt" % "sbt-multi-jvm" % "0.6.0")
addSbtPlugin("com.github.sbt" % "sbt-dynver" % "5.0.1")
//addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.18.0")
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.11.4")

// Dependencies graph plugin
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")


resolvers += "Maven Central" at "https://repo1.maven.org/maven2"
// resolvers += Resolver.url("maven-repo", url("https://repo1.maven.org/maven2/[organisation]/[module]/[module]_[revision]/[artifact]-[revision].[ext]"))
// resolvers += Resolver.url("maven-repo")(Patterns("[organisation]/[module]/[revision]/[artifact]-[revision].[ext]"))
// resolvers += Resolver.url("my-test-repo", url)( Patterns("[organisation]/[module]/[revision]/[artifact].[ext]") )

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.9.9") //2.6.25 | 2.8.22 | 2.9.9
addSbtPlugin("com.typesafe.play" % "sbt-twirl" % "1.6.10") //1.5.2 | 1.6.10
addSbtPlugin("com.github.sbt" % "sbt-multi-jvm" % "0.6.0")
addSbtPlugin("com.github.sbt" % "sbt-dynver" % "5.0.1")
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.11.4")
// addSbtPlugin("com.typesafe.play" % "twirl-api" % "1.6.10")
//addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.18.0")

// Dependencies graph plugin
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")

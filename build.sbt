
name := "playframework-test"

val akkaVersion = "2.7.1" //2.5.32 | 2.6.21 | 2.7.1 | 2.8.8
val akkaDiagnosticsVersion = "2.0.1"
val logbackClassicVersion = "1.2.13"
val scalaTestVersion = "3.2.19"
val playVersion = "2.7.9" //2.6.25 | 2.7.9 | 2.9.9
val twirlVersion = "1.6.10" //1.5.2 | 1.6.10

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-serialization-jackson" % akkaVersion,
  "com.typesafe.play" %% "play-guice" % playVersion,
  "com.typesafe.play" %% "play-ws" % "2.9.9",
  "com.typesafe.play" %% "play" % playVersion,
  "ch.qos.logback" % "logback-classic" % logbackClassicVersion,
  "org.slf4j" % "log4j-over-slf4j" % "2.0.17", //1.7.16 | 2.0.17
  "com.lightbend.akka" %% "akka-diagnostics" % akkaDiagnosticsVersion,
  "ch.epfl.scala" % "sbt-bloop_2.12_1.0" % "2.0.17",
  "org.scala-lang" % "scala-compiler" % "2.12.20",
  // "com.typesafe.play" % "sbt-twirl_2.12_1.0" % twirlVersion,
  // "com.typesafe.play" % "twirl-api_2.12" % twirlVersion,

//  Testing dependencies
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,
  "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion % Test,
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test
)

//resolvers := Seq()

lazy val projectSettings = Seq(
  ThisBuild / version := "1.0.0-SNAPSHOT",
  ThisBuild / scalaVersion := "2.13.17", //2.11.12 | 2.12.20 | 2.13.17
  //organisation := "org.xptm",
  Compile / scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlog-reflective-calls", "-Xlint"),
  Compile / javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation"),
  run / javaOptions ++= Seq("-Xms128m", "-Xmx1024m", "-Djava.library.path=./target/native"),
  run / fork := true,
  // disable parallel tests
  Test / parallelExecution := false
)

lazy val root = (project in file("."))
  .settings(
    projectSettings
  )
  .enablePlugins(PlayScala,JavaAppPackaging)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "org.xptm.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "org.xptm.binders._"

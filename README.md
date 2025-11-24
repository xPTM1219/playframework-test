# playframework-test

This project contains a simple Play project to learn about
Play's and Akka structure and dependencies.

## Notes

I manage to compile and run it using SBT `v1.9.9` and `v1.11.7`.

* Scala 2.13.17
* Java 17
* Akka 2.7.1
* Play 2.7.9

## Errors

I finally compiled!!!!!!! It seems that its missing the
`application.properties` file. This is where I stop.

```bash
application: application.conf: java.io.IOException: resource not found on classpath: application.conf, application.json: java.io.IOException: resource not found on classpath: application.json, application.properties: java.io.IOException: resource not found on classpath: application.properties
```

### Steps to reproduce

1. Delete the folder `~/.cache/coursier`
2. Run `sbt compile`
3. Run `sbt run`
4. The page is available in `localhost:9000`

### Twirl dependencies

Adding Twirl dependencies manually breaks the compilation.

```bash
"com.typesafe.play" % "sbt-twirl_2.12_1.0" % twirlVersion,
"com.typesafe.play" % "twirl-api_2.12" % twirlVersion,
```

Producting the following error:

```bash
[error] Modules were resolved with conflicting cross-version suffixes in ProjectRef(uri("file:/home/xptm/Programming/playframework-test/"), "root"):
[error]    org.scala-lang.modules:scala-xml _2.13, _2.12
[error]    com.typesafe.play:twirl-api _2.13, _2.12
[error]    org.scala-lang.modules:scala-parser-combinators _2.13, _2.12
[error] java.lang.RuntimeException: Conflicting cross-version suffixes in: org.scala-lang.modules:scala-xml, com.typesafe.play:twirl-api, org.scala-lang.modules:scala-parser-combinators
[error]         at scala.sys.package$.error(package.scala:30)
[error]         at sbt.librarymanagement.ConflictWarning$.processCrossVersioned(ConflictWarning.scala:39)
[error]         at sbt.librarymanagement.ConflictWarning$.apply(ConflictWarning.scala:19)
[error]         at sbt.Classpaths$.$anonfun$ivyBaseSettings$71(Defaults.scala:3294)
[error]         at scala.Function1.$anonfun$compose$1(Function1.scala:49)
[error]         at sbt.internal.util.$tilde$greater.$anonfun$$u2219$1(TypeFunctions.scala:63)
[error]         at sbt.std.Transform$$anon$4.work(Transform.scala:69)
[error]         at sbt.Execute.$anonfun$submit$2(Execute.scala:283)
[error]         at sbt.internal.util.ErrorHandling$.wideConvert(ErrorHandling.scala:24)
[error]         at sbt.Execute.work(Execute.scala:292)
[error]         at sbt.Execute.$anonfun$submit$1(Execute.scala:283)
[error]         at sbt.ConcurrentRestrictions$$anon$4.$anonfun$submitValid$1(ConcurrentRestrictions.scala:265)
[error]         at sbt.CompletionService$$anon$2.call(CompletionService.scala:65)
[error]         at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error]         at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:539)
[error]         at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[error]         at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
[error]         at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
[error]         at java.base/java.lang.Thread.run(Thread.java:840)
[error] (update) Conflicting cross-version suffixes in: org.scala-lang.modules:scala-xml, com.typesafe.play:twirl-api, org.scala-lang.modules:scala-parser-combinators
```

## Old Errors

> This are old errors, I'm leaving it for historic purposes.

```bash
* org.scala-lang.modules:scala-xml_2.12:2.3.0 (early-semver) is selected over {1.2.0, 1.1.1}
[error]             +- org.scala-lang:scala-compiler:2.12.20              (depends on 2.3.0)
[error]             +- com.typesafe.sbt:sbt-native-packager:1.3.20 (sbtVersion=1.0, scalaVersion=2.12) (depends on 1.1.1)
[error]             +- com.typesafe.play:twirl-api_2.12:1.4.2             (depends on 1.2.0)
```

### sbt-native-packager not found

I encountered the error below, the artifact does exists [here](https://repo1.maven.org/maven2/com/typesafe/play/sbt-plugin_2.12_1.0/2.9.9/)
, but the problem is that the compiler is not adding the correct name to the
files. For example, instead of looking for `sbt-plugin_2.12_1.0-2.9.9.pom` it
looks for `sbt-plugin-2.9.9.pom`, and of course it fails because there is no
file like this in the repo.

```bash
[error]   not found: https://repo1.maven.org/maven2/com/typesafe/play/sbt-plugin_2.12_1.0/2.9.9/sbt-plugin-2.9.9.pom
```

I have opened an issue in `sbt-native-packager` Github to see if someone helps.
I think think the issue is because I don't have specific resovers to add the
correct name but I'm not sure.

[Issue opened in Github](https://github.com/sbt/sbt-native-packager/issues/1732)

I tried using the resolvers format and it doesn't work.

[SBT resolvers](https://www.scala-sbt.org/1.x/docs/Resolvers.html)

I'm thinking in downloading and adding the artifacts manually.
I also updated the pom file in order to pull the correct one.
`vim repo.scala-sbt.org/scalasbt/sbt-plugin-releases/com.typesafe.play/sbt-plugin/scala_2.12/sbt_1.0/2.7.9/ivys/ivy.xml`

Posted solution to [Stackoverflow](https://stackoverflow.com/questions/79828037/sbt-native-packager-not-found-when-compiling)

## Resources

* [Play v2.5.19 docs](https://www.playframework.com/documentation/2.5.x/Home)
* [Play v2.7.9 docs](https://www.playframework.com/documentation/2.7.x/Home)
* [Example projects](https://doc.akka.io/libraries/akka-core/current/project/examples.html)
* [Maven dependencies](https://repo1.maven.org/maven2/)

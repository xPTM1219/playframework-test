# playframework-test

This project contains a simple Play project to learn about
Play's and Akka structure.

## Notes

At the moment I had to use SBT v1.2.8 because Akka fails somehow.

* Scala 2.12.20
* Java 17
* Akka v2.5.32

## Errors

Amazing isn't xD

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

## Resources

* [Play v2.5.19 docs](https://www.playframework.com/documentation/2.5.x/Home)
* [Play v2.7.9 docs](https://www.playframework.com/documentation/2.7.x/Home)
* [Example projects](https://doc.akka.io/libraries/akka-core/current/project/examples.html)
* [Maven dependencies](https://repo1.maven.org/maven2/)

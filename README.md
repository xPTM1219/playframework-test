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

## Resources

* [Play v2.5.19 docs](https://www.playframework.com/documentation/2.5.x/Home)
* [Play v2.7.9 docs](https://www.playframework.com/documentation/2.7.x/Home)
* [Example projects](https://doc.akka.io/libraries/akka-core/current/project/examples.html)
* [Maven dependencies](https://repo1.maven.org/maven2/)

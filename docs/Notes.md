# Notes

This notes contains things encountered and reasons for fixes and decisions,
an Architecture Decision Record (ADR) basicslly.

## Pairing Play 2.7.9, Akka 2.6.21 and Java 21

There were 5 cascading issues, each unmasking the next:

| # | Problem | Fix |
|---|---------|-----|
| 1 | `sourceMapper` error — sbt plugin **2.6.25** dev-server code calling Play **2.7.9** runtime, which rejects `sourceMapper` | `project/plugins.sbt`: `sbt-plugin 2.6.25` → **2.7.9** (always match `playVersion` in `build.sbt`) |
| 2 | `resource not found on classpath: application.conf` — Play's layout reads resources from `conf/`, not `src/main/resources/` (your `.conf` files there are silently ignored) | Created `conf/application.conf` (minimal: `play.http.secret.key`) |
| 3 | Guice `Unable to load cache item` — generated `routes.java` compiled by JDK 21 to bytecode **v65**, unreadable by Guice 4.2's ASM; and shaded cglib needs `java.lang` opened on Java 16+ | `build.sbt`: added `javacOptions += "--release 8"`; created `.sbtopts` with `-J--add-opens=java.base/java.lang=ALL-UNNAMED` (dev server runs *inside* the sbt JVM, so `run / javaOptions` doesn't apply) |
| 4 | `ClassNotFoundException: sample.cluster.CborSerializable` — cluster serialization config referenced a class that only exists in the Akka cluster sample, not this app | Removed the akka cluster block from `conf/application.conf` (only keep it if you actually run the cluster sample) |
| 5 | Assets 500 — Play 2.7's `play.utils.Resources` uses internal `sun.net.www.protocol.file.FileURLConnection`, blocked on Java 17+ | `.sbtopts`: added `-J--add-exports=java.base/sun.net.www.protocol.file=ALL-UNNAMED` |

Verification: `home`/css/js/favicon all return **200**, log shows `Application started (Dev) (no global state)` with no errors.

Two notes:
- **slf4j mismatch**: I downgraded `log4j-over-slf4j` 2.0.17 → 1.7.36 in `build.sbt` — logback-classic 1.2.13 requires slf4j 1.7.x; with 2.x you get a silent NOP logger and no log output in the console.
- **Long term**: Play 2.7 predates Java 17/21 (officially supports 8/11). The `--add-opens`/`--add-exports` workarounds are fine for local learning, but if you later want zero JPMS flags, use Play 2.9.9 (the plugin/libs pair `2.9.9` you already listed, with sbt 1.11.7 and Java 21) or run sbt under JDK 11.

## 

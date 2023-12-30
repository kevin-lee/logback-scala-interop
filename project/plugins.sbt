logLevel := sbt.Level.Warn

addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.12")

val sbtDevOopsVersion = "3.0.0"
addSbtPlugin("io.kevinlee" % "sbt-devoops-java"      % sbtDevOopsVersion)
addSbtPlugin("io.kevinlee" % "sbt-devoops-sbt-extra" % sbtDevOopsVersion)
addSbtPlugin("io.kevinlee" % "sbt-devoops-github"    % sbtDevOopsVersion)

addSbtPlugin("io.kevinlee" % "sbt-devoops-starter"    % sbtDevOopsVersion)

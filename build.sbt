ThisBuild / scalaVersion := props.ProjectScalaVersion
ThisBuild / organization := "io.kevinlee"
ThisBuild / organizationName := "Kevin's Code"

ThisBuild / developers := List(
  Developer(
    props.GitHubUsername,
    "Kevin Lee",
    "kevin.code@kevinlee.io",
    url(s"https://github.com/${props.GitHubUsername}"),
  )
)
ThisBuild / homepage := url(s"https://github.com/${props.GitHubUsername}/${props.RepoName}").some
ThisBuild / scmInfo :=
  ScmInfo(
    browseUrl = url(s"https://github.com/${props.GitHubUsername}/${props.RepoName}"),
    connection = s"scm:git:git@github.com:${props.GitHubUsername}/${props.RepoName}.git",
  ).some

ThisBuild / licenses := props.licenses

ThisBuild / resolvers += "sonatype-snapshots" at s"https://${props.SonatypeCredentialHost}/content/repositories/snapshots"

lazy val logbackScalaInterop = (project in file("."))
  .enablePlugins(
    DevOopsJavaPlugin,
    DevOopsGitHubReleasePlugin,
  )
  .settings(
    name := props.ProjectName,
    javacOptions := Seq(
      "-source",
      javaVersion.value,
      "-encoding",
      "UTF-8",
    ),
    Compile / compile / javacOptions ++= Seq(
      "-target",
      javaVersion.value,
      "-Xlint:unchecked",
      "-g",
      "-deprecation",
    ),
    Compile / test / javacOptions := (Compile / compile / javacOptions).value,
    libraryDependencies ++= Seq(
      libs.logbackClassic
    ),
  )
  .settings(mavenCentralPublishSettings)

lazy val props =
  new {

    val GitHubUsername = "kevin-lee"
    val RepoName       = "logback-scala-interop"

    val ProjectName = RepoName

    final val ProjectScalaVersion = "2.13.11"

    lazy val licenses = List(License.MIT)

    val SonatypeCredentialHost = "s01.oss.sonatype.org"
    val SonatypeRepository     = s"https://$SonatypeCredentialHost/service/local"

    final val LogbackVersion = "1.5.11"
  }

lazy val libs = new {
  lazy val logbackClassic: ModuleID = "ch.qos.logback" % "logback-classic" % props.LogbackVersion

}

lazy val mavenCentralPublishSettings: SettingsDefinition = List(
  /* Publish to Maven Central { */
  sonatypeCredentialHost := props.SonatypeCredentialHost,
  sonatypeRepository := props.SonatypeRepository,
  /* } Publish to Maven Central */
)

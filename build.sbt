import scala.xml.transform.{RewriteRule, RuleTransformer}
import Dependencies._

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "org.sciscala"
ThisBuild / organizationName := "sciscala"

lazy val core = (project in file("core"))
  .settings(
    name := "simpledf-core",
    scalacOptions += "-Ymacro-annotations",
    resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    libraryDependencies += "org.typelevel" %% "simulacrum" % "1.0.0", // TODO: Move to simulacrum-scalafix
    libraryDependencies += "org.typelevel" %% "spire" % "0.17.0-M1",
    //libraryDependencies += "io.estatico" %% "newtype" % "0.4.4",
    libraryDependencies += scalaTest % Test
  )

lazy val arrow = (project in file("arrow"))
  .dependsOn(core)
  .settings(
    name := "simpledf-arrow",
    scalacOptions += "-Ymacro-annotations",
    libraryDependencies += "org.typelevel" %% "simulacrum" % "1.0.0", // TODO: Move to simulacrum-scalafix
    libraryDependencies += "org.typelevel" %% "spire" % "0.17.0-M1",
    libraryDependencies += "org.apache.arrow" % "arrow-vector" % "0.17.1",
    libraryDependencies += scalaTest % Test
  )

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:postfixOps",
  "-language:higherKinds",
  "-Ymacro-annotations"
)

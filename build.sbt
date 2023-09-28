name := "backendchallenge"

version := "0.0.1"

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.17" % Test
)

addCommandAlias(
  "format",
  ";scalafmtAll;scalafmtSbt"
)

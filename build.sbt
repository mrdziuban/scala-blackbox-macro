lazy val core = project.in(file("core"))
  .settings(name := "core", scalaVersion := "2.12.6")
  .dependsOn(csvInstances)
  .aggregate(csvInstances)

lazy val csvInstances = project.in(file("csv-instances"))
  .settings(name := "csv-instances", scalaVersion := "2.12.6")
  .dependsOn(macros)
  .aggregate(macros)

lazy val macros = project.in(file("macros"))
  .settings(
    name := "macros",
    scalaVersion := "2.12.6",
    libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.12.6"
  )

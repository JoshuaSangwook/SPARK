
lazy val commonSettings = Seq(
  organization := "io.joon",
  version := "1.0.0",
  scalaVersion := "2.11.11"
)

lazy val app = (project in file("."))
  .settings(
    commonSettings,
    name := "SparkML9ex",
    artifactName := { (sv: ScalaVersion, module: ModuleID, artifact: Artifact) =>
      artifact.name + "." + artifact.extension
    },
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-sql" % "2.2.1",
      "org.apache.spark" %% "spark-hive" % "2.2.1",
      "org.apache.spark" %% "spark-core" % "2.2.1",
      "org.apache.spark" %% "spark-mllib" % "2.2.1",
      "org.apache.spark" %% "spark-streaming-kafka-0-8" % "2.2.1",
      //"org.apache.kafka" %% "kafka" % "1.0.0",
    )
  )
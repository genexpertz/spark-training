name := "learning-spark-mini-example"
version := "0.0.1"
scalaVersion := "2.10.4"
// additional libraries
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core_2.11" % "1.6.1" % "provided"
)
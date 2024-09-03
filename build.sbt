scalaVersion := "3.5.1-RC2"

scalacOptions += "-deprecation"

TaskKey[Unit]("warningsReviewdogDiagnosticFormat") := {
  import warning_diff.JsonClassOps.*
  val json = warning_diff.rdf.DiagnosticResult.fromWarnings(
    warningsAll.value.distinct
  ).toJsonString
  println(json)
  IO.write(file("warnings.json"), json)
}
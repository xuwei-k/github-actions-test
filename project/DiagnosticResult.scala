package warning_diff.rdf

import sjsonnew.BasicJsonProtocol.*
import sjsonnew.JsonFormat

case class DiagnosticResult(
  diagnostics: Seq[Diagnostic],
  source: Option[Source]
)

object DiagnosticResult {
  def fromWarnings(values: Seq[warning_diff.Warning]): DiagnosticResult =
    DiagnosticResult(
      diagnostics = values.map { w =>
        Diagnostic(
          message = w.message,
          location = Location(
            path = {
              val prefix = "${BASE}"
              w.position.sourcePath match {
                case Some(value) =>
                  if (value.startsWith(prefix) ) {
                    value.drop(prefix.length)
                  } else {
                    value
                  }
                case None =>
                  ""
              }
            },
            range = Range(
              line = w.position.line,
              column = w.position.startColumn
            )
          ),
          severity = Some(Severity.Warning)
        )
      },
      source = Some(
        Source(
          name = "Scala"
        )
      )
    )

  implicit val instance: JsonFormat[DiagnosticResult] =
    caseClass2(apply, unapply)(
      "diagnostics",
      "source"
    )
}

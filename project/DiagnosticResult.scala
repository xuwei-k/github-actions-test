package warning_diff.rdf

import sjsonnew.BasicJsonProtocol.*
import sjsonnew.JsonFormat
import java.io.File

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
              val prefix = "${BASE}/"
              w.position.sourcePath match {
                case Some(value) =>
                  // val dir = new File(".").getCanonicalPath
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
              start = Position(
                line = w.position.startLine,
                column = w.position.startColumn
              ),
              end = Position(
                line = w.position.endLine,
                column = w.position.endColumn
              )
            )
          ),
          severity = None
        )
      },
      source = None
    )

  implicit val instance: JsonFormat[DiagnosticResult] =
    caseClass2(apply, unapply)(
      "diagnostics",
      "source"
    )
}

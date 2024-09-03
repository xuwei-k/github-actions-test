package warning_diff.rdf

import sjsonnew.BasicJsonProtocol._
import sjsonnew.JsonFormat
import warning_diff.JsonClassOps._

case class Diagnostic(
  message: String,
  location: Location,
  severity: Option[String]
) {
  override def toString = this.toJsonString
}

object Diagnostic {
  implicit val instance: JsonFormat[Diagnostic] =
    caseClass3(apply, unapply)(
      "message",
      "location",
      "severity"
    )
}

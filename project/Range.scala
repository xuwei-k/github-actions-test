package warning_diff.rdf

import sjsonnew.BasicJsonProtocol.*
import sjsonnew.JsonFormat

case class Range(
    start: Position,
    end: Position,
)

object Range {
  implicit val instance: JsonFormat[Range] =
    caseClass2(apply, unapply)(
      "start",
      "end"
    )
}

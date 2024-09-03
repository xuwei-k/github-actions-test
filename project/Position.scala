package warning_diff.rdf

import sjsonnew.BasicJsonProtocol._
import sjsonnew.JsonFormat

case class Position(
  line: Option[Int],
  column: Option[Int]
)

object Position{
  implicit val instance: JsonFormat[Position] =
    caseClass2(apply, unapply)(
      "line",
      "column"
    )
}

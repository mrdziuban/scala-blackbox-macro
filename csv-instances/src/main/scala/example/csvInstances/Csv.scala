package example.csvInstances

import example.macros.{Csv, CsvMacro}
import scala.language.experimental.macros

object csv {
  implicit def deriveCsv[A]: Csv[A] = macro CsvMacro.deriveImpl[A]

  implicit val csvStr: Csv[String] = s => List(s)
}

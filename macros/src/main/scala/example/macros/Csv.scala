package example.macros

trait Csv[A] { def apply(a: A): List[String] }

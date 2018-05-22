package example.macros

import scala.reflect.macros.blackbox.Context

object CsvMacro {
  def deriveImpl[A: c.WeakTypeTag](c: Context): c.Expr[Csv[A]] = {
    import c.universe._

    val tpe = c.weakTypeOf[A]

    val accumulated = tpe.decls.collect {
      case m: MethodSymbol if m.isCaseAccessor =>
        q"implicitly[_root_.example.macros.Csv[${m.returnType.asSeenFrom(tpe, tpe.typeSymbol)}]].apply(x.${m.name})"
    }.foldLeft(q"List[String]()")((acc, x) => q"$acc ++ $x")

    c.Expr[Csv[A]](q"new _root_.example.macros.Csv[$tpe] { def apply(x: $tpe): List[String] = $accumulated }")
  }
}

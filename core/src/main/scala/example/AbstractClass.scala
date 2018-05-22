package example

import example.macros.Csv

abstract class AbstractClass[A]()(implicit ca: Csv[A])

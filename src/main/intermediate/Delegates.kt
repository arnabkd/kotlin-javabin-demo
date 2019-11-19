package main.intermediate

interface Printer {
  fun print(s: String)
}
interface Copier {
  fun copy(s: String): String
}

class DefaultPrinter: Printer {
  override fun print(s: String) = println(s)
}

class DefaultCopier: Copier {
  override fun copy(s: String) = String(s.toCharArray())
}

data class PrinterCopier(
  val printer: Printer,
  val copier: Copier
): Printer by printer, Copier by copier

fun main() {
  val printerCopier = PrinterCopier(DefaultPrinter(), DefaultCopier())
  val copy = printerCopier.copy("test")
  printerCopier.print("testString")
}

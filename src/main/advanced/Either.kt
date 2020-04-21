package main.advanced

import arrow.core.left
import arrow.core.right
import java.lang.IllegalArgumentException

// Is this really an Int?
fun divide(x: Int, y: Int) = x / y

// Partial returns
fun dividePartial(x: Int, y: Int) = when (y) {
    0 -> IllegalArgumentException("not divisible by 0").left()
    else -> (x/y).right()
}

fun divideAndPrintResult(x: Int, y: Int) =
  dividePartial(x, y).fold({
    println("Error: ${it.message}")
  }, {
    println("Success: the result of the division is $it")
  })

fun main() {
  divideAndPrintResult(10, 0)
  divideAndPrintResult(4,2)
}

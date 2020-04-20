package main.beginner

// Scope functions are temporary scope variables.
// with, let, run, also, apply
// Their main two differences:
// - how the variable is referred to
// - the return value
// Read more at https://kotlinlang.org/docs/reference/scope-functions.html

fun letExample() {
  val result = AmountUSD(10).let {
    val conversionRate = getConversionRate()
    AmountNok(it.amount * conversionRate)
  }
  println(result)
}

fun runExample() {
  val result = AmountNok(100).run {
    println(this.amount) // print the amount of NOK.
    // This just returns Unit
  }
}

fun getConversionRate() = 12
class AmountUSD(val amount: Int)
class AmountNok(val amount: Int)

fun alsoExample() {
  getSomeValue().also {
    println("the result is $it")
  }
}

fun getSomeValue() = 42

fun main() {
  letExample()
  runExample()
  alsoExample()
}

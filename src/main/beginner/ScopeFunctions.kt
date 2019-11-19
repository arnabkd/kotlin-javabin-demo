package main.beginner

// Scope functions are temporary scope variables.
// with, let, run, also, apply
// Their main two differences:
// - how the variable is referred to
// - the return value

fun letExample() {
  val result = "str".let {
    print(it) // Receiver
    print(it) // Argument
    42 // Block return value
  }
}

fun runExample() {
  val result = "str".run {
    print(this) // Receiver
    print(this) // Argument
    42 // Block return value
  }
}

fun alsoExample() {
  val result = "str".also {
    print(it) // Receiver
    print(it) // Argument
    42
  }
}

fun main() {
  letExample()
  runExample()
  alsoExample()
}

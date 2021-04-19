package main.advanced

import kotlin.properties.Delegates

/*fun main() {

  // Use for computed properties
  val lazyValue: String by lazy {
    println("computed!")
    "Hello"
  }
  println(lazyValue) // prints "computed" and then "Hello"
  println(lazyValue) // just prints "Hello"

  // Vetoable uses a beforeCheck before changing the value
  // Useful for safeguards
  var someonesAge: Int by Delegates.vetoable(0) {
      // change only if this check passes
      _, oldValue, newValue -> newValue > oldValue
  }
  println(someonesAge) // 0
  someonesAge = 10
  println(someonesAge) // 10
  someonesAge = 5 // will not change anything
  println(someonesAge) // 10

  // Observable has an afterCheck
  // Useful for notifying others of changes made to a variable
  var name: String by Delegates.observable("unnamed") {
      prop, old, new ->
    println("$old -> $new") // can be used to notify others with this afterCheck
  }
  name = "Tom" // unnamed -> Tom
  name = "Tom Tomson" // Tom -> Tom Tomson

}*/

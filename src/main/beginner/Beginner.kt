package main.beginner

// Regular class
class SimplePerson(val name: String, val age: Int)

// Data class, with equals, hashCode, toString, destructuring and copy function
data class Person(val firstName: String, val lastName: String, val age: Int)

// Extension function
fun Person.toDescriptiveString() = "$firstName is $age years old"

fun main() {
  val immutableVal = 10
  // immutableVal = 11 // compile error

  var mutableVar = 10
  mutableVar = 11

  // Built in type-safety that takes care of nulls
  val nullablePerson: Person? = null
  //val person2: Person = null // compile error

  val dave = Person("Dave", "Davidson", 20)
  val john = Person("John", "Johnson", 30)
  //val person4 = main.beginner.main.beginner.Person(null, 35) // compile error

  println(dave.toDescriptiveString())
  println(john.toDescriptiveString())

  Person("Dave", "Davidson", 20).toDescriptiveString()
}

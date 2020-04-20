package main.beginner

// Regular class
class SimplePerson(val name: String, val age: Int)

// Data class, with equals, hashCode, toString, destructuring and copy function
data class Person(val firstName: String, val lastName: String, val age: Int)

// Extension function
fun Person.toDescriptiveString() = "$firstName is $age years old"

fun printNameOfPerson(person: Person) {
  // This will always be true, and the compiler knows it, so it warns you
  if (person != null) {
    println(person.firstName)
  }
}

fun printNameOfNullablePerson(person: Person?) {
  if (person != null) {
    // Compiler smartcasts from Person? to Person as person will never be null now
    println(person.firstName)
  }
}

fun printNameOfNullablePerson2(person: Person?) {
  // Safe call operator ?. avoids nullpointers
  // Null coalescing operator aka Elvis operator ?: provides a value if person is null
  println(person?.firstName ?: "person is null")
}

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

  // data classes have a human readable toString
  println(dave)
  // Person(firstName=Dave, lastName=Davidson, age=20)

  println(dave.toDescriptiveString())
  println(john.toDescriptiveString())

  Person("Dave", "Davidson", 20).toDescriptiveString()

  // data classes have destructuring
  listOf(dave, john).forEach { (firstName, _, age) ->
    println("firstName: $firstName, age: $age, ignoring lastName")
  }

  // data classes treat equals differently
  val equalsWithDataClass =
    Person("A", "A", 10) == Person("A", "A", 10)
  println(equalsWithDataClass) // true, since all values are equal

  val equalsWithRegularClass =
    SimplePerson("A", 10) == SimplePerson("A", 10)
  println(equalsWithRegularClass) // false, since this is not the same object
}

package main.advanced

import main.intermediate.Person

typealias PersonCheck = (Person) -> Boolean
infix fun PersonCheck.and(that: PersonCheck): PersonCheck = { it: Person ->
  this(it) && that(it)
}
infix fun PersonCheck.or(that: PersonCheck): PersonCheck = {
  this(it) or that(it)
}

fun main() {
  val canVote = { it: Person -> it.age > 18 }
  val overThirty = { it: Person -> it.age >= 30 }
  val overThirtyCanVote = canVote and overThirty

  val tom = Person("Tom", 20)
  println("Can tom vote? ${canVote(tom)}") // true
  println("Is tom over thirty AND can vote? ${overThirtyCanVote(tom)}") // false

  // Lets say we only want to look at people over 40 and people under 20 for some reason
  val underTwenty = { it: Person -> it.age < 20 }
  val overForty = { it: Person -> it.age > 40 }
  val isInAgerange = underTwenty or overForty
  println("Is Tom in our age range? ${isInAgerange(tom)}")
}

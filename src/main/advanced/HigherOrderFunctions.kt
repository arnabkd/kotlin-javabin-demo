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
  println(canVote(tom)) // true
  println(overThirtyCanVote(tom)) // false
}

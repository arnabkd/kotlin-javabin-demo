package main.intermediate

import java.time.LocalDate

sealed class Entity {
  abstract val name: String
  abstract val age: Int
}

data class Person(override val name: String, override val age: Int): Entity()
data class DeadPerson(
  override val name: String,
  override val age: Int,
  val deathDate: LocalDate
): Entity()

// This would introduce a compile error
// data class Cat(override val name: String, override val age: Int): Entity()

fun typeDescription(entity: Entity) = when(entity) {
  is Person -> "Live person"
  is DeadPerson -> "Dead person"
}

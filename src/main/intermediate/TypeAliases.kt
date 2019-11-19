package main.intermediate

import java.time.LocalDate

typealias PersonList = List<Person>
typealias DeadPersonList = List<DeadPerson>

// Extension functions on PersonLists
fun PersonList.printNames() = forEach {
  println(it.name)
}

fun DeadPersonList.printDeathDates() = forEach {
  println(it.deathDate)
}

fun main() {
  listOf(
    Person("Dave", 30),
    Person("John", 40)
  ).printNames()

  listOf(
    DeadPerson("Edison", 84, LocalDate.of(1931, 10, 18))
  ).printDeathDates()
}

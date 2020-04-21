package main.advanced

import main.intermediate.Person

typealias Transform<A, B> = (A) -> B

/**
 * This is a demonstration of how to set up a pipeline which ensures that we cannot skip any steps.
 * Useful for instance when you want all requests to be filtered for say GeoIP, then auth checked
 * and so on.
 */
fun <A, B, C, D> combine(
  f: (A) -> B,
  g: (B) -> C,
  h: (C) -> D
): Transform<A, D> = { x ->
  h(g(f(x)))
}

sealed class Student {
  abstract val person: Person // A
}

// B
data class KindergartenStudent(override val person: Person) : Student()

// C
data class PrimarySchoolStudent(override val person: Person) : Student()

// D
data class HighschoolStudent(override val person: Person) : Student()

fun startKindergarten(person: Person) = KindergartenStudent(person)

fun graduateToMiddleSchool(student: KindergartenStudent) = PrimarySchoolStudent(student.person)

fun graduateToHighSchool(student: PrimarySchoolStudent) = HighschoolStudent(student.person)

fun main() {
  val child = Person("Tom", 3)
  // A -> B -> C -> D
  combine(
    ::startKindergarten,
    ::graduateToMiddleSchool,
    ::graduateToHighSchool
  )(child)
    .let {
      println("${it.person.name} is now a highschool student")
    }

  /* The following is a compile error because of type incompatibility
  combine(
    ::startKindergarten,
    ::graduateToHighSchool,
    ::graduateToMiddleSchool
  )(child)
    .let {
      println("${it.person.name} is now a highschool student")
    } */
}

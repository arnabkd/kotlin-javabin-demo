package main.intermediate

fun addEmployee(input: Person?) {
  require(input!=null) // throws IllegalArgument
  println("adding employee ${input.name}")
}

fun addEmployeeWithCheck(input: Person) {
  val canAddEmployees = false
  check(canAddEmployees) // throws IllegalState
  println("adding employee ${input.name}")
}


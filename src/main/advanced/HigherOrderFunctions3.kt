package main.advanced

import main.intermediate.Person

typealias Transform<A, B> = (A) -> B

fun <A, B, C> transform(
  f: Transform<A, B>,
  g: Transform<B, C>
): Transform<A, C> = { x ->
  g(f(x))
}

sealed class Request {
  abstract val client: Person
}

data class InitialRequest(override val client: Person) : Request()
data class ApprovedRequest(override val client: Person) : Request()
data class FinishedRequest(override val client: Person) : Request() {
  val finalMessage = "Request for ${client.name} completed!"
}

fun initialize(client: Person): InitialRequest {
  println("initializing")
  return InitialRequest(client)
}

fun approve(input: InitialRequest): ApprovedRequest {
  println("Approving the request")
  return ApprovedRequest(input.client)
}

fun finish(input: ApprovedRequest): FinishedRequest {
  println("Finishing up..")
  return FinishedRequest(input.client)
}


fun main() {
  val client = Person("Dave", 30)

  // first initialize, then approve, then finish (in that order), and finally print the final message
  // Person -> InitialRequest -> ApprovedRequest -> FinishedRequest
  // Before the order is finished
  val pre = transform(::initialize, ::approve)
  // After the order is finished
  val post = transform(
    {it: FinishedRequest -> it.finalMessage},
    {println(it)}
  )

  val pipeline = transform(pre, transform(::finish, post))
  pipeline(client)

  // Doing them in the wrong order causes a compile error!
  // Why? Because transform expects ((A)->B, (B)->C) but gets ((A)->B, (C)->D)
  // transform(::initialize, ::finish)
}

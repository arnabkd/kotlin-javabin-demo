package main.advanced

typealias GenericOperation<A> = (A) -> A
fun <A>compose(
  vararg ops: GenericOperation<A>
): GenericOperation<A> =  { it ->
  var result = it
  ops.forEach { op ->
    result = op(result)
  }
  result
}

fun <A>GenericOperation<A>.repeat(times: Int) =
  (1..times)
    .map{ this }
    .toTypedArray()
    .let {
      compose(*it)
    }

infix fun <A>Int.times(op: GenericOperation<A>) = op.repeat(this)

fun double(x: Int) = x + x
fun square(x: Int) = x * x

fun main() {
  val doubleAndSquare = compose(::double, ::square)
  println(doubleAndSquare(1))

  val doubleThrice = compose(::double, ::double, ::double)
  println(doubleThrice(1))


  val doubleEightTimes = ::double.repeat(8)
  println(doubleEightTimes(1)) // 256

  val doubleEightTimesAnotherWay = 8.times(::double)
  println(doubleEightTimesAnotherWay(1))
}

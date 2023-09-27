package chapter04.sec02

sealed class List<out A>

private fun <A> length(xs: List<A>): Int = TODO()

private fun List<Double>.sum(): Double = TODO()

private fun List<Double>.isEmpty(): Boolean = TODO()

fun <A> List<A>.size(): Int = TODO()

val listing1 = {
  fun mean(xs: List<Double>): Double =
    if (xs.isEmpty())
      throw ArithmeticException("mean of empty list!")
    else xs.sum() / length(xs)
}

val listing2 = {
  fun mean(xs: List<Double>, onEmpty: Double) =
    if (xs.isEmpty()) onEmpty
    else xs.sum() / xs.size()
}

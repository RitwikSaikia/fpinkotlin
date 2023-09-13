package chapter03.sec02

import kotlin.random.Random

sealed class List<out A> {

  companion object {
    fun <A> of(vararg aa: A): List<A> {
      val tail = aa.sliceArray(1 until aa.size)
      return if (aa.isEmpty())
        Nil
      else
        Cons(aa[0], of(*tail))
    }

    fun sum(ints: List<Int>): Int =
      when (ints) {
        is Nil -> 0
        is Cons -> ints.head + sum(ints.tail)
      }

    fun product(doubles: List<Double>): Double =
      when (doubles) {
        is Nil -> 1.0
        is Cons ->
          if (doubles.head == 0.0)
            0.0
          else
            doubles.head * product(doubles.tail)
      }
  }
}

data object Nil : List<Nothing>()

data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()

fun <A> of(vararg aa: A): List<A> {
  val tail = aa.sliceArray(1 until aa.size)
  return if (aa.isEmpty())
    Nil
  else
    Cons(aa[0], List.of(*tail))
}

val ints = List.of(1, 2, 3, 4)

fun sum(xs: List<Int>): Int =
  when (xs) {
    is Nil -> 0
    is Cons -> xs.head + sum(xs.tail)
  }

fun main() = sum(ints)

val listing35 = {

  val x = Random.nextInt(-10, 10)
  val y: String =
    if (x == 0)
      "x is zero"
    else if (x < 0)
      "x is negative"
    else
      "x is positive"
}

val listing36 = {
  val x = Random.nextInt(-10, 10)
  val y: String =
    when {
      x == 0 -> "x is zero"
      x < 0 -> "x is negative"
      else -> "x is positive"
    }
}

val listing37 = {
  fun sum(xs: List<Int>): Int =
    when (xs) {
      is Nil -> 0
      is Cons -> xs.head + sum(xs.tail)
    }
}

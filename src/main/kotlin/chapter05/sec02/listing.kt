package chapter05.sec02

import chapter04.None
import chapter04.Option
import chapter04.Some

sealed class Stream<out A>

data class Cons<out A>(
  val head: () -> A,
  val tail: () -> Stream<A>
) : Stream<A>()

object Empty : Stream<Nothing>()

fun <A> Stream<A>.headOption(): Option<A> =
  when (this) {
    is Empty -> None
    is Cons -> Some(head())
  }

val tl: Stream<String> = TODO()

fun expensive(c: String): String = TODO()
val y: String = TODO()

val x = Cons({ expensive(y) }, { tl })
val h1 = x.headOption()
val h2 = x.headOption()

fun <A> cons(hd: () -> A, tl: () -> Stream<A>): Stream<A> {
  val head: A by lazy(hd)
  val tail: Stream<A> by lazy(tl)
  return Cons({ head }, { tail })
}

fun <A> empty(): Stream<A> = Empty

fun <A> of(vararg xs: A): Stream<A> =
  if (xs.isEmpty()) empty()
  else cons({ xs[0] }) {
    of(*xs.sliceArray(1 until xs.size))
  }

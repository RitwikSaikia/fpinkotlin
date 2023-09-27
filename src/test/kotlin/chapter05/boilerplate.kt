package chapter05

import chapter03.List
import chapter03.reverse
import chapter04.*
import chapter03.Cons as ConsL
import chapter03.Nil as NilL

fun <A> Stream<A>.toList(): List<A> {
  tailrec fun go(xs: Stream<A>, acc: List<A>): List<A> = when (xs) {
    is Empty -> acc
    is Cons -> go(xs.tail(), ConsL(xs.head(), acc))
  }
  return reverse(go(this, NilL))
}

fun <A> Stream<A>.take(n: Int): Stream<A> =
  Stream.unfold(this) { s: Stream<A> ->
    when (s) {
      is Cons ->
        if (n > 0)
          Some(s.head() to s.tail().take(n - 1))
        else None

      else -> None
    }
  }

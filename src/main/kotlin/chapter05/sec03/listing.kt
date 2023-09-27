package chapter05.sec03

import chapter03.List
import chapter04.*
import chapter03.Cons as ConsL
import chapter03.Nil as NilL

fun <A, B> Stream<A>.map(f: (A) -> B): Stream<B> = TODO()

fun <A> Stream<A>.filter(f: (A) -> Boolean): Stream<A> = TODO()

fun <A> Stream<A>.toList(): List<A> = TODO()

fun <A> Stream<A>.headOption(): Option<A> = TODO()

sealed class Stream<out A> {

  companion object {
    fun <A> cons(hd: () -> A, tl: () -> Stream<A>): Stream<A> {
      val head: A by lazy(hd)
      val tail: Stream<A> by lazy(tl)
      return Cons({ head }, { tail })
    }

    fun <A> of(vararg xs: A): Stream<A> =
      if (xs.isEmpty()) empty()
      else cons(
        { xs[0] },
        { of(*xs.sliceArray(1 until xs.size)) }
      )

    fun <A> empty(): Stream<A> = Empty
  }

  fun exists(p: (A) -> Boolean): Boolean =
    when (this) {
      is Cons -> p(this.head()) || this.tail().exists(p)
      else -> false
    }

  fun <B> foldRight(
    z: () -> B,
    f: (A, () -> B) -> B
  ): B =
    when (this) {
      is Cons -> f(this.head()) {
        tail().foldRight(z, f)
      }

      is Empty -> z()
    }

  fun exists2(p: (A) -> Boolean): Boolean =
    foldRight({ false }, { a, b -> p(a) || b() })

  fun find(p: (A) -> Boolean): Option<A> =
    filter(p).headOption()
}

data class Cons<out A>(
  val head: () -> A,
  val tail: () -> Stream<A>
) : Stream<A>()

object Empty : Stream<Nothing>()

val trace = {
  Stream.of(1, 2, 3, 4).map { it + 10 }
    .filter { it % 2 == 0 }
    .map { it * 3 }.toList()

  Stream.cons({ 11 }, { Stream.of(2, 3, 4).map { it + 10 } })
    .filter { it % 2 == 0 }
    .map { it * 3 }.toList()

  Stream.of(2, 3, 4).map { it + 10 }
    .filter { it % 2 == 0 }
    .map { it * 3 }.toList()

  Stream.cons({ 12 }, { Stream.of(3, 4).map { it + 10 } })
    .filter { it % 2 == 0 }
    .map { it * 3 }.toList()

  ConsL(
    36,
    Stream.of(3, 4).map { it + 10 }
      .filter { it % 2 == 0 }
      .map { it * 3 }.toList()
  )

  ConsL(
    36,
    Stream.cons(
      { 13 },
      { Stream.of(4).map { it + 10 } }
    )
      .filter { it % 2 == 0 }
      .map { it * 3 }.toList()
  )

  ConsL(
    36,
    Stream.of(4).map { it + 10 }
      .filter { it % 2 == 0 }
      .map { it * 3 }.toList()
  )

  ConsL(
    36,
    Stream.cons(
      { 14 },
      { Stream.empty<Int>().map { it + 10 } }
    )
      .filter { it % 2 == 0 }
      .map { it * 3 }.toList()
  )

  ConsL(
    36,
    ConsL(
      42,
      Stream.empty<Int>().map { it + 10 }
        .filter { it % 2 == 0 }
        .map { it * 3 }.toList()
    )
  )

  ConsL(36, ConsL(42, NilL))
}

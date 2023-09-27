package chapter04.ex05

import chapter03.Cons
import chapter03.List
import chapter03.Nil
import chapter04.*
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

class Exercise05 : WordSpec({

  fun <A, B> traverse(
    xa: List<A>,
    f: (A) -> Option<B>
  ): Option<List<B>> =
    when (xa) {
      is Nil -> Some(Nil)
      is Cons ->
        map2(f(xa.head), traverse(xa.tail, f)) { b, xb -> Cons(b, xb) }
    }

  fun <A> sequence(xs: List<Option<A>>): Option<List<A>> =
    traverse(xs) { it }

  fun <A> catches(a: () -> A): Option<A> =
    try {
      Some(a())
    } catch (e: Throwable) {
      None
    }

  "traverse" should {
    """return some option of a transformed list if all
      transformations succeed""" {
      val xa = List.of(1, 2, 3, 4, 5)
      traverse(xa) { a: Int ->
        catches { a.toString() }
      } shouldBe Some(
        List.of("1", "2", "3", "4", "5")
      )
    }

    "return a none option if any transformations fail" {
      val xa = List.of("1", "2", "x", "4")
      traverse(xa) { a ->
        catches { a.toInt() }
      } shouldBe None
    }
  }
})

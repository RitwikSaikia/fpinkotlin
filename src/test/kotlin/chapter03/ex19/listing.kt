package chapter03.ex19

import chapter03.Cons
import chapter03.List
import chapter03.ex13.append
import chapter03.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A, B> flatMap(xa: List<A>, f: (A) -> List<B>): List<B> =
  foldRight(
    xa,
    List.empty()
  ) { a, lb ->
    append(f(a), lb)
  }

fun <A, B> flatMap2(xa: List<A>, f: (A) -> List<B>): List<B> =
  foldRight(
    xa,
    List.empty()
  ) { a, xb ->
    foldRight(f(a), xb) { b, lb -> Cons(b, lb) }
  }

class Exercise19 : WordSpec({
  "list flatmap" should {
    "map and flatten a list" {
      val xs = List.of(1, 2, 3)
      flatMap(xs) { i -> List.of(i, i) } shouldBe
        List.of(1, 1, 2, 2, 3, 3)
    }
  }
})

package chapter03.ex18

import chapter03.Cons
import chapter03.List
import chapter03.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A> filter(xs: List<A>, f: (A) -> Boolean): List<A> =
  foldRight(xs, List.empty()) { x, acc ->
    if (f(x)) {
      Cons(x, acc)
    } else {
      acc
    }
  }

class Exercise18 : WordSpec({
  "list filter" should {
    "filter out elements not compliant to predicate" {
      val xs = List.of(1, 2, 3, 4, 5)
      filter(xs) { it % 2 == 0 } shouldBe List.of(2, 4)
    }
  }
})

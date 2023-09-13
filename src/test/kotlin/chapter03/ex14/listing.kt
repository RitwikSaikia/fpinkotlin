package chapter03.ex14

import chapter03.Cons
import chapter03.List
import chapter03.ex13.append
import chapter03.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A> concat(xxs: List<List<A>>): List<A> =
  foldRight(
    xxs,
    List.empty()
  ) { xs1: List<A>, xs2: List<A> ->
    foldRight(xs1, xs2) { a, ls -> Cons(a, ls) }
  }

fun <A> concat2(xxs: List<List<A>>): List<A> =
  foldRight(
    xxs,
    List.empty()
  ) { xs1, xs2 -> append(xs1, xs2) }

class Exercise14 : WordSpec({
  "list concat" should {
    "concat a list of lists into a single list" {
      concat(
        List.of(
          List.of(1, 2, 3),
          List.of(4, 5, 6)
        )
      ) shouldBe List.of(1, 2, 3, 4, 5, 6)

      concat2(
        List.of(
          List.of(1, 2, 3),
          List.of(4, 5, 6)
        )
      ) shouldBe List.of(1, 2, 3, 4, 5, 6)
    }
  }
})

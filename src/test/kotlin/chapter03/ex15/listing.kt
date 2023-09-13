package chapter03.ex15

import chapter03.Cons
import chapter03.List
import chapter03.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun increment(xs: List<Int>): List<Int> =
  foldRight(
    xs,
    List.empty()
  ) { i: Int, ls -> Cons(i + 1, ls) }

class Exercise15 : WordSpec({
  "list increment" should {
    "add 1 to every element" {
      increment(List.of(1, 2, 3, 4, 5)) shouldBe
        List.of(2, 3, 4, 5, 6)
    }
  }
})

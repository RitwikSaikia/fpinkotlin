package chapter03.ex16

import chapter03.Cons
import chapter03.List
import chapter03.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun doubleToString(xs: List<Double>): List<String> =
  foldRight(xs, List.empty()) { x, acc -> Cons(x.toString(), acc) }

class Exercise16 : WordSpec({
  "list doubleToString" should {
    "convert every double element to a string" {
      doubleToString(List.of(1.1, 1.2, 1.3, 1.4)) shouldBe
        List.of("1.1", "1.2", "1.3", "1.4")
    }
  }
})

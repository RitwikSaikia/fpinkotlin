package chapter03.ex08

import chapter03.List
import chapter03.Nil
import chapter03.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A> length(xs: List<A>): Int = foldRight(xs, 0) { _, acc -> acc + 1 }

class Exercise8 : WordSpec({
  "list length" should {
    "calculate the length" {
      length(List.of(1, 2, 3, 4, 5)) shouldBe 5
    }

    "calculate zero for an empty list" {
      length(Nil) shouldBe 0
    }
  }
})

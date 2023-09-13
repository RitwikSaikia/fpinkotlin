package chapter03.ex21

import chapter03.Cons
import chapter03.List
import chapter03.Nil
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun add(xa: List<Int>, xb: List<Int>): List<Int> =
  when (xa) {
    Nil -> Nil
    is Cons -> when (xb) {
      Nil -> Nil
      is Cons -> Cons(xa.head + xb.head, add(xa.tail, xb.tail))
    }
  }

class Exercise21 : WordSpec({
  "list add" should {
    "add elements of two corresponding lists" {
      add(List.of(1, 2, 3), List.of(4, 5, 6)) shouldBe
        List.of(5, 7, 9)
    }
  }
})

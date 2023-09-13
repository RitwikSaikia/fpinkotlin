package chapter03.ex13

import chapter03.Cons
import chapter03.List
import chapter03.ex11.reverse
import chapter03.foldLeft
import chapter03.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A> append(a1: List<A>, a2: List<A>): List<A> =
  foldRight(a1, a2) { x, y -> Cons(x, y) }

fun <A> appendL(a1: List<A>, a2: List<A>): List<A> =
  foldLeft(reverse(a1), a2) { y, x -> Cons(x, y) }

class Exercise13 : WordSpec({
  "list append" should {
    "append two lists to each other using foldRight" {
      append(
        List.of(1, 2, 3),
        List.of(4, 5, 6)
      ) shouldBe List.of(1, 2, 3, 4, 5, 6)
    }
  }

  "list appendL" should {
    "append two lists to each other using foldLeft" {
      appendL(
        List.of(1, 2, 3),
        List.of(4, 5, 6)
      ) shouldBe List.of(1, 2, 3, 4, 5, 6)
    }
  }
})

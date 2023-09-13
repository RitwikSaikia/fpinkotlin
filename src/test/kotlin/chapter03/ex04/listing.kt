package chapter03.ex04

import chapter03.Cons
import chapter03.List
import chapter03.Nil
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A> dropWhile(l: List<A>, f: (A) -> Boolean): List<A> = when (l) {
  is Nil -> Nil
  is Cons ->
    if (f(l.head)) dropWhile(l.tail, f) else l
}

class Exercise4 : WordSpec({
  "list dropWhile" should {
    "drop elements until predicate is no longer satisfied" {
      dropWhile(
        List.of(1, 2, 3, 4, 5)
      ) { it < 4 } shouldBe List.of(4, 5)
    }

    "drop no elements if predicate never satisfied" {
      dropWhile(
        List.of(1, 2, 3, 4, 5)
      ) { it == 100 } shouldBe List.of(1, 2, 3, 4, 5)
    }

    "drop all elements if predicate always satisfied" {
      dropWhile(
        List.of(1, 2, 3, 4, 5)
      ) { it < 100 } shouldBe List.of()
    }

    "return Nil if input is empty" {
      dropWhile(List.empty<Int>()) { it < 100 } shouldBe Nil
    }
  }
})

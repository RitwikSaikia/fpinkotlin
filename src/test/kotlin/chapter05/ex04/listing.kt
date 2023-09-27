package chapter05.ex04

import chapter05.Stream
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A> Stream<A>.forAll(p: (A) -> Boolean): Boolean =
  foldRight({ true }, { a, b -> p(a) && b() })

class Exercise04 : WordSpec({
  "Stream.forAll" should {
    "ensure that all elements match the predicate" {
      val s = Stream.of(1, 2, 3, 4, 5)
      s.forAll { it < 6 } shouldBe true
    }

    "stop evaluating if one element does not satisfy the predicate" {
      val s = Stream.of(1, 2, 3, 4, 5)
      s.forAll { it != 3 } shouldBe false
    }
  }
})

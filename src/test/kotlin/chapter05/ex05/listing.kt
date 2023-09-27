package chapter05.ex05

import chapter03.List
import chapter05.Stream
import chapter05.Stream.Companion.cons
import chapter05.Stream.Companion.empty
import chapter05.toList
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

class Exercise05 : WordSpec({

  fun <A> Stream<A>.takeWhile(p: (A) -> Boolean): Stream<A> =
    foldRight(
      { empty() },
      { h, t -> if (p(h)) cons({ h }, t) else empty() }
    )

  "Stream.takeWhile" should {
    "return elements while the predicate evaluates true" {
      val s = Stream.of(1, 2, 3, 4, 5)
      s.takeWhile { it < 4 }.toList() shouldBe
        List.of(1, 2, 3)
    }

    "stop returning once predicate evaluates false" {
      val s = Stream.of(1, 2, 3, 4, 5, 4, 3, 2, 1)
      s.takeWhile { it < 4 }.toList() shouldBe
        List.of(1, 2, 3)
    }

    "return all elements if predicate always evaluates true" {
      val s = Stream.of(1, 2, 3, 4, 5)
      s.takeWhile { true }.toList() shouldBe
        List.of(1, 2, 3, 4, 5)
    }
    "return empty if predicate always evaluates false" {
      val s = Stream.of(1, 2, 3, 4, 5)
      s.takeWhile { false }.toList() shouldBe
        List.empty()
    }
  }
})

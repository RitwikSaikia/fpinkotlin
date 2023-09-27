package chapter05.ex08

import chapter03.List
import chapter05.Stream
import chapter05.Stream.Companion.cons
import chapter05.take
import chapter05.toList
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

class Exercise08 : WordSpec({

  fun <A> constant(a: A): Stream<A> =
    cons({ a }, { constant(a) })

  "constant" should {
    "return an infinite stream of a given value" {
      constant(1).take(5).toList() shouldBe
        List.of(1, 1, 1, 1, 1)
    }
  }
})

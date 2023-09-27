package chapter05.ex09

import chapter03.List
import chapter05.Stream
import chapter05.Stream.Companion.cons
import chapter05.take
import chapter05.toList
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

class Exercise09 : WordSpec({

  fun from(n: Int): Stream<Int> =
    cons({ n }, { from(n + 1) })

  "from" should {
    "return a Stream of ever incrementing numbers" {
      from(5).take(5).toList() shouldBe
        List.of(5, 6, 7, 8, 9)
    }
  }
})

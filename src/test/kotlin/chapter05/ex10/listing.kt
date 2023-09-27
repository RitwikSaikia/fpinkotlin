package chapter05.ex10

import chapter03.List
import chapter05.Stream
import chapter05.Stream.Companion.cons
import chapter05.take
import chapter05.toList
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

class Exercise10 : WordSpec({

  fun fibs(): Stream<Int> {
    fun go(curr: Int, nxt: Int): Stream<Int> =
      cons({ curr }, { go(nxt, curr + nxt) })
    return go(0, 1)
  }

  "fibs" should {
    "return a stream of fibonacci sequence numbers" {
      fibs().take(10).toList() shouldBe
        List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
    }
  }
})

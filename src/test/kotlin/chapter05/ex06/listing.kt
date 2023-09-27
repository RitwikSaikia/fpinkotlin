package chapter05.ex06

import chapter04.*
import chapter05.Stream
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

class Exercise06 : WordSpec({

  fun <A> Stream<A>.headOption(): Option<A> =
    this.foldRight(
      { Option.empty() },
      { a, _ -> Some(a) }
    )

  "Stream.headOption" should {
    "return some first element from the stream if it is not empty" {
      val s = Stream.of(1, 2, 3, 4)
      s.headOption() shouldBe Some(1)
    }

    "return none if the stream is empty" {
      Stream.empty<Int>().headOption() shouldBe None
    }
  }
})

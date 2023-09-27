package chapter05.ex15

import chapter03.List
import chapter04.*
import chapter05.Cons
import chapter05.Stream
import chapter05.toList
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import chapter03.Cons as ConsL
import chapter03.Nil as NilL

class Exercise15 : WordSpec({

  fun <A> Stream<A>.tails(): Stream<Stream<A>> =
    Stream.unfold(this) { s: Stream<A> ->
      when (s) {
        is Cons ->
          Some(s to s.tail())
        else -> None
      }
    }

  fun <A, B> List<A>.map(f: (A) -> B): List<B> = when (this) {
    is ConsL -> ConsL(f(this.head), this.tail.map(f))
    is NilL -> NilL
  }

  "Stream.tails" should {
    "return the stream of suffixes of the input sequence" {
      Stream.of(1, 2, 3)
        .tails().toList().map { it.toList() } shouldBe
        List.of(
          ConsL(1, ConsL(2, ConsL(3, NilL))),
          ConsL(2, ConsL(3, NilL)),
          ConsL(3, NilL)
        )
    }
  }
})

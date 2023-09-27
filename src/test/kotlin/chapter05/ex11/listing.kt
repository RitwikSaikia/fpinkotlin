package chapter05.ex11

import chapter03.List
import chapter04.*
import chapter05.Stream
import chapter05.Stream.Companion.cons
import chapter05.Stream.Companion.empty
import chapter05.take
import chapter05.toList
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A, S> unfold(z: S, f: (S) -> Option<Pair<A, S>>): Stream<A> =
  f(z).map { pair ->
    cons(
      { pair.first },
      { unfold(pair.second, f) }
    )
  }.getOrElse {
    empty()
  }

class Exercise11 : WordSpec({
  "unfold" should {
    """return a stream based on an intial state and a function
      applied to each subsequent element""" {
      unfold(0) { s: Int ->
        Some(s to (s + 1))
      }.take(5).toList() shouldBe
        List.of(0, 1, 2, 3, 4)
    }
  }
})

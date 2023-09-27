package chapter05.ex01

import chapter03.List
import chapter03.reverse
import chapter05.Cons
import chapter05.Empty
import chapter05.Stream
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import chapter03.Cons as ConsL
import chapter03.Nil as NilL

class Exercise01 : WordSpec({
  fun <A> Stream<A>.toList(): List<A> {
    tailrec fun go(xs: Stream<A>, acc: List<A>): List<A> = when (xs) {
      is Empty -> acc
      is Cons -> go(xs.tail(), ConsL(xs.head(), acc))
    }
    return reverse(go(this, NilL))
  }

  "Stream.toList" should {
    "force the stream into an evaluated list" {
      val s = Stream.of(1, 2, 3, 4, 5)
      s.toList() shouldBe List.of(1, 2, 3, 4, 5)
    }
  }
})

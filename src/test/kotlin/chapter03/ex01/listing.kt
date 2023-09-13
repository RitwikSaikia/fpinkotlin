package chapter03.ex01

import chapter03.Cons
import chapter03.List
import chapter03.Nil
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.WordSpec

fun <A> tail(xs: List<A>): List<A> = when (xs) {
  is Nil -> throw IllegalStateException()
  is Cons -> xs.tail
}

class Exercise1 : WordSpec({
  "list tail" should {
    "return the tail when present" {
      tail(List.of(1, 2, 3, 4, 5)) shouldBe
        List.of(2, 3, 4, 5)
    }

    "throw an illegal state exception when no tail is present" {
      shouldThrow<IllegalStateException> {
        tail(Nil)
      }
    }
  }
})

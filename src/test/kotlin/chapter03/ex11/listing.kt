package chapter03.ex11

import chapter03.Cons
import chapter03.List
import chapter03.Nil
import chapter03.foldLeft
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A> reverseOld(xs: List<A>): List<A> {
  tailrec fun go(remaining: List<A>, acc: List<A> = Nil): List<A> = when (remaining) {
    is Nil -> acc
    is Cons -> go(remaining.tail, Cons(remaining.head, acc))
  }
  return go(xs)
}

fun <A> reverse(xs: List<A>): List<A> =
  foldLeft(xs, List.empty()) { t, h -> Cons(h, t) }

class Exercise11 : WordSpec({
  "list reverse" should {
    "reverse list elements" {
      reverse(List.of(1, 2, 3, 4, 5)) shouldBe
        List.of(5, 4, 3, 2, 1)
    }
  }
})

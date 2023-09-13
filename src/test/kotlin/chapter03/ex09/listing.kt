package chapter03.ex09

import chapter03.Cons
import chapter03.List
import chapter03.Nil
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

tailrec fun <A, B> foldLeft(xs: List<A>, z: B, f: (B, A) -> B): B =
  when (xs) {
    is Nil -> z
    is Cons -> foldLeft(xs.tail, f(z, xs.head), f)
  }

class Exercise8 : WordSpec({
  "list foldLeft" should {
    """apply a function f providing a zero accumulator from tail
      recursive position""" {
      foldLeft(List.of("a", "b", "c", "d", "e"), "->") { x, y -> x + y } shouldBe "->abcde"
    }
  }
})

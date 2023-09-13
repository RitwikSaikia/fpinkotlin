package chapter03.ex07

import chapter03.Cons
import chapter03.List
import chapter03.Nil
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A, B> foldRight(xs: List<A>, z: B, f: (A, B) -> B): B =
  when (xs) {
    is Nil -> z
    is Cons -> f(xs.head, foldRight(xs.tail, z, f))
  }

val f = { x: Int, y: List<Int> -> Cons(x, y) }
val z = Nil as List<Int>

val trace = {
  foldRight(List.of(1, 2, 3), z, f)
  Cons(1, foldRight(List.of(2, 3), z, f))
  Cons(1, Cons(2, foldRight(List.of(3), z, f)))
  Cons(1, Cons(2, Cons(3, foldRight(List.empty(), z, f))))
  Cons(1, Cons(2, Cons(3, Nil)))
}

fun main() {
  foldRight(
    Cons(1, Cons(2, Cons(3, Nil))),
    Nil as List<Int>
  ) { x, y -> Cons(x, y) }
}

class Exercise7 : WordSpec({
  "list foldRight" should {
    """apply a function f""" {
      foldRight(List.of("a", "b", "c", "d", "e"), "<-") { x, y -> x + y } shouldBe "abcde<-"
    }
  }
})

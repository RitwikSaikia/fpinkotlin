package chapter03.ex17

import chapter03.Cons
import chapter03.List
import chapter03.foldRight
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A, B> map(xs: List<A>, f: (A) -> B): List<B> =
  foldRight(xs, List.empty()) { x, acc -> Cons(f(x), acc) }

class Exercise17 : WordSpec({
  "list map" should {
    "apply a function to every list element" {
      map(List.of(1, 2, 3, 4, 5)) { it * 10 } shouldBe
        List.of(10, 20, 30, 40, 50)
    }
  }
})

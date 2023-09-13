package chapter03.ex20

import chapter03.List
import chapter03.ex19.flatMap
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A> filter2(xa: List<A>, f: (A) -> Boolean): List<A> =
  flatMap(xa) { a ->
    if (f(a)) List.of(a) else List.empty()
  }

class Exercise20 : WordSpec({
  "list filter" should {
    "filter out elements not compliant to predicate" {
      filter2(
        List.of(1, 2, 3, 4, 5)
      ) { it % 2 == 0 } shouldBe List.of(2, 4)
    }
  }
})

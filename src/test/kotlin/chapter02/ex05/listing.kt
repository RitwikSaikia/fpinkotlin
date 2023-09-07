package chapter02.ex05

import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

class Exercise5 : WordSpec({
  fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C =
    { a -> f(g(a)) }

  "compose" should {
    "apply function composition over two functions" {
      val fahrenhite2celsius: (Double) -> String =
        compose<Double, Double, String>(
          { b -> "$b degrees celsius" },
          { a -> (a - 32.0) * (5.0 / 9.0) }
        )

      fahrenhite2celsius(68.0) shouldBe "20.0 degrees celsius"
    }
  }
})

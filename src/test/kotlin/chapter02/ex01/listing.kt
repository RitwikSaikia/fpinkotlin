package chapter02.ex01

import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec
import kotlinx.collections.immutable.persistentMapOf

//TODO: Enable tests by removing `!` prefix
class Chapter02 : WordSpec({
  tailrec fun fib(i: Int): Int =
    when (i) {
      1, 2 -> 1
      else -> fib(i - 1) + fib(i - 2)
    }

  "fib" should {
    "return the nth fibonacci number" {
      persistentMapOf(
        1 to 1,
        2 to 1,
        3 to 2,
        4 to 3,
        5 to 5,
        6 to 8,
        7 to 13,
        8 to 21
      ).forEach { (n, num) ->
        fib(n) shouldBe num
      }
    }
  }
})

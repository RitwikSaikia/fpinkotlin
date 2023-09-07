package chapter02.sec01

val listing1 = {
  fun factorial(i: Int): Int {
    fun go(n: Int, acc: Int): Int =
      if (n <= 0) {
        acc
      } else {
        go(n - 1, n * acc)
      }
    return go(i, 1)
  }
}

val listing2 = {
  fun factorial(i: Int): Int {
    tailrec fun go(n: Int, acc: Int): Int =
      if (n <= 0) {
        acc
      } else {
        go(n - 1, n * acc)
      }
    return go(i, 1)
  }
}

object Example {

  private fun abs(n: Int): Int =
    if (n < 0) {
      -n
    } else {
      n
    }

  private fun factorial(i: Int): Int {
    fun go(n: Int, acc: Int): Int =
      if (n <= 0) {
        acc
      } else {
        go(n - 1, n * acc)
      }
    return go(i, 1)
  }

  fun formatAbs(x: Int): String {
    val msg = "The absolute value of %d is %d"
    return msg.format(x, abs(x))
  }

  fun formatFactorial(x: Int): String {
    val msg = "The factorial of %d is %d"
    return msg.format(x, factorial(x))
  }
}

fun main() {
  println(Example.formatAbs(-42))
  println(Example.formatFactorial(7))
}

val listing4 = {
  fun factorial(i: Int): Int = TODO()

  fun abs(n: Int): Int = TODO()

  fun formatResult(name: String, n: Int, f: (Int) -> Int): String {
    val msg = "The %s of %d is %d."
    return msg.format(name, n, f(n))
  }

  fun main() {
    println(formatResult("factorial", 7, ::factorial))
    println(formatResult("absolute value", -42, ::abs))

    println(
      formatResult("absolute", -42, fun(n: Int): Int {
        return if (n < 0) {
          -n
        } else {
          n
        }
      })
    )

    println(
      formatResult("absolute", -42) { n ->
        if (n < 0) {
          -n
        } else {
          n
        }
      }
    )

    println(
      formatResult("absolute", -42) {
        if (it < 0) {
          -it
        } else {
          it
        }
      }
    )
  }
}

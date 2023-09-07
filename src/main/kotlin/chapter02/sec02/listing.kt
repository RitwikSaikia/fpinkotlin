package chapter02.sec02

fun findFirst(ss: Array<String>, key: String): Int {
  tailrec fun loop(n: Int): Int =
    when {
      n >= ss.size -> -1
      ss[n] == key -> n
      else -> loop(n + 1)
    }
  return loop(0)
}

fun <A> findFirst(xs: Array<A>, p: (A) -> Boolean): Int {
  tailrec fun loop(n: Int): Int =
    when {
      n >= xs.size -> -1
      p(xs[n]) -> n
      else -> loop(n + 1)
    }
  return loop(0)
}

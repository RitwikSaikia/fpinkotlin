package chapter04.sec01

fun failingFn(i: Int): Int {
  val y: Int = throw Exception("boom")
  return try {
    val x = 42 + 5
    x + y
  } catch (e: Exception) {
    43
  }
}

fun failingFn2(i: Int): Int =
  try {
    val x = 42 + 5
    x + (throw Exception("boom!")) as Int
  } catch (e: Exception) {
    43
  }

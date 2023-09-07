package chapter02.sec03

val listing1 = {
  fun <A, B, C> partial1(a: A, f: (A, B) -> C): (B) -> C = TODO()
}

val listing2 = {
  fun <A, B, C> partial1(a: A, f: (A, B) -> C): (B) -> C =
    { b: B -> TODO() }
}

val listing3 = {
  fun <A, B, C> partial1(a: A, f: (A, B) -> C): (B) -> C =
    { b: B -> f(a, b) }
}

val listing4 = {
  fun <A, B, C> partial1(a: A, f: (A, B) -> C): (B) -> C =
    { b -> f(a, b) }
}

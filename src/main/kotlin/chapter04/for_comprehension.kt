package chapter04

fun <A> Option.Companion.fx(f: () -> Unit): Option<A> = TODO()
fun <A> Option<A>.bind(): A = TODO()

val listing1 = {
  fun <A, B, C> map2(
    oa: Option<A>,
    ob: Option<B>,
    f: (A, B) -> C
  ): Option<C> =
    oa.flatMap { a ->
      ob.map { b ->
        f(a, b)
      }
    }
}

val listing2 = {
  fun <A, B, C> map2(
    oa: Option<A>,
    ob: Option<B>,
    f: (A, B) -> C
  ): Option<C> =
    Option.fx {
      val a = oa.bind()
      val b = ob.bind()
      f(a, b)
    }
}

package chapter04.ex03

import chapter04.*
import io.kotlintest.shouldBe
import io.kotlintest.specs.WordSpec

fun <A, B, C> map2(oa: Option<A>, ob: Option<B>, f: (A, B) -> C): Option<C> =
  oa.flatMap { a -> ob.map { b -> f(a, b) } }

class Exercise03 : WordSpec({
  "map2" should {
    val a = Some(5)
    val b = Some(20)
    val none = Option.empty<Int>()

    "combine two option values using a binary function" {
      map2(a, b) { aa, bb ->
        aa * bb
      } shouldBe Some(100)
    }

    "return none if either option is not defined" {
      map2(a, none) { aa, bb ->
        aa * bb
      } shouldBe None

      map2(none, b) { aa, bb ->
        aa * bb
      } shouldBe None
    }
  }
})

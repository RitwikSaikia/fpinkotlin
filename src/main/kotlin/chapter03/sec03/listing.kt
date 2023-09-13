package chapter03.sec03

import chapter03.Cons
import chapter03.List
import chapter03.Nil

fun <A> append(a1: List<A>, a2: List<A>): List<A> =
  when (a1) {
    is Nil -> a2
    is Cons -> Cons(a1.head, append(a1.tail, a2))
  }

package chapter05.sec01

import chapter03.List
import kotlin.system.exitProcess

fun <A, B> List<A>.map(f: (A) -> B): List<B> = TODO()

fun <A> List<A>.filter(f: (A) -> Boolean): List<A> = TODO()

val listing = {
  List.of(1, 2, 3, 4)
    .map { it + 10 }.filter { it % 2 == 0 }.map { it * 3 }

  List.of(11, 12, 13, 14)
    .filter { it % 2 == 0 }.map { it * 3 }

  List.of(36, 42)
}

fun square(x: Double): Double = x * x

val input = ""

val result = if (input.isEmpty()) exitProcess(-1) else input

val a = 10

fun <A> lazyIf(
  cond: Boolean,
  onTrue: () -> A,
  onFalse: () -> A
): A = if (cond) onTrue() else onFalse()

val y = lazyIf(
  (a < 22),
  { println("a") },
  { println("b") }
)

fun maybeTwice(b: Boolean, i: () -> Int) =
  if (b) i() + i() else 0

fun maybeTwice2(b: Boolean, i: () -> Int) {
  val j: Int by lazy(i)
  if (b) j + j else 0
}

fun expensiveOp(): Int = TODO()

val x: Int by lazy { expensiveOp() }

fun useit() =
  if (x > 10) "hi"
  else if (x == 0) "zero"
  else ("lo")

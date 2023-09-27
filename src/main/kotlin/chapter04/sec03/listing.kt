package chapter04.sec03

sealed class List<out A>

private fun <A> length(xs: List<A>): Int = TODO()

private fun List<Double>.sum(): Double = TODO()

private fun List<Double>.isEmpty(): Boolean = TODO()

fun <A> List<A>.size(): Int = TODO()

sealed class Option<out A>

data class Some<out A>(val get: A) : Option<A>()

object None : Option<Nothing>()

val listing1 = {
  fun mean(xs: List<Double>): Option<Double> =
    if (xs.isEmpty()) None
    else Some(xs.sum() / xs.size())
}

fun <A, B> Option<A>.map(f: (A) -> B): Option<B> = TODO()

fun <A, B> Option<A>.flatMap(f: (A) -> Option<B>): Option<B> = TODO()

fun <A> Option<A>.getOrElese(default: () -> A): A = TODO()

fun <A> Option<A>.filter(f: (A) -> Boolean): Option<A> = TODO()

data class Employee(
  val name: String,
  val department: String,
  val manager: Option<String>
)

fun lookupByName(name: String): Option<Employee> = TODO()

fun timeDepartment(): Option<String> =
  lookupByName("Tim").map { it.department }

val unwieldy: Option<Option<String>> =
  lookupByName("Tim").map { it.manager }

val manager: String = lookupByName("Tim")
  .flatMap { it.manager }
  .getOrElese { "Unemployed" }

val dept: String = lookupByName("Tim")
  .map { it.department }
  .filter { it != "Accounts" }
  .getOrElese { "Unemployed" }

fun <A, B> lift(f: (A) -> B): (Option<A>) -> Option<B> =
  { oa -> oa.map(f) }

val absO: (Option<Double>) -> Option<Double> =
  lift { kotlin.math.abs(it) }

fun insuranceRateQuote(
  age: Int,
  numberOfSpeedingTickets: Int
): Double = TODO()

private fun <A, B, C> map2(
  oa: Option<A>,
  ob: Option<B>,
  f: (A, B) -> C
): Option<C> = TODO()

fun parseInsuranceRateQuote(
  age: String,
  speedingTickets: String
): Option<Double> {
  val optAge: Option<Int> = catches { age.toInt() }

  val optTickets: Option<Int> =
    catches { speedingTickets.toInt() }

  return map2(optAge, optTickets) { a, t -> insuranceRateQuote(a, t) }
}

fun <A> catches(a: () -> A): Option<A> =
  try {
    Some(a())
  } catch (e: Throwable) {
    None
  }

fun <A> sequence(xs: List<Option<A>>): Option<List<A>> = TODO()

fun <A, B> List<A>.map(f: (A) -> B): List<B> = TODO()

fun parseInts(xs: List<String>): Option<List<Int>> =
  sequence(xs.map { str -> catches { str.toInt() } })

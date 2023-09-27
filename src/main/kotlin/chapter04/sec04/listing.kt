package chapter04.sec04

sealed class Either<out E, out A>

data class Left<out E>(val value: E) : Either<E, Nothing>()

data class Right<out A>(val value: A) : Either<Nothing, A>()

fun <A> List<A>.size(): Int = TODO()

fun List<Double>.sum(): Double = TODO()

fun <A> List<A>.isEmpty(): Boolean = TODO()

fun mean(xs: List<Double>): Either<String, Double> =
  if (xs.isEmpty())
    Left("mean of empty list!")
  else Right(xs.sum() / xs.size())

fun saveDiv(x: Int, y: Int): Either<Exception, Int> =
  try {
    Right(x / y)
  } catch (e: Exception) {
    Left(e)
  }

fun <A> catches(a: () -> A): Either<Exception, A> =
  try {
    Right(a())
  } catch (e: Exception) {
    Left(e)
  }

fun <E, A, B, C> map2(
  ae: Either<E, A>,
  be: Either<E, B>,
  f: (A, B) -> C
): Either<E, C> = TODO()

data class Name(val value: String)

data class Age(val value: Int)

data class Person(val name: Name, val age: Age)

fun mkName(name: String): Either<String, Name> =
  if (name.isBlank()) Left("Name is empty")
  else Right(Name(name))

fun mkAge(age: Int): Either<String, Age> =
  if (age < 0) Left("Age is out of range.")
  else Right(Age(age))

fun mkPerson(name: String, age: Int): Either<String, Person> =
  map2(mkName(name), mkAge(age)) { n, a -> Person(n, a) }

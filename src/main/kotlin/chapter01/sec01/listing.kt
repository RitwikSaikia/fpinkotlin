package chapter01.sec01

val listing1 = {

  class CreditCard {

    fun charge(price: Float): Unit = TODO()
  }

  data class Coffee(val price: Float = 2.50F)

  class Cafe {

    fun buyCoffee(cc: CreditCard): Coffee {
      val cup = Coffee()

      cc.charge(cup.price)

      return cup
    }
  }
}

val listing2 = {

  data class Coffee(val price: Float = 2.95F)

  class CreditCard

  class Payments {
    fun charge(cc: CreditCard, price: Float): Unit = TODO()
  }

  class Cafe {
    fun buyCoffee(cc: CreditCard, p: Payments): Coffee {
      val cup = Coffee()
      p.charge(cc, cup.price)
      return cup
    }
  }
}

val listing4 = {
  class CreditCard

  data class Charge(val cc: CreditCard, val amount: Float) {
    fun combine(other: Charge): Charge =
      if (cc == other.cc) {
        Charge(cc, amount + other.amount)
      } else {
        throw Exception("Can't combine charges to different cards")
      }
  }
}

val listing5 = {

  class CreditCard

  data class Coffee(val price: Float = 2.50f)

  data class Charge(val cc: CreditCard, val amount: Float) {
    fun combine(other: Charge): Charge = TODO()
  }

  class Cafe {

    fun buyCoffee(cc: CreditCard): Pair<Coffee, Charge> = TODO()

    fun buyCoffees(
      cc: CreditCard,
      n: Int
    ): Pair<List<Coffee>, Charge> {
      val purchases: List<Pair<Coffee, Charge>> = List(n) { buyCoffee(cc) }

      val (coffees, charges) = purchases.unzip()

      return Pair(
        coffees,
        charges.reduce { c1, c2 -> c1.combine(c2) }
      )
    }
  }
}

val listing6 = {

  class CreditCard

  data class Charge(val cc: CreditCard, val amount: Float) {
    fun combine(other: Charge): Charge = TODO()
  }

  fun List<Charge>.coalesce(): List<Charge> =
    this.groupBy { it.cc }.values
      .map { it.reduce { a, b -> a.combine(b) } }
}

package vendingmachine

data class Coin(val weight: String, val diameter: String)

fun quarter() = Coin("5.670 g", "24.26 mm")
fun dime() = Coin("2.268 g", "17.91 mm")
fun nickel() = Coin("5.000 g", "21.21 mm")
fun cent() = Coin("2.500 g", "21.21 mm")

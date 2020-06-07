data class Coin(val weight: String, val diameter: String, private val name: String = "fake"){
    override fun toString(): String = name
}

fun quarter() = Coin("5.670 g", "24.26 mm", "quarter")
fun dime() = Coin("2.268 g", "17.91 mm", "dime")
fun nickel() = Coin("5.000 g", "21.21 mm", "nickel")
fun cent() = Coin("2.500 g", "21.21 mm", "cent")

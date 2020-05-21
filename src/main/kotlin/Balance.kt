import java.lang.Math.abs

class Balance(private val coins: List<Coin> = emptyList()) {
    fun show(): String = "%.2f".format(balance())
    fun isSufficientFor(amount: Double): Boolean = balance() >= amount
    fun add(coin: Coin): Balance = Balance(coins + coin)
    fun add(newCoins: List<Coin>): Balance = Balance(coins + newCoins)

    fun isEmpty(): Boolean = balance() == 0.00

    fun balance(): Double = coins.sumByDouble { coin -> valueOf(coin) }

    fun changeFor(amount: Double): List<Coin> {
        return calculateChange(balance() - amount)
    }

    private fun calculateChange(amount: Double): List<Coin> {
        if(amount._eq(0.05)) {
            println("$amount returns nickel")
            return listOf(nickel())
        }
        if(amount._eq(0.10)) {
            println("$amount returns dime")
            return listOf(dime())
        }
        if(amount._eq(0.25)) {
            println("$amount returns quarter")
            return listOf(quarter())
        }
        println("$amount returns nothing")
        return emptyList()
    }

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }

    fun Double._eq(other: Double) = abs(this - other) < 0.0001
}

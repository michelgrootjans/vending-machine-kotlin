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
        if(amount._ge(0.25)) return calculateChange(amount - 0.25) + quarter()
        if(amount._ge(0.10)) return calculateChange(amount - 0.10) + dime()
        if(amount._ge(0.05)) return listOf(nickel())  + calculateChange(amount - 0.05)
        return emptyList()
    }

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }

    // don't look - ugly code ahead
    fun Double._eq(other: Double) = abs(this - other) < 0.0001
    fun Double._ge(other: Double) = this > other || this._eq(other)
}

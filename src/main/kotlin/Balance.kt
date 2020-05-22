import java.lang.Math.abs

class Balance(private val coins: List<Coin> = emptyList()) {
    fun show(): String = "%.2f".format(balance())
    fun isSufficientFor(amount: Double): Boolean = balance() >= amount
    fun add(coin: Coin): Balance = Balance(coins + coin)
    fun add(newCoins: List<Coin>): Balance = Balance(coins + newCoins)

    fun isEmpty(): Boolean = balance() == 0.00

    fun balance(): Double = coins.sumByDouble { coin -> valueOf(coin) }

    fun changeFor(amount: Double): List<Coin> {
        return toCoins(balance() - amount)
    }

    private fun toCoins(amount: Double): List<Coin> {
        when {
            blah(amount, quarter()) -> return bleh(amount, quarter())
            blah(amount, dime())    -> return bleh(amount, dime())
            blah(amount, nickel())  -> return bleh(amount, nickel())
            else -> return emptyList()
        }
    }

    private fun blah(amount: Double, coin: Coin) = amount._greaterOrEqualTo(valueOf(coin))

    private fun bleh(amount: Double, coin: Coin) = toCoins(amount - valueOf(coin)) + coin

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }

    // don't look - ugly code ahead
    fun Double._equalTo(other: Double) = abs(this - other) < 0.0001
    fun Double._greaterOrEqualTo(other: Double) = this > other || this._equalTo(other)
}

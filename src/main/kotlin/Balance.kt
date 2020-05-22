import java.lang.Math.abs

class Balance(private val coins: List<Coin> = emptyList()) {
    fun show(): String = "%.2f".format(balance())
    fun isSufficientFor(amount: Double): Boolean = balance() >= amount
    fun add(coin: Coin): Balance = Balance(coins + coin)
    fun add(newCoins: List<Coin>): Balance = Balance(coins + newCoins)
    fun isEmpty(): Boolean = balance() == 0.00
    fun acceptsCoin(coin: Coin): Boolean = listOf(nickel(), dime(), quarter()).contains(coin)
    fun balance(): Double = coins.sumByDouble { coin -> valueOf(coin) }
    fun changeFor(amount: Double): List<Coin> = toCoins(balance() - amount)

    private fun toCoins(amount: Double): List<Coin> {
        when {
            amount._greaterOrEqualTo(valueOf(quarter())) -> return toCoins(amount - valueOf(quarter())) + quarter()
            amount._greaterOrEqualTo(valueOf(dime()))    -> return toCoins(amount - valueOf(dime())) + dime()
            amount._greaterOrEqualTo(valueOf(nickel()))  -> return toCoins(amount - valueOf(nickel())) + nickel()
            else -> return emptyList()
        }
    }

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

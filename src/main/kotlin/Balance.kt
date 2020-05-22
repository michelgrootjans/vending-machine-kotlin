import java.lang.Math.abs

class Balance(private val coins: List<Coin> = emptyList()) {
    fun show(): String = "%.2f".format(balance())
    fun isSufficientFor(amount: Double): Boolean = balance() >= amount
    fun add(coin: Coin): Balance = Balance(coins + coin)
    fun add(newCoins: List<Coin>): Balance = Balance(coins + newCoins)

    fun isEmpty(): Boolean = balance() == 0.00

    fun balance(): Double = coins.sumByDouble { coin -> valueOf(coin) }

    fun changeFor(amount: Double): List<Coin> {
        return changeFo(balance() - amount)
    }

    private fun changeFo(amount: Double): List<Coin> {
        when {
            amount.greaterOrEqualTo(0.25) -> return changeFo(amount - 0.25) + quarter()
            amount.greaterOrEqualTo(0.10) -> return changeFo(amount - 0.10) + dime()
            amount.greaterOrEqualTo(0.05) -> return changeFo(amount - 0.05) + nickel()
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
    fun Double.equalTo(other: Double) = abs(this - other) < 0.0001
    fun Double.greaterOrEqualTo(other: Double) = this > other || this.equalTo(other)
}

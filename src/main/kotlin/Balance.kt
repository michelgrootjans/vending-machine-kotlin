class Balance(private val coins: List<Coin> = emptyList()) {
    fun show(): String = "%.2f".format(balance())
    fun isSufficientFor(amount: Double): Boolean = balance() >= amount
    fun add(coin: Coin): Balance = Balance(coins + coin)
    fun add(newCoins: List<Coin>): Balance = Balance(coins + newCoins)

    fun isEmpty(): Boolean = balance() == 0.00

    fun balance(): Double = coins.sumByDouble { coin -> valueOf(coin) }

    fun changeFor(amount: Double): List<Coin> {
        if (balance() <= amount) return emptyList()
        return calculateChange(balance() - amount)
    }

    private fun calculateChange(d: Double): List<Coin> {
        if(d == 0.10) return listOf(dime())
        return listOf(quarter())
    }

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }
}

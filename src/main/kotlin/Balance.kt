class Balance(private val coins: List<Coin> = emptyList()) {
    fun show(): String = "%.2f".format(total())
    fun isSufficientFor(amount: Double): Boolean = amount <= total()
    fun add(coin: Coin): Balance = Balance(coins + coin)
    fun isEmpty(): Boolean = total() == 0.00

    fun total(): Double = coins.sumByDouble { coin -> valueOf(coin) }

    fun changeFor(price: Double): List<Coin> {
        if (price < total()) return listOf(quarter())
        return emptyList()
    }

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }

}

class Balance(private val coins: List<Coin> = emptyList()) {
    fun show(): String = "%.2f".format(amount())
    fun isSufficientFor(amount: Double): Boolean = amount <= amount()
    fun add(coin: Coin): Balance = Balance(coins + coin)
    fun isEmpty(): Boolean = amount() == 0.00

    fun amount(): Double = coins.sumByDouble { coin -> valueOf(coin) }

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }

}

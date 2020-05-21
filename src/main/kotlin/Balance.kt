class Balance(private val balance: Double = 0.00, private val coins: List<Coin> = emptyList()) {

    fun show(): String = "%.2f".format(balanc())
    fun isSufficientFor(amount: Double): Boolean = amount <= balance
    fun add(amount: Double, coin: Coin): Balance = Balance(balance + amount, coins + coin)
    fun isEmpty(): Boolean {
        return balance == 0.00
    }
    fun balanc(): Double = coins.sumByDouble { coin -> valueOf(coin) }

    fun amount(): Double = balance

private fun valueOf(coin: Coin) = when (coin) {
    nickel() -> 0.05
    dime() -> 0.10
    quarter() -> 0.25
    else -> 0.00
}

}

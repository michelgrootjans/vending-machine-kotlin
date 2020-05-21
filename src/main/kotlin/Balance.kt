class Balance(private val balance: Double = 0.00, private val coins: List<Coin> = emptyList()) {

    fun show(): String = "%.2f".format(balance)
    fun isSufficientFor(amount: Double): Boolean = amount <= balance
    fun add(amount: Double, coin: Coin): Balance = Balance(balance + amount)
    fun subtract(amount: Double): Balance = Balance(balance - amount)
    fun isEmpty(): Boolean {
        return balance == 0.00
    }

    fun amount(): Double = balance
}

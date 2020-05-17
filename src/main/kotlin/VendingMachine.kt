package vendingmachine

class VendingMachine(
    val balance: Double = 0.00,
    val coinReject: List<Coin> = emptyList(),
    val dispenser: List<String> = emptyList()
) {
    val products = listOf("cola", "chips", "candy")

    fun insert(coin: Coin): VendingMachine =
        if (isValid(coin)) VendingMachine(balance + valueOf(coin), coinReject)
        else VendingMachine(balance, coinReject + coin)

    fun pressButton1(): VendingMachine =
        VendingMachine(-1.00, coinReject, dispenser + "cola")

    fun pressButton2(): VendingMachine =
        VendingMachine(-2.00, coinReject)

    fun pressButton3(): VendingMachine =
        VendingMachine(-3.00, coinReject)

    fun display(): String = when (balance) {
        0.00 -> "INSERT COIN"
        -1.00 -> "THANK YOU"
        -2.00 -> "THANK YOU"
        -3.00 -> "THANK YOU"
        else -> "%.2f".format(balance)
    }

    fun dispenser(): List<String> = when (balance) {
        -1.00 -> listOf("cola")
        -2.00 -> listOf("chips")
        -3.00 -> listOf("candy")
        else -> dispenser
    }

    fun coinReject(): List<Coin> {
        return coinReject
    }

    private fun isValid(coin: Coin): Boolean = listOf(nickel(), dime(), quarter()).contains(coin)

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }
}

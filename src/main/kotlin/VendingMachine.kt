package vendingmachine

class VendingMachine(
    val balance: Double = 0.00,
    val coinReject: List<Coin> = emptyList(),
    val dispenser: List<String> = emptyList(),
    val defaultMessage: String = "INSERT COIN"
) {
    val products = listOf("cola", "chips", "candy")

    fun insert(coin: Coin): VendingMachine =
        if (isValid(coin)) VendingMachine(balance + valueOf(coin), coinReject)
        else VendingMachine(balance, coinReject + coin)

    fun pressButton1(): VendingMachine = dispense(0)
    fun pressButton2(): VendingMachine = dispense(1)
    fun pressButton3(): VendingMachine = dispense(2)

    private fun dispense(productNumber: Int) = VendingMachine(0.00, coinReject, dispenser + products[productNumber], "THANK YOU")

    fun display(): String = when (balance) {
        0.00 -> defaultMessage
        else -> "%.2f".format(balance)
    }

    fun dispenser(): List<String> = when (balance) {
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

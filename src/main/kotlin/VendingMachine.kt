package vendingmachine

class VendingMachine(
    val balance: Double = 0.00,
    val dispenser: List<String> = emptyList(),
    val coinReject: List<Coin> = emptyList(),
    val defaultMessage: String = "INSERT COIN"
) {
    val products2 = listOf(
            Product("cola", 1.00),
            Product("chips", 0.50),
            Product("candy", 0.65)
    )

    fun tick() = VendingMachine(balance, dispenser, coinReject)

    fun insert(coin: Coin): VendingMachine =
        if (isValid(coin)) VendingMachine(balance + valueOf(coin), coinReject = coinReject)
        else VendingMachine(balance, coinReject = coinReject + coin)

    fun pressButton1(): VendingMachine = dispense2(products2[0])
    fun pressButton2(): VendingMachine = dispense2(products2[1])
    fun pressButton3(): VendingMachine = dispense2(products2[2])

    private fun dispense2(product: Product): VendingMachine {
        if (balance >= product.price)
            return dispense(product.name)
        return VendingMachine(
                0.00,
                dispenser,
                coinReject,
                "PRICE %.2f".format(product.price)
        )
    }

    private fun dispense(product: String): VendingMachine {
        if(balance > 0.00)
        return VendingMachine(
                0.00,
                dispenser + product,
                coinReject,
                "THANK YOU"
        )
        return VendingMachine(
                balance,
                dispenser,
                coinReject,
                "PRICE 1.00"
        )
    }

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

data class Product(val name: String, val price: Double) {

}

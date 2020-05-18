package vendingmachine

class VendingMachine(
    val balance: Double = 0.00,
    val dispenser: List<String> = emptyList(),
    val coinReject: List<Coin> = emptyList(),
    val defaultMessage: String = "INSERT COIN"
) {
    val products = listOf(
            Product("cola", 1.00),
            Product("chips", 0.50),
            Product("candy", 0.65)
    )

    fun tick() = VendingMachine(balance, dispenser, coinReject)

    fun insert(coin: Coin): VendingMachine =
        if (isValid(coin)) VendingMachine(balance + valueOf(coin), coinReject = coinReject)
        else VendingMachine(balance, coinReject = coinReject + coin)

    fun pressButton1(): VendingMachine = pressButton(0)
    fun pressButton2(): VendingMachine = pressButton(1)
    fun pressButton3(): VendingMachine = pressButton(2)

    private fun pressButton(buttonIndex: Int) = dispense(products[buttonIndex])

    private fun dispense(product: Product): VendingMachine {
        if (balance >= product.price) {
            if(balance > 0.00)
                return VendingMachine(
                        0.00,
                        dispenser + product.name,
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
        return VendingMachine(
                0.00,
                dispenser,
                coinReject,
                "PRICE %.2f".format(product.price)
        )
    }

    fun display(): String = when (balance) {
        0.00 -> defaultMessage
        else -> "%.2f".format(balance)
    }

    fun dispenser(): List<String> = dispenser
    fun coinReject(): List<Coin> = coinReject

    private fun isValid(coin: Coin): Boolean = listOf(nickel(), dime(), quarter()).contains(coin)

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }
}

data class Product(val name: String, val price: Double)

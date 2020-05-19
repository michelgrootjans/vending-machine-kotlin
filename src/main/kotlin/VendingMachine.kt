package vendingmachine

class VendingMachine(
    val balance: Double = 0.00,
    val dispenser: List<String> = emptyList(),
    val coinReject: List<Coin> = emptyList(),
    val defaultMessage: String = "INSERT COIN"
) {
    val inventory = mapOf(
            1 to Product("cola", 1.00),
            2 to Product("chips", 0.50),
            3 to Product("candy", 0.65)
    )

    fun tick() = VendingMachine(balance, dispenser, coinReject)

    fun insert(coin: Coin): VendingMachine =
        if (isValid(coin)) VendingMachine(balance + valueOf(coin), coinReject = coinReject)
        else VendingMachine(balance, coinReject = coinReject + coin)


    fun pressButton1(): VendingMachine = dispense(inventory.getValue(1))
    fun pressButton2(): VendingMachine = dispense(inventory.getValue(2))
    fun pressButton3(): VendingMachine = dispense(inventory.getValue(3))

    private fun dispense(product: Product): VendingMachine {
        // warning: ugly code ahead
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

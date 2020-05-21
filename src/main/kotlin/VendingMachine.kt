class VendingMachine(
        val balance: Double = 0.00,
        val dispenser: List<String> = emptyList(),
        val coinReject: List<Coin> = emptyList(),
        val display: Display = DefaultDisplay()
) {

    private val catalog = Catalog()

    fun tick() = VendingMachine(balance, dispenser, coinReject)

    fun insert(coin: Coin): VendingMachine =
        if (isValid(coin)) VendingMachine(balance + valueOf(coin), dispenser, coinReject)
        else VendingMachine(balance, dispenser, coinReject + coin)


    fun pressButton1(): VendingMachine = sell(catalog.getValue(1))
    fun pressButton2(): VendingMachine = sell(catalog.getValue(2))
    fun pressButton3(): VendingMachine = sell(catalog.getValue(3))

    fun display(): String = display.show(balance)

    fun dispenser(): List<String> = dispenser
    fun coinReject(): List<Coin> = coinReject

    private fun sell(product: Product): VendingMachine {
        if (balance >= product.price) {
                return VendingMachine(
                        0.00,
                        dispenser + product.name,
                        coinReject,
                        SaleSuccessful()
                )
        }
        return VendingMachine(
                0.00,
                dispenser,
                coinReject,
                SaleFailed(product)
        )
    }

    private fun isValid(coin: Coin): Boolean = listOf(nickel(), dime(), quarter()).contains(coin)

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }
}

class Catalog() {
    fun getValue(i: Int): Product {
        return catalog.get(i)!!;
    }

    val catalog = mapOf(
            1 to Product("cola", 1.00),
            2 to Product("chips", 0.50),
            3 to Product("candy", 0.65)
    )
}



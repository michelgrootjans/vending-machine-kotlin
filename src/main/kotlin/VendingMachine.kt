class VendingMachine(
        private val balance: Double = 0.00,
        private val dispenser: List<String> = emptyList(),
        private val coinReject: List<Coin> = emptyList(),
        private val display: Display = DefaultDisplay()
) {
    private val catalog = Catalog()

    fun tick() : VendingMachine = VendingMachine(balance, dispenser, coinReject)

    fun insert(coin: Coin): VendingMachine =
        if (isValid(coin)) VendingMachine(balance + valueOf(coin), dispenser, coinReject)
        else VendingMachine(balance, dispenser, coinReject + coin)


    fun pressButton1(): VendingMachine = sell(catalog.getProduct(1))
    fun pressButton2(): VendingMachine = sell(catalog.getProduct(2))
    fun pressButton3(): VendingMachine = sell(catalog.getProduct(3))

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
        return vendingMachine(display = SaleFailed(product))
    }

    private fun vendingMachine(
            balance: Double = this.balance,
            display: Display = this.display,
            dispenser: List<String> = this.dispenser,
            coinReject: List<Coin> = this.coinReject
    ): VendingMachine = VendingMachine(balance, dispenser, coinReject, display)

    private fun isValid(coin: Coin): Boolean = listOf(nickel(), dime(), quarter()).contains(coin)

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }
}

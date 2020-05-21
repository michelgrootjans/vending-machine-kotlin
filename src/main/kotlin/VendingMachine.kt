class VendingMachine(
        private val balance: Double = 0.00,
        private val display: Display = DefaultDisplay(),
        private val dispenser: List<String> = emptyList(),
        private val coinReject: List<Coin> = emptyList(),
        private val dispenser2: Dispenser = Dispenser()
) {
    private val catalog = Catalog()

    fun tick(): VendingMachine = vendingMachine(display = DefaultDisplay())

    fun insert(coin: Coin): VendingMachine = when {
        isValid(coin) -> vendingMachine(balance = balance + valueOf(coin))
        else -> vendingMachine(coinReject = coinReject + coin)
    }

    fun display(): String = display.show(balance)
    fun dispenser(): List<String> = dispenser2.items
    fun coinReject(): List<Coin> = coinReject

    fun pressButton1(): VendingMachine = sell(catalog.getProduct(1))
    fun pressButton2(): VendingMachine = sell(catalog.getProduct(2))
    fun pressButton3(): VendingMachine = sell(catalog.getProduct(3))

    private fun sell(product: Product): VendingMachine =
            if (sufficientFundsFor(product))
                vendingMachine(balance = 0.00, display = SaleSuccessful(), dispenser2 = dispenser2.dispense(product.name))
            else
                vendingMachine(display = SaleFailed(product))

    private fun sufficientFundsFor(product: Product) = balance >= product.price

    private fun isValid(coin: Coin): Boolean = listOf(nickel(), dime(), quarter()).contains(coin)

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }

    private fun vendingMachine(
            balance: Double = this.balance,
            display: Display = this.display,
            dispenser: List<String> = emptyList(),
            coinReject: List<Coin> = this.coinReject,
            dispenser2: Dispenser = this.dispenser2
    ): VendingMachine = VendingMachine(balance, display, dispenser, coinReject, dispenser2)
}

class Dispenser(val items : List<String> = emptyList()) {
    fun dispense(item: String): Dispenser = Dispenser(items + item)

}

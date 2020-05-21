class VendingMachine(
        private val balance: Balance = Balance(),
        private val display: Display = Display(),
        private val dispenser: Dispenser = Dispenser(),
        private val coinReject: CoinReject = CoinReject()
) {
    private val catalog = Catalog()

    fun tick(): VendingMachine = vendingMachine(display = display.default())

    fun display(): String = display.show(balance)
    fun dispenser(): List<String> = dispenser.items
    fun coinReject(): List<Coin> = coinReject.coins

    fun insert(coin: Coin): VendingMachine = when {
        isValid(coin) -> vendingMachine(balance = balance.add(valueOf(coin)))
        else -> vendingMachine(coinReject = coinReject.add(coin))
    }

    fun pressButton1(): VendingMachine = sell(catalog.getProduct(1))
    fun pressButton2(): VendingMachine = sell(catalog.getProduct(2))
    fun pressButton3(): VendingMachine = sell(catalog.getProduct(3))

    private fun sell(product: Product): VendingMachine =
            if (balance.isSufficientFor(product.price))
                vendingMachine(balance = Balance(), display = display.saleSuccessful(), dispenser = dispenser.dispense(product.name), coinReject = coinReject.difficultstuffWith(balance, product))
            else
                vendingMachine(display = display.saleFailed(product))

    private fun isValid(coin: Coin): Boolean = listOf(nickel(), dime(), quarter()).contains(coin)

    private fun valueOf(coin: Coin) = when (coin) {
        nickel() -> 0.05
        dime() -> 0.10
        quarter() -> 0.25
        else -> 0.00
    }

    private fun vendingMachine(
            balance: Balance = this.balance,
            display: Display = this.display,
            dispenser: Dispenser = this.dispenser,
            coinReject: CoinReject = this.coinReject
    ): VendingMachine = VendingMachine(balance, display, dispenser, coinReject)
}

class VendingMachine(
        private val balance: Balance = Balance(),
        private val display: Display = Display(),
        private val dispenser: Dispenser = Dispenser(),
        private val coinReturn: CoinReturn = CoinReturn()
) {
    private val catalog = Catalog()

    fun tick(): VendingMachine = vendingMachine(display = display.default())

    fun display(): String = display.show(balance)
    fun dispenser(): List<String> = dispenser.items
    fun coinReturn(): List<Coin> = coinReturn.coins

    fun insert(coin: Coin): VendingMachine = when {
        balance.acceptsCoin(coin) -> vendingMachine(balance = balance.add(coin))
        else -> vendingMachine(coinReturn = coinReturn.add(coin))
    }

    fun pressButton1(): VendingMachine = sell(catalog.getProduct(1))
    fun pressButton2(): VendingMachine = sell(catalog.getProduct(2))
    fun pressButton3(): VendingMachine = sell(catalog.getProduct(3))
    fun pressCoinReturn(): VendingMachine = vendingMachine(balance = Balance(), coinReturn = CoinReturn(balance.coins))

    private fun sell(product: Product): VendingMachine =
            if (balance.isSufficientFor(product.price))
                vendingMachine(
                        balance = Balance(),
                        display = display.saleSuccessful(),
                        dispenser = dispenser.dispense(product.name),
                        coinReturn = coinReturn.add(balance.changeFor(product.price))
                )
            else
                vendingMachine(display = display.saleFailed(product))

    private fun vendingMachine(
            balance: Balance = this.balance,
            display: Display = this.display,
            dispenser: Dispenser = this.dispenser,
            coinReturn: CoinReturn = this.coinReturn
    ): VendingMachine = VendingMachine(balance, display, dispenser, coinReturn)
}
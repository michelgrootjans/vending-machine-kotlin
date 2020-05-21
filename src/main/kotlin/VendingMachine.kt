class VendingMachine(
        private val balance: Double = 0.00,
        private val display: Display = DefaultDisplay(),
        private val dispenser: Dispenser = Dispenser(),
        private val coinReject: List<Coin> = emptyList(),
        private val balance2: Balance = Balance()
) {
    private val catalog = Catalog()

    fun tick(): VendingMachine = vendingMachine(display = DefaultDisplay())

    fun display(): String = display.show(balance, balance2)
    fun dispenser(): List<String> = dispenser.items
    fun coinReject(): List<Coin> = coinReject

    fun insert(coin: Coin): VendingMachine = when {
        isValid(coin) -> vendingMachine(balance = balance + valueOf(coin), balance2 = balance2.add(valueOf(coin)))
        else -> vendingMachine(coinReject = coinReject + coin)
    }

    fun pressButton1(): VendingMachine = sell(catalog.getProduct(1))
    fun pressButton2(): VendingMachine = sell(catalog.getProduct(2))
    fun pressButton3(): VendingMachine = sell(catalog.getProduct(3))

    private fun sell(product: Product): VendingMachine =
            if (balance2.isSufficientFor(product.price))
                vendingMachine(balance = 0.00, balance2 = balance2.subtract(product.price), display = SaleSuccessful(), dispenser = dispenser.dispense(product.name))
            else
                vendingMachine(display = SaleFailed(product))

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
            coinReject: List<Coin> = this.coinReject,
            dispenser: Dispenser = this.dispenser,
            balance2: Balance = this.balance2
    ): VendingMachine = VendingMachine(balance, display, dispenser, coinReject, balance2)
}

class Balance(private val balance: Double = 0.00) {
    fun isSufficientFor(amount: Double): Boolean = amount <= balance
    fun add(amount: Double): Balance = Balance(balance + amount)
    fun subtract(amount: Double): Balance = Balance(balance - amount)
    fun show(): String {
        return "%.2f".format(balance)
    }

}


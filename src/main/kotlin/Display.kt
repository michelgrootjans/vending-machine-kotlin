open class Display {
    open fun show(balance: Double, balance2: Balance): String {
        return "%.2f".format(balance)
    }
}
class DefaultDisplay : Display() {
    override fun show(balance: Double, balance2: Balance): String = when (balance) {
        0.00 -> "INSERT COIN"
        else -> "%.2f".format(balance)
    }
}
class SaleSuccessful : Display() {
    override fun show(balance: Double, balance2: Balance): String {
        return "THANK YOU"
    }
}
class SaleFailed(private val product: Product) : Display() {
    override fun show(balance: Double, balance2: Balance): String {
        return "PRICE %.2f".format(product.price)

    }
}

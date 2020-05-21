open class Display {
    open fun show(balance: Balance): String {
        return balance.show()
    }

    open fun saleSuccessful(): Display {
        return SaleSuccessful()
    }

    fun saleFailed(product: Product): Display {
        return SaleFailed(product)
    }
}

class DefaultDisplay : Display() {
    override fun show(balance: Balance): String =
            if (balance.isEmpty()) "INSERT COIN"
            else balance.show()
}

class SaleSuccessful : Display() {
    override fun show(balance: Balance): String = "THANK YOU"
}

class SaleFailed(private val product: Product) : Display() {
    override fun show(balance: Balance): String = "PRICE %.2f".format(product.price)
}

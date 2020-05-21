open class Display {
    open fun show(balance2: Balance): String {
        return balance2.show()
    }
}

class DefaultDisplay : Display() {
    override fun show(balance2: Balance): String =
            if (balance2.isEmpty()) "INSERT COIN"
            else balance2.show()
}

class SaleSuccessful : Display() {
    override fun show(balance2: Balance): String {
        return "THANK YOU"
    }
}

class SaleFailed(private val product: Product) : Display() {
    override fun show(balance2: Balance): String {
        return "PRICE %.2f".format(product.price)

    }
}

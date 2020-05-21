open class AbstractDisplay {
    open fun show(balance: Balance): String =
            if (balance.isEmpty()) "INSERT COIN"
            else balance.show()

    open fun saleSuccessful(): AbstractDisplay {
        return SaleSuccessful()
    }

    fun saleFailed(product: Product): AbstractDisplay {
        return SaleFailed(product)
    }

    fun default(): AbstractDisplay {
        return AbstractDisplay()
    }
}

class DefaultDisplay : AbstractDisplay() {
}

private class SaleSuccessful : AbstractDisplay() {
    override fun show(balance: Balance): String = "THANK YOU"
}

private class SaleFailed(private val product: Product) : AbstractDisplay() {
    override fun show(balance: Balance): String = "PRICE %.2f".format(product.price)
}

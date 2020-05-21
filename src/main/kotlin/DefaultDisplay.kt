open class DefaultDisplay {
    open fun show(balance: Balance): String =
            if (balance.isEmpty()) "INSERT COIN"
            else balance.show()

    open fun saleSuccessful(): DefaultDisplay {
        return SaleSuccessful({ balance -> "THANK YOU" })
    }

    fun saleFailed(product: Product): DefaultDisplay {
        return SaleFailed(product)
    }

    fun default(): DefaultDisplay {
        return DefaultDisplay()
    }
}

private class SaleSuccessful(val function: (balance: Balance) -> String) : DefaultDisplay() {
    override fun show(balance: Balance): String = function(balance)
}

private class SaleFailed(private val product: Product) : DefaultDisplay() {
    override fun show(balance: Balance): String = "PRICE %.2f".format(product.price)
}

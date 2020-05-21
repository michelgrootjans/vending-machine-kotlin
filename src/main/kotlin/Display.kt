open class Display(val _show: (Balance) -> String = fun(balance: Balance): String = defaultMessage(balance)) {
    fun show(balance: Balance): String = _show(balance)

    fun default(): Display = Display()
    fun saleSuccessful(): Display = Display { balance -> "THANK YOU" }
    fun saleFailed(product: Product): Display = Display { balance -> "PRICE %.2f".format(product.price) }
}

private fun defaultMessage(balance: Balance): String {
    return if (balance.isEmpty()) "INSERT COIN"
    else balance.show()
}

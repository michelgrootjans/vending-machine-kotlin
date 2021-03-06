class Display(val _show: (Balance) -> String = fun(balance: Balance): String = defaultMessage(balance)) {
    fun show(balance: Balance): String = _show(balance)

    fun default(): Display = Display()
    fun saleSuccessful(): Display = Display { _ -> "THANK YOU" }
    fun saleFailed(product: Product): Display = Display { balance -> "PRICE ${product.price.format()}" }
}

private fun defaultMessage(balance: Balance): String {
    return if (balance.isEmpty()) "INSERT COIN"
    else balance.show()
}

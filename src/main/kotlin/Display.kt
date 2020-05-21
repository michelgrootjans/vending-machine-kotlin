open class Display(val _show: (Balance) -> String = fun(balance: Balance): String = defaultMessage(balance)) {

    fun show(balance: Balance): String = _show(balance)

    open fun saleSuccessful(): Display {
        return Display { balance -> "THANK YOU" }
    }

    fun saleFailed(product: Product): Display {
        return Display { balance -> "PRICE %.2f".format(product.price) }
    }

    fun default(): Display {
        return Display()
    }
}

private fun defaultMessage(balance: Balance): String {
    return if (balance.isEmpty()) "INSERT COIN"
    else balance.show()
}


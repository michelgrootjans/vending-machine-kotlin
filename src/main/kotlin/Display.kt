open class Display(val showw: (Balance) -> String = fun(balance: Balance): String {
    if (balance.isEmpty()) return "INSERT COIN"
    else return  balance.show()
}) {

    open fun show(balance: Balance): String = showw(balance)

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


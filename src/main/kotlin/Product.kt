class Catalog {
    fun getProduct(number: Int): Product {
        return catalog[number] ?: error("This machine does not have products in slot $number")
    }

    private val catalog = mapOf(
            1 to Product("cola", Amount(1.00)),
            2 to Product("chips", Amount(0.50)),
            3 to Product("candy", Amount(0.65))
    )
}

data class Product(val name: String, val price: Amount)

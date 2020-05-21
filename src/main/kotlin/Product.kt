class Catalog() {
    fun getValue(i: Int): Product {
        return catalog[i]!!
    }

    private val catalog = mapOf(
            1 to Product("cola", 1.00),
            2 to Product("chips", 0.50),
            3 to Product("candy", 0.65)
    )
}

data class Product(val name: String, val price: Double)

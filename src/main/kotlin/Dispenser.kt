class Dispenser(val items : List<String> = emptyList()) {
    fun dispense(item: String): Dispenser = Dispenser(items + item)
}

class CoinReject(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReject {
        return CoinReject(coins + coin)
    }

    fun difficultstuffWith(balance: Balance, product: Product): CoinReject {
        val cons = listOf(balance.remainingCoinsAfter(product.price))
        if(balance.amount() > product.price) {
            val coin = cons[0]
            return add(coin)
        }
        return CoinReject(coins)
    }
}
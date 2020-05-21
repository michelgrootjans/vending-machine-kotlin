class CoinReject(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReject {
        return CoinReject(coins + coin)
    }

    fun difficultstuffWith(balance: Balance, product: Product): CoinReject {
        val coins = balance.remainingCoinsAfter(product.price)
        if(balance.amount() > product.price) {
            val coin = coins[0]
            return add(coin)
        }
        return CoinReject(this.coins)
    }
}
class CoinReject(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReject {
        return CoinReject(coins + coin)
    }

    fun difficultstuffWith(balance: Balance, product: Product): CoinReject {
        val rest = balance.remainingCoinsAfter(product.price)
        if(balance.amount() > product.price) {
            return add(rest[0])
        }
        return CoinReject(this.coins)
    }
}
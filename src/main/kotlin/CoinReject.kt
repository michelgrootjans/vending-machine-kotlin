class CoinReject(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReject {
        return CoinReject(coins + coin)
    }

    fun difficultstuffWith(balance: Balance, product: Product): CoinReject {
        if(balance.amount() > product.price) return add(balance.remainingCoinsAfter(product.price))
        return CoinReject(coins)
    }
}
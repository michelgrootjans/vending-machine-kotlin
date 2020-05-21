class CoinReject(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReject {
        return CoinReject(coins + coin)
    }

    fun difficultstuffWith(balance: Balance, product: Product): CoinReject {
        val rest = balance.changeFor(product.price)
        if(balance.amount() > product.price) {
            return add(rest[0])
        }
        return CoinReject(this.coins)
    }
}
class CoinReject(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReject {
        return CoinReject(coins + coin)
    }

    fun difficultstuffWith(balance: Balance, product: Product): CoinReject {
        val change = balance.changeFor(product.price)
        if(balance.amount() > product.price) {
            return add(change[0])
        }
        return CoinReject( coins  + balance.changeFor(product.price))
    }
}
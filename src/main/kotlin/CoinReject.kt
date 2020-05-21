class CoinReject(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReject {
        return CoinReject(coins + coin)
    }

    fun add(change: List<Coin>): CoinReject {
        return CoinReject(coins + change)
    }
}
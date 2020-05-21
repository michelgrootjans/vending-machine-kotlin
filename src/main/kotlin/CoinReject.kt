class CoinReject(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReject {
        return CoinReject(coins + coin)
    }

    fun difficultstuffWith(change: List<Coin>): CoinReject {
        return CoinReject(coins + change)
    }
}
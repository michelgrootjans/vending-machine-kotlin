class CoinReject(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReject = CoinReject(coins + coin)
    fun add(change: List<Coin>): CoinReject = CoinReject(coins + change)
}
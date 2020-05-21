class CoinReturn(val coins: List<Coin> = emptyList()) {
    fun add(coin: Coin): CoinReturn = CoinReturn(coins + coin)
    fun add(change: List<Coin>): CoinReturn = CoinReturn(coins + change)
}
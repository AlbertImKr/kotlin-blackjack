package blackjack.business.card

data class Card(val suit: Suit, val rank: Rank) {
    override fun toString(): String {
        return "${rank.printName}${suit.printName}"
    }
}

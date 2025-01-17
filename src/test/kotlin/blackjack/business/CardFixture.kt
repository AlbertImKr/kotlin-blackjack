package blackjack.business

import blackjack.business.card.Card
import blackjack.business.card.Rank
import blackjack.business.card.Suit

object CardFixture {
    val SPACE_ACE = Card(Suit.SPADE, Rank.ACE)
    val SPACE_TWO = Card(Suit.SPADE, Rank.TWO)
    val SPACE_THREE = Card(Suit.SPADE, Rank.THREE)
    val SPACE_FOUR = Card(Suit.SPADE, Rank.FOUR)
    val SPACE_FIVE = Card(Suit.SPADE, Rank.FIVE)
    val SPACE_EIGHT = Card(Suit.SPADE, Rank.EIGHT)
    val SPACE_NINE = Card(Suit.SPADE, Rank.NINE)
    val SPACE_TEN = Card(Suit.SPADE, Rank.TEN)
}

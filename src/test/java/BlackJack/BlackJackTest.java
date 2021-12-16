package BlackJack;

import CardGame.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackTest {
    BlackJack blackJack = new BlackJack();

    @Test
    void getScoreTwentyOne() {
        assertEquals(21, blackJack.getScore(new Hand("DK,SA")));
    }

    @Test
    void getScoreTen() {
        assertEquals(10, blackJack.getScore(new Hand("D4,S6")));
    }

    @Test
    void getScoreFiveCards() {
        assertEquals(15, blackJack.getScore(new Hand("D2,S3,D3,C4,H3")));
    }
}
import com.memorygame.*;
import java.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testCardCreation() {
        Card card = new Card("Teste"); // Cria uma carta
        assertEquals("Teste", card.getValue()); // Verifica o valor da carta
        assertFalse(card.isFaceUp()); // Verifica se a carta está virada para baixo
    }

    @Test
    void testCardFlip() {
        Card card = new Card("Teste"); // Cria uma carta
        card.flip(); // Vira a carta
        assertTrue(card.isFaceUp()); // Verifica se a carta está virada para cima
        card.flip(); // Desvira a carta
        assertFalse(card.isFaceUp()); // Verifica se a carta está virada para baixo
    }

    @Test
    void testBoardInitialization() {
        Game game = Game.getInstance(2); // Cria uma instância do jogo com 2 pares
        Board board = game.getBoard();   // Obtém o tabuleiro do jogo
        assertEquals(4, board.getCards().size()); // Verifica o número de cartas no tabuleiro
    }

    @Test
    void testCardMatching() {
        Game game = Game.getInstance(2); // Cria uma instância do jogo com 2 pares
        Board board = game.getBoard();   // Obtém o tabuleiro do jogo
        List<Card> cards = board.getCards(); // Obtém as cartas

        // Supondo que as cartas estão em pares e o tabuleiro foi embaralhado
        int firstCardIndex = -1;
        int secondCardIndex = -1;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getValue().equals(cards.get(j).getValue())) {
                    firstCardIndex = i;
                    secondCardIndex = j;
                    break;
                }
            }
            if (firstCardIndex != -1) break;
        }

        assertNotEquals(-1, firstCardIndex); // Verifica se encontrou a primeira carta
        assertNotEquals(-1, secondCardIndex); // Verifica se encontrou a segunda carta

        board.flipCard(firstCardIndex); // Vira a primeira carta
        board.flipCard(secondCardIndex); // Vira a segunda carta
        assertTrue(board.checkMatch(firstCardIndex, secondCardIndex)); // Verifica se formam um par
    }

    @Test
    void testAllCardsMatched() {
        Game game = Game.getInstance(1); // Cria uma instância do jogo com 1 par
        Board board = game.getBoard(); // Obtém o tabuleiro do jogo
        List<Card> cards = board.getCards(); // Obtém as cartas
        
        // Marca as cartas como encontradas
        for (Card card : cards) {
            card.setMatched(true);
        }

        assertTrue(board.allCardsMatched()); // Verifica se todas as cartas foram encontradas como pares
    }
}
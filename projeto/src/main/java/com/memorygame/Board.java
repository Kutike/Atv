package com.memorygame;

import java.util.Collections;
import java.util.List;

public class Board {
    private final List<Card> cards; // Lista de cartas no tabuleiro

    // Construtor
    public Board(List<Card> cards) {
        this.cards = cards;
        Collections.shuffle(this.cards); // Embaralha as cartas
    }

    // Retorna a lista de cartas
    public List<Card> getCards() {
        return cards;
    }

    // Vira a carta no índice especificado, se não estiver virada ou não for parte de um par encontrado
    public void flipCard(int index) {
        if (!cards.get(index).isMatched()) {
            cards.get(index).flip();
        }
    }

    // Verifica se as cartas nos índices formam um par
    public boolean checkMatch(int index1, int index2) {
        Card card1 = cards.get(index1);
        Card card2 = cards.get(index2);
        if (card1.getValue().equals(card2.getValue())) {
            card1.setMatched(true);
            card2.setMatched(true);
            return true;
        }
        return false;
    }

    // Verifica se todas as cartas foram encontradas como pares
    public boolean allCardsMatched() {
        for (Card card : cards) {
            if (!card.isMatched()) {
                return false;
            }
        }
        return true;
    }
}
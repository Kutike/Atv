package com.memorygame;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
    // Cria e retorna uma lista de cartas com os valores especificados
    public static List<Card> createCards(int pairs) {
        List<Card> cards = new ArrayList<>();
        for (int i = 1; i <= pairs; i++) {
            cards.add(new Card("Carta" + i));
            cards.add(new Card("Carta" + i));
        }
        return cards;
    }
}
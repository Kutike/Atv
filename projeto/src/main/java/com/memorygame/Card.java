package com.memorygame;

public class Card {
    private final String value; // Valor da carta
    private boolean isFaceUp;   // Estado da carta (virada para cima ou não)
    private boolean isMatched;  // Estado se a carta foi encontrada em um par

    // Construtor
    public Card(String value) {
        this.value = value;
        this.isFaceUp = false;
        this.isMatched = false;
    }

    // Retorna o valor da carta
    public String getValue() {
        return value;
    }

    // Verifica se a carta está virada para cima
    public boolean isFaceUp() {
        return isFaceUp;
    }

    // Vira a carta (altera o estado)
    public void flip() {
        if (!isMatched) {
            this.isFaceUp = !this.isFaceUp;
        }
    }

    // Define o estado da carta como parte de um par encontrado
    public void setMatched(boolean isMatched) {
        this.isMatched = isMatched;
    }

    // Verifica se a carta é parte de um par encontrado
    public boolean isMatched() {
        return isMatched;
    }
}
package com.memorygame;

public class Game {
    private static Game instance; // Instância única do jogo (Singleton)
    private final Board board;    // Tabuleiro do jogo

    // Construtor
    private Game(int pairs) {
        this.board = new Board(CardFactory.createCards(pairs));
    }

    // Retorna a instância do jogo, criando-a se necessário
    public static Game getInstance(int pairs) {
        if (instance == null) {
            instance = new Game(pairs);
        }
        return instance;
    }

    // Retorna o tabuleiro do jogo
    public Board getBoard() {
        return board;
    }
}
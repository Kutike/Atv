package com.memorygame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = Game.getInstance(4); // Cria uma instância do jogo com 4 pares de cartas
        Board board = game.getBoard();   // Obtém o tabuleiro do jogo

        while (!board.allCardsMatched()) { // Continua até que todas as cartas estejam viradas
            System.out.println("Tabuleiro Atual:");
            for (int i = 0; i < board.getCards().size(); i++) { // Exibe o estado atual do tabuleiro
                Card card = board.getCards().get(i);
                if (card.isFaceUp()) {
                    System.out.print("[" + card.getValue() + "] ");
                } else {
                    System.out.print("[?] ");
                }
            }
            System.out.println();

            int index1 = -1, index2 = -1;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.println("Digite dois indices de cartas para virar (1-" + board.getCards().size() + "):");
                    index1 = Integer.parseInt(scanner.next()) - 1; // Converte o índice para base 0
                    index2 = Integer.parseInt(scanner.next()) - 1; // Converte o índice para base 0
                    validInput = true;

                    if (index1 == index2 || index1 < 0 || index2 < 0 || index1 >= board.getCards().size() || index2 >= board.getCards().size()) {
                        System.out.println("Indices invalidos, tente novamente.");
                        validInput = false;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Entrada invalida! Digite somente numeros entre 1 e " + board.getCards().size() + ".");
                }
            }

            if (board.getCards().get(index1).isMatched() || board.getCards().get(index2).isMatched()) {
                System.out.println("Esse par ja foi encontrado.");
                continue;
            }

            board.flipCard(index1); // Vira a primeira carta
            board.flipCard(index2); // Vira a segunda carta

            if (board.checkMatch(index1, index2)) { // Verifica se formam um par
                System.out.println("Par encontrado!");
            } else {
                System.out.println("Nao e um par.");
                board.flipCard(index1); // Desvira a primeira carta
                board.flipCard(index2); // Desvira a segunda carta
            }
        }

        System.out.println("Todas as cartas viradas! Voce ganhou!");
        scanner.close(); // Fecha o scanner
    }
}
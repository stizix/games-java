package games.factoredgames;

import java.util.Scanner;

public class PlayTicTacToe {

    private static int askInt(Scanner scanner, String question) {
        while (true) {
            System.out.print(question);
            String token = scanner.next();
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                System.out.println("Ce n'est pas un nombre, recommence.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom du premier joueur (X) : ");
        String first = scanner.next();
        System.out.print("Nom du second joueur (O) : ");
        String second = scanner.next();

        TicTacToe game = new TicTacToe(first, second);

        while (!game.isOver()) {
            System.out.println();
            System.out.println(game.situationToString());
            System.out.println("C'est a " + game.getCurrentPlayer() + " de jouer");
            System.out.println("Votre coup :");

            int row = askInt(scanner, "- rangee ? ");
            int column = askInt(scanner, "- colonne ? ");
            int coup = 3*row + column;

            if (game.isValid(coup)) {
                game.execute(coup);
            } else {
                System.out.println("Coup invalide (hors grille ou case deja prise), recommence.");
            }
        }

        System.out.println();
        System.out.println(game.situationToString());
        String winner = game.getWinner();
        if (winner == null) {
            System.out.println("Match nul !");
        } else {
            System.out.println("Bravo " + winner + ", vous avez gagne !");
        }

        scanner.close();
    }
}

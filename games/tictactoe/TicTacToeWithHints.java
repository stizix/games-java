package games.tictactoe;

import java.util.ArrayList;

public class TicTacToeWithHints extends TicTacToe {

    public TicTacToeWithHints(String firstPlayer, String secondPlayer) {
        // On crée le constructeur avec super pour récuperer celui de TicTacToe
        super(firstPlayer, secondPlayer);
    }

    public ArrayList<Integer> hints() {
        // On fait la liste de résultats
        ArrayList<Integer> result = new ArrayList<>();
        //ensuite on définit qui est l'opposant (la menace)
        String opponentMark;        
        if (getCurrentPlayer().equals(firstPlayer)) {
            opponentMark = "O";
        } else {
            opponentMark = "X";
        }
        // Et on teste pour voir si il y a des menaces pour les ajouter dans la liste 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    board[i][j] = opponentMark;

                    if (getWinner() != null) {
                        result.add(3 * i + j);
                    }

                    board[i][j] = null;
                }
            }
        }
        return result;
    }

    @Override
    public String situationToString() {
        String affichage = super.situationToString();

        ArrayList<Integer> listeIndices = this.hints();

        if (!listeIndices.isEmpty()) {
            affichage += "Indices (menaces) : " + listeIndices + System.lineSeparator();
        }

        return affichage;
    }
}
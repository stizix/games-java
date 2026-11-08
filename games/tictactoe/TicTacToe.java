package games.tictactoe;

public class TicTacToe {

    protected String firstPlayer;
    protected String secondPlayer;
    protected String[][] board;
    private String currentPlayer;

    public TicTacToe(String firstPlayer, String secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.board = new String[3][3];
        this.currentPlayer = firstPlayer;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void execute(int row, int column) {
        if (currentPlayer.equals(firstPlayer)) {
            board[row][column] = "X";
            currentPlayer = secondPlayer;
        } else {
            board[row][column] = "O";
            currentPlayer = firstPlayer;
        }
    }

    public boolean isValid(int row, int column) {
        return row >= 0 && row <= 2
            && column >= 0 && column <= 2
            && board[row][column] == null;
    }

    public boolean wins(String player, int row, int column, int deltaRow, int deltaColumn) {
        String mark;
        if (player.equals(firstPlayer)) {
            mark = "X";
        } else {
            mark = "O";
        }
        return mark.equals(board[row][column])
            && mark.equals(board[row + deltaRow][column + deltaColumn])
            && mark.equals(board[row + 2 * deltaRow][column + 2 * deltaColumn]);
    }

    private boolean hasWon(String player) {
        for (int i = 0; i < 3; i++) {
            if (wins(player, i, 0, 0, 1)) {
                return true;
            }
            if (wins(player, 0, i, 1, 0)) {
                return true;
            }
        }
        return wins(player, 0, 0, 1, 1)
            || wins(player, 0, 2, 1, -1);
    }

    public String getWinner() {
        if (hasWon(firstPlayer)) {
            return firstPlayer;
        }
        if (hasWon(secondPlayer)) {
            return secondPlayer;
        }
        return null;
    }

    private boolean isFull() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isOver() {
        return getWinner() != null || isFull();
    }

    public String situationToString() {
        String s = "  0 1 2" + System.lineSeparator();
        for (int r = 0; r < 3; r++) {
            s += r;
            for (int c = 0; c < 3; c++) {
                s += " " + (board[r][c] == null ? "." : board[r][c]);
            }
            s += System.lineSeparator();
        }
        return s;
    }

}

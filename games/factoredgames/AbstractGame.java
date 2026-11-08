package games.factoredgames;

public abstract class AbstractGame{
    protected String firstPlayer;
    protected String secondPlayer;
    protected String currentPlayer;
    public AbstractGame(String firstPlayer, String secondPlayer){
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.currentPlayer = firstPlayer;
    }
    protected abstract void doExecute(int coup);
    public void execute(int coup){
        doExecute(coup);
        if (currentPlayer.equals(firstPlayer)){
            currentPlayer = secondPlayer;
        }
        else{
            currentPlayer = firstPlayer;
        }
    }
    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
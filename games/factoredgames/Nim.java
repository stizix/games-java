package games.factoredgames;
public class Nim extends AbstractGame{

	int tailleInitialeTas;
	int nbreMaxAllumettes;
	int currentTas;


public Nim(int tailleInitialeTas, int nbreMaxAllumettes, String j1, String j2){
super(j1,j2);
this.tailleInitialeTas= tailleInitialeTas;
this.nbreMaxAllumettes= nbreMaxAllumettes;
this.currentTas= tailleInitialeTas;
}

public int getInitialNbMatches(){
	return this.tailleInitialeTas;
}

public int getCurrentNbMatches(){
	return this.currentTas;
}


public String situationToString() {
	return this.getCurrentNbMatches() +" Allumettes restantes; joueur suivant : "+ this.getCurrentPlayer();
}

    protected void doExecute(int coup) {


this.currentTas = this.currentTas - coup;


}

public boolean isValid(int v){
if ( v > 0 && v <= this.nbreMaxAllumettes && v <= this.currentTas){
	return true;
}
else {
	return false;
}
}

public boolean isOver(){
	if ( this.currentTas == 0){
		return true;
}
	else {
		return false;
	}

}

public String getWinner() {
	if (this.isOver()) {
		return this.currentPlayer;
	}
	return null;
}

}

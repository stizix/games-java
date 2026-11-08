package games.nim ;

public class Nim{

	int tailleInitialeTas;
	int nbreMaxAllumettes;
	int currentTas;

	String j1;
	String j2;
	String currentJ;

public Nim(int tailleInitialeTas, int nbreMaxAllumettes, String j1, String j2){
this.currentJ=j1;
this.j1= j1;
this.j2= j2;
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

public String getCurrentPlayer(){
	return this.currentJ;
}

public String situationToString() {
	return this.getCurrentNbMatches() +" Allumettes restantes; joueur suivant : "+ this.getCurrentPlayer();
}

public void removeMatches(int k) {

this.currentTas = this.currentTas - k;

	if (this.currentJ.equals(this.j1)){
		this.currentJ = this.j2;
		}
	else {
		this.currentJ = this.j1;
		}

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
		return this.currentJ;
	}
	return null;
}

}

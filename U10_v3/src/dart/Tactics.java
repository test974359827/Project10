package dart;

public class Tactics extends Darts{
	
	
	int[][] PlayerPoint; // die Punkte von Player wird hier gespeichert.
	
/**
 * Hier wird mithilfe von PlayerCount Tactics gespielt.
 * @param PlayerCount : Anzahl alle Players
 */
	
	public Tactics(int PlayerCount){
		
			super("Tactics",PlayerCount); //
			if(! getTest()) gameTactics();
		
		}
	/**
	 * die Punkte von Player wird mithilfe von Klasse Player in Array gespeichert.
	 * @param Player 
	 */ 
	public void Point(Player Player){
		PlayerPoint = Player.getThrowDartValue();
	}
	
	/**
	 * hier wird entschieden ob Player gewonnen hat.
	 * Kein Parameter
	 * @return true or false, True wenn Spieler gewonnen hat und else false
	 */
	public boolean gewonnen(){
		
		

		int PlayerPointMerge[][] = new int [22][2] ; 
		
	// Hier wird die gleiche werte von Array PlayerPoint in einem anderen Array gemerged.
	// Z.B.: 18 (Nummer)& 2(	Multiplikator) ,18 (Nummer)& 1(Multiplikator) => 18 (Nummer)& 3(Multiplikator)
	// Algorithmus von Merge:
		int wert=0;
		for(int a=1; a<22; a++) {
			wert=0;
			for(int b=0; b< PlayerPoint.length ; b++) {
				if(PlayerPoint[b][0]==a) {
					wert= wert+PlayerPoint[b][1];
					} if(PlayerPoint[b][0]==25){
						wert= wert+PlayerPoint[b][1];	
				}
					PlayerPointMerge[a][1]= wert; // Multiplikator von der Zahl
					PlayerPointMerge[a][0]= a;    // welche Nummer der Player getroffen hat
				
				}
			
			}
	for(int i= 9; i< PlayerPointMerge.length; i++) { // entscheidet ob der Spieler gewonnen hat.
			// wenn Player alle Zahlen von 10 bis 20 und 25 dreimal getroffen hat dann hat er gewonnen.
		if(PlayerPointMerge[i][0]==i+1 
					&& ((PlayerPointMerge[i][0])*(PlayerPointMerge[i][1])
					> 3*(PlayerPointMerge[i][0]))) {
				return true;	
			}
		}
				return false;	
	}
/**
 * hier wird game Tactics gespielt.
 * 
 */
	public void gameTactics() {
		while(! isOver()){
			Player player = getPlayerByIndex(getActivePlayerNumber());
			if(getLeftDarts() > 0){ // so lange der Player Darts übrig hat, kann er weiterspielen
				int[] in = input();
				throwDart(in[0],in[1]);
				Point(player);
				if(gewonnen()) { // wenn Player gewonnen hat dann endGame.
					setGameWinner(true);
					endGame();
				}
			} 
			else { // wenn nicht dann nächster Player.
				nextPlayer();
			}
		
			
		}		
		}	
	}


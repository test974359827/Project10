package dart;

public class Tactics extends Darts{
	
	
	int[][] PlayerPoint; // die Punkte von Player wird hier gespeichert.
	
/**
 * Hier wird mithilfe von PlayerCount gameTactics gespielt.
 * @param PlayerCount : Nummer von Player
 */
	
	public Tactics(int PlayerCount){
		
			super("Tactics",PlayerCount); //
			gameTactics();
			
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
		
		
	//	Arrays.sort(PlayerPoint, new Comparator<Integer[]>() {
	//	    public int compare(Integer[] int1, Integer[] int2) {
	//	        Integer numOfKeys1 = int1[0];
	//	        Integer numOfKeys2 = int2[0];
	//	        return numOfKeys1.compareTo(numOfKeys2);
	//	    }
	//	}
	//	);
		int PlayerPointMerge[][] = new int [22][2] ; 
		
	// hier wird die gleiche von Array PlayerPoint in einem Array gemerged.
		// hier wird die Algorithmus von Merge geschrieben.
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
					PlayerPointMerge[a][0]= a;    // wie viel der Player getroffen hat
					
					
				}
			
			}
	for(int i= 9; i< PlayerPointMerge.length; i++) { // entscheidet ob Player gewonnen hat.
			// wenn Player alle Zahlen von 10 bis 20 und 25 dreimal getroffen hat.
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
			if(getLeftDarts() > 0){ // so lange der Player Darts ubrig hat, kann er weiterspielen
				int[] in = input();
				throwDart(in[0],in[1]);
				Point(player);
				if(gewonnen()) { // wenn Player gewonnen hat dann endGame.
			//		setGameWinner(true);
					endGame();
				}
			} 
			else { // wenn nicht dann nächster Player.
				nextPlayer();
			}
		
			
		}		
		}	
	}


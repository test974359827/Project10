package dart;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Tactics extends Darts{
	
	
	public int[][] PlayerPoint; // die Punkte von Player wird hier gespeichert.
	
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

	 * kein Return
	 * 
	 */
	public void Point(){
		PlayerPoint = getPlayerByIndex(getActivePlayerNumber()).getThrowDartValue();
	  
	
	}
	public int PlayerPointMerge[][] ; 
	
	public int[][] Merg() {
		// Hier wird die gleiche werte von Array PlayerPoint in einem anderen Array gemerged.
		// Z.B.: 18 (Nummer)& 2(	Multiplikator) ,18 (Nummer)& 1(Multiplikator) => 18 (Nummer)& 3(Multiplikator)
		// Algorithmus von Merge:
		int[][] merg = new int[22][2];
		for(int a=0; a<21; a++) {
			merg[a][1] = 0;
			int temp = 0 ;
			for(int b=0; b< PlayerPoint.length ; b++) {
				if(PlayerPoint[b][0]==a) {
					temp= temp+PlayerPoint[b][1];
					} 
				}
			merg[a][0]= a;    // welche Nummer der Player getroffen hat
			merg[a][1] = temp;
			}
		for(int b=0; b< PlayerPoint.length ; b++){
			if(PlayerPoint[b][0] == 25)
				merg[21][1] = merg[21][1]  + PlayerPoint[b][1];
		} 
		merg[21][0] = 25;
		PlayerPointMerge = new int[22][2];
		PlayerPointMerge = merg;
		return merg;
	}
	
	
	/**
	 * hier wird entschieden ob Player gewonnen hat.
	 * Kein Parameter
	 * @return true or false, True wenn Spieler gewonnen hat und else false
	 */
	public boolean gewonnen(){
		Merg();
		int[][] temp = PlayerPointMerge;
		 for(int i = 1 ; i < temp.length ; i++)
			 System.out.println(Integer.toString(temp[i][0]) + " "+Integer.toString(temp[i][1]) );
		 
		 
		 int t = 0;
	for(int i= 10; i< PlayerPointMerge.length; i++) { // entscheidet ob der Spieler gewonnen hat.
			// wenn Player alle Zahlen von 10 bis 20 und 25 dreimal getroffen hat dann hat er gewonnen.
		
		if(PlayerPointMerge[i][1] >= 3) 
			t++;
					
	}
	System.out.println(t);
	if(t == 12){
		return true;}
	return false;	
	}
/**
 * hier wird game Tactics gespielt.
 * 
 */
	public void gameTactics() {
		while(! isOver()){
			if(getLeftDarts() > 0){ // so lange der Player Darts übrig hat, kann er weiterspielen
				int[] in = input();
				throwDart(in[0],in[1]);
				Point();
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


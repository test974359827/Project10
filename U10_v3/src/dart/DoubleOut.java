package dart;
/**
 * diese method ist für GameMode : Double Out
 * 
 * In diesem Spielmodus
 * startet ein Spieler standardmäßig mit einer Punktzahl von 501 Punkten und muss diese auf
 * 0 senken

 * @author Shayan Davari Fard
 *
 */
public class DoubleOut extends Darts{

	/**
	 * die private Variable für Gewwinpunkte als int
	 */
	private int wp = 501 ; // Gewwinpunkte 
	/**
	 * die private Variable für Punkte des Spielers als int
	 */
	private int Point = 0 ;
	/**
	 * die private Variable für ganze Punkte jeder Spieler als int[]
	 */
	private int[] playerScores ;
	
	
	/**
	 * Konstruktur
	 * 
	 * @param PlayerCount
	 */
	public DoubleOut(int PlayerCount){
		super("Double Out",PlayerCount);
		playerScores = new int[getPlayerCount()];
		if(!getTest()) gameDoubleOut(); // Anfang des Spiels
	}
	/**
	 * Point : für Rechnung bisheriger Punkte Spieler
	 * 
	 * @param Player , der active ist
	 */
	public void Point(){
		Point = 0 ; 
		int[][] PlayerPoint = getPlayerByIndex(getActivePlayerNumber()).getThrowDartValue();
		for(int i = 0 ; i < PlayerPoint.length ; i++)
			Point = PlayerPoint[i][0] * PlayerPoint[i][1] + Point; 
	}

	public int getPoint(){
		return Point;
	}
	
	/**
	 * gameDoubleOut : hier wird das Spiel durchgeführt
	 * 
	 * 
	 * 
	 */
	public void gameDoubleOut(){
		// solange Spiel noch gespielt wird ...
		while(! isOver()){
			if(getLeftDarts() > 0){ 
				int[] in = input();
				if(!throwDart(in[0],in[1]))
					break;
				Point();
				if(Point > wp){
					Sonder();
					nextPlayer();
				}
				if(obgewinnt()){
						setGameWinner(true);
						endGame();
				}
			}
			else if(getLeftDarts() == 0)
				nextPlayer();
		}
		
	}
	
	
	public boolean obgewinnt(){
		Player[] player = getPlayers();
		Point();
		if(getPoint() == wp ){ // wenn wp erreicht wird, ist Game am Ende
			if(player[getActivePlayerNumber()].getThrowDartValueByIndex(player[getActivePlayerNumber()].getThrowDartValue().length-1, 1) == 2 )
			return true;
		}
		return false;
			
	}
		
	/**
	 * Sonder : Das ist für besondere Fälle 
	 * 1. wenn Spieler mehr als WP erreicht
	 * 2. wenn Spieler genau wp erreicht aber Multi von letze versuch nicht 2 ist 
	 * 
	 * Wenn erreichende Punkte mehr als notwendige Punkte ist, muss diese Runde nicht beachtet werden ( alle nummer und multi auf 0 eingesetzt wird ) 
	 * 
	 */
	public void Sonder(){
		int[] TD = { 0 , 0 };
		Player player = getPlayerByIndex(getActivePlayerNumber());
		switch (getLeftDarts()){
		case 2 : 
			player.setThrowDartValueByIndex(player.getThrowDartValue().length - 1 , TD);
			addToTable(getActivePlayerNumber(), "0 * 0", player.getThrowDartValue().length);
			player.setThrowDartValue(TD);
			addToTable(getActivePlayerNumber(), "0 * 0", player.getThrowDartValue().length);
			player.setThrowDartValue(TD);
			addToTable(getActivePlayerNumber(), "0 * 0", player.getThrowDartValue().length);
			break;
		case 1 : 
			player.setThrowDartValueByIndex(player.getThrowDartValue().length - 2 , TD);
			addToTable(getActivePlayerNumber(), "0 * 0", player.getThrowDartValue().length-1);
			player.setThrowDartValueByIndex(player.getThrowDartValue().length - 1 , TD);
			addToTable(getActivePlayerNumber(), "0 * 0", player.getThrowDartValue().length);
			player.setThrowDartValue(TD);
			addToTable(getActivePlayerNumber(), "0 * 0", player.getThrowDartValue().length);
			break;
		case 0 : 
			player.setThrowDartValueByIndex(player.getThrowDartValue().length - 3 , TD);
			addToTable(getActivePlayerNumber(), "0 * 0", player.getThrowDartValue().length-2);
			player.setThrowDartValueByIndex(player.getThrowDartValue().length - 2 , TD);
			addToTable(getActivePlayerNumber(), "0 * 0", player.getThrowDartValue().length-1);
			player.setThrowDartValueByIndex(player.getThrowDartValue().length - 1 , TD);
			addToTable(getActivePlayerNumber(), "0 * 0", player.getThrowDartValue().length);
			break;
		}
	}
	
	/**
	 * getScore
	 * 
	 * verbleibenden
	 * Punktzahl für jeden Spieler zurückgibt
	 * 
	 * @return playerScores als int
	 */
	public int[] getScore() {
		Player[] ListOfPlayer = getPlayers();
		for(int i = 0; i < getPlayerCount(); i++) {
			playerScores[i] = wp;
			if(ListOfPlayer[i].getThrowDartValue() != null){//TODO baraye Arian
				for(int j = 0; j < ListOfPlayer[i].getThrowDartValue().length; j++) 
					playerScores[i] = playerScores[i] - ListOfPlayer[i].getThrowDartValueByIndex(j, 0) * ListOfPlayer[i].getThrowDartValueByIndex(j, 1) ;	
			}
		}
		
		return playerScores;
	}
}

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
	private int wp = 51 ; // Gewwinpunkte 
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
		gameDoubleOut(); // Anfang des Spiels
	}
	/**
	 * Point : für Rechnung bisheriger Punkte Spieler
	 * 
	 * @param Player , der active ist
	 */
	public void Point(Player Player){
		Point = 0 ; 
		int[][] PlayerPoint = Player.getThrowDartValue();
		for(int i = 0 ; i < PlayerPoint.length ; i++)
			Point = PlayerPoint[i][0] * PlayerPoint[i][1] + Point; 
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
			Player player = getPlayerByIndex(getActivePlayerNumber());
			if(getLeftDarts() > 0){ 
				int[] in = input();
				if(!throwDart(in[0],in[1]))
					break;
				Point(player);
				if(Point > wp){
					Sonder();
					nextPlayer();
				}
					
				if(Point == wp ){ // wenn wp erreicht wird, ist Game am Ende
					if(in[1] == 2 )
						endGame();
					else{ 
						Sonder();
						nextPlayer();
					}	
				}
			}
			else if(getLeftDarts() == 0)
				nextPlayer();
		}
		
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
			int temp = 0;
			int [][] historyPoint = ListOfPlayer[i].getThrowDartValue();
			for(int j = 0; j < ListOfPlayer[i].getThrowDartValue().length; j++) {
				temp = temp + historyPoint[j][0] * historyPoint[j][1];				
			}
			playerScores[i] = wp - temp;
		}
		
		return playerScores;
	}
}

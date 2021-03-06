package dart;

/**
 * Spielmodi Schanghai
 */

public class Shanghai extends Darts{
	
	private int [] playerScores = new int[getPlayerCount()]; // In diesem Array werden Punktzahl jeder Spieler gespeichert.
	private int maxRoundNumber = 9; // Maximale Anzahl der Runden
	
	/**
	 * Der Konstruktor der Spielmodi Schanghai
	 * @param PlayerCount 
	 * 		Anzahl der Spieler
	 */
	public Shanghai(int PlayerCount){
		super("Shanghai",PlayerCount);
		if(!getTest()) gameShanghai(); // Die Basismethode der Spielmodi Schanghai, die hier aufgerufen und ausgef�hrt wird.
	}
	

	/**
	 * Die Methode pr�ft. ob in der ersten
	 Runde nur Punkte mit W�rfen auf das Feld mit der 1 erzielt werden (mit Doppel und Trippel
	 ), in der zweiten Runde nur mit Feld 2 usw. bis in der neunten Runde auf Feld 9.
	 
	 * @param Num 
	 * 		Num bezeichnet hier das Feld 1 bis 9 
	 * @param round 
	 * 		Rundenummer
	 * @return
	 * 		Gibt das entsprechende Zahlenfeld zur�ck, falls die Rundennummer die Feldnummer entspricht. Ansonsten 0.
	 * 		
	 */
	public int checkPlayerThrow(int Num , int round) {
		if(Num == round) {			
			return Num;
		}
		
		return 0; 
	}
	
	
	/**
	 * 
	 * 	 Basis Methode der Spielmodi Schangahi
	 */
	public void gameShanghai() {
		int i=0;
		while(!isOver()) {
			
			if(i <  maxRoundNumber * 3 * getPlayers().length)
		{
			
			if(getLeftDarts() > 0){ // verbleibende W�rfe
				int[] in = input(); // Die Eingabe
				throwDartsShanghahi(in[0],in[1]);	
			}
			else if(getLeftDarts() == 0){ // Sonderregel, falls der Spieler ein Schanghai erzielt(Er gewinnt sofort) 
				if(specialCase()) { 
					setGameWinner(true); // Der Gewinner wird festgestellt
					endGame();} // Hier wird das Spiel beendet
					nextPlayer(); // N�chste Spieler ist daran
				}
		    }
			whoIsWinner(getScore()); // Die Punktzahl des Gewinners wird ausgegeben. 
			setGameWinner(true); // Der Gewinner wird festgestellt
			endGame(); // Hier wird das Spiel beendet
		}
		i++;
	}
	
	public void throwDartsShanghahi(int a1, int a2) {
		int round = 0; 
		Player p = getPlayerByIndex(getActivePlayerNumber());
		if(p.getThrowDartValue() == null) // Falls der Spieler noch nicht geworfen hat, Also throwDartValue = null; 
			round = 1;
		else 
			round = (int)(p.getThrowDartValue().length / 3) + 1; // Rundenummer
		throwDart(checkPlayerThrow(a1, round), a2);
		
	}
	
	
	/**
	 * die Methode gibt ein Array mit der Punktzahl f�r jeden Spieler zur�ck.
	 * @return 
	 * 	gibt das Array zur�ck, das die Punktzahl f�r jeden Spieler enth�lt.
	 */
	public int[] getScore() {	
		
		Player[] ListOfPlayer = getPlayers(); // Enth�lt alle Spieler 
		for(int i = 0; i < getPlayerCount(); i++) {
			playerScores[i] = 0 ;
			if(ListOfPlayer[i].getThrowDartValue() != null){
				for(int j = 0; j < ListOfPlayer[i].getThrowDartValue().length; j++) 
					playerScores[i] = playerScores[i] + ListOfPlayer[i].getThrowDartValueByIndex(j, 0) * ListOfPlayer[i].getThrowDartValueByIndex(j, 1) ;	// Berechnung der Punktzahl
			}
			
		}
		
		return playerScores;
	}

	
	/**
	 * Diese Methode geht am Ende des Spiels das ganze Array durch, welches die Punktzahl jedes Spielers enth�lt und �berpr�ft,
	 * welcher Spieler die h�chste Punktzahl erreicht hat. 
	 * @param ps
	 * 		Punktzahl
	 */
	public void whoIsWinner(int [] ps) {
		int temp = 0; // Zwischenspeicher 
		for(int i = 1; i < ps.length; i++) {
			if(ps[temp] < ps[i]) {
				temp = i;
			}
		}
		setActivePlayerNumber(temp); // Der jetzige Spieler(bzw. der die h�chste Punktzahl erreicht hat) ist der Gewinner.
		
	}
	 
	/**
	 * Die Sonderregel, Das Shanghai. Ein Spieler erzielt ein Shanghai, indem er die zu treffende
	 Zahl mit einem Multiplikator von 1, danach mit einem Multiplikator von 2 und zuletzt mit
	 einem Multiplikator von 3 trifft. Der Spieler, der ein Shanghai erzielt, gewinnt das Spiel sofort.
	 
	 * @param player 
	 * 		Bezeichnet der Spieler (�bergabe)
	 * @return 
	 * 		gibt true zur�ck, falls die Bedingungen f�r die Sonderregel erf�llt sind und false, when nicht. 
	 */
	public boolean specialCase() {
		Player p = getPlayerByIndex(getActivePlayerNumber());
		int a3 = p.getThrowDartValueByIndex(p.getThrowDartValue().length - 1, 1); // Multipikator 1  
		int a2 = p.getThrowDartValueByIndex(p.getThrowDartValue().length - 2, 1); // Multipikator 2
		int a1 = p.getThrowDartValueByIndex(p.getThrowDartValue().length - 3, 1); // Multipikator 3 
		
		if(a3 == 3 && a2 == 2 && a1 == 1) {		
			return true;
		}
		
		return false;
		
	}
}

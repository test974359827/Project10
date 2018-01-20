package dart;

/**
 * Spielmodi Schanghai
 */

public class Shanghai extends Darts{
	
	private int [] playerScores = null; // In diesem Array werden Punktzahl jeder Spieler gespeichert.
	private int maxRoundNumber = 9; // Maximale Anzahl der Runden
	
	
	/**
	 * Der Konstruktor der Spielmodi Schanghai
	 * @param PlayerCount 
	 * 		Anzahl der Spieler
	 */
	public Shanghai(int PlayerCount){
		super("Shanghai",PlayerCount);
		gameShanghai(); // Die Basismethode der Spielmodi Schangahi, die hier aufgerufen und ausgeführt wird.
	}
	
	
	/**
	 * Die Methode prüft. ob in der ersten
	 Runde nur Punkte mit Würfen auf das Feld mit der 1 erzielt werden (mit Doppel und Trippel
	 ), in der zweiten Runde nur mit Feld 2 usw. bis in der neunten Runde auf Feld 9.
	 
	 * @param Num 
	 * 		Num bezeichnet hier das Feld 1 bis 9 
	 * @param round 
	 * 		Rundenummer
	 * @return
	 * 		Gibt das entsprechende Zahlenfeld zurück, falls die Rundennummer die Feldnummer entspricht. Ansonsten 0.
	 * 		
	 */
	public int checkPlayerThrow(int Num , int round) {
		if(Num == round) {			
			return Num;
		}
		
		return 0; 
	}
	
	
	/**
	 * 	 Basis Methode der Spielmodi Schangahi
	 */
	public void gameShanghai() {
		
		for(int i = 0; i < maxRoundNumber * 3 * getPlayers().length; i++){
			Player player = getPlayerByIndex(getActivePlayerNumber()); // Player wird erstellt
			
			if(getLeftDarts() > 0){ // verbleibende Würfe
				int[] in = input(); // Die Eingabe
				int round = 1; // Rundenummer
				if(player.getThrowDartValue() == null) // Falls der Spieler noch nicht geworfen hat, Also throwDartValue = null; 
					round = 1;
				else 
					round = (int)(player.getThrowDartValue().length / 3) + 1; // Rundenummer

				throwDart(checkPlayerThrow(in[0], round), in[1]);
			}
			else if(getLeftDarts() == 0){ // Sonderregel, falls der Spieler ein Schanghai erzielt(Er gewinnt sofort) 
				if(specialCase(player)) 
					setGameWinner(true); // Der Gewinner wird festgestellt
					endGame(); // Hier wird das Spiel beendet
					nextPlayer(); /// SOAL KONAM!
				}
		    }
			whoIsWinner(getScore()); // Die Punktzahl des Gewinners wird ausgegeben.  
			
			// ------------ Inja nabayad endGame bashe ?
	}
	
	
	
	/**
	 * die Methode gibt ein Array mit der Punktzahl für jeden Spieler zurück.
	 * @return 
	 * 	gibt das Array zurück, das die Punktzahl für jeden Spieler enthält.
	 */
	public int[] getScore() {
		Player[] ListOfPlayer = getPlayers(); // Enthält alle Spieler 
		for(int i = 0; i < getPlayerCount(); i++) {
			int temp = 0; // Zwischenspeicher 
			int [][] historyPoint = ListOfPlayer[i].getThrowDartValue(); // Für jeden Spieler werden die Würfe hier gespeichert. 
			for(int j = 0; j < 27; j++) {
				temp = temp + historyPoint[j][0] * historyPoint[j][1];				
			}
			playerScores[i] = temp;
		}
		
		return playerScores;
	}
	
	/**
	 * Diese Methode geht am Ende des Spiels das ganze Array durch, welches die Punktzahl jedes Spielers enthält und überprüft,
	 * welcher Spieler die höchste Punktzahl erreicht hat. 
	 * @param ps
	 */
	public void whoIsWinner(int [] ps) {
		int temp = 0; // Zwischenspeicher 
		for(int i = 1; i < ps.length; i++) {
			if(ps[temp] < ps[i]) {
				temp = i;
			}
		}
		setActivePlayerNumber(temp); // Der jetzige Spieler(bzw. der die höchste Punktzahl erreicht hat) ist der Gewinner.
		
	}

	 
	/**
	 * Die Sonderregel, Das Shanghai. Ein Spieler erzielt ein Shanghai, indem er die zu treffende
	 Zahl mit einem Multiplikator von 1, danach mit einem Multiplikator von 2 und zuletzt mit
	 einem Multiplikator von 3 trifft. Der Spieler, der ein Shanghai erzielt, gewinnt das Spiel sofort.
	 
	 * @param player 
	 * 		Bezeichnet der Spieler (Übergabe)
	 * @return 
	 * 		gibt true zurück, falls die Bedingungen für die Sonderregel erfüllt sind und false, when nicht. 
	 */
	public boolean specialCase(Player player) {
		int a3 = player.getThrowDartValueByIndex(player.getThrowDartValue().length - 1, 1); // Multipikator 1  
		int a2 = player.getThrowDartValueByIndex(player.getThrowDartValue().length - 2, 1); // Multipikator 2
		int a1 = player.getThrowDartValueByIndex(player.getThrowDartValue().length - 3, 1); // Multipikator 3 
		
		if(a3 == 3 && a2 == 2 && a1 == 1) {		
			return true;
		}
		
		return false;
		
	}
}

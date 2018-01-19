package dart;

public class Shanghai extends Darts{
	
	private int [] playerScores = null; 
	private int maxRoundNumber = 9;
	
	public Shanghai(int PlayerCount){
		super("Shanghai",PlayerCount);
		gameShanghai();
	}
	
	public int checkPlayerThrow(int Num , int round) {
		if(Num == round) {			
			return Num;
		}
		
		return 0; 
	}
	public void gameShanghai() {
		
		for(int i = 0; i < maxRoundNumber * 3 * getPlayers().length; i++){
			Player player = getPlayerByIndex(getActivePlayerNumber());
			
			if(getLeftDarts() > 0){
				int[] in = input();
				
				int round = 1;
				if(player.getThrowDartValue() == null) {
					round = 1;
					
				} else {
					round = (int)(player.getThrowDartValue().length / 3) + 1;
					
				}
				throwDart(checkPlayerThrow(in[0], round), in[1]);
			}
			else if(getLeftDarts() == 0)
				
				if(specialCase(player)) {
					
					endGame();
				} 
			
				nextPlayer();
		}
		
	}
	
	public int[] getScore() {
		Player[] ListOfPlayer = getPlayers();
		for(int i = 0; i < getPlayerCount(); i++) {
			int temp = 0;
			int [][] historyPoint = ListOfPlayer[i].getThrowDartValue();
			for(int j = 0; j < 27; j++) {
				temp = temp + historyPoint[j][0] * historyPoint[j][1];				
			}
			playerScores[i] = temp;
		}
		
		return playerScores;
	}
	public void whoIsWinner() {
		
	}
	
	
	/**
	 * Die Sonderregel, Das Schanghaisadasdsa
	 */
	public boolean specialCase(Player player) {
		int a3 = player.getThrowDartValueByIndex(player.getThrowDartValue().length, 1); // Multipikator 1  
		int a2 = player.getThrowDartValueByIndex(player.getThrowDartValue().length - 1, 1); // Multipikator 2
		int a1 = player.getThrowDartValueByIndex(player.getThrowDartValue().length - 2, 1); // Multipikator 3 
		
		if(a3 == 3 && a2 == 2 && a1 == 1) {		
			return true;
		}
		
		return false;
		
	}
}

package dart;

import javax.swing.JOptionPane;

import UI.*;

public abstract class Darts implements IDarts {
	
	private int ActivePlayerNumber = 0,PlayerCount = 0;
	private int LeftDarts = 0 ; 
	private Player[] Players ;
	private String Gamemode = null;
	private boolean Running = false, Over = false, start = false  ; 
	private Player Winner = null; 
	public int[] ThrowDartValue = new int[2];
	
	public Darts(String Gamemode,int PlayerCount){
		this.Gamemode = Gamemode ; 
		this.PlayerCount = PlayerCount;
		Players = new Player[PlayerCount];
		game();
	}

	
	public void game(){
		if(PlayerCount != 0){
			int i = PlayerCount;
			while(i > 0){
				String a = JOptionPane.showInputDialog("Geben Sie der Name des Spielers Nummer "+(PlayerCount - i+1)+" ein"); // bekommt ein Name des Spielers
				Player player = new Player(a);
				if(addPlayer(player)){ // �berpr�ft ob ein Spieler doppelt vorkommt oder nicht. wenn ja , muss n�chste Spieler gefragt werden.
					i--;
				}
			}
			start = true;
			Running = true;
			}
		
		else{
			start = false;
			MyFrame.Win.error("ERROR : We need more player for game. Player Count = 0");
		}
	}

	public int[] input(Player player){
	    int numb = Integer.parseInt(JOptionPane.showInputDialog("Number"));
	    int mult = Integer.parseInt(JOptionPane.showInputDialog("mult"));
	    ThrowDartValue[0]= numb;
	    ThrowDartValue[1] = mult;
	    return ThrowDartValue;    
	  }
	
	public boolean addPlayer(Player player){
		for(int i = 0 ; i < PlayerCount ; i++){
			if(Players[i] != null){ // Wenn i-te Element von Plasyers nicht leer ist, �berpr�ft ,ob Name der Spieler gleich mit eingegebenem Spieler ist oder nicht.
				if(player.getName().equals(Players[i].getName())) // wenn Name 
					return false;// wenn Namen gleich sind, gibt es false zur�ck, sonst �berpr�ft n�chste Element von Players
			} 
			else{
				Players[i] = player ; // Wenn i-te Eleemnt von Players null ist, setzt dieser Player an dieser Stelle ein.
				break;
			}
		}
		return true;
	}
	
	public void nextPlayer(){
		ActivePlayerNumber ++ ;
		if(getActivePlayerNumber() == getPlayerCount())
			ActivePlayerNumber = 0 ; 
	}
		
	public int getActivePlayerNumber(){
		return ActivePlayerNumber;
	}
	
	public int getPlayerCount(){
		return PlayerCount;
	}
	
	public Player[] getPlayers(){
		return Players;
	}
	
	public String getGamemode(){
		return Gamemode;
	}
	
	public int getLeftDarts(){
		return LeftDarts;
	}
	
	public boolean isRunning(){
		return Running;
	}
	
	public boolean isOver(){
		return Over;
	}
	
	public boolean start(){
		//TODO
		return start;
	}
	
	public Player getWinner(){
		if(isOver())
			Winner = Players[ActivePlayerNumber];
		return Winner;
	}
	
	public boolean throwDart(int number, int multiplier){
		
		
		if((number > 0 && number < 21 && multiplier > 0 && multiplier < 4) || (number == 25 && multiplier > 0 && multiplier < 3)){
			int[] a = {number , multiplier};
			Players[ActivePlayerNumber].setThrowDartValue(a);
			LeftDarts = Players[0].getThrowDartValue().length;
			return true;
		}
		int[] a = {0 , 0};
		Players[ActivePlayerNumber].setThrowDartValue(a);
		LeftDarts = Players[0].getThrowDartValue().length;
		return false;
	}
	
	public void endGame(){
		Over = true ; 
		getWinner();
		//TODO
	}
}

package dart;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import UI.*;

public abstract class Darts implements IDarts {
	/**
	 * //TODO
	 */
	private int ActivePlayerNumber = 0,PlayerCount = 0;
	/**
	 * //TODO
	 */
	private int LeftDarts = 3 ; 
	/**
	 * //TODO
	 */
	private Player[] Players ;
	/**
	 * //TODO
	 */
	private String Gamemode = null;
	/**
	 * //TODO
	 */
	private boolean Running = false, Over = false, start = false  ; 
	/**
	 * //TODO
	 */
	private Player Winner = null; 
	/**
	 * //TODO
	 */
	public int[] ThrowDartValue = new int[2];
	/**
	 * //TODO
	 */
	public PointTable Table ;
	/**
	 * Konstruktor
	 * @param Gamemode
	 * @param PlayerCount
	 */
	public Darts(String Gamemode,int PlayerCount){
		this.Gamemode = Gamemode ; 
		this.PlayerCount = PlayerCount;
		Players = new Player[PlayerCount];
		if(start())
			Running = true;
	}
	
	
	
	/**
	 * @see IDarts.start()
	 */
	public boolean start(){
		//TODO
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
			Table = new PointTable(Players);
			}
		
		else{
			start = false;
			MyFrame.Win.error("ERROR : We need more player for game. Player Count = 0");
		}
		return start;
	}

	
	
	/**
	 * @see IDarts.addPlayer(player)
	 */
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
	
	/**
	 * @see IDarts.
	 */
	public boolean throwDart(int number, int multiplier){
		if((number > 0 && number < 21 && multiplier > 0 && multiplier < 4) || (number == 25 && multiplier > 0 && multiplier < 3)){
			int[] a = {number , multiplier};
			Players[ActivePlayerNumber].setThrowDartValue(a);
			LeftDarts --;
			addToTable(ActivePlayerNumber, number * multiplier, Players[ActivePlayerNumber].getThrowDartValue().length);
			return true;
		}
		int[] a = {0 , 0};
		Players[ActivePlayerNumber].setThrowDartValue(a);
		LeftDarts --;
		addToTable(ActivePlayerNumber, 0, Players[ActivePlayerNumber].getThrowDartValue().length);
		return false;
	}
	public void addToTable(int ActivePlayerNumber , int point , int Row){
		Table.addPoint(ActivePlayerNumber, point , Row);
	}
	
	
	/**
	 * @see IDarts.nextPlayer()
	 */
	public void nextPlayer(){
		ActivePlayerNumber ++ ;
		if(getActivePlayerNumber() == getPlayerCount())
			ActivePlayerNumber = 0 ; 
		LeftDarts = 3;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int[] input(){
		
	    int numb = Integer.parseInt(JOptionPane.showInputDialog("Number Dart " + Integer.toString(4 - LeftDarts) + " von " + Players[ActivePlayerNumber].getName()  ));
	    int mult = Integer.parseInt(JOptionPane.showInputDialog("multDart " + Integer.toString(4 - LeftDarts) + " von " + Players[ActivePlayerNumber].getName()  ));
	    ThrowDartValue[0]= numb;
	    ThrowDartValue[1] = mult;
	    return ThrowDartValue;    
	  }
	
	
	/**
	 * @see IDarts.
	 */
	public void endGame(){
		Over = true ; 
		getWinner();
		//TODO
		MyFrame.Win.error(Winner.getName());

	}
	
	/**
	 * @see IDarts.
	 */
	public Player getWinner(){
		if(isOver())
			Winner = Players[ActivePlayerNumber];
		return Winner;
	}
	
	
	/**
	 * @see IDarts.
	 */
	public int getActivePlayerNumber(){
		return ActivePlayerNumber;
	}
	
	/**
	 * @see IDarts.getPlayerCount()
	 */
	public int getPlayerCount(){
		return PlayerCount;
	}
	
	/**
	 * @see IDarts.getPlayers()
	 */
	public Player[] getPlayers(){
		return Players;
	}
	
	/**
	 * @see IDarts.getGamemode()
	 */
	public String getGamemode(){
		return Gamemode;
	}
	
	/**
	 * @see IDarts.getLeftDarts()
	 */
	public int getLeftDarts(){
		return LeftDarts;
	}
	
	/**
	 * @see IDarts.isRunning()
	 */
	public boolean isRunning(){
		return Running;
	}
	
	/**
	 * @see IDarts.isOver()
	 */
	public boolean isOver(){
		return Over;
	}

	
	/**
	 * 
	 * @param ActivePlayerNumber
	 */
	public void setActivePlayerNumber(int ActivePlayerNumbe){
		ActivePlayerNumber = ActivePlayerNumbe;
	}
	
	
	
	
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public Player getPlayerByIndex(int a ){
		return Players[a];
	}
	
}

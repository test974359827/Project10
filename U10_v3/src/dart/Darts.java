package dart;

import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import UI.*;

public abstract class Darts implements IDarts {
	/**
	 * ActivePlayerNumber= der Player, der momentan spielt.
	 * PlayerCount = Anzahl aller Spieler
	 */
	private int ActivePlayerNumber = 0,PlayerCount = 0;
	/**
	 * LeftDarts= Anzahl der Würfe, der ein Spieler noch übrig hat.
	 */
	private int LeftDarts = 3 ; 
	/**
	 * Players= Ein Array, das alle Spieler enthält.
	 */
	private Player[] Players ;
	/**
	 * Gamemode= Spielmodus
	 */
	private String Gamemode = null;
	/**
	 * Running= When das Spiel am Laufen ist. 
	 * Over = Wenn das Spiel zu Ende ist. 
	 * Start = Anfang
	 */
	private boolean Running = false, Over = false, start = false  ; 
	/**
	 * Winner= der Spieler, der gewonnen hat.
	 */
	private Player Winner = null; 
	/**
	 * ThrowDartValue= die Nummer, die der Player getroffen hat.
	 */
	public int[] ThrowDartValue = new int[2];
	/**
	 * Table= Die Tabelle, in der die Ergebnisse angezeigt werden.
	 */
	public PointTable Table ;
	/**
	 * 
	 */
	private boolean Test = false; // Gibt true züruck, falls nur Tests durchzuführen sind, ansonten false, when das Spiel durchzuführen ist.
	
	private boolean GameWinner = false; // Gibt true zuürck, falls das Spiel ein Gewinner hat und false, falls kein Gewinner. 
	
	/**
	 * Hier wird der Konstruktor der Klasse Darts erstellt.
	 * @param Gamemode
	 * 		Spielmodi
	 * @param PlayerCount
	 	Anzahl der Spieler
	 */
	public Darts(String Gamemode,int PlayerCount){
		Object[] options1 = { "Ja","Nein"  };
				 JPanel panel = new JPanel();
			        panel.add(new JLabel("ist das JTest ?"));
			        
			        res = JOptionPane.showOptionDialog(null, panel, "JTest ?",
			                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
			                null, options1, options1[0]);

			        
			        if(res == 0)
			        	Test = true;
			       
		this.Gamemode = Gamemode ; 
		this.PlayerCount = PlayerCount;
		Players = new Player[PlayerCount];
		if(start())
			Running = true;
	}
	
	
	
	/**
	 * @see IDarts.start()
	 */
	public boolean start(){ // TODO
		//TODO
		if(PlayerCount != 0){
			if(!Test){
				int i = PlayerCount;
				while(i > 0){
					String a = inBox("NAME","Geben Sie der Name des Spielers Nummer "+(PlayerCount - i+1)+" ein"); // bekommt ein Name des Spielers
					Player player = new Player(a);
					if(addPlayer(player)){ // Überprüft ob ein Spieler doppelt vorkommt oder nicht. wenn ja , muss nï¿½chste Spieler gefragt werden.
						i--;
					}
				}
				start = true;
				Table = new PointTable(Players);
				}
			else{
				int i = PlayerCount;
				while(i > 0){
					Player player = new Player("Spiler "+Integer.toString(PlayerCount - i+1));
					if(addPlayer(player)){ // Überprüft ob ein Spieler doppelt vorkommt oder nicht. wenn ja , muss nï¿½chste Spieler gefragt werden.
						i--;
					}
				}
				start = true;
				Table = new PointTable(Players);
			}
		}
			
		else{
			start = false;
			MSG("ERROR : We need more player for game. Player Count = 0");
		}
		
		
		return start;
	}

	
	
	/**
	 * @see IDarts.addPlayer(player)
	 */
	public boolean addPlayer(Player player){ 
		for(int i = 0 ; i < PlayerCount ; i++){
			if(Players[i] != null){ // Wenn i-te Element von Plasyers nicht leer ist, ï¿½berprï¿½ft ,ob Name der Spieler gleich mit eingegebenem Spieler ist oder nicht.
				if(player.getName().equals(Players[i].getName())) // wenn Name 
					return false;// wenn Namen gleich sind, gibt es false zurï¿½ck, sonst ï¿½berprï¿½ft nï¿½chste Element von Players
			} 
			else{
				Players[i] = player ; // Wenn i-te Eleemnt von Players null ist, setzt dieser Player an dieser Stelle ein.
				break;
			}
		}
		return true;
	}
	
	/**
	 * Diese Methode führt alles bezüglich der Würfe durch. 
	 * @param number
	 * 		Zahl
	 * @param multiplier
	 * 		 Multipikator
	 * @return 
	 * 		Gibt true zurück, falls der Spieler geworfen hat und ansonsten false. 
	 * 
	 * @see IDarts.throwDart(number,multiplier)
	 */
	public boolean throwDart(int number, int multiplier){ 
		if(!Over){
			if((number > 0 && number < 21 && multiplier > 0 && multiplier < 4) || (number == 25 && multiplier > 0 && multiplier < 3)){
				int[] a = {number , multiplier};
				Players[ActivePlayerNumber].setThrowDartValue(a);
				LeftDarts --;
				addToTable(ActivePlayerNumber, Integer.toString(number) +" * "+Integer.toString(multiplier) , Players[ActivePlayerNumber].getThrowDartValue().length);
				return true;
			}
			int[] a = {0 , 0};
			Players[ActivePlayerNumber].setThrowDartValue(a);
			LeftDarts --;
			addToTable(ActivePlayerNumber, "0 * 0", Players[ActivePlayerNumber].getThrowDartValue().length);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Diese Methode fügt Elemente(Punktzahl) zu unserer Ergebnistabele hinzu.
	 * @param ActivePlayerNumber 
	 * 		Derzeitige Spieler
	 * @param point 
	 *	Punkteanzahl 
	 * @param Row
	 *	Reihe in der Tabelle
	 */
	public void addToTable(int ActivePlayerNumber , String point , int Row){
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
	 * Die Methode input dient zur Eingabe. Alles bezüglich der Input-Eingabe wird hier gemacht. 
	 * @return
	 * 		Gibt die Eingabe zurück
	 */
	public int[] input(){
		
		String num = inBox("Number","Number Dart " + Integer.toString(4 - LeftDarts) +
				" von " + Players[ActivePlayerNumber].getName()  );
		try{
			ThrowDartValue[0] =Integer.parseInt(num);
		}
		catch(Exception e){
			if(!Over)
				JOptionPane.showMessageDialog(null,"keine Number eingegeben ist, deshalb wird 0 asugewählt");
			ThrowDartValue[0] = 0 ;
		}
		if(!Over){
		String mul = inBox("Multi","multDart " + Integer.toString(4 - LeftDarts) + 
				" von " + Players[ActivePlayerNumber].getName()  );
		try{
			ThrowDartValue[1] =Integer.parseInt(mul);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"keine Number eingegeben ist, deshalb wird 0 asugewählt");
			ThrowDartValue[1] = 0 ;
		}}
	    return ThrowDartValue;    
	  }
	private String in = null ;
	private int res;
	
	
	/**
	 * Die Methode bezieht sich auf das Input Kästchen, das zur Eingabe etc. auftatucht. 
	 * @param Title
	 * 		Title der Nachrichtenbox
	 * @param Message
	 * 		Die Nachricht in der Nachrichtenbox
	 * @return
	 * 		Gibt die eingegebene Nachricht in dem Textfeld zurück.
	 */
	public String inBox(String Title , String Message){
		 in = null;
		Object[] options1 = { "ADD",
         "Rand","Quit"  };
		 JPanel panel = new JPanel();
	        panel.add(new JLabel(Message));
	        JTextField textField = new JTextField(10);
	        panel.add(textField);
	        
	        res = JOptionPane.showOptionDialog(null, panel, Title,
	                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
	                null, options1, textField);

	        
	        if(res == 0)
	        	in = textField.getText();
	        
	        else if(res ==1 )
	        	if(isRunning()){
	        		Random rn = new Random();
	        		
	        		if(Title == "Number" )
	        			in = Integer.toString( rn.nextInt(24) + 1);
	        		else
	        			in = Integer.toString( rn.nextInt(2) + 1);
	        	}
	        		
	        	else{
	        		String SALTCHARS = "abcdefghijklmnopqrstuwdxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	                StringBuilder salt = new StringBuilder();
	                Random rnd = new Random();
	                while (salt.length() < 10) { // length of the random string.
	                    int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	                    salt.append(SALTCHARS.charAt(index));
	                }
					in = salt.toString();
	        	}
	        		
	        else {
	        	Over = true;
	        	endGame();
	        }
		return in ; 
	}
	

	
	/**
	 * @see IDarts.endGame()
	 */
	public void endGame(){
		Over = true ;
		if(GameWinner){ 
			getWinner();
			}
		
		if(Winner != null)
			MSG(" Winner is : " + Winner.getName() );
		else 
			MSG("Game is Over Without Winner");
		Table.setVisible(true);
	}
	
	/**
	 * @see IDarts.getWinner()
	 */
	public Player getWinner(){ 
		Winner = Players[ActivePlayerNumber];
		return Winner;
	}
	
	
	/**
	 * @see IDarts.getActivePlayerNumber()
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
	 * Stellt den derzeitigen Spieler fest(der gerade am Spielen ist.) 
	 * 
	 */
	public void setActivePlayerNumber(int ActivePlayernumber){
		ActivePlayerNumber = ActivePlayernumber;
	}
	
	
	/**
	 * Die Methode gibt den entsprechenden Spieler basierend auf dem Index in dem Array zurück.
	 * @param a 
	 * 		Index 
	 * @return 
	 * 		Gibt die i-te Stelle bzw. den i-ten Spieler aus. 
	 */
	public Player getPlayerByIndex(int a){
		return Players[a];
	}
	
	/**
	 * Die Methode stellt den Gewinner fest.
	 * @param GameWinner
	 * 		gibt true zurück, falls es einen Gewinner gibt, ansonsten false.
	 */
	public void setGameWinner(boolean GameWinner){
		this.GameWinner = GameWinner;
	}
	
	/**
	 * Diese Methode zeigt die Nachrichten in dem GUI an. 
	 * @param a 
	 * 		a enthält die Nachricht als String 
	 */
	public void MSG(String a){
		JOptionPane.showMessageDialog(null,a);
	}
	
	/**
	 * Setter: für Test
	 * @param Test als Boolean
	 * 		
	 */
	public void setTest(boolean Test){
		this.Test = Test ;
	}
	
	/**
	 * Getter: für Test
	 * @return Test als Boolean 
	 */
	public boolean getTest(){
		return Test;
	}
	
}

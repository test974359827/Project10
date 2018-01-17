package dart;

import java.util.ArrayList;

/**
	 * Represents a player in a dart game
	 *
	 */
	 public class Player {
	
	 /**
	 * name of the player
	 */
	 private String name;
	 
	 //TODO
	 private int[][] ThrowDartValue ;
	 
	 /**
	 * Initializes the player
	 *
	 * @param playerName the name of the player
	 */
	 public Player(String playerName){
	 name=playerName;
	 }
	
	 /**
	 * returns the name of the player
	 * @return the name of the player
	 */
	 public String getName(){
	 return name;
	 }

	public int[][] getThrowDartValue() {
		return ThrowDartValue;
	}
	
	public int getThrowDartValueByIndex(int i , int j) {
		return ThrowDartValue[i][j];
	}

	public void setThrowDartValue(int[] TD) {
		int len;
		if(ThrowDartValue == null)
			len = 0 ;
		else 
			len = ThrowDartValue.length;
		int[][] a = new int[len + 1][2];
		for(int i = 0 ; i < len ; i++){
			a[i][0] = ThrowDartValue[i][0];
			a[i][1] = ThrowDartValue[i][1];
		}
		a[len][0]=TD[0];
		a[len][1]=TD[1];
		
		ThrowDartValue = a;
	}
	 
	 
}

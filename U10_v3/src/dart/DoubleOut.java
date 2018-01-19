package dart;

public class DoubleOut extends Darts{

	
	private int wp = 51 ; // Gewwinpunkte 
	private int Point = 0 ;
	
	public DoubleOut(int PlayerCount){
		super("Double Out",PlayerCount);
		gameDoubleOut();
	}
//	
	public void Point(Player Player){
		Point = 0 ;
		int[][] PlayerPoint = Player.getThrowDartValue();
		for(int i = 0 ; i < PlayerPoint.length ; i++)
			Point = PlayerPoint[i][0] * PlayerPoint[i][1] + Point;
	}
	
	
	public void gameDoubleOut(){
		
		while(! isOver()){
			Player player = getPlayerByIndex(getActivePlayerNumber());
			if(getLeftDarts() > 0){
				int[] in = input();
				throwDart(in[0],in[1]);
				Point(player);
				if(Point > wp){
					int[] TD = { 0 , 0 };
					switch (getLeftDarts()){
					case 2 : 
						player.setThrowDartValueByIndex(player.getThrowDartValue().length - 1 , TD);
						player.setThrowDartValue(TD);
						player.setThrowDartValue(TD);
						break;
					case 1 : 
						player.setThrowDartValueByIndex(player.getThrowDartValue().length - 2 , TD);
						player.setThrowDartValueByIndex(player.getThrowDartValue().length - 1 , TD);
						player.setThrowDartValue(TD);
						break;
					case 0 : 
						player.setThrowDartValueByIndex(player.getThrowDartValue().length - 3 , TD);
						player.setThrowDartValueByIndex(player.getThrowDartValue().length - 2 , TD);
						player.setThrowDartValueByIndex(player.getThrowDartValue().length - 1 , TD);
						break;
					}
					nextPlayer();
				}
					
				if(Point == wp)
					endGame();
			}
			else if(getLeftDarts() == 0)
				nextPlayer();
		}
		
	}
}

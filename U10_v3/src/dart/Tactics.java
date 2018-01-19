package dart;

public class Tactics extends Darts{
	
	int[][] PlayerPoint;
	public Tactics(int PlayerCount){
		
			super("Tactics",PlayerCount);
			gameTactics();
			
		}
	public void Point(Player Player){
		PlayerPoint = Player.getThrowDartValue();
	}
	
	public boolean gewonnen(){
		
		
	//	Arrays.sort(PlayerPoint, new Comparator<Integer[]>() {
	//	    public int compare(Integer[] int1, Integer[] int2) {
	//	        Integer numOfKeys1 = int1[0];
	//	        Integer numOfKeys2 = int2[0];
	//	        return numOfKeys1.compareTo(numOfKeys2);
	//	    }
	//	}
	//	);
		int PlayerPointMerge[][] = new int [22][1] ;
		int wert=0;
		for(int a=1; a<22; a++) {
			wert=0;
			for(int b=0; b< PlayerPoint.length ; b++) {
				if(PlayerPoint[b][0]==a) {
					wert= wert+PlayerPoint[b][1];
					} if(PlayerPoint[b][0]==25){
						wert= wert+PlayerPoint[b][1];	
				}
					PlayerPointMerge[a][1]= wert;
					PlayerPointMerge[a][0]= a;
				}
			
			}
	for(int i= 9; i<= PlayerPointMerge.length; i++) {
			if(PlayerPointMerge[i][0]==i+1 
					&& ((PlayerPointMerge[i][0])*(PlayerPointMerge[i][1])
					> 3*(PlayerPointMerge[i][0]))) {
				return true;	
			}
		}
				return false;	
	}

	public void gameTactics() {
		while(! isOver()){
			Player player = getPlayerByIndex(getActivePlayerNumber());
			if(getLeftDarts() > 0){
				int[] in = input();
				throwDart(in[0],in[1]);
				Point(player);
				if(gewonnen()) {
					endGame();
				} else {
					nextPlayer();
				}
		}
			
		}		
		}	
	}


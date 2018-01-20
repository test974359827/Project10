package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import dart.*;
/**
 * 
 * @author Arian Tashakkor 
 *
 */
public class ShanghaiTest {
	Shanghai Arian = new Shanghai(2);
	
 @Test
 public void GameStarting(){
	 
	 assertEquals(2, Arian.getPlayerCount());
	 assertEquals("Shanghai", Arian.getGamemode());
	 
	 Arian.throwDartsShanghahi(1, 1);
	 Arian.throwDartsShanghahi(1, 2);
	 Arian.throwDartsShanghahi(1, 3);
	 Arian.getScore();
	 
	 int[] ps =new int[2];
	 ps = Arian.getScore();
	 System.out.println(ps[0]);
	 assertEquals(6, ps[0]);
	 assertEquals(true, Arian.specialCase());
	 
	 Arian.nextPlayer();
	 assertEquals(0, Arian.checkPlayerThrow(2, 1));
	 
	 Arian.throwDartsShanghahi(1, 2);
	 Arian.throwDartsShanghahi(2, 3);
	 Arian.throwDartsShanghahi(3, 1);// 1 2
	 
	 Arian.throwDartsShanghahi(1, 1);
	 Arian.throwDartsShanghahi(2, 1);
	 Arian.throwDartsShanghahi(3, 2);// 2 2
	 
	 Arian.throwDartsShanghahi(1, 1);
	 Arian.throwDartsShanghahi(2, 2);
	 Arian.throwDartsShanghahi(3, 3);// 3 9
	 
	 Arian.throwDartsShanghahi(1, 2);
	 Arian.throwDartsShanghahi(2, 2);
	 Arian.throwDartsShanghahi(2, 3);// 4
	 
	 Arian.throwDartsShanghahi(1, 2);
	 Arian.throwDartsShanghahi(6, 2);
	 Arian.throwDartsShanghahi(7, 3);// 5
	 
	 Arian.throwDartsShanghahi(5, 1);
	 Arian.throwDartsShanghahi(2, 2);
	 Arian.throwDartsShanghahi(3, 3);// 6
	 
	 Arian.throwDartsShanghahi(1, 1);
	 Arian.throwDartsShanghahi(2, 2);
	 Arian.throwDartsShanghahi(3, 3);// 7
	 
	 Arian.throwDartsShanghahi(6, 1);
	 Arian.throwDartsShanghahi(9, 2);
	 Arian.throwDartsShanghahi(10,3);// 8
	 
	 Arian.throwDartsShanghahi(12, 1);
	 Arian.throwDartsShanghahi(2, 2);
	 Arian.throwDartsShanghahi(1, 2);// 9
	
	 	
	 Arian.getScore();
	 assertEquals(13, ps[1]);
	 
 }
 

	
}

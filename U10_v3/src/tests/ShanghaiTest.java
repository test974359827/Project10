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
	 
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.getScore();
	 
	 int[] ps =new int[2];
	 ps = Arian.getScore();
	 assertEquals(126, ps[0]);
	 assertEquals(true, Arian.specialCase());
	 Arian.nextPlayer();
	 
	 
	 Arian.throwDart(1, 2);
	 Arian.throwDart(2, 3);
	 Arian.throwDart(3, 1);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 1);
	 Arian.throwDart(3, 2);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 2);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(2, 3);
	 Arian.throwDart(1, 2);
	 Arian.throwDart(6, 2);
	 Arian.throwDart(7, 3);
	 Arian.throwDart(5, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(1, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(3, 3);
	 Arian.throwDart(6, 1);
	 Arian.throwDart(9, 2);
	 Arian.throwDart(10, 3);
	 Arian.throwDart(12, 1);
	 Arian.throwDart(2, 2);
	 Arian.throwDart(1, 2);
	 Arian.getScore();
	 System.out.println(ps[1]);
	 assertEquals(185, ps[1]);
	 

	 //assertEquals(true, Arian.obGewonnen());
 }
 

	
}

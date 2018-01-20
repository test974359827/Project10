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
	 assertEquals("Schanghai", Arian.getGamemode());
	 
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
	 System.out.println(Arian.getScore());
	 Arian.getScore();
	 //assertEquals(30 ,Arian.getScore());
	
	 int[] ps =new int[2];
	 ps = Arian.getScore();
	 assertEquals(471,ps[0]);
	 assertEquals(501,ps[1]);
	 Arian.nextPlayer();
	 Arian.throwDart(1, 1);
	 Arian.throwDart(25, 2);
	 Arian.throwDart(25, 2);
	 Arian.throwDart(25, 2);
	 Arian.throwDart(25, 2);
	 Arian.throwDart(25, 2);
	 Arian.throwDart(25, 2);
	 Arian.throwDart(25, 2);
	 Arian.throwDart(25, 2);
	 Arian.throwDart(25, 2);
	 Arian.throwDart(25, 2);
	 ps = Arian.getScore();
	 assertEquals(0,ps[1]);
	// Arian.getScore();
	// assertEquals(501,Arian.getScore());
	// assertEquals(true,Arian.obgewinnt());
 }
 

	
}

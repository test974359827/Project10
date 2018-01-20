package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import dart.*;

/**
 * 
 * @author shayan davarifard
 *
 */
public class DoubleOutTest {
	DoubleOut Shayan = new DoubleOut(2);
	
 @Test
 public void GameStarting(){
	 
	 assertEquals(2,Shayan.getPlayerCount());
	 assertEquals("Double Out",Shayan.getGamemode());
	 
	 Shayan.throwDart(10, 1);
	 Shayan.throwDart(10, 1);
	 Shayan.throwDart(10, 1);
	 Shayan.Point();
	 assertEquals(30,Shayan.getPoint());
	 
	 int[] ps =new int[2];
	 ps = Shayan.getScore();
	 assertEquals(471,ps[0]);
	 assertEquals(501,ps[1]);
	 Shayan.nextPlayer();
	 Shayan.throwDart(1, 1);
	 Shayan.throwDart(25, 2);
	 Shayan.throwDart(25, 2);
	 Shayan.throwDart(25, 2);
	 Shayan.throwDart(25, 2);
	 Shayan.throwDart(25, 2);
	 Shayan.throwDart(25, 2);
	 Shayan.throwDart(25, 2);
	 Shayan.throwDart(25, 2);
	 Shayan.throwDart(25, 2);
	 Shayan.throwDart(25, 2);
	 ps = Shayan.getScore();
	 assertEquals(0,ps[1]);
	 Shayan.Point();
	 assertEquals(501,Shayan.getPoint());
	 assertEquals(true,Shayan.obgewinnt());
 }
 

	
}

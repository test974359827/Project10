package tests;

import static org.junit.Assert.*;

import java.lang.reflect.GenericArrayType;

import org.junit.Test;

import dart.DoubleOut;

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
 
 @Test
 public void PlayerTest(){

	 
	 Shayan.throwDart(10, 1);
//	 assertEquals(10,Shayan.getPlayerByIndex(0).getThrowDartValueByIndex(0, 0));
//	 assertEquals(1,Shayan.getPlayerByIndex(0).getThrowDartValueByIndex(0, 1));
 }
// 
// @Test
// public void DartsTestThrowDart(){
//	 
//	 assertEquals(2,Shayan.getPlayerCount());
//	 assertEquals("Double Out",Shayan.getGamemode());
//	 assertEquals("Spiler 1",Shayan.getPlayerByIndex(0).getName());
//	 assertEquals("Spiler 2",Shayan.getPlayerByIndex(1).getName());
//	 
//	 Shayan.throwDart(10, 1);
//	 assertEquals(10,Shayan.getPlayerByIndex(0).getThrowDartValueByIndex(0, 0));
//	 System.out.println(Shayan.getActivePlayerNumber());
// }
//	
}
